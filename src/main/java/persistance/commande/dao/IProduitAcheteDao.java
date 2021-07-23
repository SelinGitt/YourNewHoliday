/**
 * 
 */
package persistance.commande.dao;

import persistance.commande.entity.ProduitAcheteDo;
import persistance.commun.dao.IGenericDao;

/**
 * Interface ajoutant des requêtes en base de données pour ProduitAcheteDo
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface IProduitAcheteDao extends IGenericDao<ProduitAcheteDo> {

    /**
     * Permet de retourner un ProduitAcheteDo en base de données
     *
     * @param  idOriginal l'identifiant du produit dans la table produit
     * @param  version    la version du produit
     * @return            ProduitAcheteDo le produit trouvé, null sinon
     */
    ProduitAcheteDo recupererProduitAcheteDo(final Integer idOriginal, final Integer version);

}
