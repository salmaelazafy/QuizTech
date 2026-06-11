package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cas_tests")
@Getter
@Setter
@NoArgsConstructor

public class CasTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entree;

    private String sortieAttendue;

    @ManyToOne
    @JoinColumn(name = "question_programmation_id")
    private QuestionProgrammation questionProgrammation;
}