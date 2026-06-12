package edu.hightech.quiztech.dto.mapper;

import edu.hightech.quiztech.dto.response.ClasseResponse;
import edu.hightech.quiztech.entity.Classe;
import org.springframework.stereotype.Component;

@Component
public class ClasseMapper {

    public ClasseResponse toResponse(Classe classe) {
        if (classe == null) return null;

        ClasseResponse response = new ClasseResponse();
        response.setId(classe.getId());
        response.setNomClasse(classe.getNomClasse());
        response.setNombreEtudiants(classe.getEtudiants() != null ? classe.getEtudiants().size() : 0);

        return response;
    }
}