package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Classe;
import edu.hightech.quiztech.entity.Enseignant;
import edu.hightech.quiztech.entity.RessourcePedagogique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourcePedagogiqueRepository extends JpaRepository<RessourcePedagogique, Long> {

    List<RessourcePedagogique> findByEnseignant(Enseignant enseignant);

    List<RessourcePedagogique> findByClasse(Classe classe);

    List<RessourcePedagogique> findByTitreContainingIgnoreCase(String titre);

}