-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- H�te : 127.0.0.1:3306
-- G�n�r� le : jeu. 22 avr. 2021 � 12:17
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de donn�es : `bdynh`
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
-- D�chargement des donn�es de la table `produit`
--

INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (1, 2, 'MVR1256934', 'Voyage aux Maldives', 'description1', 'Maldives', '900.00', 'Maison dHotes', 1, 'maldives.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (2, 1, 'GRC1267941', 'Voyage en Gr�ce', 'description2', 'Gr�ce', '500.00', 'Suite', 0, 'greece.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (3, 1, 'SPA1278951', 'Voyage en Espagne', 'description3', 'Espagne', '450.00', 'chambre dh�tel', 1, 'espagne.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (4, 3, 'ITA1289967', 'Voyage en Italie', 'description4', 'Italie', '300.00', 'chambre dh�tel', 1, 'italy.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (5, 1, 'TYO1299974', 'Voyage � Tokyo', 'description5', 'Tokyo', '800.00', 'Appartement', 1, 'tokyo.jpg', 1);
INSERT INTO `produit` (`idProduitOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (6, 1, 'POR1299984', 'Voyage au Portugal ', 'description6', 'Portugal', '600.00', 'Maison dHotes', 0, 'portugal.jpg', 1);

--
-- D�chargement des donn�es de la table `droit`
--

INSERT INTO `droit` (`idDroit`, `url`) VALUES (1, 'listerProduits.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (2, 'listerUtilisateur.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (3, 'contact.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (4, 'listerProduitsAdmin.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (5, 'connecter.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (6, 'creerUtilisateur.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (7, 'deconnecter.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (8, 'listerCommande.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (9, 'modifierUtilisateur.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (10, 'consulterUtilisateur.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (11, 'creerProduitAdmin.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (12, 'consulterProduit.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (13, 'editerProduitAdmin.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (14, 'detailCommande.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (15, 'listerPanierProduits.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (16, 'listerPanierAdresses.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (17, 'mentionsLegales.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (18, 'displayImage.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (19, 'supprimerUtilisateur.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (20, 'supprimerProduitPanier.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (21, 'viderPanier.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (22, 'modifierQuantite.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (23, 'validerPanierProduits.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (24, 'ajouterProduitPanier.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (25, 'validerPanier.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (26, 'supprimerProduitAdmin.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (27, 'uploadImageUser.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (28, 'uploadImageProduit.do');
INSERT INTO `droit` (`idDroit`, `url`) VALUES (29, 'consulterProduitAchete.do');

--
-- D�chargement des donn�es de la table `role`
--

INSERT INTO `role` (`idRole`, `libelle`) VALUES (1, 'Visiteur');
INSERT INTO `role` (`idRole`, `libelle`) VALUES (2, 'Client');
INSERT INTO `role` (`idRole`, `libelle`) VALUES (3, 'Administrateur');



--
-- D�chargement des donn�es de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (1, 'VISITEUR0000001', '2021-04-12 11:30:51', 'Visiteur01', 'Visiteur', '2021-04-12 11:30:51', 'En Visite', 'visiteur@gmail.com', 'NoPassWord', '/img/visiteur01.png', 0, 1);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (2, 'ClientCLIENT123', '2021-04-01 16:30:02', 'Barath�on', 'Robert', '2000-10-17 22:30:46', '13 rue de Port R�al\r\n59000 Lille', 'baratheon.robert@hotmail.com', '46E43F808CF3CAB2C8AC6321D7FF743F43A13A412C38FAFFDDD8252D711113E2', '/img/image_01.png', 0, 2);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (3, 'ClientCLIENT456', '2021-04-12 11:30:51', 'Lanister', 'Cersey', '2002-05-30 11:25:12', '28 rue de Port R�al\r\n59000 Lille', 'cersey.lanister@gmail.com', '89CB729B086227098038A94DFA0302264F1AC476A47F170FF36E4E424704E98F', '/img/image_02.png', 0, 2);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (4, 'ClientCLIENT753', '2021-04-06 11:14:03', 'Jackson', 'Persey', '1985-12-31 00:00:00', '12 rue de la toison d\or\r\n59200 Villeneuve d\Ascq', 'persey.jackson@gmail.com', '24E66925A7BCDB8F1F0DB288ED0A141876342E9C63EEA506C0680CBF1FDBA99C', '/img/image_03.png', 0, 2);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (5, 'clientCLIENT789', '2020-12-09 11:18:02', 'Maimai', 'Maiko', '1995-08-12 00:30:30', '14 rue de la marmelade\r\n59100 ROUBAIX', 'maiko.maimai@gmail.com', 'D631ABB9C855BF981CB65F57557E0B27B43D458C58F6DCDA8416E922F5A01AD9', '/img/image_04.png', 1, 2);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (6, 'Administrateur1', '1999-07-05 10:40:42', 'Marsial', 'Tony', '1978-06-06 00:00:00', '15 rue de Venon\r\n59000 Lille', 'marsial.tony@gmail.com', '7A69AC317999979CB5FB116A797C41A4207348FA7B26DAB94FF4EED5AE0BDB7D', '/img/image_05.png', 0, 3);
INSERT INTO `utilisateur` (`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (7, 'Administrateur2', '2021-03-01 11:26:30', 'Marly', 'Cynthia', '2001-01-16 18:02:09', '59 rue du ciel\r\n59100 Roubaix', 'cynthia.marly@gmail.com', '6F482F6246F6095B77E654F902F8AD31C739D32F1ED1CF4FF754052CE7D79D38', '/img/image_06.png', 1, 3);

--
-- D�chargement des donn�es de la table `commande`
--

INSERT INTO `commande` (`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES(1, 'ABC1', 'Dupont', 'Rolan', '12, rue des oiseaux bleu, 75005, Paris', 'Dupont', 'Rolan', '12, rue des oiseaux bleu, 75005, Paris', '2021-02-09 13:49:11', '1200.00', '1200.00', 3, 2);
INSERT INTO `commande` (`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES(2, 'ABC2', 'Barath�on', 'Robert', '12, rue des oiseaux bleu, 75005, Paris', 'Dupont', 'Rolan', '12, rue des oiseaux bleu, 75005, Paris', '2021-04-01 13:49:11', '4000.00', '3600.00', 5, 2);
INSERT INTO `commande` (`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES(3, 'ABC3', 'Robert', 'Marcel', '3, rue du Paradis, 62400, B�thune', 'Lanister', 'Cersey', '3, rue du Paradis, 62400, B�thune', '2020-11-13 13:50:33', '600.00', '600.00', 1, 3);
INSERT INTO `commande` (`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES(4, 'ABC4', 'Lanister', 'Cersey', '3, rue du Paradis, 62400, B�thune', 'Lanister', 'Cersey', '3, rue du Paradis, 62400, B�thune', '2021-02-09 13:50:33', '1200.00', '1200.00', 2, 3);
INSERT INTO `commande` (`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES(5, 'ABC5', 'Maimai', 'Maiko', '124, rue du petit chemin, 59000, Lille', 'LeForestier', 'Maxime', '221, rue de l�glise 59790, Ronchin', '2021-03-17 13:52:28', '900.00', '900.00', 1, 5);
INSERT INTO `commande` (`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES(6, 'ABC6', 'Marsial', 'Tony', '124, rue du petit chemin, 59000, Lille', 'Marsial', 'Tony', '221, rue de l�glise 59790, Ronchin', '2021-04-12 14:02:45', '1000.00', '1000.00', 1, 6);

--
-- D�chargement des donn�es de la table `produit_achete`
--

INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (1, 3, 1, 'SPA1278951', 'Voyage en Espagne', 'description3', 'Espagne', '450.00', 'chambre d\h�tel', 1, 'espagne.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (2, 4, 3, 'ITA1289967', 'Voyage en Italie', 'description4', 'Italie', '300.00', 'chambre d\h�tel', 1, 'italy.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (3, 5, 2, 'TYO1299974', 'Voyage � Tokyo', 'description5', 'Tokyo', '800.00', 'Appartement', 1, 'tokyo.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (4, 1, 1, 'MVR1256934', 'Voyage aux Maldives', 'description1', 'Maldives', '900.00', 'Maison d\Hotes', 1, 'maldives.jpg', 1);
INSERT INTO `produit_achete` (`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (6, 1, 2, 'MVR1256934', 'Voyage aux Maldives', 'description1', 'Maldives', '1000.00', 'Hotel', 1, 'maldives.jpg', 1);

--
-- D�chargement des donn�es de la table `liste_commande`
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
-- D�chargement des donn�es de la table `possede`
--

INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (1, 1, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (2, 1, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (3, 1, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (4, 2, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (5, 3, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (6, 3, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (7, 3, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (8, 4, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (9, 5, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (10, 6, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (11, 6, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (12, 7, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (13, 7, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (14, 8, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (15, 8, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (16, 9, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (17, 9, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (18, 10, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (19, 10, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (20, 11, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (21, 12, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (22, 12, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (23, 12, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (24, 13, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (25, 14, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (26, 14, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (27, 15, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (28, 15, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (29, 16, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (30, 16, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (31, 17, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (32, 17, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (33, 17, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (34, 18, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (35, 18, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (36, 18, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (37, 19, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (38, 19, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (39, 20, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (40, 20, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (41, 21, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (42, 21, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (43, 22, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (44, 22, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (45, 23, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (46, 23, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (47, 24, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (48, 24, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (49, 25, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (50, 25, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (51, 26, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (52, 27, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (53, 27, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (54, 27, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (55, 28, 3);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (56, 29, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (57, 29, 3);
