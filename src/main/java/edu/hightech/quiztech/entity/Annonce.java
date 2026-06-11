package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "annonces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Column(columnDefinition = "TEXT")
    private String contenu;

    private LocalDateTime datePublication;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
}