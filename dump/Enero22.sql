CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: test
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `abono`
--

DROP TABLE IF EXISTS `abono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abono` (
  `idAbono` int(11) NOT NULL AUTO_INCREMENT,
  `codigoAbono` varchar(10) NOT NULL,
  `montoACobrar` decimal(10,0) NOT NULL,
  `montoPagado` decimal(10,0) DEFAULT NULL,
  `completoAbono` enum('SI','NO') NOT NULL,
  `fechaACobrar` date NOT NULL,
  `fechaPago` date DEFAULT NULL,
  `abonoPrestamo` varchar(10) NOT NULL,
  `puntualAbono` enum('SI','NO') NOT NULL,
  `estadoAbono` enum('PENDIENTE','PAGADO','ERROR') NOT NULL,
  `numeroAbono` int(3) NOT NULL,
  PRIMARY KEY (`idAbono`),
  UNIQUE KEY `codigoAbono_UNIQUE` (`codigoAbono`),
  KEY `fk_abono_prestamo` (`abonoPrestamo`),
  CONSTRAINT `fk_abono_prestamo` FOREIGN KEY (`abonoPrestamo`) REFERENCES `prestamo` (`codigoPrestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abono`
--

LOCK TABLES `abono` WRITE;
/*!40000 ALTER TABLE `abono` DISABLE KEYS */;
INSERT INTO `abono` VALUES (1,'A001',60000,100000,'SI','2018-01-15','2018-01-03','P001','SI','PAGADO',1),(2,'A002',60000,30000,'NO','2018-01-29','2018-01-11','P001','SI','PAGADO',2),(3,'A003',60000,60000,'SI','2018-02-12','2018-01-06','P001','SI','PAGADO',3),(4,'A004',60000,50000,'NO','2018-02-26','2018-01-06','P001','SI','PAGADO',4),(5,'A005',75000,75000,'SI','2018-01-18','2018-01-06','P002','SI','PAGADO',1),(6,'A006',75000,75000,'SI','2018-02-01','2018-01-11','P002','SI','PAGADO',2),(7,'A007',75000,75000,'SI','2018-02-15','2018-01-06','P002','SI','PAGADO',3),(8,'A008',75000,75000,'SI','2018-03-01','2018-01-06','P002','SI','PAGADO',4),(9,'A009',75000,75000,'SI','2018-03-15','2018-01-06','P002','SI','PAGADO',5),(10,'A010',75000,75000,'SI','2018-03-29','2018-01-06','P002','SI','PAGADO',6),(11,'A011',75000,75000,'SI','2018-04-12','2018-01-06','P002','SI','PAGADO',7),(12,'A012',75000,75000,'SI','2018-04-26','2018-01-06','P002','SI','PAGADO',8),(13,'A013',75000,75000,'SI','2018-05-10','2018-01-06','P002','SI','PAGADO',9),(14,'A014',75000,75000,'SI','2018-05-24','2018-01-06','P002','SI','PAGADO',10),(15,'A015',90000,90000,'SI','2018-01-25','2018-01-06','P003','SI','PAGADO',1),(16,'A016',90000,90000,'SI','2018-02-08','2018-01-06','P003','SI','PAGADO',2),(17,'A017',90000,90000,'SI','2018-02-22','2018-01-06','P003','SI','PAGADO',3),(18,'A018',90000,90000,'SI','2018-03-08','2018-01-06','P003','SI','PAGADO',4),(19,'A019',75000,70000,'NO','2018-01-20','2018-01-19','P004','SI','PAGADO',1),(20,'A020',75000,76000,'SI','2018-02-03','2018-01-06','P004','SI','PAGADO',2),(21,'A021',75000,76000,'SI','2018-02-17','2018-01-06','P004','SI','PAGADO',3),(22,'A022',75000,76000,'SI','2018-03-03','2018-01-06','P004','SI','PAGADO',4),(23,'A023',75000,232000,'SI','2018-03-17','2018-01-11','P004','SI','PAGADO',5),(24,'A024',75000,70000,'NO','2018-03-31','2018-01-09','P004','SI','PAGADO',6),(25,'A025',75000,150000,'SI','2018-04-14','2018-01-12','P004','SI','PAGADO',7),(26,'A026',75000,0,'NO','2018-04-28',NULL,'P004','NO','PENDIENTE',8),(27,'A027',75000,0,'NO','2018-05-12',NULL,'P004','NO','PENDIENTE',9),(28,'A028',75000,0,'NO','2018-05-26',NULL,'P004','NO','PENDIENTE',10),(29,'A029',100000,1000000,'SI','2018-02-06','2018-01-06','P005','SI','PAGADO',1),(30,'A030',100000,0,'NO','2018-03-06',NULL,'P005','NO','PENDIENTE',2),(31,'A031',100000,0,'NO','2018-04-06',NULL,'P005','NO','PENDIENTE',3),(32,'A032',100000,0,'NO','2018-05-06',NULL,'P005','NO','PENDIENTE',4),(33,'A033',100000,0,'NO','2018-06-06',NULL,'P005','NO','PENDIENTE',5),(34,'A034',100000,0,'NO','2018-07-06',NULL,'P005','NO','PENDIENTE',6),(35,'A035',100000,0,'NO','2018-08-06',NULL,'P005','NO','PENDIENTE',7),(36,'A036',100000,0,'NO','2018-09-06',NULL,'P005','NO','PENDIENTE',8),(37,'A037',100000,0,'NO','2018-10-06',NULL,'P005','NO','PENDIENTE',9),(38,'A038',100000,0,'NO','2018-11-06',NULL,'P005','NO','PENDIENTE',10),(39,'A039',70000,200000,'SI','2018-02-06','2018-01-06','P006','SI','PAGADO',1),(40,'A040',70000,80000,'SI','2018-03-06','2018-01-06','P006','SI','PAGADO',2),(41,'A041',70000,0,'NO','2018-04-06',NULL,'P006','NO','PENDIENTE',3),(42,'A042',70000,0,'NO','2018-05-06',NULL,'P006','NO','PENDIENTE',4),(43,'A043',27500,110000,'SI','2018-01-13','2018-01-06','P007','SI','PAGADO',1),(44,'A044',27500,0,'NO','2018-01-20',NULL,'P007','NO','PENDIENTE',2),(45,'A045',27500,0,'NO','2018-01-27',NULL,'P007','NO','PENDIENTE',3),(46,'A046',27500,0,'NO','2018-02-03',NULL,'P007','NO','PENDIENTE',4),(47,'A047',12000,120000,'SI','2018-01-13','2018-01-06','P008','SI','PAGADO',1),(48,'A048',12000,0,'NO','2018-01-20',NULL,'P008','NO','PENDIENTE',2),(49,'A049',12000,0,'NO','2018-01-27',NULL,'P008','NO','PENDIENTE',3),(50,'A050',12000,0,'NO','2018-02-03',NULL,'P008','NO','PENDIENTE',4),(51,'A051',12000,0,'NO','2018-02-10',NULL,'P008','NO','PENDIENTE',5),(52,'A052',12000,0,'NO','2018-02-17',NULL,'P008','NO','PENDIENTE',6),(53,'A053',12000,0,'NO','2018-02-24',NULL,'P008','NO','PENDIENTE',7),(54,'A054',12000,0,'NO','2018-03-03',NULL,'P008','NO','PENDIENTE',8),(55,'A055',12000,0,'NO','2018-03-10',NULL,'P008','NO','PENDIENTE',9),(56,'A056',12000,0,'NO','2018-03-17',NULL,'P008','NO','PENDIENTE',10),(67,'A057',150000,600000,'SI','2018-01-20','2018-01-12','P009','SI','PAGADO',1),(68,'A068',150000,0,'NO','2018-02-03',NULL,'P009','NO','PENDIENTE',2),(69,'A069',150000,0,'NO','2018-02-17',NULL,'P009','NO','PENDIENTE',3),(70,'A070',150000,0,'NO','2018-03-03',NULL,'P009','NO','PENDIENTE',4),(71,'A071',150000,600000,'SI','2018-01-22','2018-01-08','P010','SI','PAGADO',1),(72,'A072',150000,0,'NO','2018-02-05',NULL,'P010','NO','PENDIENTE',2),(73,'A073',150000,0,'NO','2018-02-19',NULL,'P010','NO','PENDIENTE',3),(74,'A074',150000,0,'NO','2018-03-05',NULL,'P010','NO','PENDIENTE',4),(75,'A075',175000,0,'NO','2018-02-08',NULL,'P011','NO','PENDIENTE',1),(76,'A076',175000,0,'NO','2018-03-08',NULL,'P011','NO','PENDIENTE',2),(77,'A077',175000,600000,'SI','2018-04-08','2018-01-12','P011','SI','PAGADO',3),(78,'A078',175000,100000,'NO','2018-05-08','2018-01-03','P011','SI','PAGADO',4),(79,'A079',20000,0,'NO','2017-02-02',NULL,'P012','NO','PENDIENTE',1),(80,'A080',20000,0,'NO','2017-03-02',NULL,'P012','NO','PENDIENTE',2),(81,'A081',20000,0,'NO','2017-04-02',NULL,'P012','NO','PENDIENTE',3),(82,'A082',20000,0,'NO','2017-05-02',NULL,'P012','NO','PENDIENTE',4),(83,'A083',20000,0,'NO','2017-06-02',NULL,'P012','NO','PENDIENTE',5),(84,'A084',20000,0,'NO','2017-07-02',NULL,'P012','NO','PENDIENTE',6),(85,'A085',20000,0,'NO','2017-08-02',NULL,'P012','NO','PENDIENTE',7),(86,'A086',20000,0,'NO','2017-09-02',NULL,'P012','NO','PENDIENTE',8),(87,'A087',20000,200000,'SI','2017-10-02','2018-01-12','P012','NO','PAGADO',9),(88,'A088',20000,0,'NO','2017-11-02',NULL,'P012','NO','PENDIENTE',10);
/*!40000 ALTER TABLE `abono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `codigoCliente` varchar(10) NOT NULL,
  `nombreCliente` varchar(45) NOT NULL,
  `empresaCliente` varchar(45) NOT NULL,
  `referenciaCliente` varchar(45) NOT NULL,
  `estadoCliente` enum('ACTIVO','NO_ACTIVO','NO RECOMENDADO') DEFAULT 'NO_ACTIVO',
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `codigoCliente_UNIQUE` (`codigoCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'C001','Julian Guerrero','NextU','Ingeniero','ACTIVO'),(2,'C002','Andres Sandoval','PSL','Tester','ACTIVO'),(3,'C003','Jorge Sanchez','Chispa','Domicilio',NULL),(4,'C004','','','',NULL),(5,'C005','','','',NULL),(6,'C006','','','',NULL),(7,'C007','','','',NULL),(8,'C008','','','',NULL),(9,'C009','','','',NULL),(10,'C010','','','',NULL),(11,'C011','','','',NULL),(12,'C012','','','',NULL),(13,'C013','','','',NULL),(14,'C014','','','',NULL),(15,'C015','','','',NULL),(16,'C016','','','',NULL),(17,'C017','','','',NULL),(18,'C018','','','',NULL),(19,'C019','','','',NULL),(20,'C020','','','',NULL),(21,'C021','','','',NULL),(22,'C022','Andres Herrera','ARA','Cajero','ACTIVO'),(23,'C023','Andres Perez','D1','Cajero',NULL),(24,'C024','','','',NULL),(25,'C025','','','',NULL),(26,'C026','','','',NULL),(27,'C027','Julian andres guerrero ome','','',NULL),(28,'C028','','','Es el hermano de tal y pascual y eso',NULL),(29,'C029','Andres Sandoval','','',NULL),(30,'C030','tEST','','','NO_ACTIVO');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
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
  `estadoPrestamo` enum('PENDIENTE','PAGADO','REFINANCIADO','VENCIDO') NOT NULL,
  PRIMARY KEY (`idPrestamo`),
  UNIQUE KEY `codigoPrestamo_UNIQUE` (`codigoPrestamo`),
  KEY `fk_prestamo_cliente` (`codigoClienteFK`),
  CONSTRAINT `fk_prestamo_cliente` FOREIGN KEY (`codigoClienteFK`) REFERENCES `cliente` (`codigoCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (1,'P001',200000,10,4,240000,240000,'2018-01-01','2018-02-26','QUINCENAL','c001','PAGADO'),(2,'P002',500000,10,10,750000,750000,'2018-01-04','2018-05-24','QUINCENAL','c002','PAGADO'),(3,'P003',300000,10,4,360000,360000,'2018-01-11','2018-03-08','QUINCENAL','c002','PAGADO'),(4,'P004',500000,10,10,750000,750000,'2018-01-06','2018-05-26','QUINCENAL','c022','PAGADO'),(5,'P005',500000,10,10,1000000,1000000,'2018-01-06','2018-11-06','MENSUAL','C001','PAGADO'),(6,'P006',200000,10,4,280000,280000,'2018-01-06','2018-05-06','MENSUAL','c001','PAGADO'),(7,'P007',100000,10,4,110000,110000,'2018-01-06','2018-02-03','SEMANAL','c001','PAGADO'),(8,'P008',100000,10,10,120000,120000,'2018-01-06','2018-03-17','SEMANAL','c001','PAGADO'),(9,'P009',500000,10,4,600000,600000,'2018-01-06','2018-03-03','QUINCENAL','c001','PAGADO'),(10,'P010',500000,10,4,600000,600000,'2018-01-08','2018-03-05','QUINCENAL','c001','PAGADO'),(11,'P011',500000,10,4,700000,700000,'2018-01-08','2018-05-08','MENSUAL','c001','PAGADO'),(12,'P012',100000,10,10,200000,200000,'2017-01-02','2017-11-02','MENSUAL','c001','PAGADO');
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_abono`(codigoAbono VARCHAR(10), montoACobrar DECIMAL, montoPagado DECIMAL, completoAbono ENUM('SI','NO'),fechaACobrar DATE, abonoPrestamo VARCHAR(10),puntualAbono ENUM('SI','NO'),estadoAbono ENUM('PENDIENTE','PAGADO','ERROR'),numeroAbono INT(3))
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
/*!50003 DROP PROCEDURE IF EXISTS `calcular_intereses_a_recaudar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_intereses_a_recaudar`(OUT interesesARecaudar FLOAT, codigoPrestamoE VARCHAR(10))
BEGIN
	SET interesesARecaudar=(SELECT SUM(saldoPagadoPrestamo-montoPrestamo) FROM test.Prestamo  WHERE codigoPrestamo=codigoPrestamoE && estadoPrestamo='PAGADO');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcular_intereses_recaudados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_intereses_recaudados`(OUT interesesRecaudados FLOAT, codigoPrestamoE VARCHAR(10))
BEGIN
	SET interesesRecaudados=(SELECT SUM(saldoPendientePrestamo-montoPrestamo) FROM test.Prestamo  WHERE codigoPrestamo=codigoPrestamoE);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcular_total_prestado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_total_prestado`(OUT totalprestado FLOAT, codigoprestamoE VARCHAR(10))
BEGIN
	SET totalprestado=(SELECT SUM(montoPrestamo) FROM test.Prestamo  WHERE codigoprestamo=codigoprestamoE);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcular_total_recaudado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_total_recaudado`(OUT totalRecaudado FLOAT, codigoPrestamoE VARCHAR(10))
BEGIN
	SET totalRecaudado=(SELECT SUM(saldoPagadoprestamo) FROM test.Prestamo  WHERE codigoPrestamo=codigoPrestamoE);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `calcular_total_recaudo_pendiente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `calcular_total_recaudo_pendiente`(OUT totalRecaudoPendiente FLOAT, codigoPrestamoE VARCHAR(10))
BEGIN
	SET totalRecaudoPendiente=(SELECT SUM(saldoPendientePrestamo) FROM test.Prestamo  WHERE codigoPrestamo=codigoPrestamoE && estadoPrestamo='PENDIENTE');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `contar_abonos_cobrados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_abonos_cobrados`(OUT totalCobrados INT)
BEGIN
	SET totalCobrados=(SELECT COUNT(*) FROM Abono WHERE estadoabono='PAGADO');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `contar_abonos_pendientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_abonos_pendientes`(OUT totalPendientes INT)
BEGIN
	SET totalPendientes=(SELECT COUNT(*) FROM Abono WHERE estadoabono='PENDIENTE');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `contar_clientes_activos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_clientes_activos`(OUT total_activos INT)
BEGIN
    SET total_activos=(SELECT COUNT(*) FROM Cliente WHERE estadoCliente='ACTIVO');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `contar_clientes_registrados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_clientes_registrados`(OUT total_registrados INT)
BEGIN
	SET total_registrados=(SELECT COUNT(*) FROM Cliente);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `contar_prestamos_activos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_prestamos_activos`(OUT totalActivos INT)
BEGIN
	SET totalActivos=(SELECT COUNT(*) FROM Prestamo WHERE estadoPrestamo='PENDIENTE');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `contar_prestamos_finalizados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_prestamos_finalizados`(OUT totalFinalizados INT)
BEGIN
	SET totalFinalizados=(SELECT COUNT(*) FROM Prestamo WHERE estadoPrestamo='PAGADO');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `contar_prestamos_vencidos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `contar_prestamos_vencidos`(OUT totalVencidos INT)
BEGIN
	SET totalVencidos=(SELECT COUNT(*) FROM Prestamo WHERE estadoPrestamo='VENCIDO');
END ;;
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
/*!50003 DROP PROCEDURE IF EXISTS `listar_abonos_pagados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_abonos_pagados`()
SELECT * FROM Abono WHERE estadoAbono='PAGADO' ORDER BY fechaPago ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_abonos_pendientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_abonos_pendientes`()
SELECT * FROM Abono WHERE estadoAbono='PENDIENTE' ORDER BY fechaACobrar ASC ;;
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_clientes`()
SELECT * FROM Cliente ORDER BY nombreCliente ASC ;;
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
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_prestamos`()
SELECT * FROM Prestamo ORDER BY fechaInicioPrestamo ASC ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_prestamos_actualizados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_prestamos_actualizados`()
SELECT * FROM Prestamo ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listar_prestamos_vencidos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `listar_prestamos_vencidos`()
SELECT * FROM Prestamo WHERE estadoPrestamo='VENCIDO' ORDER BY fechaInicioPrestamo ASC ;;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `pagar_abono`(codigoAbonoE VARCHAR(10), fechaPagoE DATE, montoPagadoE DECIMAL, completoAbonoE ENUM('SI','NO'), puntualAbonoE ENUM('SI','NO'))
BEGIN
UPDATE `test`.`Abono` SET fechaPago=fechaPagoE, montoPagado=montoPagadoE, estadoAbono='PAGADO', completoAbono=completoAbonoE, puntualAbono=puntualAbonoE WHERE codigoAbono=codigoAbonoE;

  end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sumar_pagos_abono` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sumar_pagos_abono`(abonoPrestamoE VARCHAR(10))
BEGIN   
     DECLARE total DECIMAL;
	BEGIN
    SET total=(SELECT SUM(montoPagado) FROM test.Abono  WHERE abonoPrestamo=abonoPrestamoE);
    UPDATE `test`.`Prestamo` SET saldoPagadoPrestamo=total WHERE codigoPrestamo=abonoPrestamoE;
    END;
  end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verificar_estado_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verificar_estado_clientes`(codigoClienteE VARCHAR(10))
BEGIN
	DECLARE contadorPrestamos INT;
    SET contadorPrestamos=(SELECT COUNT(*) FROM prestamo WHERE codigoClienteFK=codigoClienteE);
    IF(contadorPrestamos>=1) THEN
    UPDATE `test`.`cliente` SET estadoCliente='ACTIVO' WHERE codigoCliente=codigoClienteE; 
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verificar_prestamo_pagado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = '' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verificar_prestamo_pagado`(abonoPrestamoE VARCHAR(10))
BEGIN   
     DECLARE totalPagado DECIMAL;
     DECLARE totalPendiente DECIMAL;
	BEGIN
    SET totalPagado=(SELECT SUM(montoPagado) FROM test.Abono  WHERE abonoPrestamo=abonoPrestamoE);
    SET totalPendiente=(SELECT saldoPendientePrestamo FROM `test`.`Prestamo` WHERE codigoPrestamo=abonoPrestamoE);
		IF(totalPagado>=totalPendiente) THEN 
        UPDATE `test`.`Prestamo` SET estadoPrestamo='PAGADO' WHERE codigoPrestamo=abonoPrestamoE;
		ELSE IF(totalPendiente>totalPagado) THEN
        UPDATE `test`.`Prestamo` SET estadoPrestamo='PENDIENTE' WHERE codigoPrestamo=abonoPrestamoE;
        END IF;
        END IF;
    END;
  end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verificar_prestamo_vencido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `verificar_prestamo_vencido`(codigoPrestamoE VARCHAR(10))
begin 
	DECLARE fechaActual DATE;
	DECLARE fechaFinal DATE;
	DECLARE estadoActual VARCHAR(10);
     begin
   SET fechaActual=(SELECT CURRENT_timestamp());
    SET fechaFinal=(SELECT fechaFinprestamo FROM `test`.`Prestamo` WHERE codigoPrestamo=codigoPrestamoE);
    SET estadoActual=(SELECT estadoPrestamo FROM `test`.`Prestamo` WHERE codigoPrestamo=codigoPrestamoE);
		IF(fechaActual>fechaFinal && estadoActual='PENDIENTE') THEN 
        UPDATE `test`.`Prestamo` SET estadoPrestamo='VENCIDO' WHERE codigoPrestamo=codigoPrestamoE;
		ELSE IF(fechaActual>fechaFinal && estadoActual='PAGADO') THEN
        UPDATE `test`.`Prestamo` SET estadoPrestamo='PAGADO' WHERE codigoPrestamo=codigoPrestamoE;
        END IF;
        END IF;
        end;
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

-- Dump completed on 2018-01-11 18:09:38
