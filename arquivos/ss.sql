-- phpMyAdmin SQL Dump
-- version 4.5.1deb3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 07, 2015 at 05:14 PM
-- Server version: 5.6.25-4
-- PHP Version: 5.6.14-1+b1

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
  `setor_idsetor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cargo`
--

INSERT INTO `cargo` (`idcargo`, `nome`, `setor_idsetor`) VALUES
(1, 'cargoTeste', 1),
(2, 'UEPA', 1),
(3, 'UEPA2', 10);

-- --------------------------------------------------------

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
CREATE TABLE `local` (
  `idlocal` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `local`
--

INSERT INTO `local` (`idlocal`, `nome`) VALUES
(1, 'Teste123'),
(2, 'Teste123'),
(3, 'Inferno');

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
  `realizacoes` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`idpedido`, `datahora`, `descricao`, `situacao`, `usuario_idusuario`, `local_idlocal`, `setor_idsetor`, `dataultimamod`, `responsavel`, `realizacoes`) VALUES
(1, '2015-10-15', 'teste123', 2, 1, 1, 3, '2015-10-15', 1, ''),
(3, '2015-10-23', 'Bom dia 123', 2, 1, 2, 4, '2015-10-23', 1, ''),
(4, '2015-10-23', 'atestsae', 3, 1, 1, 1, '2015-10-23', 1, ''),
(5, '2015-10-23', 'Ribakinho', 4, 1, 1, 1, '2015-10-23', 1, ''),
(7, '2015-10-24', '11', 4, 1, 1, 1, '2015-10-24', 1, ''),
(8, '2015-10-24', 'teste', 1, 1, 1, 1, '2015-11-07', 1, 'Jesus Christ'),
(9, '2015-10-24', '123', 4, 1, 1, 1, '2015-10-24', 1, ''),
(10, '2015-10-24', '444', 4, 1, 2, 6, '2015-10-24', 1, ''),
(11, '2015-10-24', 'eaewww !!!', 4, 1, 1, 1, '2015-10-24', 1, ''),
(12, '2015-11-18', 'Rafael', 4, 4, 2, 8, '2015-11-18', 1, ''),
(13, '2015-11-12', '2222', 2, 3, 2, 8, '2015-11-07', 1, 'EEETA'),
(17, '2015-11-12', 'tstseset', 2, 2, 2, 3, '2015-11-12', 1, ''),
(18, '2015-11-06', 'UEPAAA 123', 0, 1, 1, 4, '2015-11-06', 1, ''),
(20, '2015-11-06', 't11111', 2, 1, 1, 1, '2015-11-06', 1, ''),
(21, '2015-11-06', 'daew123', 1, 1, 2, 9, '2015-11-06', 1, ''),
(22, '2015-11-06', 'ribakinho', 4, 1, 1, 9, '2015-11-06', 1, ''),
(25, '2015-11-06', '123 - Inferno', 4, 1, 3, 10, '2015-11-06', 1, ''),
(26, '2015-11-07', 'NOVA ORDEM !!!', 2, 1, 1, 1, '2015-11-07', 1, 'teeeeeeetaMurcha'),
(29, '2015-11-07', 'Ordem que vai ser assumida pelo OVO', 4, 1, 1, 1, '2015-11-07', 1, NULL),
(30, '2015-11-07', 'easttaesets', 1, 1, 1, 1, '2015-11-07', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
CREATE TABLE `setor` (
  `idsetor` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `setor`
--

INSERT INTO `setor` (`idsetor`, `nome`) VALUES
(1, 'setorTeste'),
(3, 'Setor:'),
(4, 'Setor:'),
(5, 'Setor:'),
(6, 'Setor:'),
(7, 'Setor:'),
(8, 'Setor:'),
(9, 'Opa'),
(10, ' 123');

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
  `cargo_idcargo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nome`, `senha`, `login`, `cargo_idcargo`) VALUES
(1, 'Usuario Teste', 'teste', 'teste', 2),
(2, '1234', 'teset', 'Usuario:', 2),
(3, '1234', 'teset', 'Usuario:', 2),
(4, 'MEU AMIGO123', 'teset', 'Usuario:', 3),
(5, '1234', 'teset', 'Usuario:', 2),
(6, '12312', 'eaew', 'Usuario:', 2),
(7, 'Rafael', '123', 'Usuario:', 3),
(8, 'ovoMaltine', '123', 'ovo', 3),
(9, '12345', '123', 'lindo', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`idcargo`,`setor_idsetor`),
  ADD KEY `fk_cargo_setor1_idx` (`setor_idsetor`);

--
-- Indexes for table `local`
--
ALTER TABLE `local`
  ADD PRIMARY KEY (`idlocal`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`idpedido`,`usuario_idusuario`,`local_idlocal`),
  ADD KEY `fk_pedido_usuario_idx` (`usuario_idusuario`),
  ADD KEY `fk_pedido_local1_idx` (`local_idlocal`),
  ADD KEY `fk_pedido_setor1_idx` (`setor_idsetor`),
  ADD KEY `responsavel` (`responsavel`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`idsetor`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`,`cargo_idcargo`),
  ADD KEY `fk_usuario_cargo1_idx` (`cargo_idcargo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cargo`
--
ALTER TABLE `cargo`
  MODIFY `idcargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `local`
--
ALTER TABLE `local`
  MODIFY `idlocal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `idpedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `idsetor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
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
