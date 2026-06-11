package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.QuestionProgrammation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionProgrammationRepository extends JpaRepository<QuestionProgrammation, Long> {

    List<QuestionProgrammation> findByLangageIgnoreCase(String langage);

}