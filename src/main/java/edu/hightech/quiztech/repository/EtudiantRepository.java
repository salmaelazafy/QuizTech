package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Classe;
import edu.hightech.quiztech.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByNomCompletContainingIgnoreCase(String nomComplet);

    List<Etudiant> findByClasse(Classe classe);

    long countByClasse(Classe classe);
}