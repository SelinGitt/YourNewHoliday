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

INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (1, 1, "FRA9TZ9A7B", "Le Général Hôtel", "Niché dans une rue calme, juste à côté de l'avenue de la République, l'hôtel Le Général se trouve dans l'un des quartiers les plus branchés de Paris. À la croisée du Marais et du 11ème arrondissement, les quartiers mêlent histoire, art, bars et cafés populaires, salles de concert, marchés historiques, théâtres et nouvelles tendances.", "Paris", 151.99, "Hôtel", 1, "Paris.jpg", 45);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (2, 1, "GREK2WJJZW", "Oceanis Beach Report", "Prenez le temps de vous détendre dans le centre bien-être de l'établissement. Après une longue journée passée sur la plage privée, profitez des nombreuses infrastructures de loisirs à votre disposition et qui incluent une piscine extérieure et un sauna. Parmi les équipements et services offerts par cet hôtel vous trouvez également l'accès Wi-Fi à Internet gratuit, un service de concierge et un service de garde d'enfants payant.établissement fait l'objet d'une fermeture du 08 novembre au 27 mars. Les équipements et services proposés incluent un centre d'affaires, un service de départ express et une réception ouverte 24 heures sur 24. En échange d'un supplément, l'établissement propose une navette vers et depuis l'aéroport (disponible 24 h/24) et un parking gratuit se trouve dans l'enceinte de l'établissement.", "Ixià", 498.00, "Hôtel", 0, "greece.jpg", 0);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (3, 3, "ITAO194Y02", "Golfo dell'Asinara Beach Resort", "La détente avant tout ! Profitez des nombreuses options de loisirs disponibles dans l'établissement, notamment une piscine extérieure en saison, ou admirez la vue qui vous est offerte depuis une terrasse et un jardin. Parmi les services et équipements offerts par cet hôtel vous trouvez également l'accès Wi-Fi à Internet gratuit et un service d'assistance pour les visites touristiques ou l'achat de billets.", "Sardaigne", 344.95, "Resort", 1, "Italy.jpg", 511);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (4, 1, "MAL912A0NJ", "Kaani Beach Hotel", "Des massages vous attendent pour des moments de pur bien-être et la détente est au rendez-vous sur une terrasse sur le toit. Cet hôtel de style Art déco offre aussi features l'accès Wi-Fi à Internet gratuit, une salle de jeux vidéo et un service d'organisation de mariages. Les équipements et services proposés incluent un service de départ express, un service de nettoyage à sec / blanchisserie et une réception ouverte 24 heures sur 24. Une navette vers le terminal des ferrys est proposée gratuitement.", "Maldives", 997.00, "Chambres d'hôte", 1, "Maldives.jpg", 78);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (5, 2, "PORMEV5GUQ", "Muthu Clube Praia Da Oura", "L’hôtel 4 étoiles Clube Praia da Oura se trouve à seulement quelques minutes à pied de la plage. Admirez la vue sur la côte de l’Algarve depuis l’hôtel, détendez-vous à la bibliothèque et dans les piscines extérieures, et profitez d’un dîner décontracté et de divertissements en soirée aux bars et restaurants sur place. Vous pourrez aussi utiliser le salon de beauté et les barbiers de l’hôtel voisin, Forte Do Vale. Toutes les chambres de l’hôtel offrent la télévision par satellite et la connexion Wi-Fi.", "Albufeira", 231.00, "Appart'hôtel", 1, "portugal.jpg", 12);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (6, 1, "JAPHCUNQBK", "HONDORI INN", "En choisissant HONDORI INN, vous serez au cœur de Hiroshima, à moins de 10 minutes de marche de Dôme de la bombe atomique et de Musée d'art d'Hiroshima. Cet appartement se trouve à 0,7 km de Parc du mémorial de la paix de Hiroshima et à 1,1 km de Musée du mémorial pour la paix. A proximité du dôme de la bombe atomique.", "Hiroshima", 1080.00, "Appartement", 1, "Tokyo.jpg", 234);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (7, 4, "SPADINEJ9C", "Paradise Island", "Ce complexe-club très apprécié est niché dans des collines peu élevées, à la lisière de Playa Blanca. Ses clients pourront facilement rejoindre à pied (1,5 km) de nombreux magasins et lieux de divertissement. Il y a une navette régulière et un arrêt de bus à 1 km de l'hôtel.", "Lanzarote", 681.00, "Hôtel", 0, "espagne.jpg", 176);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (8, 1, "BRA3LS6LV5", "Copacabana Beach", "Situé dans la rue principale du quartier de Leme, face à la plage, au bout de la célèbre promenade de Copacabana Beach et à proximité du téléphérique du Pain de Sucre, cet hôtel est l’endroit idéal pour profiter des nombreuses animations de Rio. L’hôtel propose de spacieuses chambres climatisées dotées d’un accès WIFI gratuit, d’une télévision avec chaînes câblées et d’un minibar. Confortables et avec un décor moderne, les chambres sont idéales pour vous détendre après une journée de visite dans Rio. ", "Rio de Janeiro", 1299.00, "Hôtel", 1, "bresil.jpg", 421);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (9, 1, "AUSZWNO0ZQ", "ADELAIDE CENTRAL YHA", "Surplombant le pittoresque Light Square au cœur du centre-ville, l'Adelaide Central YHA est une auberge de jeunesse moderne. Elle propose des hébergements confortables en dortoirs et des chambres privées. Ce logement budget offre un excellent rapport qualité-prix.", "Sydney", 879.00, "Auberge de jeunesse", 0, "australie.jpg", 344);
INSERT INTO produit(idProduitOriginal, version, reference, nom, description, destination, prix_unitaire, hebergement, mise_en_vente, chemin_de_l_image, services) VALUES (10, 3, "SOU0VNLXRV", "PILGRIMS REST", "Pour une première approche de l'Afrique du Sud avec au programme la visite du célèbre canyon de la Blyde River, profond de 600 à 800 mètres, offrant un panorama spectaculaire et des cascades grandioses. Puis direction les pistes sauvages du fameux parc Kruger pour une rencontre avec le monde animalier. Vous terminerez par la visite de Soweto, lieu chargé d'histoire et jadis cœur de la lutte anti-apartheid.", "Johannesburg", 1499.00, "Hôtel", 1, "afriqueDuSud.jpg", 272);

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
INSERT INTO `droit` (`idDroit`, `url`) VALUES (26, 'uploadImageUser.do');

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`idRole`, `libelle`) VALUES (1, 'Visiteur');
INSERT INTO `role` (`idRole`, `libelle`) VALUES (2, 'Client');
INSERT INTO `role` (`idRole`, `libelle`) VALUES (3, 'Administrateur');



