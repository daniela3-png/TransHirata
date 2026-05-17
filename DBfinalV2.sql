CREATE DATABASE  IF NOT EXISTS `db_hirata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `db_hirata`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_hirata
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activos_ti`
--

DROP TABLE IF EXISTS `activos_ti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activos_ti` (
  `id_activo` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_dispositivo` enum('CPU','NOTEBOOK','IMPRESORA','MONITOR','SERVIDOR') NOT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `modelo` varchar(50) DEFAULT NULL,
  `nro_serie` varchar(100) NOT NULL,
  `estado` enum('OPERATIVO','EN_MANTENCION','DEBAJA') DEFAULT 'OPERATIVO',
  `sistema_operativo` varchar(50) DEFAULT NULL,
  `version_sw` varchar(50) DEFAULT NULL,
  `id_usuario_asignado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_activo`),
  UNIQUE KEY `nro_serie` (`nro_serie`),
  KEY `id_usuario_asignado` (`id_usuario_asignado`),
  CONSTRAINT `activos_ti_ibfk_1` FOREIGN KEY (`id_usuario_asignado`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activos_ti`
--

LOCK TABLES `activos_ti` WRITE;
/*!40000 ALTER TABLE `activos_ti` DISABLE KEYS */;
INSERT INTO `activos_ti` VALUES (4,'NOTEBOOK','Dell','Latitude 3540','NB-DANI-01','OPERATIVO',NULL,NULL,1),(5,'NOTEBOOK','HP','ProBook 450','NB-JAVI-03','OPERATIVO',NULL,NULL,3),(6,'CPU','Lenovo','ThinkCentre M70','CPU-DANI-01','OPERATIVO',NULL,NULL,1),(7,'CPU','Lenovo','ThinkCentre M70','CPU-MAU-04','OPERATIVO',NULL,NULL,4),(8,'CPU','Lenovo','ThinkCentre M70','CPU-ALEX-02','OPERATIVO',NULL,NULL,2),(9,'IMPRESORA','Epson','EcoTank L3210','PRN-DANI-01','OPERATIVO',NULL,NULL,1),(10,'IMPRESORA','Brother','HL-L2350DW','PRN-ALEX-02','OPERATIVO',NULL,NULL,2),(11,'IMPRESORA','HP','LaserJet M15w','PRN-JAVI-03','OPERATIVO',NULL,NULL,3),(12,'IMPRESORA','Canon','Pixma G3110','PRN-MAU-04','OPERATIVO',NULL,NULL,4);
/*!40000 ALTER TABLE `activos_ti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camion`
--

DROP TABLE IF EXISTS `camion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `camion` (
  `patente` varchar(10) NOT NULL,
  `marca` varchar(30) DEFAULT NULL,
  `modelo` varchar(30) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `kilometraje_actual` int(11) DEFAULT 0,
  `estado` enum('ACTIVO','MANTENCION','FUERA_DE_SERVICIO') DEFAULT 'ACTIVO',
  PRIMARY KEY (`patente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camion`
--

LOCK TABLES `camion` WRITE;
/*!40000 ALTER TABLE `camion` DISABLE KEYS */;
INSERT INTO `camion` VALUES ('ABCD-12','Volvo','FH16',2020,4000,'ACTIVO'),('EFGH-34','Mercedes-Benz','FH17',2022,2000,'ACTIVO'),('IJKL-56','Scania','FH18',2023,3500,'ACTIVO'),('MNOP-78','Iveco','FH19',2019,4500,'ACTIVO');
/*!40000 ALTER TABLE `camion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mantencion_ti`
--

DROP TABLE IF EXISTS `mantencion_ti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mantencion_ti` (
  `id_mantencion` int(11) NOT NULL AUTO_INCREMENT,
  `id_activo` int(11) DEFAULT NULL,
  `id_usuario_soporte` int(11) DEFAULT NULL,
  `tipo_mantencion` enum('PREVENTIVO','CORRECTIVO') NOT NULL,
  `descripcion_falla` text DEFAULT NULL,
  `accion_realizada` text DEFAULT NULL,
  `fecha_mantencion` datetime DEFAULT current_timestamp(),
  `fecha_inicio` datetime DEFAULT NULL,
  `fecha_termino` datetime DEFAULT NULL,
  `estado_equipo` enum('OPERATIVO','EN_REPARACION','EN_ESPERA_REPUESTO','PENDIENTE_REPUESTO') DEFAULT 'OPERATIVO',
  `proxima_revision` date DEFAULT NULL,
  PRIMARY KEY (`id_mantencion`),
  KEY `id_activo` (`id_activo`),
  KEY `id_usuario_soporte` (`id_usuario_soporte`),
  CONSTRAINT `mantencion_ti_ibfk_1` FOREIGN KEY (`id_activo`) REFERENCES `activos_ti` (`id_activo`),
  CONSTRAINT `mantencion_ti_ibfk_2` FOREIGN KEY (`id_usuario_soporte`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantencion_ti`
--

LOCK TABLES `mantencion_ti` WRITE;
/*!40000 ALTER TABLE `mantencion_ti` DISABLE KEYS */;
INSERT INTO `mantencion_ti` VALUES (1,4,3,'CORRECTIVO','asdasd','asdasd','2026-05-16 20:43:54','2026-05-16 20:43:00',NULL,'OPERATIVO',NULL),(2,4,3,'CORRECTIVO','sdfsf','asdads','2026-05-16 22:02:49','2026-05-16 22:02:00','2026-05-16 23:00:00','OPERATIVO',NULL),(3,4,3,'CORRECTIVO','asda','asdd','2026-05-16 22:19:04','2026-05-16 22:18:00','2026-05-16 23:00:00','OPERATIVO',NULL);
/*!40000 ALTER TABLE `mantencion_ti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mantenimiento_camion`
--

DROP TABLE IF EXISTS `mantenimiento_camion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mantenimiento_camion` (
  `id_mantenimiento` int(11) NOT NULL AUTO_INCREMENT,
  `patente` varchar(10) DEFAULT NULL,
  `kilometraje_programado` int(11) NOT NULL,
  `fecha_mantenimiento` date NOT NULL,
  `solicitado_por` varchar(100) DEFAULT NULL,
  `realizado` tinyint(1) DEFAULT 0,
  `detalle_servicio` text DEFAULT NULL,
  PRIMARY KEY (`id_mantenimiento`),
  KEY `patente` (`patente`),
  CONSTRAINT `mantenimiento_camion_ibfk_1` FOREIGN KEY (`patente`) REFERENCES `camion` (`patente`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantenimiento_camion`
--

LOCK TABLES `mantenimiento_camion` WRITE;
/*!40000 ALTER TABLE `mantenimiento_camion` DISABLE KEYS */;
/*!40000 ALTER TABLE `mantenimiento_camion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro_kilometraje`
--

DROP TABLE IF EXISTS `registro_kilometraje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registro_kilometraje` (
  `id_registro` int(11) NOT NULL AUTO_INCREMENT,
  `patente` varchar(10) DEFAULT NULL,
  `fecha_registro` datetime DEFAULT current_timestamp(),
  `kilometraje` int(11) NOT NULL,
  PRIMARY KEY (`id_registro`),
  KEY `patente` (`patente`),
  CONSTRAINT `registro_kilometraje_ibfk_1` FOREIGN KEY (`patente`) REFERENCES `camion` (`patente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_kilometraje`
--

LOCK TABLES `registro_kilometraje` WRITE;
/*!40000 ALTER TABLE `registro_kilometraje` DISABLE KEYS */;
/*!40000 ALTER TABLE `registro_kilometraje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repuestos`
--

DROP TABLE IF EXISTS `repuestos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repuestos` (
  `id_repuesto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_pieza` varchar(100) NOT NULL,
  `tipo_pieza` enum('RAM','DISCO_DURO','TONER','FUENTE_PODER','PERIFERICO') NOT NULL,
  `stock_actual` int(11) DEFAULT 0,
  `estado_pieza` enum('NUEVO','USADO') DEFAULT 'NUEVO',
  `categoria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repuestos`
--

LOCK TABLES `repuestos` WRITE;
/*!40000 ALTER TABLE `repuestos` DISABLE KEYS */;
INSERT INTO `repuestos` VALUES (1,'Memoria RAM 8GB DDR4','RAM',9,'NUEVO','NOTEBOOK'),(2,'Disco SSD 480GB','DISCO_DURO',5,'NUEVO','PC'),(3,'Tóner Negro HP','TONER',3,'NUEVO','IMPRESORA'),(4,'Batería Notebook Universal','RAM',9,'NUEVO','NOTEBOOK'),(5,'Cargador Notebook 19V','RAM',15,'NUEVO','NOTEBOOK'),(6,'Teclado Notebook Español','RAM',5,'NUEVO','NOTEBOOK'),(7,'Módulo RAM 8GB DDR4 Laptop','RAM',20,'NUEVO','NOTEBOOK'),(8,'Fuente de Poder 500W','FUENTE_PODER',8,'NUEVO','PC'),(9,'Disco SSD 480GB SATA','DISCO_DURO',25,'NUEVO','PC'),(10,'Ventilador CPU 120mm','PERIFERICO',12,'NUEVO','PC'),(11,'Pasta Térmica Pro','PERIFERICO',30,'NUEVO','PC'),(12,'Cable Poder Trébol','PERIFERICO',50,'NUEVO','PC'),(13,'Tóner Negro HP 85A','TONER',10,'NUEVO','IMPRESORA'),(14,'Tóner Cian Epson','TONER',6,'NUEVO','IMPRESORA'),(15,'Tóner Magenta Epson','TONER',6,'NUEVO','IMPRESORA'),(16,'Tóner Amarillo Epson','TONER',6,'NUEVO','IMPRESORA'),(17,'Kit de Rodillos de Arrastre','PERIFERICO',4,'NUEVO','IMPRESORA'),(18,'Cable USB Impresora 1.8m','PERIFERICO',20,'NUEVO','IMPRESORA');
/*!40000 ALTER TABLE `repuestos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uso_repuestos_ti`
--

DROP TABLE IF EXISTS `uso_repuestos_ti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uso_repuestos_ti` (
  `id_uso` int(11) NOT NULL AUTO_INCREMENT,
  `id_mantencion` int(11) DEFAULT NULL,
  `id_repuesto` int(11) DEFAULT NULL,
  `cantidad_usada` int(11) DEFAULT 1,
  PRIMARY KEY (`id_uso`),
  KEY `id_mantencion` (`id_mantencion`),
  KEY `id_repuesto` (`id_repuesto`),
  CONSTRAINT `uso_repuestos_ti_ibfk_1` FOREIGN KEY (`id_mantencion`) REFERENCES `mantencion_ti` (`id_mantencion`),
  CONSTRAINT `uso_repuestos_ti_ibfk_2` FOREIGN KEY (`id_repuesto`) REFERENCES `repuestos` (`id_repuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uso_repuestos_ti`
--

LOCK TABLES `uso_repuestos_ti` WRITE;
/*!40000 ALTER TABLE `uso_repuestos_ti` DISABLE KEYS */;
INSERT INTO `uso_repuestos_ti` VALUES (1,1,1,1),(2,3,4,1);
/*!40000 ALTER TABLE `uso_repuestos_ti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `rut` varchar(12) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `rol` enum('ADMIN','MANTENCION','CONDUCTOR','SOPORTE_TI') NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `rut` (`rut`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'19471598-6','Daniela','Montecinos','1947','ADMIN'),(2,'18897826-6','Alexandra','Ticona','1889','MANTENCION'),(3,'20505764-1','Javiera','Manquez','2050','SOPORTE_TI'),(4,'15046158-8','Mauricio','Fernandez','1504','CONDUCTOR');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'db_hirata'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-16 22:25:44
