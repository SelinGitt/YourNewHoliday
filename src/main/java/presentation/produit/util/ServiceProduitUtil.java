/**
 * 
 */
package presentation.produit.util;

/**
 * Classe représentant ServiceProduitUtil <br>
 *
 * @author Valentin
 */
public class ServiceProduitUtil {

    private static final int NB_SERVICES = 9;

    /**
     * Constructor
     */
    public ServiceProduitUtil() {
        super();
    }

    /**
     * Permet de genere un tableau de boolean sur les services, avec leur etat true ou false <br>
     * Obligatoire car le tableau de service envoyer a la creation on l'edition d'un pdt peut etre incomplet
     *
     * @param  services Tableau de service sur lequel on ce base
     * @return          Tableau de boolean avec tout les services et leur etat
     */
    protected Boolean[] fillServiceArray(final Boolean[] services) {
        final var newServiceTab = this.generateArray();

        for (var i = 0; i < services.length; i++) {
            if (services[i] != null) {
                newServiceTab[i] = true;
            }
        }

        return newServiceTab;
    }

    /**
     * Permet de genere un tableau de boolean de la taille du nombre de service <br>
     * avec tout les index a false
     *
     * @return Boolean[]
     */
    protected Boolean[] generateArray() {
        final var serviceTab = new Boolean[NB_SERVICES];

        for (var i = 0; i < NB_SERVICES; i++) {
            serviceTab[i] = false;
        }

        return serviceTab;
    }
}
