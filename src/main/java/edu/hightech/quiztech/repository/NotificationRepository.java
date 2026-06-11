package edu.hightech.quiztech.repository;

import edu.hightech.quiztech.entity.Notification;
import edu.hightech.quiztech.entity.Utilisateur;
import edu.hightech.quiztech.entity.enums.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUtilisateur(Utilisateur utilisateur);

    List<Notification> findByUtilisateurAndEstLueFalse(Utilisateur utilisateur);

    List<Notification> findByType(NotificationType type);

}