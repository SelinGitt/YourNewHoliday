/**
 * 
 */
package presentation.produit.controller;

import java.util.stream.Stream;

/**
 * Enum contenant les pages de retour possibles
 *
 * @author Lucas
 */
public enum PageRedirection {
    /**
     * La page de ListerProduits (PDT_00)
     */
    LISTE_PRODUITS("listerProduits", "listerProduits.do"),
    /**
     * La page de ListerProduitsAdmin (PDT_01)
     */
    LISTE_PRODUITS_ADMIN("listerProduitsAdmin", "listerProduitsAdmin.do"),
    /**
     * La page de ListePanierProduits (PAN_00)
     */
    LISTE_PANIER("listerPanierProduits", "listerPanierProduits.do"),
    /**
     * La page de DetailCommande (CMD_04)
     */
    DETAIL_COMMANDE("detail", "detailCommande.do");

    private String pageUrl;
    private String pageDestination;

    PageRedirection(final String pageUrl, final String pageConcrete) {
        this.pageUrl = pageUrl;
        this.pageDestination = pageConcrete;
    }

    /**
     * Permet de trouver la value de l'enum en fonction de sa page d'origine
     *
     * @param  pageUrl La page url à retrouver
     * @return         la PageRedirection trouvée, LISTE_PRODUITS si aucun résultat n'est trouvé
     */
    public static PageRedirection findValue(final String pageUrl) {
        return Stream.of(PageRedirection.values()).filter(pageRedirection -> pageRedirection.pageUrl.equals(pageUrl)).findFirst()
                .orElse(LISTE_PRODUITS);
    }

    /**
     * Getter for pageConcrete
     *
     * @return the pageConcrete
     */
    public String getPageConcrete() {
        return pageDestination;
    }

}
