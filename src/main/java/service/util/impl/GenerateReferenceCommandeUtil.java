/**
 * 
 */
package service.util.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import presentation.utilisateur.dto.UtilisateurDto;

/**
 * Classe représentant l'implémentation d'une référence pour une commande
 *
 * @author Administrateur
 */
@Component
@Qualifier("CMD")
public class GenerateReferenceCommandeUtil extends AbstractGenerateReferenceUtil {

    /**
     * Constructor
     */
    public GenerateReferenceCommandeUtil() {
        // le préfixe est vide pour commande car on doit générer la référence à partir du hash
        // de : nom Client, prénom Client, nombre de produits dans le panier et date d'achat.        
        this.prefix = "";
    }

    @Override
    public String generateReference(final Object... param) {
        // on vérifie la cohérence des données reçues
        if (isConform(param)) {
            final var reference = hash(param);
            logger.info("Référence {} générée par {}", reference, this.getClass().getSimpleName());
            return reference;
        }
        return null;
    }

    private boolean isConform(final Object... param) {
        // Pour être conforme, il faut :
        // un UtilisateurDto, un nombre de produit et une date conforme.
        return isUserConform(param[0]) && isNombreConform(param[1]) && isDateConforme(param[2]);

    }

    private boolean isUserConform(final Object utilisateurAttendu) {
        if (!(utilisateurAttendu instanceof UtilisateurDto)) {
            return false;
        }
        // Utilisateur
        final var utilisateur = (UtilisateurDto) utilisateurAttendu;
        // dont les noms et prénoms sont non nulls
        return null != utilisateur.getNom() && null != utilisateur.getPrenom();
    }

    private boolean isNombreConform(final Object nombreAttendu) {
        if (!(nombreAttendu instanceof Integer)) {
            return false;
        }
        // Nombre
        final var nombre = (Integer) nombreAttendu;
        // positif
        return nombre >= 0;
    }

    private boolean isDateConforme(final Object dateAttendue) {
        // Une date
        if (!(dateAttendue instanceof Date)) {
            return false;
        }
        return true;
    }

    private String hash(final Object... param) {
        final var utilisateur = (UtilisateurDto) param[0];
        final var nombreDeProduit = (Integer) param[1];
        // gestion de la date
        final var date = (Date) param[2];
        final var calendar = Calendar.getInstance();
        calendar.setTime(date);
        // le hash est composé de :
        final var hash = new StringBuilder();
        // la première lettre du nom
        hash.append(utilisateur.getNom().toUpperCase().charAt(0));
        // la première lettre du prénom
        hash.append(utilisateur.getPrenom().toUpperCase().charAt(0));
        // le nombre de produit dans le panier
        hash.append(String.format("%02d", nombreDeProduit));
        // le jour du mois
        hash.append(String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)));
        // le mois. On ajoute un pour rester cohérent, pour Calendar Janvier = 0 décembre = 11 ! 
        hash.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
        // l'année. On retire 2000 pour garder les deux chiffres significatifs de l'année.
        hash.append(String.format("%02d", calendar.get(Calendar.YEAR) - 2000));
        // la seconde de la journée. On fait les conversions élémentaires.
        hash.append(String.format("%05d",
                (calendar.get(Calendar.SECOND) + calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.HOUR) * 24 * 60)));
        return hash.toString();
    }

}
