package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Question;
import edu.hightech.quiztech.entity.ReponseEtudiant;
import edu.hightech.quiztech.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReponseEtudiantRepository extends JpaRepository<ReponseEtudiant, Long> {

    List<ReponseEtudiant> findBySubmission(Submission submission);

    List<ReponseEtudiant> findByQuestion(Question question);

}