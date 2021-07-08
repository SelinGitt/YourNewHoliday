/**
 * 
 */
package persistance.commun.dao;

import java.util.List;

/**
 * Interface généric du CRUD pour tout entité de la base de données
 *
 * @author                         Ilaitsivery Jacques MADIOMANANA
 * @param  {@literal<}T{@literal>} Le type à utiliser pour l'interface
 */
public interface IGenericDao<T> {

    /**
     * Permet de retourner une liste d'élément de Type T provenant de la base de données
     *
     * @return List<T> la liste de bean Pojo de Type T que l'on retourne
     */
    List<T> findAll();

    /**
     * Permet de trouver une entité T en fonction de son ID en base
     *
     * @param  id l'id de l'entité T à trouver
     * @return    l'entité T trouvée, retourne <code>null</code> si l'entité n'a pas été trouvée
     */
    T findById(final Integer id);
    // Les autres méthodes de CRUD de l'interface

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
