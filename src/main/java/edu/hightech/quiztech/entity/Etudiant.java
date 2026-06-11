package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "etudiants")
@DiscriminatorValue("ETUDIANT")
@Getter @Setter @NoArgsConstructor

public class Etudiant extends Utilisateur {

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @OneToMany(mappedBy = "etudiant")
    private List<Submission> submissions;
}
