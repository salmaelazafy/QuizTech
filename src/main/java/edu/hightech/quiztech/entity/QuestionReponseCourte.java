package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions_reponse_courte")
@DiscriminatorValue("REPONSE_COURTE")
@Getter
@Setter
@NoArgsConstructor

public class QuestionReponseCourte extends Question {

    @Column(nullable = false)
    private String reponseCorrecte;

    private Boolean casseSensible;
}