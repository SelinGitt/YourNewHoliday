/**
 * 
 */
package persistance.commun.dao;

import java.util.List;

/**
 * Interface généric du CRUD pour tout entité de la base de données
 *
 * @author     Ilaitsivery Jacques MADIOMANANA
 * @param  <T> Le type à utiliser pour l'interface
 */
public interface IGenericDao<T> {

    /**
     * Permet de retourner une liste d'élément de Type T provenant de la base de données
     *
     * @return List<T> la liste de bean Pojo de Type T que l'on retourne
     */
    List<T> findAll();

    // Les autres méthodes de CRUD de l'interface
}