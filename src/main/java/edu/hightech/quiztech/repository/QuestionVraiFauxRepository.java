package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.QuestionVraiFaux;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionVraiFauxRepository extends JpaRepository<QuestionVraiFaux, Long> {

    List<QuestionVraiFaux> findByReponseCorrecte(Boolean reponseCorrecte);

}