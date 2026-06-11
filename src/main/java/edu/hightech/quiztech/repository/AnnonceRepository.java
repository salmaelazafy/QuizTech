package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Annonce;
import edu.hightech.quiztech.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    List<Annonce> findByEnseignant(Enseignant enseignant);

    List<Annonce> findByTitreContainingIgnoreCase(String titre);

}