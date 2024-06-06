CREATE DATABASE  IF NOT EXISTS `db_a3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_a3`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: db_a3
-- ------------------------------------------------------
-- Server version	8.0.36-2ubuntu3

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
-- Table structure for table `tb_amigos`
--

DROP TABLE IF EXISTS `tb_amigos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_amigos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_amigos`
--

LOCK TABLES `tb_amigos` WRITE;
/*!40000 ALTER TABLE `tb_amigos` DISABLE KEYS */;
INSERT INTO `tb_amigos` VALUES (1,'lucas','4899'),(2,'saraha','4898');
/*!40000 ALTER TABLE `tb_amigos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emprestimos`
--

DROP TABLE IF EXISTS `tb_emprestimos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_emprestimos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_amigo` int NOT NULL,
  `id_ferramenta` int NOT NULL,
  `data_emprestimo` date NOT NULL,
  `data_devolucao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_amigo` (`id_amigo`),
  KEY `id_ferramenta` (`id_ferramenta`),
  CONSTRAINT `tb_emprestimos_ibfk_1` FOREIGN KEY (`id_amigo`) REFERENCES `tb_amigos` (`id`),
  CONSTRAINT `tb_emprestimos_ibfk_2` FOREIGN KEY (`id_ferramenta`) REFERENCES `tb_ferramentas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emprestimos`
--

LOCK TABLES `tb_emprestimos` WRITE;
/*!40000 ALTER TABLE `tb_emprestimos` DISABLE KEYS */;
INSERT INTO `tb_emprestimos` VALUES (6,1,1,'2024-06-04',NULL),(7,2,1,'2024-06-04',NULL),(8,1,1,'2024-06-04',NULL),(9,2,1,'2024-06-04',NULL),(10,1,1,'2024-06-04',NULL);
/*!40000 ALTER TABLE `tb_emprestimos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_ferramentas`
--

DROP TABLE IF EXISTS `tb_ferramentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_ferramentas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `custo` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_ferramentas`
--

LOCK TABLES `tb_ferramentas` WRITE;
/*!40000 ALTER TABLE `tb_ferramentas` DISABLE KEYS */;
INSERT INTO `tb_ferramentas` VALUES (1,'chave','phillips',14.9),(2,'tesoura','xiaomi',24.9);
/*!40000 ALTER TABLE `tb_ferramentas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-06 11:55:11
