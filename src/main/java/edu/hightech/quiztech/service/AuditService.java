package edu.hightech.quiztech.service;

import edu.hightech.quiztech.dto.response.AuditLogResponse;
import edu.hightech.quiztech.entity.AuditLog;
import edu.hightech.quiztech.entity.Utilisateur;
import edu.hightech.quiztech.entity.enums.CategorieAudit;
import edu.hightech.quiztech.repository.AuditLogRepository;
import edu.hightech.quiztech.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void logAction(Long utilisateurId, String action, String details, CategorieAudit categorie) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);

        AuditLog log = new AuditLog();
        log.setUtilisateur(utilisateur);
        log.setAction(action);
        log.setDetails(details);
        log.setCategorie(categorie);
        log.setDateAction(LocalDateTime.now());

        auditLogRepository.save(log);
    }

    public List<AuditLogResponse> getAllLogs() {
        return auditLogRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private AuditLogResponse mapToResponse(AuditLog log) {
        if (log == null) return null;
        AuditLogResponse res = new AuditLogResponse();
        res.setId(log.getId());
        res.setDateAction(log.getDateAction());
        res.setAction(log.getAction());
        res.setDetails(log.getDetails());
        res.setCategorie(log.getCategorie());
        res.setUserName(log.getUtilisateur() != null ? log.getUtilisateur().getNomComplet() : "Système");
        return res;
    }
}