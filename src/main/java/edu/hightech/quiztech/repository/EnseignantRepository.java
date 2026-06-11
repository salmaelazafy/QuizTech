package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    List<Enseignant> findByNomCompletContainingIgnoreCase(String nomComplet);

}