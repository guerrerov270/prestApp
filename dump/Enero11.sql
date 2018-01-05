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
  `codigoAbono` varchar(10) NOT NULL,
  `montoACobrar` decimal(10,0) NOT NULL,
  `montoPagado` decimal(10,0) DEFAULT NULL,
  `completoAbono` tinyint(1) NOT NULL,
  `fechaACobrar` date NOT NULL,
  `fechaPago` date DEFAULT NULL,
  `abonoPrestamo` varchar(10) NOT NULL,
  `puntualAbono` tinyint(1) NOT NULL,
  `estadoAbono` enum('PENDIENTE','PAGADO','ERROR') NOT NULL,
  `numeroAbono` int(3) NOT NULL,
  PRIMARY KEY (`idAbono`),
  UNIQUE KEY `codigoAbono_UNIQUE` (`codigoAbono`),
  KEY `fk_abono_prestamo` (`abonoPrestamo`),
  CONSTRAINT `fk_abono_prestamo` FOREIGN KEY (`abonoPrestamo`) REFERENCES `Prestamo` (`codigoPrestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Abono`
--

LOCK TABLES `Abono` WRITE;
/*!40000 ALTER TABLE `Abono` DISABLE KEYS */;
INSERT INTO `Abono` VALUES (1,'A001',60000,0,0,'2018-01-15',NULL,'P001',0,'PENDIENTE',1),(2,'A002',60000,0,0,'2018-01-29',NULL,'P001',0,'PENDIENTE',2),(3,'A003',60000,0,0,'2018-02-12',NULL,'P001',0,'PENDIENTE',3),(4,'A004',60000,0,0,'2018-02-26',NULL,'P001',0,'PENDIENTE',4),(5,'A005',75000,0,0,'2018-01-18',NULL,'P002',0,'PENDIENTE',1),(6,'A006',75000,0,0,'2018-02-01',NULL,'P002',0,'PENDIENTE',2),(7,'A007',75000,0,0,'2018-02-15',NULL,'P002',0,'PENDIENTE',3),(8,'A008',75000,0,0,'2018-03-01',NULL,'P002',0,'PENDIENTE',4),(9,'A009',75000,0,0,'2018-03-15',NULL,'P002',0,'PENDIENTE',5),(10,'A010',75000,0,0,'2018-03-29',NULL,'P002',0,'PENDIENTE',6),(11,'A011',75000,0,0,'2018-04-12',NULL,'P002',0,'PENDIENTE',7),(12,'A012',75000,0,0,'2018-04-26',NULL,'P002',0,'PENDIENTE',8),(13,'A013',75000,0,0,'2018-05-10',NULL,'P002',0,'PENDIENTE',9),(14,'A014',75000,0,0,'2018-05-24',NULL,'P002',0,'PENDIENTE',10),(15,'A015',90000,0,0,'2018-01-25',NULL,'P003',0,'PENDIENTE',1),(16,'A016',90000,0,0,'2018-02-08',NULL,'P003',0,'PENDIENTE',2),(17,'A017',90000,0,0,'2018-02-22',NULL,'P003',0,'PENDIENTE',3),(18,'A018',90000,0,0,'2018-03-08',NULL,'P003',0,'PENDIENTE',4);
/*!40000 ALTER TABLE `Abono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `codigoCliente` varchar(10) NOT NULL,
  `nombreCliente` varchar(45) NOT NULL,
  `empresaCliente` varchar(45) NOT NULL,
  `referenciaCliente` varchar(45) NOT NULL,
  `estadoCliente` enum('RECOMENDADO','ERROR','NO RECOMENDADO') DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `codigoCliente_UNIQUE` (`codigoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
INSERT INTO `Cliente` VALUES (1,'C001','Julian Guerrero','NextU','Ingeniero',NULL),(2,'C002','Andres Sandoval','PSL','Tester',NULL),(3,'C003','Jorge Sanchez','Chispa','Domicilio',NULL),(4,'C004','','','',NULL),(5,'C005','','','',NULL),(6,'C006','','','',NULL),(7,'C007','','','',NULL),(8,'C008','','','',NULL),(9,'C009','','','',NULL),(10,'C010','','','',NULL),(11,'C011','','','',NULL),(12,'C012','','','',NULL),(13,'C013','','','',NULL),(14,'C014','','','',NULL),(15,'C015','','','',NULL),(16,'C016','','','',NULL),(17,'C017','','','',NULL),(18,'C018','','','',NULL),(19,'C019','','','',NULL),(20,'C020','','','',NULL),(21,'C021','','','',NULL);
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
  `codigoPrestamo` varchar(10) NOT NULL,
  `montoPrestamo` decimal(10,0) NOT NULL,
  `tasaInteresPrestamo` int(11) NOT NULL,
  `numeroCuotasPrestamo` int(11) NOT NULL,
  `saldoPendientePrestamo` decimal(10,0) NOT NULL,
  `saldoPagadoPrestamo` decimal(10,0) NOT NULL,
  `fechaInicioPrestamo` date NOT NULL,
  `fechaFinPrestamo` date NOT NULL,
  `tipoPlazoPrestamo` enum('MENSUAL','QUINCENAL','SEMANAL','OTRO') NOT NULL,
  `codigoClienteFK` varchar(10) NOT NULL,
  `estadoPrestamo` enum('PENDIENTE','PAGADO','REFINANCIADO','ERROR') NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  UNIQUE KEY `codigoPrestamo_UNIQUE` (`codigoPrestamo`),
  KEY `fk_prestamo_cliente` (`codigoClienteFK`),
  CONSTRAINT `fk_prestamo_cliente` FOREIGN KEY (`codigoClienteFK`) REFERENCES `Cliente` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamo`
--

LOCK TABLES `Prestamo` WRITE;
/*!40000 ALTER TABLE `Prestamo` DISABLE KEYS */;
INSERT INTO `Prestamo` VALUES (1,'P001',200000,10,4,240000,0,'2018-01-01','2018-02-26','QUINCENAL','c001','PENDIENTE'),(2,'P002',500000,10,10,750000,0,'2018-01-04','2018-05-24','QUINCENAL','c002','PENDIENTE'),(3,'P003',300000,10,4,360000,0,'2018-01-11','2018-03-08','QUINCENAL','c002','PENDIENTE');
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_abono`(codigoAbono VARCHAR(10), montoACobrar DECIMAL, montoPagado DECIMAL, completoAbono TINYINT(1),fechaACobrar DATE, abonoPrestamo VARCHAR(10),puntualAbono TINYINT(1),estadoAbono ENUM('PENDIENTE','PAGADO','ERROR'),numeroAbono INT(3))
INSERT INTO `test`.`Abono` (`codigoAbono`,`montoACobrar`,`montoPagado`, `completoAbono`,`fechaACobrar`,`abonoPrestamo`,`puntualAbono`,`estadoAbono`,`numeroAbono`) VALUES (codigoAbono, montoACobrar, montoPagado, completoAbono,fechaACobrar,abonoPrestamo,puntualAbono,estadoAbono,numeroAbono) ;;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_cliente`(codigoCliente VARCHAR(10),nombreCliente VARCHAR(45),empresaCliente VARCHAR(45),referenciaCliente VARCHAR(45))
INSERT INTO `test`.`Cliente` (`codigoCliente`,`nombreCliente`, `empresaCliente`,`referenciaCliente`) VALUES (codigoCliente, nombreCliente, empresaCliente, referenciaCliente) ;;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_prestamo`(codigoPrestamo VARCHAR(10),montoPrestamo DECIMAL,tasaInteresPrestamo INT,numeroCuotasPrestamo INT,saldoPendientePrestamo DECIMAL, saldoPagadoPrestamo DECIMAL, fechaInicioFormateada DATE, fechaFinFormateada DATE, tipoPlazoPrestamo ENUM('MENSUAL','QUINCENAL','SEMANAL','OTRO'), codigoClienteFK VARCHAR(10), estadoPrestamo ENUM('PENDIENTE','PAGADO','REFINANCIADO'))
INSERT INTO `test`.`Prestamo` (`codigoPrestamo`,`montoPrestamo`, `tasaInteresPrestamo`,`numeroCuotasPrestamo`,`saldoPendientePrestamo`,`saldoPagadoPrestamo`,`fechaInicioPrestamo`,`fechaFinPrestamo`,`tipoPlazoPrestamo`,`codigoClienteFK`, `estadoPrestamo`) VALUES (codigoPrestamo, montoPrestamo, tasaInteresPrestamo, numeroCuotasPrestamo,saldoPendientePrestamo, saldoPagadoPrestamo, fechaInicioFormateada, fechaFinFormateada, tipoPlazoPrestamo, codigoClienteFK, estadoPrestamo) ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_abono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_abono`(codigoAbonoE VARCHAR(10))
SELECT * FROM `test`.`Abono` WHERE codigoAbono=codigoAbonoE ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `buscar_abono_prestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_abono_prestamo`(abonoPrestamoE VARCHAR(10))
SELECT * FROM `test`.`Abono` WHERE abonoPrestamo=abonoPrestamoE ;;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_cliente`(codigoClienteE VARCHAR(10))
SELECT idCliente,codigoCliente,nombreCliente,empresaCliente,referenciaCliente FROM `test`.`Cliente` WHERE codigoCliente=codigoClienteE ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `generar_codigo_abono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_codigo_abono`(OUT codigo_secundario VARCHAR(4))
BEGIN   
     DECLARE contador INT;
  DECLARE cantidadAbonos INT;
	BEGIN
    SET cantidadAbonos=(SELECT COUNT(*) FROM Abono);
    IF(cantidadAbonos=0) THEN
		SET contador=1;
        IF(contador<10)THEN
            SET codigo_secundario= CONCAT('A00',contador);
            ELSE IF(contador<100) THEN
                SET codigo_secundario= CONCAT('A0',contador);
                ELSE IF(contador<1000)THEN
                    SET codigo_secundario= CONCAT('A',contador);
                END IF;
            END IF;
        END IF;
    END IF;
    SET contador= (SELECT MAX(idAbono)+1 FROM Abono);
    IF(contador<10)THEN
            SET codigo_secundario= CONCAT('A00',contador);
            ELSE IF(contador<100) THEN
                SET codigo_secundario= CONCAT('A0',contador);
                ELSE IF(contador<1000)THEN
                    SET codigo_secundario= CONCAT('A',contador);
                END IF;
            END IF;
        END IF;
    END;
  end ;;
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
  DECLARE cantidadClientes INT;
	BEGIN
    SET cantidadClientes=(SELECT COUNT(*) FROM Cliente);
    IF(cantidadClientes=0) THEN
		SET contador=1;
        IF(contador<10)THEN
            SET codigo_secundario= CONCAT('C00',contador);
            ELSE IF(contador<100) THEN
                SET codigo_secundario= CONCAT('C0',contador);
                ELSE IF(contador<1000)THEN
                    SET codigo_secundario= CONCAT('C',contador);
                END IF;
            END IF;
        END IF;
    END IF;
    SET contador= (SELECT MAX(idCliente)+1 FROM Cliente);
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
/*!50003 DROP PROCEDURE IF EXISTS `generar_codigo_prestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `generar_codigo_prestamo`(OUT codigo_secundario VARCHAR(4))
BEGIN   
     DECLARE contador INT;
  DECLARE cantidadPrestamos INT;
	BEGIN
    SET cantidadPrestamos=(SELECT COUNT(*) FROM Prestamo);
    IF(cantidadPrestamos=0) THEN
		SET contador=1;
        IF(contador<10)THEN
            SET codigo_secundario= CONCAT('P00',contador);
            ELSE IF(contador<100) THEN
                SET codigo_secundario= CONCAT('P0',contador);
                ELSE IF(contador<1000)THEN
                    SET codigo_secundario= CONCAT('P',contador);
                END IF;
            END IF;
        END IF;
    END IF;
    SET contador= (SELECT MAX(idPrestamo)+1 FROM Prestamo);
    IF(contador<10)THEN
            SET codigo_secundario= CONCAT('P00',contador);
            ELSE IF(contador<100) THEN
                SET codigo_secundario= CONCAT('P0',contador);
                ELSE IF(contador<1000)THEN
                    SET codigo_secundario= CONCAT('P',contador);
                END IF;
            END IF;
        END IF;
    END;
  end ;;
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
/*!50003 DROP PROCEDURE IF EXISTS `pagar_abono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pagar_abono`(codigoAbonoE VARCHAR(10), fechaPagoE DATE, montoPagadoE DECIMAL)
BEGIN
UPDATE `test`.`Abono` SET fechaPago=fechaPagoE, montoPagado=montoPagadoE, estadoAbono='PAGADO' WHERE codigoAbono=codigoAbonoE;

  end ;;
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

-- Dump completed on 2018-01-05 18:37:39