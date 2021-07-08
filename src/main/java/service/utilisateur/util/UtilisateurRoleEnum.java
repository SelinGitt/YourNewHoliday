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
     * Permet de recuperer le role selon le libelle
     *
     * @param  libelle Libelle du role
     * @return         {@link UtilisateurRoleEnum}
     */
    public static UtilisateurRoleEnum getRole(final String libelle) {
        switch (libelle) {
            case "Visiteur":
                return UtilisateurRoleEnum.VISITEUR;
            case "Client":
                return UtilisateurRoleEnum.CLIENT;
            default:
                return UtilisateurRoleEnum.ADMINISTRATEUR;
        }
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