--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (1, "USRTE5QUFI", "2021-01-01", "Moreau", "David", "1988-07-19", "235 avenue du Président Kennedy 31000 Toulouse", "david.moreau@hotmail.com", "B3D11D5B56C40067E6138372AB69066DD3780914A8829D1A4E90B507F5E52657", "USRTE5QUFI.jpg", 0, 3);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (2, "USRVI0XYC5", "2021-02-01", "Dupont", "Mathieu", "1966-12-12", "11 rue Solférino 59000 Lille", "dupont.mathieu@hotmail.fr", "65FDB01D9DF454211580537702F6BA7E92FF21224AACBEFC8006DF21E1108B6E", "USRVI0XYC5.jpg", 0, 2);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (3, "USRB7YTJ7C", "2021-02-02", "Smith", "Hannah", "1985-05-15", "46 Tichfield St. Liverpool L5 8UT UNITED KINGDOM", "smith.hannah@gmail.com", "44385B017DA71550ACCDCA619FD0DF5ADDF860EC34CCCBFA9B0F5F09FC5D3DF8", "USRB7YTJ7C.jpg", 0, 2);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (4, "USRYASJD3E", "2021-05-06", "Fournier", "Henry", "1959-03-21", "159 rue du Général de Gaulle 75000 Paris", "fournier.henry@hotmail.fr", "C08899A109D9E682D1E1A52D0A599F26512E51F3625BC33C92253D3F54C4FC92", "USRYASJD3E.jpg", 1, 2);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (5, "USRWHKO9JW", "2021-01-15", "Lambert", "Jeanne", "1983-07-19", "47 boulevard Deschamps", "lambert.jeanne@hotmail.fr", "3A1AA238777F22C06B574520DEDD22283E268AC3370577E1D2F8E6D89BB3E4B4", "USRWHKO9JW.png", 0, 3);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (6, "USR1HJM9P9", "2021-01-22", "Charpentier", "Marine", "1994-11-11", "65 rue de Lesquin 59155 Faches Thumesnil", "char.marine@hotmail.fr", "B64D1B147B5D76B991241E955D61850FB879E039501C58C9C60BF8E3F8D07D6D", "default_avatar.jpg", 0, 3);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (7, "USRWJVHA5M", "2021-04-25", "Meunier", "Pierre", "1978-07-12", "457 rue du faubourg de Douai 33000 Bordeaux", "meunier.pierre@hotmail.fr", "46A15A2D9661122CC9500ED28D2BF281737DF5E59389572282AED3FD3B60A0AD", "USRWJVHA5M.png", 0, 2);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (8, "USRKWZPLCI", "2021-05-05", "Cooper", "Penny", "1977-09-30", "33 Leicester St. London L7 UNITED KINGDOM", "penny.cooper@gmail.com", "6421BB94F9B7AD7610257AE45EF365FAAEBFC1AE1C828B6971FEC848E9FBF5EB", "default_avatar.jpg", 1, 2);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (9, "USRMC6DNXA", "2021-06-16", "Rodriguez", "Pedro", "1984-02-29", "122 rue de la bonne étoile 75011 Paris", "pedro.rodriguez@hotmail.fr", "193C8239F05CC9F1105B45D9FF7C882C025511621D6BA34FD510FA2EE55FB3B4", "USRMC6DNXA.png", 0, 2);
INSERT INTO `utilisateur`(`idUtilisateur`, `reference`, `date_d_inscription`, `nom`, `prenom`, `date_de_naissance`, `adresse`, `email`, `password`, `chemin_de_lavatar`, `est_desactive`, `idRole`) VALUES (10, "USRUCGO5A8", "2021-04-03", "Rolland", "Marianne", "1971-12-25", "56 rue de la chance 13000 Marseille", "rolland.marianne@hotmail.fr", "C5D13ACCE9406D0DB149E51796F4793EE2F8727B971D1DD520F68C8D4D2451A3", "default_avatar.jpg", 0, 2);

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (1, "MP5009052150411", "Meunier", "Pierre", "457 rue du faubourg de Douai 33000 Bordeaux", "Meunier", "Pierre", "457 rue du faubourg de Douai 33000 Bordeaux", "2021-05-09 	13:49:11", 17110.00, 16254.50, 50, 7);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (2, "SH0502022146892", "Smith", "Hannah", "46 Tichfield St. Liverpool L5 8UT UNITED KINGDOM", "Lawson", "Sandra", "46 Tichfield St. Liverpool L5 8UT UNITED KINGDOM", "2021-02-02 	13:12:12", 1711.00, 1711.00, 5, 3);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (3, "RP1009072139643", "Sanchez", "Marta", "122 rue de la bonne étoile 75011 Paris", "Rodriguez", "Pedro", "122 rue de la bonne étoile 75011 Paris", "2021-07-09 	11:28:43", 13990.00, 13990.00, 10, 9);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (4, "CP0212052146801", "Cooper", "Penny", "33 Leicester St. London L7 UNITED KINGDOM", "Cooper", "Penny", "33 Leicester St. London L7 UNITED KINGDOM", "2021-05-12 	12:54:11", 462.00, 462.00, 2, 8);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (5, "CM0315042128803", "Charpentier", "Morice", "65 rue de Lesquin 59155 Faches Thumesnil", "Charpentier", "Morice", "4 rue Marie Curie 62100 Calais", "2021-04-15 	08:23:43", 636.00, 636.00, 3, 6);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (6, "MD0401072132489", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "2021-07-01 	09:09:09", 5596.00, 5596.00, 4, 1);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (7, "MD0211022168454", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "2021-02-11 	19:23:54", 2160.00, 2160.00, 2, 1);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (8, "MD0108042182853", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "2021-04-08 	22:43:33", 300.00, 300.00, 1, 1);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (9, "MD0201072139614", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "2021-01-13 	11:13:14", 303.98, 303.98, 2, 1);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (10, "MD0111022143242", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "2021-03-24 	12:12:12", 1299.00, 1299.00, 1, 1);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (11, "MD0108042161274", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "2021-05-17 	21:03:54", 151.99, 151.99, 1, 1);
INSERT INTO `commande`(`idCommande`, `reference`, `nom_facturation`, `prenom_facturation`, `adresse_facturation`, `nom_livraison`, `prenom_livraison`, `adresse_livraison`, `date_commande`, `prix_total_ante_remise`, `prix_avec_remise`, `quantiteTotale`, `idUtilisateur`) VALUES (12, "MD0106062114863", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "Moreau", "David", "235 avenue du Président Kennedy 31000 Toulouse", "2021-06-06 	03:43:33", 455.97, 455.97, 3, 1);

