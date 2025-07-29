CREATE DATABASE  IF NOT EXISTS `bd_banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_banco`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_banco
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `dni_cliente` int(8) NOT NULL,
  `cuil_cliente` char(11) NOT NULL,
  `nombre_cliente` varchar(20) NOT NULL,
  `apellido_cliente` varchar(20) NOT NULL,
  `sexo_cliente` enum('F','M','O') NOT NULL,
  `nacionalidad_cliente` varchar(50) DEFAULT NULL,
  `fecha_nacimiento_cliente` date NOT NULL,
  `direccion_cliente` varchar(50) DEFAULT NULL,
  `id_localidad_cliente` int(2) NOT NULL,
  `id_provincia_cliente` int(2) NOT NULL,
  `correo_electronico_cliente` varchar(50) DEFAULT NULL,
  `telefono_cliente` varchar(20) DEFAULT NULL,
  `usuario_cliente` char(14) NOT NULL,
  `contrasena_cliente` varchar(50) NOT NULL,
  `estado_cliente` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`dni_cliente`),
  UNIQUE KEY `cuil_cliente_UK` (`cuil_cliente`),
  UNIQUE KEY `usuario_cliente_UK` (`usuario_cliente`),
  KEY `FK_id_localidad_cliente` (`id_localidad_cliente`),
  KEY `FK_id_provincia_cliente` (`id_provincia_cliente`),
  CONSTRAINT `FK_id_localidad_cliente` FOREIGN KEY (`id_localidad_cliente`) REFERENCES `localidades` (`id_localidad`),
  CONSTRAINT `FK_id_provincia_cliente` FOREIGN KEY (`id_provincia_cliente`) REFERENCES `provincias` (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (30111221,'20301112211','Lucía','Martínez','F','Argentina','1992-04-10','Calle 1 123',1,1,'lucia@example.com','1122334455','30111221.BANCO','pass123',1),(30111222,'20301112222','Carlos','Gómez','M','Argentina','1988-07-15','Calle 2 234',2,1,'carlos@example.com','2233445566','30111222.BANCO','pass123',1),(30111223,'20301112233','María','Fernández','F','Argentina','1995-01-20','Calle 3 345',3,1,'maria@example.com','3344556677','30111223.BANCO','pass123',1),(30111224,'20301112244','Javier','Rodríguez','M','Argentina','1990-10-05','Calle 4 456',4,2,'javier@example.com','4455667788','30111224.BANCO','pass123',1),(30111225,'20301112255','Sofía','López','F','Argentina','1985-12-30','Calle 5 567',5,2,'sofia@example.com','5566778899','30111225.BANCO','pass123',1),(30111226,'20301112266','Martín','García','M','Argentina','1993-09-18','Calle 6 678',6,2,'martin@example.com','6677889900','30111226.BANCO','pass123',1),(30111227,'20301112277','Valentina','Pérez','F','Argentina','1998-03-25','Calle 7 789',7,3,'valen@example.com','7788990011','30111227.BANCO','pass123',1),(30111228,'20301112288','Tomás','Sánchez','M','Argentina','1991-11-11','Calle 8 890',8,3,'tomas@example.com','8899001122','30111228.BANCO','pass123',1),(30111229,'20301112299','Camila','Díaz','F','Argentina','1996-08-08','Calle 9 901',9,3,'camila@example.com','9900112233','30111229.BANCO','pass123',1),(30111230,'20301112300','Franco','Moreno','M','Argentina','1987-06-17','Calle 10 012',10,4,'franco@example.com','1011122333','30111230.BANCO','pass123',1),(30111231,'20301112311','Agustina','Romero','F','Argentina','1994-02-13','Calle 11 123',11,4,'agus@example.com','1112233444','30111231.BANCO','pass123',1),(30111232,'20301112322','Diego','Alvarez','M','Argentina','1990-01-01','Calle 12 234',12,4,'diego@example.com','1223344555','30111232.BANCO','pass123',1),(30111233,'20301112333','Paula','Silva','F','Argentina','1989-05-05','Calle 13 345',1,1,'paula@example.com','1334455666','30111233.BANCO','pass123',1),(30111234,'20301112344','Leonardo','Torres','M','Argentina','1992-07-22','Calle 14 456',2,1,'leo@example.com','1445566777','30111234.BANCO','pass123',1),(30111235,'20301112355','Florencia','Ruiz','F','Argentina','1997-11-19','Calle 15 567',3,1,'flor@example.com','1556677888','30111235.BANCO','pass123',1);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentas` (
  `nroCuenta_cuenta` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `dnicliente_cuenta` int(8) NOT NULL,
  `fecha_creacion_cuenta` date NOT NULL,
  `cbu_cuenta` char(22) NOT NULL,
  `idtipo_cuenta` int(1) NOT NULL,
  `saldo_cuenta` decimal(15,2) DEFAULT '10000.00',
  `estado_cuenta` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`nroCuenta_cuenta`),
  UNIQUE KEY `cbu_cuenta` (`cbu_cuenta`),
  KEY `FK_dnicliente_cuenta` (`dnicliente_cuenta`),
  KEY `FK_idtipo_cuenta_idx` (`idtipo_cuenta`),
  CONSTRAINT `FK_dnicliente_cuenta` FOREIGN KEY (`dnicliente_cuenta`) REFERENCES `clientes` (`dni_cliente`),
  CONSTRAINT `FK_idtipo_cuenta` FOREIGN KEY (`idtipo_cuenta`) REFERENCES `tipocuentas` (`id_tipoCuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11015 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (11000,30111221,'2025-07-26','0000000000000000000121',1,36141.65,1),(11001,30111222,'2025-07-26','0000000000000000000122',2,9750.00,1),(11002,30111223,'2025-07-26','0000000000000000000123',2,32800.00,1),(11003,30111224,'2025-07-26','0000000000000000000124',2,10900.00,1),(11004,30111225,'2025-07-26','0000000000000000000125',1,24500.00,1),(11005,30111226,'2025-07-26','0000000000000000000126',1,8300.00,1),(11006,30111227,'2025-07-26','0000000000000000000127',1,86926.65,1),(11007,30111228,'2025-07-26','0000000000000000000128',2,10890.00,1),(11008,30111229,'2025-07-26','0000000000000000000129',1,57900.00,1),(11009,30111230,'2025-07-26','0000000000000000000130',1,11750.00,1),(11010,30111231,'2025-07-26','0000000000000000000131',2,8850.00,1),(11011,30111232,'2025-07-26','0000000000000000000132',2,11400.00,1),(11012,30111233,'2025-07-26','0000000000000000000133',2,9850.00,1),(11013,30111234,'2025-07-26','0000000000000000000134',2,9050.00,1),(11014,30111235,'2025-07-26','0000000000000000000135',1,10700.00,1);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuotasprestamo`
--

DROP TABLE IF EXISTS `cuotasprestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuotasprestamo` (
  `id_cuota` int(5) NOT NULL AUTO_INCREMENT,
  `id_prestamo_cuota` int(5) NOT NULL,
  `monto_cuota` decimal(15,2) DEFAULT NULL,
  `fechaPago_cuota` date DEFAULT NULL,
  PRIMARY KEY (`id_cuota`),
  KEY `FK_id_prestamo_cuota` (`id_prestamo_cuota`),
  CONSTRAINT `FK_id_prestamo_cuota` FOREIGN KEY (`id_prestamo_cuota`) REFERENCES `prestamos` (`id_prestamo`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuotasprestamo`
--

LOCK TABLES `cuotasprestamo` WRITE;
/*!40000 ALTER TABLE `cuotasprestamo` DISABLE KEYS */;
INSERT INTO `cuotasprestamo` VALUES (1,1,4791.67,'2025-07-26'),(2,1,4791.67,'2025-07-26'),(3,1,4791.67,'2025-07-26'),(4,1,4791.67,'2025-07-26'),(5,1,4791.67,'2025-07-26'),(6,3,4350.00,'2025-07-26'),(7,3,4350.00,'2025-07-26'),(8,3,4350.00,'2025-07-26'),(9,3,4350.00,'2025-07-26'),(10,3,4350.00,'2025-07-26'),(11,7,4916.67,'2025-07-26'),(12,7,4916.67,'2025-07-26'),(13,7,4916.67,'2025-07-26'),(14,7,4916.67,'2025-07-26'),(15,7,4916.67,'2025-07-26');
/*!40000 ALTER TABLE `cuotasprestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `id_localidad` int(2) NOT NULL AUTO_INCREMENT,
  `descripcion_localidad` varchar(50) DEFAULT NULL,
  `id_provincia_localidad` int(2) NOT NULL,
  PRIMARY KEY (`id_localidad`),
  KEY `FK_id_provincia_localidad` (`id_provincia_localidad`),
  CONSTRAINT `FK_id_provincia_localidad` FOREIGN KEY (`id_provincia_localidad`) REFERENCES `provincias` (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,'Tigre',1),(2,'Escobar',1),(3,'Morón',1),(4,'Resistencia ',2),(5,'Las Breñas',2),(6,'Ciervo Petiso',2),(7,'El Rodeo',3),(8,'Belén',3),(9,'Fiambalá',3),(10,'Yerba Buena',4),(11,'Tafí Viejo',4),(12,'Lules',4),(13,'La Banda',15),(14,'Santa Rosa',11),(15,'Posadas',10);
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimientos` (
  `id_movimiento` int(5) NOT NULL AUTO_INCREMENT,
  `nroCuenta_movimiento` int(5) unsigned NOT NULL,
  `fecha_movimiento` date NOT NULL,
  `detalle_movimiento` varchar(100) DEFAULT NULL,
  `importe_movimiento` decimal(15,2) NOT NULL,
  `id_tipoMovimiento` int(1) NOT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `FK_id_tipoMovimiento` (`id_tipoMovimiento`),
  KEY `FK_nroCuenta_movimiento` (`nroCuenta_movimiento`),
  CONSTRAINT `FK_id_tipoMovimiento` FOREIGN KEY (`id_tipoMovimiento`) REFERENCES `tipomovimientos` (`id_tipoMovimiento`),
  CONSTRAINT `FK_nroCuenta_movimiento` FOREIGN KEY (`nroCuenta_movimiento`) REFERENCES `cuentas` (`nroCuenta_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (0,11006,'2025-07-26','Ingreso de dinero',10000.00,1),(1,11007,'2025-07-26','Ingreso de dinero',10000.00,1),(2,11008,'2025-07-26','Ingreso de dinero',10000.00,1),(3,11009,'2025-07-26','Ingreso de dinero',10000.00,1),(4,11010,'2025-07-26','Ingreso de dinero',10000.00,1),(5,11011,'2025-07-26','Ingreso de dinero',10000.00,1),(6,11012,'2025-07-26','Ingreso de dinero',10000.00,1),(7,11013,'2025-07-26','Ingreso de dinero',10000.00,1),(8,11014,'2025-07-26','Ingreso de dinero',10000.00,1),(9,11015,'2025-07-26','Ingreso de dinero',10000.00,1),(10,11016,'2025-07-26','Ingreso de dinero',10000.00,1),(11,11017,'2025-07-26','Ingreso de dinero',10000.00,1),(12,11018,'2025-07-26','Ingreso de dinero',10000.00,1),(13,11019,'2025-07-26','Ingreso de dinero',10000.00,1),(14,11020,'2025-07-26','Ingreso de dinero',10000.00,1),(15,11000,'2025-07-26','Ingreso de dinero',10000.00,1),(16,11001,'2025-07-26','Ingreso de dinero',10000.00,1),(17,11002,'2025-07-26','Ingreso de dinero',10000.00,1),(18,11003,'2025-07-26','Ingreso de dinero',10000.00,1),(19,11004,'2025-07-26','Ingreso de dinero',10000.00,1),(20,11005,'2025-07-26','Ingreso de dinero',10000.00,1),(30,11000,'2025-07-26','Egreso de dinero',500.00,4),(31,11001,'2025-07-26','Ingreso de dinero',500.00,4),(32,11001,'2025-07-26','Egreso de dinero',750.00,4),(33,11002,'2025-07-26','Ingreso de dinero',750.00,4),(34,11002,'2025-07-26','Egreso de dinero',1200.00,4),(35,11003,'2025-07-26','Ingreso de dinero',1200.00,4),(36,11003,'2025-07-26','Egreso de dinero',300.00,4),(37,11004,'2025-07-26','Ingreso de dinero',300.00,4),(38,11004,'2025-07-26','Egreso de dinero',800.00,4),(39,11005,'2025-07-26','Ingreso de dinero',800.00,4),(40,11005,'2025-07-26','Egreso de dinero',2500.00,4),(41,11006,'2025-07-26','Ingreso de dinero',2500.00,4),(42,11006,'2025-07-26','Egreso de dinero',990.00,4),(43,11007,'2025-07-26','Ingreso de dinero',990.00,4),(44,11007,'2025-07-26','Egreso de dinero',100.00,4),(45,11008,'2025-07-26','Ingreso de dinero',100.00,4),(46,11008,'2025-07-26','Egreso de dinero',2200.00,4),(47,11009,'2025-07-26','Ingreso de dinero',2200.00,4),(48,11009,'2025-07-26','Egreso de dinero',450.00,4),(49,11010,'2025-07-26','Ingreso de dinero',450.00,4),(50,11010,'2025-07-26','Egreso de dinero',1600.00,4),(51,11011,'2025-07-26','Ingreso de dinero',1600.00,4),(52,11011,'2025-07-26','Egreso de dinero',200.00,4),(53,11012,'2025-07-26','Ingreso de dinero',200.00,4),(54,11012,'2025-07-26','Egreso de dinero',350.00,4),(55,11013,'2025-07-26','Ingreso de dinero',350.00,4),(56,11013,'2025-07-26','Egreso de dinero',1300.00,4),(57,11014,'2025-07-26','Ingreso de dinero',1300.00,4),(58,11014,'2025-07-26','Egreso de dinero',600.00,4),(59,11000,'2025-07-26','Ingreso de dinero',600.00,4),(60,11000,'2025-07-26','Ingreso de dinero',50000.00,2),(61,11002,'2025-07-26','Ingreso de dinero',45000.00,2),(62,11004,'2025-07-26','Ingreso de dinero',15000.00,2),(63,11006,'2025-07-26','Ingreso de dinero',100000.00,2),(64,11008,'2025-07-26','Ingreso de dinero',25000.00,2),(65,11008,'2025-07-26','Ingreso de dinero',25000.00,2),(66,11000,'2025-07-26','Egreso de dinero',4791.67,3),(67,11000,'2025-07-26','Egreso de dinero',4791.67,3),(68,11000,'2025-07-26','Egreso de dinero',4791.67,3),(69,11000,'2025-07-26','Egreso de dinero',4791.67,3),(70,11000,'2025-07-26','Egreso de dinero',4791.67,3),(71,11002,'2025-07-26','Egreso de dinero',4350.00,3),(72,11002,'2025-07-26','Egreso de dinero',4350.00,3),(73,11002,'2025-07-26','Egreso de dinero',4350.00,3),(74,11002,'2025-07-26','Egreso de dinero',4350.00,3),(75,11002,'2025-07-26','Egreso de dinero',4350.00,3),(76,11006,'2025-07-26','Egreso de dinero',4916.67,3),(77,11006,'2025-07-26','Egreso de dinero',4916.67,3),(78,11006,'2025-07-26','Egreso de dinero',4916.67,3),(79,11006,'2025-07-26','Egreso de dinero',4916.67,3),(80,11006,'2025-07-26','Egreso de dinero',4916.67,3);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamos` (
  `id_prestamo` int(5) NOT NULL AUTO_INCREMENT,
  `dnicliente_prestamo` int(8) NOT NULL,
  `nroCuenta_prestamo` int(5) unsigned NOT NULL,
  `importe_a_pagar_prestamo` decimal(15,2) NOT NULL,
  `importe_solicitado_prestamo` decimal(15,2) NOT NULL,
  `plazo_de_pago_prestamo` int(2) NOT NULL,
  `cuotas_prestamo` int(2) NOT NULL,
  `fecha_creacion_prestamo` date NOT NULL,
  `montoMensual_prestamo` decimal(15,2) NOT NULL,
  `estado_prestamo` tinyint(1) DEFAULT '1',
  `condicion_prestamo` enum('A','R','N') DEFAULT 'N',
  PRIMARY KEY (`id_prestamo`),
  KEY `FK_dnicliente_prestamo` (`dnicliente_prestamo`),
  KEY `FK_nroCuenta_prestamo` (`nroCuenta_prestamo`),
  CONSTRAINT `FK_dnicliente_prestamo` FOREIGN KEY (`dnicliente_prestamo`) REFERENCES `clientes` (`dni_cliente`),
  CONSTRAINT `FK_nroCuenta_prestamo` FOREIGN KEY (`nroCuenta_prestamo`) REFERENCES `cuentas` (`nroCuenta_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamos`
--

LOCK TABLES `prestamos` WRITE;
/*!40000 ALTER TABLE `prestamos` DISABLE KEYS */;
INSERT INTO `prestamos` VALUES (1,30111221,11000,57500.00,50000.00,12,12,'2025-03-26',4791.67,1,'A'),(2,30111222,11001,34500.00,30000.00,6,6,'2025-02-26',5750.00,1,'N'),(3,30111223,11002,52200.00,45000.00,12,12,'2025-01-26',4350.00,1,'A'),(4,30111224,11003,22000.00,20000.00,6,6,'2025-08-26',3666.67,1,'N'),(5,30111225,11004,16800.00,15000.00,6,6,'2025-07-26',2800.00,1,'A'),(6,30111226,11005,93600.00,80000.00,24,24,'2025-07-26',3900.00,1,'N'),(7,30111227,11006,118000.00,100000.00,24,24,'2025-07-26',4916.67,1,'A'),(8,30111228,11007,69000.00,60000.00,12,12,'2025-07-26',5750.00,1,'N'),(9,30111229,11008,28000.00,25000.00,6,6,'2025-07-26',4666.67,1,'A'),(10,30111230,11009,45600.00,40000.00,12,12,'2025-07-26',3800.00,1,'N'),(11,30111231,110010,40250.00,35000.00,12,12,'2025-07-26',3354.17,1,'N'),(12,30111232,110011,80500.00,70000.00,18,18,'2025-10-26',4472.22,1,'N'),(13,30111233,110012,138000.00,120000.00,24,24,'2025-07-26',5750.00,1,'N'),(14,30111234,110013,20700.00,18000.00,6,6,'2025-12-26',3450.00,1,'N'),(15,30111235,110014,25300.00,22000.00,6,6,'2025-07-26',4216.67,1,'N');
/*!40000 ALTER TABLE `prestamos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `id_provincia` int(2) NOT NULL AUTO_INCREMENT,
  `descripcion_provincia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Buenos Aires'),(2,'Chaco'),(3,'Catamarca'),(4,'Tucuman'),(5,'Córdoba'),(6,'Santa Fe'),(7,'Mendoza'),(8,'Entre Ríos'),(9,'Corrientes'),(10,'Misiones'),(11,'La Pampa'),(12,'San Luis'),(13,'San Juan'),(14,'La Rioja'),(15,'Santiago del Estero');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocuentas`
--

DROP TABLE IF EXISTS `tipocuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipocuentas` (
  `id_tipoCuenta` int(1) NOT NULL,
  `descripcion_tipoCuenta` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipoCuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocuentas`
--

LOCK TABLES `tipocuentas` WRITE;
/*!40000 ALTER TABLE `tipocuentas` DISABLE KEYS */;
INSERT INTO `tipocuentas` VALUES (1,'Caja de ahorro'),(2,'Cuenta Corriente');
/*!40000 ALTER TABLE `tipocuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomovimientos`
--

DROP TABLE IF EXISTS `tipomovimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipomovimientos` (
  `id_tipoMovimiento` int(1) NOT NULL,
  `descripcion_tipoMovimiento` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipoMovimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomovimientos`
--

LOCK TABLES `tipomovimientos` WRITE;
/*!40000 ALTER TABLE `tipomovimientos` DISABLE KEYS */;
INSERT INTO `tipomovimientos` VALUES (1,'Alta de Cuenta'),(2,'Alta de un Préstamo '),(3,'Pago de Préstamo '),(4,'Transferencia');
/*!40000 ALTER TABLE `tipomovimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencias`
--

DROP TABLE IF EXISTS `transferencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transferencias` (
  `id_transferencia` int(5) NOT NULL AUTO_INCREMENT,
  `cbu_emisor_transferencia` char(22) NOT NULL,
  `cbu_receptor_transferencia` char(22) NOT NULL,
  `monto_transferencia` decimal(15,2) NOT NULL,
  `fecha_transferencia` date NOT NULL,
  `motivo_transferencia` varchar(20) NOT NULL,
  PRIMARY KEY (`id_transferencia`),
  KEY `FK_cbu_emisor_transferencia` (`cbu_emisor_transferencia`),
  KEY `FK_cbu_receptor_transferencia` (`cbu_receptor_transferencia`),
  CONSTRAINT `FK_cbu_emisor_transferencia` FOREIGN KEY (`cbu_emisor_transferencia`) REFERENCES `cuentas` (`cbu_cuenta`),
  CONSTRAINT `FK_cbu_receptor_transferencia` FOREIGN KEY (`cbu_receptor_transferencia`) REFERENCES `cuentas` (`cbu_cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencias`
--

LOCK TABLES `transferencias` WRITE;
/*!40000 ALTER TABLE `transferencias` DISABLE KEYS */;
INSERT INTO `transferencias` VALUES (1,'0000000000000000000121','0000000000000000000122',500.00,'2025-07-26','Pago amigo'),(2,'0000000000000000000122','0000000000000000000123',750.00,'2025-07-26','Deuda bar'),(3,'0000000000000000000123','0000000000000000000124',1200.00,'2025-07-26','Transferencia'),(4,'0000000000000000000124','0000000000000000000125',300.00,'2025-07-26','Regalo'),(5,'0000000000000000000125','0000000000000000000126',800.00,'2025-07-26','Préstamo'),(6,'0000000000000000000126','0000000000000000000127',2500.00,'2025-07-26','Alquiler'),(7,'0000000000000000000127','0000000000000000000128',990.00,'2025-07-26','Compras'),(8,'0000000000000000000128','0000000000000000000129',100.00,'2025-07-26','Reembolso'),(9,'0000000000000000000129','0000000000000000000130',2200.00,'2025-07-26','Transferencia'),(10,'0000000000000000000130','0000000000000000000131',450.00,'2025-07-26','Membresía'),(11,'0000000000000000000131','0000000000000000000132',1600.00,'2025-07-26','Gimnasio'),(12,'0000000000000000000132','0000000000000000000133',200.00,'2025-07-26','Almuerzo'),(13,'0000000000000000000133','0000000000000000000134',350.00,'2025-07-26','Cuota club'),(14,'0000000000000000000134','0000000000000000000135',1300.00,'2025-07-26','Transferencia'),(15,'0000000000000000000135','0000000000000000000121',600.00,'2025-07-26','Vuelta dinero');
/*!40000 ALTER TABLE `transferencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `usuario_US` char(14) NOT NULL,
  `contrasena_US` varchar(50) NOT NULL,
  `tipo_US` enum('C','A') NOT NULL,
  `dnicliente_US` int(8) DEFAULT NULL,
  `nombre_US` varchar(20) NOT NULL,
  `apellido_US` varchar(20) NOT NULL,
  `estado_US` tinyint(1) DEFAULT '1',
  `dniadmin_US` int(8) DEFAULT NULL,
  PRIMARY KEY (`usuario_US`),
  KEY `FK_dnicliente_US` (`dnicliente_US`),
  CONSTRAINT `FK_dnicliente_US` FOREIGN KEY (`dnicliente_US`) REFERENCES `clientes` (`dni_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('30111221.BANCO','pass123','C',30111221,'Lucía','Martínez',1,NULL),('30111222.BANCO','pass123','C',30111222,'Carlos','Gómez',1,NULL),('30111223.BANCO','pass123','C',30111223,'María','Fernández',1,NULL),('30111224.BANCO','pass123','C',30111224,'Javier','Rodríguez',1,NULL),('30111225.BANCO','pass123','C',30111225,'Sofía','López',1,NULL),('30111226.BANCO','pass123','C',30111226,'Martín','García',1,NULL),('30111227.BANCO','pass123','C',30111227,'Valentina','Pérez',1,NULL),('30111228.BANCO','pass123','C',30111228,'Tomás','Sánchez',1,NULL),('30111229.BANCO','pass123','C',30111229,'Camila','Díaz',1,NULL),('30111230.BANCO','pass123','C',30111230,'Franco','Moreno',1,NULL),('30111231.BANCO','pass123','C',30111231,'Agustina','Romero',1,NULL),('30111232.BANCO','pass123','C',30111232,'Diego','Alvarez',1,NULL),('30111233.BANCO','pass123','C',30111233,'Paula','Silva',1,NULL),('30111234.BANCO','pass123','C',30111234,'Leonardo','Torres',1,NULL),('30111235.BANCO','pass123','C',30111235,'Florencia','Ruiz',1,NULL),('41200035.ADMIN','41200035','A',NULL,'Oriana','Manrique',1,41200035),('43395503.ADMIN','43395503','A',NULL,'Braian','Franco',1,43395503);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_banco'
--

--
-- Dumping routines for database 'bd_banco'
--
/*!50003 DROP PROCEDURE IF EXISTS `AgregarCuenta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AgregarCuenta`(
IN dni INT(8),
IN cbu CHAR(22), 
IN idtipo INT (1)
)
BEGIN

DECLARE NroCuenta INT(5);

INSERT INTO cuentas (dnicliente_cuenta, fecha_creacion_cuenta, cbu_cuenta, idtipo_cuenta)
VALUES (dni, curdate(), cbu, idtipo);

-- guardo nrocuenta
    SELECT nroCuenta_cuenta INTO NroCuenta
    FROM Cuentas
    WHERE cbu_cuenta = cbu;

        -- insert movimientos
        INSERT INTO movimientos (
            nroCuenta_movimiento,
            fecha_movimiento,
            detalle_movimiento,
            importe_movimiento,
            id_tipoMovimiento
        )
        VALUES (NroCuenta, CURDATE(), 'Ingreso de dinero', 10000, 1);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `AltaCompletaCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AltaCompletaCliente`(
    IN dnicliente INT(8),
    IN cuil CHAR(11),
    IN nombre VARCHAR(20),
    IN apellido VARCHAR(20),
    IN sexo CHAR(1),
    IN nacionalidad VARCHAR(50),
    IN fechaNacimiento DATE,
    IN direccion VARCHAR(50),
    IN localidad INT(2),
    IN provincia INT(2),
    IN correo VARCHAR(50),
    IN telefono VARCHAR(20),
    IN usuario CHAR(14),
    IN contrasena VARCHAR(50),
    IN estado tinyint
)
BEGIN

    INSERT INTO clientes 
    (dni_cliente, cuil_cliente, nombre_cliente, apellido_cliente, sexo_cliente, nacionalidad_cliente, 
    fecha_nacimiento_cliente, direccion_cliente, id_localidad_cliente, id_provincia_cliente, 
    correo_electronico_cliente, telefono_cliente, usuario_cliente, contrasena_cliente, estado_cliente) 
    VALUES (dnicliente, cuil, nombre, apellido, sexo, nacionalidad, fechaNacimiento, direccion, 
    localidad, provincia, correo, telefono, usuario, contrasena, estado);
    
    INSERT INTO usuarios
    (usuario_US, contrasena_US, tipo_US, dnicliente_US, nombre_US, apellido_US, estado_US)
    VALUES (usuario, contrasena, 'C', dnicliente, nombre, apellido, 1);
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `AltaTransferencia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AltaTransferencia`(
    IN cbu_emisor CHAR(22),
    IN cbu_receptor CHAR(22), 
    IN monto DECIMAL(15,2),
    IN motivo VARCHAR(20)
)
BEGIN
    DECLARE saldo_actual DECIMAL(15,2);
    DECLARE NroCuentaEmisor INT(5);
    DECLARE NroCuentaReceptor INT(5);

    -- saldo del emisor
    SELECT saldo_cuenta INTO saldo_actual
    FROM Cuentas
    WHERE cbu_cuenta = cbu_emisor;

    -- guardar nro cuenta emisor
    SELECT nroCuenta_cuenta INTO NroCuentaEmisor
    FROM Cuentas
    WHERE cbu_cuenta = cbu_emisor;

    -- guardar nro cuenta receptor
    SELECT nroCuenta_cuenta INTO NroCuentaReceptor
    FROM Cuentas
    WHERE cbu_cuenta = cbu_receptor;

    -- validar si tiene saldo suficiente
    IF saldo_actual >= monto THEN
        -- insert transferencia
        INSERT INTO transferencias (
            cbu_emisor_transferencia,
            cbu_receptor_transferencia,
            monto_transferencia,
            fecha_transferencia,
            motivo_transferencia
        )
        VALUES (cbu_emisor, cbu_receptor, monto, CURDATE(), motivo);

        -- update saldos
        UPDATE Cuentas SET saldo_cuenta = saldo_cuenta - monto WHERE cbu_cuenta = cbu_emisor;
        UPDATE Cuentas SET saldo_cuenta = saldo_cuenta + monto WHERE cbu_cuenta = cbu_receptor;

        -- insert movimientos
        INSERT INTO movimientos (
            nroCuenta_movimiento,
            fecha_movimiento,
            detalle_movimiento,
            importe_movimiento,
            id_tipoMovimiento
        )
        VALUES (NroCuentaEmisor, CURDATE(), 'Egreso de dinero', monto, 4);

        INSERT INTO movimientos (
            nroCuenta_movimiento,
            fecha_movimiento,
            detalle_movimiento,
            importe_movimiento,
            id_tipoMovimiento
        )
        VALUES (NroCuentaReceptor, CURDATE(), 'Ingreso de dinero', monto, 4);

    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `AutorizarRechazarPrestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AutorizarRechazarPrestamo`(
IN id INT (5),
IN numeroCuenta_prestamo INT (5),
IN importeSolicitado DECIMAL(15,2),
IN condicion  ENUM('A', 'R', 'N')
)
BEGIN

IF condicion = "R" THEN

UPDATE prestamos SET condicion_prestamo ='R' WHERE id_prestamo = id;


END IF;


IF condicion = "A" THEN

INSERT INTO movimientos (
            nroCuenta_movimiento,
            fecha_movimiento,
            detalle_movimiento,
            importe_movimiento,
            id_tipoMovimiento
        )
        VALUES (numeroCuenta_prestamo, CURDATE(), 'Ingreso de dinero', importeSolicitado, 2);
        
UPDATE cuentas SET saldo_cuenta = saldo_cuenta + importeSolicitado WHERE nroCuenta_cuenta= numeroCuenta_prestamo;

UPDATE prestamos SET condicion_prestamo ='A' WHERE id_prestamo = id;

END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `BajaCompletaCliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `BajaCompletaCliente`(
    IN dnicliente INT(8)
)
BEGIN
    UPDATE clientes
    SET estado_cliente = 0
    WHERE dni_cliente = dnicliente AND estado_cliente = 1;

    UPDATE usuarios
    SET estado_US = 0
    WHERE dnicliente_US = dnicliente AND estado_US = 1;
    
    UPDATE cuentas
    SET estado_cuenta = 0
    WHERE dnicliente_cuenta = dnicliente AND estado_cuenta = 1;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ContarPrestamosPorMes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ContarPrestamosPorMes`(
    IN mes INT,
    IN condicion CHAR(1)
)
BEGIN
    SELECT 
        condicion_prestamo AS Condicion,
        COUNT(*) AS Cantidad
    FROM prestamos
    WHERE MONTH(fecha_creacion_prestamo) = mes
    AND condicion_prestamo = condicion
    GROUP BY condicion_prestamo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `PagarCuota` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `PagarCuota`(
IN idprestamo INT(5),
IN nroCuenta INT(5)
)
BEGIN
DECLARE monto DECIMAL(15,2);

SELECT montoMensual_prestamo INTO monto
FROM prestamos
WHERE id_prestamo = idprestamo;

INSERT INTO cuotasprestamo (id_prestamo_cuota, monto_cuota, fechaPago_cuota)
VALUES (idprestamo, monto, CURDATE());

UPDATE cuentas SET saldo_cuenta = saldo_cuenta - monto
WHERE nroCuenta_cuenta = nroCuenta;

        -- insert movimientos
        INSERT INTO movimientos (
            nroCuenta_movimiento,
            fecha_movimiento,
            detalle_movimiento,
            importe_movimiento,
            id_tipoMovimiento
        )
        VALUES (nroCuenta, CURDATE(), 'Egreso de dinero', monto, 3);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `SolicitudPrestamo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `SolicitudPrestamo`(
IN dni INT(8),
IN nroCuenta INT(5),
IN importeSolicitado DECIMAL(15,2),
IN importeAPagar DECIMAL(15,2),
IN plazo INT(2),
IN cuotas INT(2),
IN montoMensual DECIMAL(15,2)
)
BEGIN

INSERT INTO prestamos (dnicliente_prestamo, nroCuenta_prestamo, 
importe_a_pagar_prestamo, importe_solicitado_prestamo, plazo_de_pago_prestamo, 
cuotas_prestamo, fecha_creacion_prestamo, montoMensual_prestamo)
VALUES (dni, nroCuenta, importeAPagar, importeSolicitado, plazo, cuotas, CURDATE(), montoMensual);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TotalImportePrestamosPorMes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TotalImportePrestamosPorMes`(
    IN mes INT
)
BEGIN
    SELECT 
        SUM(importe_solicitado_prestamo) AS TotalAprobado
    FROM prestamos
    WHERE condicion_prestamo = 'A'
      AND MONTH(fecha_creacion_prestamo) = mes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `TotalPrestamosAprobadosPorMes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `TotalPrestamosAprobadosPorMes`(
    IN mes INT
)
BEGIN
    SELECT 
        SUM(importe_solicitado_prestamo) AS TotalAprobado
    FROM prestamos
    WHERE condicion_prestamo = 'A'
      AND MONTH(fecha_creacion_prestamo) = mes;
END ;;
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

-- Dump completed on 2025-07-28  0:44:45
