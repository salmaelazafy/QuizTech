package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "questions_programmation")
@DiscriminatorValue("PROGRAMMATION")
@Getter
@Setter
@NoArgsConstructor

public class QuestionProgrammation extends Question {

    @Column(columnDefinition = "TEXT")
    private String starterCode;

    private String langage;
    
    @Column(columnDefinition = "TEXT")
    private String solutionModele;

    @OneToMany(mappedBy = "questionProgrammation" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CasTest> casTests;
}