-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 13 oct. 2019 à 20:22
-- Version du serveur :  10.4.6-MariaDB
-- Version de PHP :  7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `segabank`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `adresse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `id` int(11) NOT NULL,
  `solde` float NOT NULL,
  `idagence` int(11) NOT NULL,
  `code` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `epargne`
--

CREATE TABLE `epargne` (
  `id` int(11) NOT NULL,
  `tauxint` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `payant`
--

CREATE TABLE `payant` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `simple`
--

CREATE TABLE `simple` (
  `id` int(11) NOT NULL,
  `decouvert` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `FK_agence` (`idagence`);

--
-- Index pour la table `epargne`
--
ALTER TABLE `epargne`
  ADD KEY `FK_epargne` (`id`);

--
-- Index pour la table `payant`
--
ALTER TABLE `payant`
  ADD KEY `FK_payant` (`id`);

--
-- Index pour la table `simple`
--
ALTER TABLE `simple`
  ADD KEY `FK_simple` (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `FK_agence` FOREIGN KEY (`idagence`) REFERENCES `agence` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `epargne`
--
ALTER TABLE `epargne`
  ADD CONSTRAINT `FK_epargne` FOREIGN KEY (`id`) REFERENCES `compte` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `payant`
--
ALTER TABLE `payant`
  ADD CONSTRAINT `FK_payant` FOREIGN KEY (`id`) REFERENCES `compte` (`id`) ON DELETE CASCADE;

--
-- Contraintes pour la table `simple`
--
ALTER TABLE `simple`
  ADD CONSTRAINT `FK_simple` FOREIGN KEY (`id`) REFERENCES `compte` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
