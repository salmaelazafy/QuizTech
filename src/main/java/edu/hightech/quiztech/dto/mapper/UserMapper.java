package edu.hightech.quiztech.dto.mapper;

import edu.hightech.quiztech.dto.response.UserResponse;
import edu.hightech.quiztech.entity.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(Utilisateur user) {
        if (user == null) return null;

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setNomComplet(user.getNomComplet());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole() != null ? user.getRole().name() : null);
        response.setDateInscription(user.getDateInscription());
        response.setStatus(user.getStatus());

        return response;
    }
}