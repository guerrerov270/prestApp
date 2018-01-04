CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.5.58, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.58-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Abono`
--

DROP TABLE IF EXISTS `Abono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Abono` (
  `idAbono` int(11) NOT NULL AUTO_INCREMENT,
  `montoAbono` decimal(10,0) NOT NULL,
  `completoAbono` tinyint(1) NOT NULL,
  `fechaAbono` date DEFAULT NULL,
  `abonoPrestamo` int(11) NOT NULL,
  `puntualAbono` tinyint(1) NOT NULL,
  `estadoAbono` enum('PENDIENTE','PAGADO','ERROR') NOT NULL,
  `numeroAbono` int(3) NOT NULL,
  PRIMARY KEY (`idAbono`,`abonoPrestamo`),
  KEY `fk_abono_prestamo` (`abonoPrestamo`),
  CONSTRAINT `fk_abono_prestamo` FOREIGN KEY (`abonoPrestamo`) REFERENCES `Prestamo` (`idPrestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Abono`
--

LOCK TABLES `Abono` WRITE;
/*!40000 ALTER TABLE `Abono` DISABLE KEYS */;
/*!40000 ALTER TABLE `Abono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `idCliente` int(16) NOT NULL AUTO_INCREMENT,
  `nombreCliente` varchar(45) NOT NULL,
  `empresaCliente` varchar(45) NOT NULL,
  `referenciaCliente` varchar(45) NOT NULL,
  `estadoCliente` enum('RECOMENDADO','ERROR','NO RECOMENDADO') DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (23,'Julian','NextU','Ingeniero',NULL);
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prestamo`
--

DROP TABLE IF EXISTS `Prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Prestamo` (
  `idPrestamo` int(11) NOT NULL AUTO_INCREMENT,
  `montoPrestamo` decimal(10,0) NOT NULL,
  `tasaInteresPrestamo` int(11) NOT NULL,
  `numeroCuotasPrestamo` int(11) NOT NULL,
  `saldoPendientePrestamo` decimal(10,0) NOT NULL,
  `saldoPagadoPrestamo` decimal(10,0) NOT NULL,
  `fechaInicioPrestamo` date NOT NULL,
  `fechaFinPrestamo` date NOT NULL,
  `tipoPlazoPrestamo` enum('MENSUAL','QUINCENAL','SEMANAL','OTRO') NOT NULL,
  `idClienteFK` int(11) NOT NULL,
  `estadoPrestamo` enum('PENDIENTE','PAGADO','REFINANCIADO','ERROR') NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  KEY `fk_prestamo_cliente` (`idClienteFK`),
  CONSTRAINT `fk_prestamo_cliente` FOREIGN KEY (`idClienteFK`) REFERENCES `Cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamo`
--

LOCK TABLES `Prestamo` WRITE;
/*!40000 ALTER TABLE `Prestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'test'
--

--
-- Dumping routines for database 'test'
--
/*!50003 DROP PROCEDURE IF EXISTS `agregar_abono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_abono`(montoAbono DECIMAL, completoAbono TINYINT(1),fechaAbono DATE,abonoPrestamo INT,puntualAbono TINYINT(1),estadoAbono ENUM('PENDIENTE','PAGADO'),numeroAbono INT(3))
INSERT INTO `test`.`Abono` (`montoAbono`, `completoAbono`,`fechaAbono`,`abonoPrestamo`,`puntualAbono`,`estadoAbono`,`numeroAbono`) VALUES (montoAbono, completoAbono,fechaAbono,abonoPrestamo,puntualAbono,estadoAbono,numeroAbono) ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agregar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_cliente`(nombreCliente VARCHAR(45),empresaCliente VARCHAR(45),referenciaCliente VARCHAR(45))
INSERT INTO `test`.`Cliente` (`nombreCliente`, `empresaCliente`,`referenciaCliente`) VALUES (nombreCliente, empresaCliente, referenciaCliente) ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agregar_prestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_prestamo`(montoPrestamo DECIMAL,tasaInteresPrestamo INT,numeroCuotasPrestamo INT,saldoPendientePrestamo DECIMAL, saldoPagadoPrestamo DECIMAL, fechaInicioFormateada DATE, fechaFinFormateada DATE, tipoPlazoPrestamo ENUM('MENSUAL','QUINCENAL','SEMANAL','OTRO'), idClienteFK INT, estadoPrestamo ENUM('PENDIENTE','PAGADO','REFINANCIADO'))
INSERT INTO `test`.`Prestamo` (`montoPrestamo`, `tasaInteresPrestamo`,`numeroCuotasPrestamo`,`saldoPendientePrestamo`,`saldoPagadoPrestamo`,`fechaInicioPrestamo`,`fechaFinPrestamo`,`tipoPlazoPrestamo`,`idClienteFK`, `estadoPrestamo`) VALUES (montoPrestamo, tasaInteresPrestamo, numeroCuotasPrestamo,saldoPendientePrestamo, saldoPagadoPrestamo, fechaInicioFormateada, fechaFinFormateada, tipoPlazoPrestamo, idClienteFK, estadoPrestamo) ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_cliente`(idClienteE INT)
SELECT idCliente,nombreCliente,empresaCliente,referenciaCliente FROM `test`.`Cliente` WHERE idCliente=idClienteE ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_codigo_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_codigo_cliente`(OUT codigo_secundario VARCHAR(4))
BEGIN  
  DECLARE contador INT;
	BEGIN
    SET contador= (SELECT COUNT(*)+1 FROM Cliente);
    IF(contador<10)THEN
            SET codigo_secundario= CONCAT('C00',contador);
            ELSE IF(contador<100) THEN
                SET codigo_secundario= CONCAT('C0',contador);
                ELSE IF(contador<1000)THEN
                    SET codigo_secundario= CONCAT('C',contador);
                END IF;
            END IF;
        END IF;
    END;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_abonos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_abonos`()
SELECT * FROM Abono ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_clientes`()
SELECT * FROM Cliente ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_prestamos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_prestamos`()
SELECT * FROM Prestamo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-04 10:49:33
