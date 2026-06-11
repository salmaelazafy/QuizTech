package edu.hightech.quiztech.service;

import edu.hightech.quiztech.dto.mapper.UserMapper;
import edu.hightech.quiztech.dto.request.CreateUserRequest;
import edu.hightech.quiztech.dto.request.UpdateUserRequest;
import edu.hightech.quiztech.dto.response.UserResponse;
import edu.hightech.quiztech.entity.Admin;
import edu.hightech.quiztech.entity.Enseignant;
import edu.hightech.quiztech.entity.Etudiant;
import edu.hightech.quiztech.entity.Utilisateur;
import edu.hightech.quiztech.entity.enums.Role;
import edu.hightech.quiztech.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UserMapper userMapper; // هنا حقنا الـ Mapper الجديد

    // 1. Créer un nouvel utilisateur (Admin, Enseignant, Etudiant)
    public UserResponse createUser(CreateUserRequest request) {
        if (utilisateurRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("L'adresse email est déjà utilisée !");
        }

        Utilisateur utilisateur;
        if (request.getRole() == Role.ADMIN) {
            utilisateur = new Admin();
        } else if (request.getRole() == Role.ENSEIGNANT) {
            utilisateur = new Enseignant();
        } else {
            utilisateur = new Etudiant();
        }

        utilisateur.setNomComplet(request.getNomComplet());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setMotDePasse(request.getMotDePasse());
        utilisateur.setRole(request.getRole());
        utilisateur.setDateInscription(LocalDate.now());
        utilisateur.setStatus("ACTIVE");

        Utilisateur savedUser = utilisateurRepository.save(utilisateur);
        return userMapper.toResponse(savedUser); // التحويل باستعمال الـ Mapper
    }

    // 2. Modifier un utilisateur existant
    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id));

        utilisateur.setNomComplet(request.getNomComplet());
        utilisateur.setEmail(request.getEmail());
        utilisateur.setRole(request.getRole());
        if (request.getStatus() != null) {
            utilisateur.setStatus(request.getStatus());
        }

        Utilisateur updatedUser = utilisateurRepository.save(utilisateur);
        return userMapper.toResponse(updatedUser); // التحويل باستعمال الـ Mapper
    }

    // 3. Supprimer un utilisateur
    public void deleteUser(Long id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur non trouvé !");
        }
        utilisateurRepository.deleteById(id);
    }

    // 4. Afficher tous les utilisateurs
    public List<UserResponse> getAllUsers() {
        return utilisateurRepository.findAll().stream()
                .map(userMapper::toResponse) // تحويل الـ List كاملة باستعمال الـ Mapper
                .collect(Collectors.toList());
    }
}