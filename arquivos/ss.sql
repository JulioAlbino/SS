-- phpMyAdmin SQL Dump
-- version 4.5.2deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 28, 2015 at 06:40 PM
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
(13, 'Funcionario', 25, 1, 2),
(14, 'Encarregado', 25, 1, 3),
(15, 'Administrador', 25, 1, 1);

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
(26, '2015-11-21', 'Ordem Finalizada', 4, 14, 9, 26, '2015-11-21', 14, 'Finalizada'),
(27, '2015-11-21', 'Ordem em Andamento', 2, 14, 8, 25, '2015-11-21', 14, NULL),
(28, '2015-11-21', 'Ordem Aguardando Encarregado setar como Finalizada', 3, 14, 8, 25, '2015-11-21', 14, 'Aguardando Finalizacao'),
(29, '2015-11-21', 'Ordem em Aberto', 1, 14, 8, 25, '2015-11-21', 14, NULL),
(30, '2015-11-21', 'Ordem de Teste', 4, 14, 8, 25, '2015-11-21', 16, 'Problema Resolvido');

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
(25, 'Setor 1', 1),
(26, ' Setor 2', 1),
(27, ' Setor 3', 1);

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
  MODIFY `idpedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `idsetor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
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
