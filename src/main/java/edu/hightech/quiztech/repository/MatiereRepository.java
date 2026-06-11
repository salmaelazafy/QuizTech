package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

    Optional<Matiere> findByCode(String code);

    Optional<Matiere> findByNom(String nom);

    boolean existsByCode(String code);

}