package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.QuestionReponseCourte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionReponseCourteRepository extends JpaRepository<QuestionReponseCourte, Long> {

    List<QuestionReponseCourte> findByReponseCorrecteContainingIgnoreCase(String reponseCorrecte);

}