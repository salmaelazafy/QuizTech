package edu.hightech.quiztech.entity;

import edu.hightech.quiztech.entity.enums.StatutExamen;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "examens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private Integer duree;

    private Integer coefficient;

    private LocalDateTime dateOuverture;

    private LocalDateTime dateFermeture;

    private Boolean isPublished = false;

    private String rejectionComment;

    @Enumerated(EnumType.STRING)
    private StatutExamen status;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Enseignant enseignant;

    @ManyToMany
    @JoinTable(
        name = "examen_classe",
        joinColumns = @JoinColumn(name = "examen_id"),
        inverseJoinColumns = @JoinColumn(name = "classe_id")
    )
    private List<Classe> classes;

    @OneToMany(mappedBy = "examen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    @OneToMany(mappedBy = "examen")
    private List<Submission> submissions;
}