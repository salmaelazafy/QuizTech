package edu.hightech.quiztech.dto.request;

import jakarta.validation.constraints.NotBlank;

public class TransferEtudiantRequest {

    @NotBlank(message = "L'identifiant de l'étudiant est obligatoire")
    private String etudiantId; // غيبقى String وفالسيرفيس غيدير ليه parseLong

    @NotBlank(message = "L'identifiant de la classe est obligatoire")
    private String classeId;

    // Getters and Setters
    public String getEtudiantId() { return etudiantId; }
    public void setEtudiantId(String etudiantId) { this.etudiantId = etudiantId; }

    public String getClasseId() { return classeId; }
    public void setClasseId(String classeId) { this.classeId = classeId; }
}