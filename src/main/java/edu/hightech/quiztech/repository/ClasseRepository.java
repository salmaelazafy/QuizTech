package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

    Optional<Classe> findByNomClasse(String nomClasse);

    boolean existsByNomClasse(String nomClasse);
}