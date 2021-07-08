/**
 * 
 */
package persistance.commun.dao;

import java.util.List;

/**
 * Interface g�n�ric du CRUD pour tout entit� de la base de donn�es
 *
 * @author                         Ilaitsivery Jacques MADIOMANANA
 * @param  {@literal<}T{@literal>} Le type � utiliser pour l'interface
 */
public interface IGenericDao<T> {

    /**
     * Permet de retourner une liste d'�l�ment de Type T provenant de la base de donn�es
     *
     * @return List<T> la liste de bean Pojo de Type T que l'on retourne
     */
    List<T> findAll();

    /**
     * Permet de trouver une entit� T en fonction de son ID en base
     *
     * @param  id l'id de l'entit� T � trouver
     * @return    l'entit� T trouv�e, retourne <code>null</code> si l'entit� n'a pas �t� trouv�e
     */
    T findById(final Integer id);
    // Les autres m�thodes de CRUD de l'interface

    /**
     * Permet de creer T en base de donnees
     * 
     * @param  bean Bean T a creer en base de doonees
     * @return      T creer
     */
    T create(final T bean);

    /**
     * Permet de mettre a jour T en base de donnees
     *
     * @param  bean Bean T a mettre a jour en base de donnees
     * @return      T mis a jour
     */
    T update(final T bean);
}
