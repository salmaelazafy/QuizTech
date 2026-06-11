package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Examen;
import edu.hightech.quiztech.entity.Matiere;
import edu.hightech.quiztech.entity.Enseignant;
import edu.hightech.quiztech.entity.enums.StatutExamen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen, Long> {

    List<Examen> findByMatiere(Matiere matiere);

    List<Examen> findByEnseignant(Enseignant enseignant);

    List<Examen> findByStatus(StatutExamen status);

    List<Examen> findByTitreContainingIgnoreCase(String titre);
}