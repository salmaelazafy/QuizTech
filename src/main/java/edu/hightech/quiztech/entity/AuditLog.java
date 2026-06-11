package edu.hightech.quiztech.entity;

import edu.hightech.quiztech.entity.enums.CategorieAudit;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateAction;

    private String action;

    private String details;

    @Enumerated(EnumType.STRING)
    private CategorieAudit categorie;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
}