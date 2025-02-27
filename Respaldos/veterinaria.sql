-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: veterinaria
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mascota`
--

DROP TABLE IF EXISTS `mascota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascota` (
  `idMascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `idPropietario` int NOT NULL,
  `especie` varchar(20) NOT NULL,
  `sexo` char(1) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `fechaFallecimiento` date DEFAULT NULL,
  PRIMARY KEY (`idMascota`),
  KEY `idPropietario` (`idPropietario`),
  CONSTRAINT `mascota_ibfk_1` FOREIGN KEY (`idPropietario`) REFERENCES `propietario` (`idPropietario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascota`
--

LOCK TABLES `mascota` WRITE;
/*!40000 ALTER TABLE `mascota` DISABLE KEYS */;
INSERT INTO `mascota` VALUES (1,'Fluffly',1,'Gato','H','1999-02-04',NULL),(2,'Mau',2,'Gato','M','1998-06-17',NULL),(3,'Buffy',1,'Perro','H','1999-05-13',NULL),(4,'Fanfan',3,'Perro','H','2000-08-31',NULL),(5,'Kaiser',4,'Perro','M','1989-08-31','1997-07-29'),(6,'Chispa',5,'Ave','H','1997-09-11',NULL),(7,'Wicho',6,'Ave','M','2000-02-09',NULL),(8,'Skim',3,'Serpiente','M','2001-04-29',NULL),(9,'Pelusa',4,'Hámster','H','2000-03-30',NULL),(10,'Zarnita',7,'Perro','H','2013-12-12','2014-02-28');
/*!40000 ALTER TABLE `mascota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietario`
--

DROP TABLE IF EXISTS `propietario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propietario` (
  `idPropietario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellidoM` varchar(30) NOT NULL,
  `apellidoP` varchar(30) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `calle` varchar(100) NOT NULL,
  `numero` int NOT NULL,
  `colonia` varchar(30) NOT NULL,
  `codigoPostal` varchar(5) DEFAULT NULL,
  `referencias` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPropietario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietario`
--

LOCK TABLES `propietario` WRITE;
/*!40000 ALTER TABLE `propietario` DISABLE KEYS */;
INSERT INTO `propietario` VALUES (1,'Arnoldo','Hernández','Sánchez','2003-09-21','Marcel Key',3419,'Lake Krystel','96862','Suite 047'),(2,'Juan','García','Ramírez','1993-04-28','Ashlee Field',113,'Alanamouth','82780','Suite 197'),(3,'Benito','Martínez','Cruz','1961-12-08','Keeling Path',148,'Wilmaburgh','94316','Suite 828'),(4,'Diana','López','Flores','1996-10-01','Esperanza Run',9126,'East Agnes','71952','Suite 463'),(5,'Omar','González','Gómez','1960-08-06','Kuphal Prairie',651,'Predovicport','87642','Suite 600'),(6,'Tomás','Pérez','Morales','1963-07-28','Orlando Skyway',2286,'Lake Terrystad','29379','Suite 339'),(7,'Felipe','Rodríguez','Vazquez','2001-07-02','Medhurst Inlet',216,'Franciscoborough','57668','Apt. 673');
/*!40000 ALTER TABLE `propietario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-26 12:06:34
