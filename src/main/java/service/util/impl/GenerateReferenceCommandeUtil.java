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
 * Classe repr�sentant l'impl�mentation d'une r�f�rence pour une commande
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
        // le pr�fixe est vide pour commande car on doit g�n�rer la r�f�rence � partir du hash
        // de : nom Client, pr�nom Client, nombre de produits dans le panier et date d'achat.        
        this.prefix = "";
    }

    @Override
    public String generateReference(final Object... param) {
        // on v�rifie la coh�rence des donn�es re�ues
        if (isConform(param)) {
            final var reference = hash(param);
            logger.info("R�f�rence {} g�n�r�e par {}", reference, this.getClass().getSimpleName());
            return reference;
        }
        return null;
    }

    private boolean isConform(final Object... param) {
        // Pour �tre conforme, il faut :
        // un UtilisateurDto, un nombre de produit et une date conforme.
        return isUserConform(param[0]) && isNombreConform(param[1]) && isDateConforme(param[2]);

    }

    private boolean isUserConform(final Object utilisateurAttendu) {
        if (!(utilisateurAttendu instanceof UtilisateurDto)) {
            return false;
        }
        // Utilisateur
        final var utilisateur = (UtilisateurDto) utilisateurAttendu;
        // dont les noms et pr�noms sont non nulls
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
        // le hash est compos� de :
        final var hash = new StringBuilder();
        // la premi�re lettre du nom
        hash.append(utilisateur.getNom().toUpperCase().charAt(0));
        // la premi�re lettre du pr�nom
        hash.append(utilisateur.getPrenom().toUpperCase().charAt(0));
        // le nombre de produit dans le panier
        hash.append(String.format("%02d", nombreDeProduit));
        // le jour du mois
        hash.append(String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)));
        // le mois. On ajoute un pour rester coh�rent, pour Calendar Janvier = 0 d�cembre = 11 ! 
        hash.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
        // l'ann�e. On retire 2000 pour garder les deux chiffres significatifs de l'ann�e.
        hash.append(String.format("%02d", calendar.get(Calendar.YEAR) - 2000));
        // la seconde de la journ�e. On fait les conversions �l�mentaires.
        hash.append(String.format("%05d",
                (calendar.get(Calendar.SECOND) + calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.HOUR) * 24 * 60)));
        return hash.toString();
    }

}
