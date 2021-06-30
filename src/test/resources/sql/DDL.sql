-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 22 avr. 2021 à 12:10
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdynh`
--
DROP DATABASE IF EXISTS `bdynh`;
CREATE DATABASE `bdynh` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bdynh`;
-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `idCommande` int(11) NOT NULL AUTO_INCREMENT,
  `reference` varchar(15) NOT NULL,
  `adresse_facturation` varchar(255) NOT NULL,
  `adresse_livraison` varchar(255) NOT NULL,
  `date_commande` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `prix_total_ante_remise` decimal(15,2) NOT NULL,
  `prix_avec_remise` decimal(15,2) NOT NULL,
  `quantiteTotale` int(11) NOT NULL,
  `idUtilisateur` int(11),
  PRIMARY KEY (`idCommande`),
  UNIQUE KEY `reference` (`reference`),
  KEY `fkIdCommande2` (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

DROP TABLE IF EXISTS `droit`;
CREATE TABLE IF NOT EXISTS `droit` (
  `idDroit` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(2048) NOT NULL,
  PRIMARY KEY (`idDroit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `liste_commande`
--

DROP TABLE IF EXISTS `liste_commande`;
CREATE TABLE IF NOT EXISTS `liste_commande` (
  `idListeCommande` int(11) NOT NULL AUTO_INCREMENT,
  `idProduit` int(11) NOT NULL,
  `idCommande` int(11) NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`idListeCommande`),
  UNIQUE KEY `UqidProduit_idCommande` (`idProduit`,`idCommande`),
  KEY `fkIdProduit` (`idProduit`),
  KEY `fkIdCommande` (`idCommande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `possede`
--

DROP TABLE IF EXISTS `possede`;
CREATE TABLE IF NOT EXISTS `possede` (
  `idPossede` int(11) NOT NULL AUTO_INCREMENT,
  `idDroit` int(11) NOT NULL,
  `idRole` int(11) NOT NULL,
  PRIMARY KEY (`idPossede`),
  UNIQUE KEY `UqidDroit_idRole` (`idDroit`,`idRole`),
  KEY `idDroit` (`idDroit`),
  KEY `idRole` (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE IF NOT EXISTS `produit` (
  `idProduitOriginal` int(11) NOT NULL AUTO_INCREMENT,
  `version` int(11) NOT NULL,
  `reference` varchar(15) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `destination` varchar(50) NOT NULL,
  `prix_unitaire` decimal(15,2) NOT NULL,
  `hebergement` varchar(255) NOT NULL,
  `mise_en_vente` tinyint(1) NOT NULL,
  `chemin_de_l_image` varchar(255) NOT NULL,
  `services` smallint(6) NOT NULL,
  PRIMARY KEY (`idProduitOriginal`),
  UNIQUE KEY `reference` (`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `produit_achete`
--

DROP TABLE IF EXISTS `produit_achete`;
CREATE TABLE IF NOT EXISTS `produit_achete` (
  `idProduit` int(11) NOT NULL AUTO_INCREMENT,
  `idDeLOriginal` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  `reference` varchar(15) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `destination` varchar(50) NOT NULL,
  `prix_unitaire` decimal(15,2) NOT NULL,
  `hebergement` varchar(255) NOT NULL,
  `mise_en_vente` tinyint(1) NOT NULL,
  `chemin_de_l_image` varchar(255) NOT NULL,
  `services` smallint(6) NOT NULL,
  PRIMARY KEY (`idProduit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `idRole` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  PRIMARY KEY (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `reference` varchar(15) NOT NULL,
  `date_d_inscription` datetime DEFAULT CURRENT_TIMESTAMP,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_de_naissance` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `adresse` varchar(255) NOT NULL,
  `email` varchar(320) NOT NULL,
  `password` varchar(255) NOT NULL,
  `chemin_de_lavatar` varchar(255) NOT NULL,
  `est_desactive` tinyint(1) NOT NULL,
  `idRole` int(11) NOT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `reference` (`reference`),
  KEY `fkidRole2` (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fkIdCommande2` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`idUtilisateur`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `liste_commande`
--
ALTER TABLE `liste_commande`
  ADD CONSTRAINT `fkIdCommande` FOREIGN KEY (`idCommande`) REFERENCES `commande` (`idCommande`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkIdProduit` FOREIGN KEY (`idProduit`) REFERENCES `produit_achete` (`idProduit`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `possede`
--
ALTER TABLE `possede`
  ADD CONSTRAINT `fkIdDroit` FOREIGN KEY (`idDroit`) REFERENCES `droit` (`idDroit`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkidRole` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fkidRole2` FOREIGN KEY (`idRole`) REFERENCES `role` (`idRole`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
