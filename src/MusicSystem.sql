CREATE DATABASE  IF NOT EXISTS `espotifai` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `espotifai`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: espotifai
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `genero_musica`
--

DROP TABLE IF EXISTS `genero_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero_musica` (
  `ID_GENERO` int NOT NULL AUTO_INCREMENT,
  `NOME_GENERO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_GENERO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero_musica`
--

LOCK TABLES `genero_musica` WRITE;
/*!40000 ALTER TABLE `genero_musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero_musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica`
--

DROP TABLE IF EXISTS `musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica` (
  `ID_MUSICA` int NOT NULL AUTO_INCREMENT,
  `NOME_MUSICA` varchar(45) NOT NULL,
  `NOTA_MUSICA` float NOT NULL,
  PRIMARY KEY (`ID_MUSICA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica`
--

LOCK TABLES `musica` WRITE;
/*!40000 ALTER TABLE `musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musica_genero_musica`
--

DROP TABLE IF EXISTS `musica_genero_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musica_genero_musica` (
  `ID_MUSICA` int NOT NULL,
  `ID_GENERO` int NOT NULL,
  PRIMARY KEY (`ID_MUSICA`,`ID_GENERO`),
  KEY `FK_GENERO_idx` (`ID_GENERO`),
  CONSTRAINT `FK_MUSICA_GENERO_MUSICA_GENERO` FOREIGN KEY (`ID_GENERO`) REFERENCES `genero_musica` (`ID_GENERO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_MUSICA_GENERO_MUSICA_MUSICA` FOREIGN KEY (`ID_MUSICA`) REFERENCES `musica` (`ID_MUSICA`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musica_genero_musica`
--

LOCK TABLES `musica_genero_musica` WRITE;
/*!40000 ALTER TABLE `musica_genero_musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `musica_genero_musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` int NOT NULL AUTO_INCREMENT,
  `NOME_USUARIO` varchar(45) NOT NULL,
  `SENHA_USUARIO` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_genero_musica`
--

DROP TABLE IF EXISTS `usuario_genero_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_genero_musica` (
  `ID_USUARIO` int NOT NULL,
  `ID_GENERO` int NOT NULL,
  `DATA_ADICAO` datetime NOT NULL,
  PRIMARY KEY (`ID_USUARIO`,`ID_GENERO`),
  KEY `FK_USUARIO_GENERO_MUSICA_GENERO_MUSICA_idx` (`ID_GENERO`),
  CONSTRAINT `FK_USUARIO_GENERO_MUSICA_GENERO_MUSICA` FOREIGN KEY (`ID_GENERO`) REFERENCES `genero_musica` (`ID_GENERO`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USUARIO_GENERO_MUSICA_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_genero_musica`
--

LOCK TABLES `usuario_genero_musica` WRITE;
/*!40000 ALTER TABLE `usuario_genero_musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_genero_musica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_musica`
--

DROP TABLE IF EXISTS `usuario_musica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_musica` (
  `ID_USUARIO` int NOT NULL,
  `ID_MUSICA` int NOT NULL,
  `NOTA_USUARIO` float NOT NULL,
  PRIMARY KEY (`ID_USUARIO`,`ID_MUSICA`),
  KEY `FK_MUSICA_idx` (`ID_MUSICA`),
  CONSTRAINT `FK_USUARIO_MUSICA_MUSICA` FOREIGN KEY (`ID_MUSICA`) REFERENCES `musica` (`ID_MUSICA`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USUARIO_MUSICA_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `usuario` (`ID_USUARIO`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_musica`
--

LOCK TABLES `usuario_musica` WRITE;
/*!40000 ALTER TABLE `usuario_musica` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_musica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-22 19:58:40
