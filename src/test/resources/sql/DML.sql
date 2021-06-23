-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 22 avr. 2021 à 12:17
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données : `bdynh`
--

--
-- Suppression des tables
--
DELETE FROM `possede`;
DELETE FROM `liste_commande`;
DELETE FROM `produit_achete`;
DELETE FROM `commande`;
DELETE FROM `utilisateur`;
DELETE FROM `role`;
DELETE FROM `droit`;
DELETE FROM `produit`;




--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (1, 2, '125693', 'Voyage aux Maldives', 'description1', 'Maldives', '900.00', 'Maison dHotes', 1, 'C:/temp/img/maldives.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (2, 1, '126794', 'Voyage en Grèce', 'description2', 'Grèce', '500.00', 'Suite', 0, 'C:/temp/img/greece.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (3, 1, '127895', 'Voyage en Espagne', 'description3', 'Espagne', '450.00', 'chambre dhôtel', 1, 'C:/temp/img/espagne.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (4, 3, '128996', 'Voyage en Italie', 'description4', 'Italie', '300.00', 'chambre dhôtel', 1, 'C:/temp/img/italy.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (5, 1, '129997', 'Voyage à Tokyo', 'description5', 'Tokyo', '800.00', 'Appartement', 1, 'C:/temp/img/tokyo.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (6, 1, '129998', 'Voyage au Portugal ', 'description6', 'Portugal', '600.00', 'Maison dHotes', 0, 'C:/temp/img/portugal.jpg', 1);

--
-- Déchargement des données de la table `droit`
--

INSERT INTO `droit` (`idDroit`, `url`) VALUES (1, 'listerProduits.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (2, 'listerUtilisateur.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (3, 'contact.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (4, 'listerProduitsAdmin.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (5, 'connecter.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (6, 'creerUtilisateur.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (7, 'deconnecter.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (8, 'listerCommande.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (9, 'listerPanierProduits.do');
-- à supprimer en même temps que utilisateurConnecteDto
INSERT INTO `droit` (`idDroit`, `url`) VALUES (42, 'user_session.do');

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`idRole`, `libelle`) VALUES (1, 'client');
INSERT INTO `role` (`idRole`, `libelle`) VALUES (2, 'visiteur');
INSERT INTO `role` (`idRole`, `libelle`) VALUES (3, 'administrateur');



--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (1, 'VISITEUR0000001', '2021-04-12 11:30:51', 'Visiteur01', 'Visiteur', '2021-04-12 11:30:51', 'En Visite', 'visiteur@gmail.com', 'NoPassWord', '/img/visiteur01.png', 0, 2);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (2, 'ClientCLIENT123', '2021-04-01 16:30:02', 'Barathéon', 'Robert', '2000-10-17 22:30:46', '13 rue de Port Réal\r\n59000 Lille', 'baratheon.robert@hotmail.com', '46E43F808CF3CAB2C8AC6321D7FF743F43A13A412C38FAFFDDD8252D711113E2', '/img/image_01.png', 0, 1);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (3, 'ClientCLIENT456', '2021-04-12 11:30:51', 'Lanister', 'Cersey', '2002-05-30 11:25:12', '28 rue de Port Réal\r\n59000 Lille', 'cersey.lanister@gmail.com', '89CB729B086227098038A94DFA0302264F1AC476A47F170FF36E4E424704E98F', '/img/image_02.png', 0, 1);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (4, 'ClientCLIENT753', '2021-04-06 11:14:03', 'Jackson', 'Persey', '1985-12-31 00:00:00', '12 rue de la toison d\or\r\n59200 Villeneuve d\Ascq', 'persey.jackson@gmail.com', '24E66925A7BCDB8F1F0DB288ED0A141876342E9C63EEA506C0680CBF1FDBA99C', '/img/image_03.png', 0, 1);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (5, 'clientCLIENT789', '2020-12-09 11:18:02', 'Maimai', 'Maiko', '1995-08-12 00:30:30', '14 rue de la marmelade\r\n59100 ROUBAIX', 'maiko.maimai@gmail.com', 'D631ABB9C855BF981CB65F57557E0B27B43D458C58F6DCDA8416E922F5A01AD9', '/img/image_04.png', 1, 1);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (6, 'Administrateur1', '1999-07-05 10:40:42', 'Marsial', 'Tony', '1978-06-06 00:00:00', '15 rue de Venon\r\n59000 Lille', 'marsial.tony@gmail.com', '7A69AC317999979CB5FB116A797C41A4207348FA7B26DAB94FF4EED5AE0BDB7D', '/img/image_05.png', 0, 3);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (7, 'Administrateur2', '2021-03-01 11:26:30', 'Marly', 'Cynthia', '2001-01-16 18:02:09', '59 rue du ciel\r\n59100 Roubaix', 'cynthia.marly@gmail.com', '6F482F6246F6095B77E654F902F8AD31C739D32F1ED1CF4FF754052CE7D79D38', '/img/image_06.png', 1, 3);

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`idCommande`, `reference`, `adresse_facturation`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (1, 'ABC1', '12, rue des oiseaux bleu, 75005, Paris', '12, rue des oiseaux bleu, 75005, Paris', '2021-02-09 13:49:11', '1200.00', '1200.00', 3, 2);
INSERT INTO `commande` (`idCommande`, `reference`, `adresse_facturation`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (2, 'ABC2', '12, rue des oiseaux bleu, 75005, Paris', '12, rue des oiseaux bleu, 75005, Paris', '2021-04-01 13:49:11', '4000.00', '3600.00', 5, 2);
INSERT INTO `commande` (`idCommande`, `reference`, `adresse_facturation`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (3, 'ABC3', '3, rue du Paradis, 62400, Béthune', '3, rue du Paradis, 62400, Béthune', '2020-11-13 13:50:33', '600.00', '600.00', 1, 3);
INSERT INTO `commande` (`idCommande`, `reference`, `adresse_facturation`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (4, 'ABC4', '3, rue du Paradis, 62400, Béthune', '3, rue du Paradis, 62400, Béthune', '2021-02-09 13:50:33', '1200.00', '1200.00', 2, 3);
INSERT INTO `commande` (`idCommande`, `reference`, `adresse_facturation`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (5, 'ABC5', '124, rue du petit chemin, 59000, Lille', '221, rue de l\église 59790, Ronchin', '2021-03-17 13:52:28', '900.00', '900.00', 1, 5);
INSERT INTO `commande` (`idCommande`, `reference`, `adresse_facturation`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (6, 'ABC6', '124, rue du petit chemin, 59000, Lille', '221, rue de l\église 59790, Ronchin', '2021-04-12 14:02:45', '1000.00', '1000.00', 1, 6);

--
-- Déchargement des données de la table `produit_achete`
--

INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (1, 3, 1, '127895', 'Voyage en Espagne', 'description3', 'Espagne', '450.00', 'chambre d\hôtel', 1, 'C:/temp/img/espagne.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (2, 4, 3, '128996', 'Voyage en Italie', 'description4', 'Italie', '300.00', 'chambre d\hôtel', 1, 'C:/temp/img/italy.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (3, 5, 2, '129997', 'Voyage à Tokyo', 'description5', 'Tokyo', '800.00', 'Appartement', 1, 'C:/temp/img/tokyo.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (4, 1, 1, '125693', 'Voyage aux Maldives', 'description1', 'Maldives', '900.00', 'Maison d\Hotes', 1, 'C:/temp/img/maldives.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (6, 1, 2, '125693', 'Voyage aux Maldives', 'description1', 'Maldives', '1000.00', 'Hotel', 1, 'C:/temp/img/maldives.jpg', 1);

--
-- Déchargement des données de la table `liste_commande`
--




INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (1, 1, 1, 2);
INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (2, 2, 1, 1);
INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (3, 3, 2, 5);
INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (4, 2, 4, 1);
INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (5, 4, 4, 1);
INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (6, 4, 5, 1);
INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (7, 6, 6, 1);
INSERT INTO `liste_commande` (`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (8, 6, 3, 1);



--
-- Déchargement des données de la table `possede`
--

INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (1, 1, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (2, 1, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (3, 1, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (4, 2, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (5, 3, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (6, 3, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (7, 3, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (8, 4, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (9, 5, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (10, 6, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (11, 6, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (12, 7, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (13, 7, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (14, 8, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (15, 8, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (16, 9, 1);
-- à supprimer en même temps que utilisateurConnecteDto
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (42, 42, 2);
