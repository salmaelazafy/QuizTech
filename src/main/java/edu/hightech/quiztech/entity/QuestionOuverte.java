package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions_ouvertes")
@DiscriminatorValue("OUVERTE")
@Getter
@Setter
@NoArgsConstructor

public class QuestionOuverte extends Question {

    
}