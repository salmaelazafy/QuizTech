package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ressources_pedagogiques")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RessourcePedagogique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private String fichier;

    private LocalDateTime datePublication;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;
    
    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;
}