--
-- Déchargement des données de la table `produit_achete`
--

INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (1, 3, 2, "ITAE133ZGW", "Italia Beach Resort", "La détente avant tout ! Profitez des nombreuses options de loisirs disponibles dans l'établissement, notamment un spa en extérieur ! Parmi les services et équipements offerts par cet hôtel vous trouvez également l'accès Wi-Fi à Internet gratuit.", "Sardaigne", 399.00, "Resort", 1, "Italy.jpg", 511);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (2, 5, 1, "POR6FJS6WU", "Albufeira Hotel", "Un hôtel liant le charme de l'ancien à la mordernité du monde actuel ! ", "Albufeira", 231.00, "Appart'hôtel", 1, "portugal.jpg", 12);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (3, 7, 1, "SPA9WE75U0", "Espana Hotel", "Ce complexe-club très apprécié est niché dans des collines peu élevées, à la lisière de Playa Blanca. Ses clients pourront facilement rejoindre à pied (1,5 km) de nombreux magasins et lieux de divertissement. Il y a une navette régulière et un arrêt de bus à 1 km de l'hôtel.", "Lanzarote", 212.00, "Hôtel", 1, "espagne.jpg", 5);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (4, 7, 2, "SPAE6KDBLZ", "Lanzarote Hotel", "Ce complexe-club très apprécié est niché dans des collines peu élevées, à la lisière de Playa Blanca. Ses clients pourront facilement rejoindre à pied (1,5 km) de nombreux magasins et lieux de divertissement. Il y a une navette régulière et un arrêt de bus à 1 km de l'hôtel.", "Lanzarote", 300.00, "Hôtel", 1, "espagne.jpg", 43);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (5, 7, 3, "SPAKJ6IYTS", "Fuerteventura Hotel", "Ce complexe-club très apprécié est niché dans des collines peu élevées, à la lisière de Playa Blanca. Ses clients pourront facilement rejoindre à pied (1,5 km) de nombreux magasins et lieux de divertissement. Il y a une navette régulière et un arrêt de bus à 1 km de l'hôtel.", "Lanzarote", 569.00, "Hôtel", 1, "espagne.jpg", 100);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (6, 10, 3, "SOU04EOTU9", "PILGRIMS REST", "Pour une première approche de l'Afrique du Sud avec au programme la visite du célèbre canyon de la Blyde River, profond de 600 à 800 mètres, offrant un panorama spectaculaire et des cascades grandioses. Puis direction les pistes sauvages du fameux parc Kruger pour une rencontre avec le monde animalier. Vous terminerez par la visite de Soweto, lieu chargé d'histoire et jadis cœur de la lutte anti-apartheid.", "Johannesburg", 1399.00, "Hôtel", 1, "afriqueDuSud.jpg", 233);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (7, 6, 1, "JAPHCUNQBK", "HONDORI INN", "En choisissant HONDORI INN, vous serez au cœur de Hiroshima, à moins de 10 minutes de marche de Dôme de la bombe atomique et de Musée d'art d'Hiroshima. Cet appartement se trouve à 0,7 km de Parc du mémorial de la paix de Hiroshima et à 1,1 km de Musée du mémorial pour la paix. A proximité du dôme de la bombe atomique.", "Hiroshima", 1080.00, "Appartement", 1, "Tokyo.jpg", 234);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (8, 1, 1, "FRA9TZ9A7B", "Le Général Hôtel", "Niché dans une rue calme, juste à côté de l'avenue de la République, l'hôtel Le Général se trouve dans l'un des quartiers les plus branchés de Paris. À la croisée du Marais et du 11ème arrondissement, les quartiers mêlent histoire, art, bars et cafés populaires, salles de concert, marchés historiques, théâtres et nouvelles tendances.", "Paris", 151.99, "Hôtel", 1, "Paris.jpg", 45);
INSERT INTO `produit_achete`(`idProduit`, `idDeLOriginal`, `version`, `reference`, `nom`, `description`, `destination`, `prix_unitaire`, `hebergement`, `mise_en_vente`, `chemin_de_l_image`, `services`) VALUES (9, 8, 1, "BRA3LS6LV5", "Copacabana Beach", "Situé dans la rue principale du quartier de Leme, face à la plage, au bout de la célèbre promenade de Copacabana Beach et à proximité du téléphérique du Pain de Sucre, cet hôtel est l’endroit idéal pour profiter des nombreuses animations de Rio. L’hôtel propose de spacieuses chambres climatisées dotées d’un accès WIFI gratuit, d’une télévision avec chaînes câblées et d’un minibar. Confortables et avec un décor moderne, les chambres sont idéales pour vous détendre après une journée de visite dans Rio. ", "Rio de Janeiro", 1299.00, "Hôtel", 1, "bresil.jpg", 421);

--
-- Déchargement des données de la table `liste_commande`
--

INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (1, 1, 1, 10);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (2, 2, 1, 10);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (3, 3, 1, 10);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (4, 4, 1, 10);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (5, 5, 1, 10);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (6, 1, 2, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (7, 2, 2, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (8, 3, 2, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (9, 4, 2, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (10, 5, 2, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (11, 6, 3, 10);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (12, 2, 4, 2);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (13, 3, 5, 3);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (14, 6, 6, 4);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (15, 7, 7, 2);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (16, 4, 8, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (17, 8, 9, 2);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (18, 9, 10, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (19, 8, 11, 1);
INSERT INTO `liste_commande`(`idListeCommande`, `idProduit`, `idCommande`, `quantite`) VALUES (20, 8, 12, 3);

--
-- Déchargement des données de la table `possede`
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
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (51, 26, 1);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (52, 26, 2);
INSERT INTO `possede` (`idPossede`, `idDroit`, `idRole`) VALUES (53, 26, 3);