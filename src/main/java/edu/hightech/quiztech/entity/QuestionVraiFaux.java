package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions_vrai_faux")
@DiscriminatorValue("VRAI_FAUX")
@Getter
@Setter
@NoArgsConstructor

public class QuestionVraiFaux extends Question {

    @Column(nullable = false)
    private Boolean reponseCorrecte;
}