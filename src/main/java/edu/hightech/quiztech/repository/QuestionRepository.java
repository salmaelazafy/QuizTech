package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Examen;
import edu.hightech.quiztech.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByExamen(Examen examen);

    List<Question> findByEnonceContainingIgnoreCase(String enonce);

    List<Question> findByExamenIdOrderByOrdreAsc(Long examenId);
}