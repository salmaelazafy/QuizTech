package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "matieres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String code;

    @ManyToMany(mappedBy = "matieres")
    private List<Enseignant> enseignants;

    @ManyToMany(mappedBy = "matieres")
    private List<Classe> classes;

    @OneToMany(mappedBy = "matiere")
    private List<Examen> examens;

   
}