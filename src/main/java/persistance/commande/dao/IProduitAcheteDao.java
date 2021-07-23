/**
 * 
 */
package persistance.commande.dao;

import persistance.commande.entity.ProduitAcheteDo;
import persistance.commun.dao.IGenericDao;

/**
 * Interface ajoutant des requ�tes en base de donn�es pour ProduitAcheteDo
 *
 * @author Ilaitsivery Jacques MADIOMANANA
 */
public interface IProduitAcheteDao extends IGenericDao<ProduitAcheteDo> {

    /**
     * Permet de retourner un ProduitAcheteDo en base de donn�es
     *
     * @param  idOriginal l'identifiant du produit dans la table produit
     * @param  version    la version du produit
     * @return            ProduitAcheteDo le produit trouv�, null sinon
     */
    ProduitAcheteDo recupererProduitAcheteDo(final Integer idOriginal, final Integer version);

}
