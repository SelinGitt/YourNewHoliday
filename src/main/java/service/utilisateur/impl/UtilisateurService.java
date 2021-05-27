package service.utilisateur.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import service.utilisateur.IUtilisateurService;

/**
 * Classe UtilisateurService <br>
 * Implemente {@link service.utilisateur.IUtilisateurService}
 *
 * @author Valentin
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UtilisateurService implements IUtilisateurService {
    // Vide pour le moment
}
