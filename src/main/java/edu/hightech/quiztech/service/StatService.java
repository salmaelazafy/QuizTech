package edu.hightech.quiztech.service;

import edu.hightech.quiztech.dto.response.StatistiquesResponse;
import edu.hightech.quiztech.entity.enums.Role;
import edu.hightech.quiztech.repository.ClasseRepository;
import edu.hightech.quiztech.repository.ExamenRepository;
import edu.hightech.quiztech.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ExamenRepository examenRepository;

    public StatistiquesResponse getGlobalStats() {
        // كنحسبو الـ count من الـ Utilisateurs على حساب الـ Role حيت هما ف نفس الـ Repository
        long totalEtudiants = utilisateurRepository.findAll().stream().filter(u -> u.getRole() == Role.ETUDIANT).count();
        long totalEnseignants = utilisateurRepository.findAll().stream().filter(u -> u.getRole() == Role.ENSEIGNANT).count();
        long totalClasses = classeRepository.count();
        long totalExamens = examenRepository.count();

        return new StatistiquesResponse(totalEtudiants, totalEnseignants, totalClasses, totalExamens);
    }
}