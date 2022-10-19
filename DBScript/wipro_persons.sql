CREATE DATABASE  IF NOT EXISTS `wipro` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `wipro`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: wipro
-- ------------------------------------------------------
-- Server version	5.7.32-log

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
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `person_id` int(11) NOT NULL,
  `person_first_name` varchar(45) NOT NULL,
  `person_last_name` varchar(45) NOT NULL,
  `person_middle_name` varchar(45) DEFAULT NULL,
  `person_email` varchar(45) DEFAULT NULL,
  `person_street` varchar(45) DEFAULT NULL,
  `person_city` varchar(45) DEFAULT NULL,
  `person_state` varchar(45) DEFAULT NULL,
  `person_country` varchar(45) DEFAULT NULL,
  `person_postalcode` varchar(45) DEFAULT NULL,
  `person_employer_name` varchar(45) DEFAULT NULL,
  `employer_id` varchar(45) DEFAULT NULL,
  `employer_street` varchar(45) DEFAULT NULL,
  `employer_city` varchar(45) DEFAULT NULL,
  `employer_state` varchar(45) DEFAULT NULL,
  `employer_country` varchar(45) DEFAULT NULL,
  `employer_postalcode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,'Wipro','Bangalore','Electronic City','wiprobgl@wipro.com','street','city','state','country','560123','Employer','EMP123','EMPStreet','EMPCity','EMPSTate','EMPCountry','147852');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'wipro'
--

--
-- Dumping routines for database 'wipro'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-14 11:43:38
