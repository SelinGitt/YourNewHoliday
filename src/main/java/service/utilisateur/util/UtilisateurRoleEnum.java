/**
 * 
 */
package service.utilisateur.util;

/**
 * Classe UtilisateurRoleEnum
 *
 * @author Valentin
 */
public enum UtilisateurRoleEnum {
    /**
     * Role Visiteur
     */
    VISITEUR(1, "Visiteur"),
    /**
     * Role Client
     */
    CLIENT(2, "Client"),
    /**
     * Role Administrateur
     */
    ADMINISTRATEUR(3, "Administrateur");

    private int    id;

    private String libelle;

    /**
     * Constructor
     *
     * @param id      ID du role
     * @param libelle Libelle du role
     */
    UtilisateurRoleEnum(final int id, final String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    /**
     * Getter for id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for libelle
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }
}
