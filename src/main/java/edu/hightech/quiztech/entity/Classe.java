package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;



@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomClasse;

    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

    @ManyToMany
    @JoinTable(
        name = "classe_matiere",
        joinColumns = @JoinColumn(name = "classe_id"),
        inverseJoinColumns = @JoinColumn(name = "matiere_id")
    )
    private List<Matiere> matieres;

    @ManyToMany(mappedBy = "classes")
    private List<Examen> examens;
    
    @OneToMany(mappedBy = "classe")
    private List<RessourcePedagogique> ressourcesPedagogiques;
    
    }