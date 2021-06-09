/**
 * 
 */
package persistance.commun.dao;

import java.util.List;

/**
 * Interface g�n�ric du CRUD pour tout entit� de la base de donn�es
 *
 * @author     Ilaitsivery Jacques MADIOMANANA
 * @param  <T> Le type � utiliser pour l'interface
 */
public interface IGenericDao<T> {

    /**
     * Permet de retourner une liste d'�l�ment de Type T provenant de la base de donn�es
     *
     * @return List<T> la liste de bean Pojo de Type T que l'on retourne
     */
    List<T> findAll();

    /**
     * Permet de trouver un �l�ment T de la base de donn�es
     *
     * @param  id l'id de l'�l�ment � trouver
     * @return    <T> l'�l�ment pojo de type T que l'on retourne
     */
    T findById(final Integer id);
    // Les autres m�thodes de CRUD de l'interface
}
