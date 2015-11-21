-- phpMyAdmin SQL Dump
-- version 4.5.1deb3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 21, 2015 at 03:25 PM
-- Server version: 5.6.27-2
-- PHP Version: 5.6.15-1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ss`
--
CREATE DATABASE IF NOT EXISTS `ss` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ss`;

-- --------------------------------------------------------

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `idcargo` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `setor_idsetor` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `permissoes` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cargo`
--

INSERT INTO `cargo` (`idcargo`, `nome`, `setor_idsetor`, `ativo`, `permissoes`) VALUES
(1, 'Cargo1 - Setor 11', 11, 0, 1),
(2, 'Cargo2 - Setor8', 8, 0, 1),
(3, 'Cargo3 - Setor11', 11, 0, 1),
(4, 'cargo4 - setor20', 20, 0, 1),
(5, 'Cargo5 - setor 21', 21, 0, 1),
(6, 'TESTE', 22, 0, 1),
(7, 'EAEW', 21, 0, 1),
(8, 'eaew', 21, 0, 2),
(9, 'EncarregadoTeste', 21, 0, 3),
(10, 'FuncionarioTeste', 22, 0, 2),
(11, 'AdministradorTeste', 22, 0, 1),
(12, 'Administrador', 22, 0, 1),
(13, 'Funcionario', 23, 1, 2),
(14, 'Encarregado', 23, 1, 3),
(15, 'Administrador', 24, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
CREATE TABLE `local` (
  `idlocal` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `local`
--

INSERT INTO `local` (`idlocal`, `nome`, `ativo`) VALUES
(6, 'Local6', 0),
(7, 'tesssta', 0),
(8, 'LOCAL8', 1),
(9, 'LOCAL9', 1),
(10, 'LOCAL1012312', 0),
(11, 'LOCAL11', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL,
  `datahora` date DEFAULT NULL,
  `descricao` varchar(999) DEFAULT NULL,
  `situacao` int(11) DEFAULT NULL,
  `usuario_idusuario` int(11) NOT NULL,
  `local_idlocal` int(11) NOT NULL,
  `setor_idsetor` int(11) NOT NULL,
  `dataultimamod` date DEFAULT NULL,
  `responsavel` int(11) DEFAULT NULL,
  `realizacoes` varchar(999) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`idpedido`, `datahora`, `descricao`, `situacao`, `usuario_idusuario`, `local_idlocal`, `setor_idsetor`, `dataultimamod`, `responsavel`, `realizacoes`) VALUES
(18, '2015-11-06', 'UEPAAA 123', 0, 1, 6, 4, '2015-11-06', 13, '');

-- --------------------------------------------------------

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
CREATE TABLE `setor` (
  `idsetor` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `ativo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `setor`
--

INSERT INTO `setor` (`idsetor`, `nome`, `ativo`) VALUES
(1, 'SETOR1', 0),
(3, 'SETOR2', 0),
(4, 'SETOR3', 0),
(6, 'SETOR6', 0),
(7, 'SETOR7', 0),
(8, 'SETOR8', 0),
(9, 'SETOR9', 0),
(10, 'SETOR10', 0),
(11, 'SETOR11', 0),
(12, 'Setor12', 0),
(13, 'Setor13', 0),
(14, 'Setor14', 0),
(15, 'Setor15', 0),
(16, 'SETOR16', 0),
(17, 'sadffads', 0),
(18, 'SETORNOVOXXX', 0),
(19, 'SETOR19 - Editado', 0),
(20, 'SETOR20 - Editado', 0),
(21, 'SETOR 21', 0),
(22, 'Setor 22', 1),
(23, 'SETOR23', 1),
(24, 'Setor24', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `cargo_idcargo` int(11) NOT NULL,
  `ativo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nome`, `senha`, `login`, `cargo_idcargo`, `ativo`) VALUES
(1, 'Usuario Teste', 'teste', 'teste', 2, 0),
(2, '1234', 'teset', 'Usuario:', 4, 0),
(3, '1234', 'teset', 'Usuario:', 2, 0),
(4, 'MEU AMIGO1234', 'teset', 'Usuario:', 3, 0),
(5, '1234', 'teset', 'Usuario:', 2, 0),
(6, '12312', 'eaew', 'Usuario:', 2, 0),
(7, 'Rafael', '123', 'Usuario:', 4, 0),
(8, 'ovoMaltine', '123', 'ovo', 5, 0),
(9, '12345', '123', 'lindo', 3, 0),
(10, 'EAEW', '1', '1', 2, 0),
(11, '123456', '123', 'VIOLINO', 2, 0),
(12, 'Usuario FODAL', '12345', 'etaa', 2, 0),
(13, 'EVARISTO', '2', '2', 13, 0),
(14, '1', '1', '1', 15, 1),
(15, ' 2', '2', '2', 14, 1),
(16, ' 3', '3', '3', 13, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idcargo`,`setor_idsetor`),
  ADD KEY `fk_cargo_setor1_idx` (`setor_idsetor`),
  ADD KEY `idcargo` (`idcargo`);

--
-- Indexes for table `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`idlocal`),
  ADD KEY `idlocal` (`idlocal`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idpedido`,`usuario_idusuario`,`local_idlocal`),
  ADD KEY `fk_pedido_usuario_idx` (`usuario_idusuario`),
  ADD KEY `fk_pedido_local1_idx` (`local_idlocal`),
  ADD KEY `fk_pedido_setor1_idx` (`setor_idsetor`),
  ADD KEY `responsavel` (`responsavel`),
  ADD KEY `descricao` (`descricao`(767)),
  ADD KEY `idpedido` (`idpedido`),
  ADD KEY `situacao` (`situacao`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`idsetor`),
  ADD KEY `idsetor` (`idsetor`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`,`cargo_idcargo`),
  ADD KEY `fk_usuario_cargo1_idx` (`cargo_idcargo`),
  ADD KEY `login` (`login`),
  ADD KEY `senha` (`senha`),
  ADD KEY `idusuario` (`idusuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idcargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `local`
--
ALTER TABLE `local`
  MODIFY `idlocal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idpedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `idsetor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `cargo`
--
ALTER TABLE `cargo`
  ADD CONSTRAINT `fk_cargo_setor1` FOREIGN KEY (`setor_idsetor`) REFERENCES `setor` (`idsetor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_local1` FOREIGN KEY (`local_idlocal`) REFERENCES `local` (`idlocal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_setor1` FOREIGN KEY (`setor_idsetor`) REFERENCES `setor` (`idsetor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pedido_usuario` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
