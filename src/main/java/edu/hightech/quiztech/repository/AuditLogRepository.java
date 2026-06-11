package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.AuditLog;
import edu.hightech.quiztech.entity.Utilisateur;
import edu.hightech.quiztech.entity.enums.CategorieAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    List<AuditLog> findByUtilisateur(Utilisateur utilisateur);

    List<AuditLog> findByCategorie(CategorieAudit categorie);

    List<AuditLog> findByActionContainingIgnoreCase(String action);

}