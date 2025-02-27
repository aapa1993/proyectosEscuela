-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: videoclub
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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `calle` varchar(100) NOT NULL,
  `numero` tinyint NOT NULL,
  `colonia` varchar(30) NOT NULL,
  `referencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Clark Kent','Calle primera',44,'Krypton','El planeta'),(2,'Peter Parker','Calle Tia Mey',33,'New York','Tio Ben'),(3,'Wanda Maximoff','Calle Prieto',14,'Sokovia','Escarlata'),(4,'Barry Allen','Calle paradoja',7,'Carrerilla','Speedforce'),(5,'Natasha Romanoff','Calle vengador',66,'Rusia','La viuda'),(6,'Bruce Wayne','Av. Wayne',1,'Gotham','Robin'),(7,'Scott Lang','Calle hormiga',38,'Cuántico','La avispa'),(8,'Wade Wilson','Calle apuesta',9,'Pool','Mercenario'),(9,'Frank Castle','Calle venganza',13,'Hells Kitchen','Castigador'),(10,'Hal Jordan','Av. Linterna',20,'Verde','Faro');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactocliente`
--

DROP TABLE IF EXISTS `contactocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactocliente` (
  `idCliente` int NOT NULL,
  `contacto` varchar(50) NOT NULL,
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `contactocliente_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactocliente`
--

LOCK TABLES `contactocliente` WRITE;
/*!40000 ALTER TABLE `contactocliente` DISABLE KEYS */;
INSERT INTO `contactocliente` VALUES (2,'spidy@hotmail.com'),(4,'9821234567'),(6,'@BatSignal'),(8,'piscinamortal@gmail.com'),(10,'@TheLantern');
/*!40000 ALTER TABLE `contactocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `idPelicula` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) NOT NULL,
  `director` varchar(60) DEFAULT NULL,
  `genero` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idPelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'Superman','Richard Donner','Si-Fi'),(2,'Spiderman','Sam Raimi','Heroes'),(3,'Batman','Matt Reeves','Suspense'),(4,'Scarface','Brian De Palma','Action'),(5,'Kill Bill','Quentin Tarantino','Thriller');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `protagonistapelicula`
--

DROP TABLE IF EXISTS `protagonistapelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `protagonistapelicula` (
  `idPelicula` int NOT NULL,
  `nombrePersonaje` varchar(60) NOT NULL,
  `nombreActor` varchar(60) NOT NULL,
  KEY `idPelicula` (`idPelicula`),
  CONSTRAINT `protagonistapelicula_ibfk_1` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `protagonistapelicula`
--

LOCK TABLES `protagonistapelicula` WRITE;
/*!40000 ALTER TABLE `protagonistapelicula` DISABLE KEYS */;
INSERT INTO `protagonistapelicula` VALUES (2,'Spiderman','Tobby Mcguire'),(3,'Batman','Christian Bale'),(5,'Black Mamba','Umah Thurman');
/*!40000 ALTER TABLE `protagonistapelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renta`
--

DROP TABLE IF EXISTS `renta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renta` (
  `idCliente` int NOT NULL,
  `idPelicula` int NOT NULL,
  `fechaRenta` date NOT NULL,
  `fechaDevolucion` date NOT NULL,
  KEY `idCliente` (`idCliente`),
  KEY `idPelicula` (`idPelicula`),
  CONSTRAINT `renta_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `renta_ibfk_2` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renta`
--

LOCK TABLES `renta` WRITE;
/*!40000 ALTER TABLE `renta` DISABLE KEYS */;
INSERT INTO `renta` VALUES (1,5,'2022-03-02','2022-03-04');
/*!40000 ALTER TABLE `renta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-26 11:50:18
