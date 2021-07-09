/**
 * 
 */
package persistance.external_files.impl;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import persistance.external_files.IFichierDao;

/**
 * Classe représentant le dao de fichierDao
 *
 * @author Alexandre
 */
@Repository
public class FichierDao implements IFichierDao {

    private static final Logger logger = LoggerFactory.getLogger(FichierDao.class);

    @Override
    public String chargerFichier(final String nomFichier) {
        final var strBuilder = new StringBuilder();
        logger.error("Creation d'un StringBuilder : ", strBuilder);
        //creation d'un FileReader avec le nom du fichier
        final var file = new File(nomFichier);
        logger.error("On cherche le fichier : ", file);
        try (final var scanner = new Scanner(file)) {
            //passe le contenu du fichier html dans la string contenuHtml
            while (scanner.hasNext()) {
                final String line = scanner.nextLine();
                strBuilder.append(line);
            }
        } catch (final IOException exception) {
            //si exception 
            logger.error("IOException Error", exception);
        }
        return strBuilder.toString();
    }

    @Override
    public boolean trouverFichier(final String nomFichier) {
        final var file = new File(nomFichier);
        logger.error("On cherche le fichier :", file);
        //on verifie que le fichier peut etre lu
        return file.canRead();
    }
}
