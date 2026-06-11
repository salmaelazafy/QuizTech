package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "questions_qcm")
@DiscriminatorValue("QCM")
@Getter
@Setter
@NoArgsConstructor

public class QuestionQCM extends Question {

    @OneToMany(mappedBy = "questionQCM", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Choix> choix;

    @Column(nullable = false)
    private Integer nombreBonnesReponses;
}