CREATE DATABASE  IF NOT EXISTS `mysqldemo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mysqldemo`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: mysqldemo
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `monitor`
--

DROP TABLE IF EXISTS `monitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `monitor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `room_id` bigint NOT NULL,
  `file_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK93wa59s2je85wkymntonx2erp` (`room_id`),
  CONSTRAINT `FK93wa59s2je85wkymntonx2erp` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monitor`
--

LOCK TABLES `monitor` WRITE;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
INSERT INTO `monitor` VALUES (14,9,'dummy.pdf'),(15,9,'some_data.pdf'),(16,10,'dummy.pdf'),(17,10,'some_data.pdf'),(18,11,'dummy.pdf'),(19,11,'some_data.pdf'),(20,12,'dummy.pdf'),(21,12,'some_data.pdf'),(22,12,'dummy.pdf'),(23,12,'dummy.pdf'),(24,12,'dummy.pdf'),(25,12,'dummy.pdf'),(26,12,'dummy.pdf'),(27,12,'dummy.pdf'),(28,12,'dummy.pdf'),(29,12,'dummy.pdf'),(30,12,'dummy.pdf'),(31,12,'dummy.pdf'),(32,13,'dummy.pdf'),(33,13,'some_data.pdf'),(34,13,'dummy.pdf'),(35,13,'dummy.pdf'),(36,13,'dummy.pdf'),(37,13,'dummy.pdf'),(38,13,'dummy.pdf'),(39,13,'dummy.pdf'),(40,13,'dummy.pdf'),(41,13,'dummy.pdf'),(42,13,'dummy.pdf'),(43,13,'dummy.pdf'),(44,13,'dummy.pdf'),(45,13,'dummy.pdf'),(46,13,'dummy.pdf'),(47,13,'dummy.pdf'),(48,13,'dummy.pdf'),(49,13,'dummy.pdf'),(50,13,'dummy.pdf'),(51,13,'dummy.pdf'),(52,13,'dummy.pdf'),(53,13,'dummy.pdf'),(54,13,'dummy.pdf'),(55,13,'dummy.pdf'),(56,13,'dummy.pdf'),(59,16,'dummy.pdf'),(61,18,'dummy.pdf'),(62,19,'dummy.pdf'),(77,28,'dummy.pdf'),(78,28,'Савастєєв_Б_Р_ІТШІз_18_1_звіт_з_практики.pdf');
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (9,'887727','Even More New Room','2024-05-18 19:06:49.883000'),(10,'967897','Z Room','2024-05-18 19:12:53.733000'),(11,'487000','A Room','2024-05-18 19:12:57.483000'),(12,'005572','Test Room','2024-05-18 21:43:54.799000'),(13,'704798','Great Room','2024-05-18 21:56:35.319000'),(16,'255773','Test Room1','2024-05-22 20:17:50.238000'),(18,'772641','Test Room3','2024-05-22 20:18:01.153000'),(19,'777694','Test Room7','2024-05-23 22:47:18.083000'),(28,'372304','Test 1','2024-05-23 23:33:24.852000');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-23 23:38:15
