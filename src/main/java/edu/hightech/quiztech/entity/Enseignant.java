package edu.hightech.quiztech.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "enseignants")
@DiscriminatorValue("ENSEIGNANT")
@Getter @Setter @NoArgsConstructor

public class Enseignant extends Utilisateur {

	@ManyToMany
	@JoinTable(
	    name = "enseignant_matiere",
	    joinColumns = @JoinColumn(name = "enseignant_id"),
	    inverseJoinColumns = @JoinColumn(name = "matiere_id")
	)
	private List<Matiere> matieres;

    @OneToMany(mappedBy = "enseignant")
    private List<Examen> examens;

    @OneToMany(mappedBy = "enseignant")
    private List<RessourcePedagogique> ressources;

    @OneToMany(mappedBy = "enseignant")
    private List<Annonce> annonces;
}