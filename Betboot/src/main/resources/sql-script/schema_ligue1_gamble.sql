CREATE DATABASE  IF NOT EXISTS `ligue1_gamble` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `ligue1_gamble`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: ligue1_gamble
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bet`
--

DROP TABLE IF EXISTS `bet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bet` (
  `bet_id` int(11) NOT NULL AUTO_INCREMENT,
  `nb_gambler` int(11) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `club_id` int(11) DEFAULT NULL,
  `match_id` int(11) NOT NULL,
  PRIMARY KEY (`bet_id`),
  KEY `bet_club_id_fk_idx` (`club_id`),
  KEY `bet_match_id_fk_idx` (`match_id`),
  CONSTRAINT `bet_club_id_fk` FOREIGN KEY (`club_id`) REFERENCES `club` (`club_id`),
  CONSTRAINT `bet_match_id_fk` FOREIGN KEY (`match_id`) REFERENCES `match` (`match_id`)
) ENGINE=InnoDB AUTO_INCREMENT=271 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bet`
--

LOCK TABLES `bet` WRITE;
/*!40000 ALTER TABLE `bet` DISABLE KEYS */;
INSERT INTO `bet` VALUES (1,0,1,2,1),(2,0,1,7,1),(3,0,1,NULL,1),(4,0,1,10,2),(5,0,1,8,2),(6,0,1,NULL,2),(7,0,1,9,3),(8,0,1,1,3),(9,0,1,NULL,3),(10,0,1,4,4),(11,0,1,5,4),(12,0,1,NULL,4),(13,0,1,3,5),(14,0,1,6,5),(15,0,1,NULL,5),(16,0,1,1,6),(17,0,1,6,6),(18,0,1,NULL,6),(19,0,1,9,7),(20,0,1,3,7),(21,0,1,NULL,7),(22,0,1,8,8),(23,0,1,4,8),(24,0,1,NULL,8),(25,0,1,10,9),(26,0,1,2,9),(27,0,1,NULL,9),(28,0,1,7,10),(29,0,1,5,10),(30,0,1,NULL,10),(31,0,1,1,11),(32,0,1,8,11),(33,0,1,NULL,11),(34,0,1,9,12),(35,0,1,7,12),(36,0,1,NULL,12),(37,0,1,3,13),(38,0,1,4,13),(39,0,1,NULL,13),(40,0,1,2,14),(41,0,1,5,14),(42,0,1,NULL,14),(43,0,1,10,15),(44,0,1,6,15),(45,0,1,NULL,15),(46,0,1,7,16),(47,0,1,8,16),(48,0,1,NULL,16),(49,0,1,5,17),(50,0,1,10,17),(51,0,1,NULL,17),(52,0,1,6,18),(53,0,1,9,18),(54,0,1,NULL,18),(55,0,1,3,19),(56,0,1,1,19),(57,0,1,NULL,19),(58,0,1,4,20),(59,0,1,2,20),(60,0,1,NULL,20),(61,0,1,8,21),(62,0,1,2,21),(63,0,1,NULL,21),(64,0,1,9,22),(65,0,1,10,22),(66,0,1,NULL,22),(67,0,1,7,23),(68,0,1,3,23),(69,0,1,NULL,23),(70,0,1,6,24),(71,0,1,4,24),(72,0,1,NULL,24),(73,0,1,5,25),(74,0,1,1,25),(75,0,1,NULL,25),(76,0,1,3,26),(77,0,1,10,26),(78,0,1,NULL,26),(79,0,1,5,27),(80,0,1,8,27),(81,0,1,NULL,27),(82,0,1,6,28),(83,0,1,7,28),(84,0,1,NULL,28),(85,0,1,1,29),(86,0,1,2,29),(87,0,1,NULL,29),(88,0,1,4,30),(89,0,1,9,30),(90,0,1,NULL,30),(91,0,1,8,31),(92,0,1,6,31),(93,0,1,NULL,31),(94,0,1,9,32),(95,0,1,5,32),(96,0,1,NULL,32),(97,0,1,10,33),(98,0,1,4,33),(99,0,1,NULL,33),(100,0,1,7,34),(101,0,1,1,34),(102,0,1,NULL,34),(103,0,1,2,35),(104,0,1,3,35),(105,0,1,NULL,35),(106,0,1,8,36),(107,0,1,9,36),(108,0,1,NULL,36),(109,0,1,5,37),(110,0,1,3,37),(111,0,1,NULL,37),(112,0,1,1,38),(113,0,1,4,38),(114,0,1,NULL,38),(115,0,1,7,39),(116,0,1,10,39),(117,0,1,NULL,39),(118,0,1,6,40),(119,0,1,2,40),(120,0,1,NULL,40),(121,0,1,2,41),(122,0,1,9,41),(123,0,1,NULL,41),(124,0,1,3,42),(125,0,1,8,42),(126,0,1,NULL,42),(127,0,1,5,43),(128,0,1,6,43),(129,0,1,NULL,43),(130,0,1,1,44),(131,0,1,10,44),(132,0,1,NULL,44),(133,0,1,4,45),(134,0,1,7,45),(135,0,1,NULL,45),(136,0,1,5,46),(137,0,1,4,46),(138,0,1,NULL,46),(139,0,1,1,47),(140,0,1,9,47),(141,0,1,NULL,47),(142,0,1,8,48),(143,0,1,10,48),(144,0,1,NULL,48),(145,0,1,7,49),(146,0,1,2,49),(147,0,1,NULL,49),(148,0,1,6,50),(149,0,1,3,50),(150,0,1,NULL,50),(151,8,18.8042,10,51),(152,3,24.96,5,51),(153,9,1.30769,NULL,51),(154,0,1,1,52),(155,0,1,3,52),(156,0,1,NULL,52),(157,0,1,2,53),(158,0,1,4,53),(159,0,1,NULL,53),(160,0,1,9,54),(161,0,1,6,54),(162,0,1,NULL,54),(163,0,1,8,55),(164,0,1,7,55),(165,0,1,NULL,55),(166,0,1,8,56),(167,0,1,1,56),(168,0,1,NULL,56),(169,0,1,6,57),(170,0,1,10,57),(171,0,1,NULL,57),(172,0,1,4,58),(173,0,1,3,58),(174,0,1,NULL,58),(175,0,1,7,59),(176,0,1,9,59),(177,0,1,NULL,59),(178,0,1,5,60),(179,0,1,2,60),(180,0,1,NULL,60),(181,0,1,2,61),(182,0,1,6,61),(183,0,1,NULL,61),(184,0,1,9,62),(185,0,1,8,62),(186,0,1,NULL,62),(187,0,1,10,63),(188,0,1,7,63),(189,0,1,NULL,63),(190,0,1,3,64),(191,0,1,5,64),(192,0,1,NULL,64),(193,0,1,4,65),(194,0,1,1,65),(195,0,1,NULL,65),(196,0,1,3,66),(197,0,1,7,66),(198,0,1,NULL,66),(199,0,1,10,67),(200,0,1,9,67),(201,0,1,NULL,67),(202,0,1,4,68),(203,0,1,6,68),(204,0,1,NULL,68),(205,0,1,1,69),(206,0,1,5,69),(207,0,1,NULL,69),(208,0,1,2,70),(209,0,1,8,70),(210,0,1,NULL,70),(211,0,1,5,71),(212,0,1,7,71),(213,0,1,NULL,71),(214,0,1,4,72),(215,0,1,8,72),(216,0,1,NULL,72),(217,0,1,3,73),(218,0,1,9,73),(219,0,1,NULL,73),(220,0,1,6,74),(221,0,1,1,74),(222,0,1,NULL,74),(223,0,1,2,75),(224,0,1,10,75),(225,0,1,NULL,75),(226,0,1,8,76),(227,0,1,5,76),(228,0,1,NULL,76),(229,0,1,2,77),(230,0,1,1,77),(231,0,1,NULL,77),(232,0,1,9,78),(233,0,1,4,78),(234,0,1,NULL,78),(235,0,1,7,79),(236,0,1,6,79),(237,0,1,NULL,79),(238,0,1,10,80),(239,0,1,3,80),(240,0,1,NULL,80),(241,0,1,5,81),(242,0,1,9,81),(243,0,1,NULL,81),(244,0,1,1,82),(245,0,1,7,82),(246,0,1,NULL,82),(247,0,1,4,83),(248,0,1,10,83),(249,0,1,NULL,83),(250,0,1,6,84),(251,0,1,8,84),(252,0,1,NULL,84),(253,0,1,3,85),(254,0,1,2,85),(255,0,1,NULL,85),(256,0,1,10,86),(257,0,1,1,86),(258,0,1,NULL,86),(259,0,1,6,87),(260,0,1,5,87),(261,0,1,NULL,87),(262,0,1,8,88),(263,0,1,3,88),(264,0,1,NULL,88),(265,0,1,9,89),(266,0,1,2,89),(267,0,1,NULL,89),(268,0,1,7,90),(269,0,1,4,90),(270,0,1,NULL,90);
/*!40000 ALTER TABLE `bet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookmaker`
--

DROP TABLE IF EXISTS `bookmaker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bookmaker` (
  `bookmaker_id` int(11) NOT NULL AUTO_INCREMENT,
  `bet_balance` int(11) DEFAULT NULL,
  `bet_profit` int(11) DEFAULT NULL,
  `match_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookmaker_id`),
  KEY `bookmaker_match_id_fk_idx` (`match_id`),
  CONSTRAINT `bookmaker_match_id_fk` FOREIGN KEY (`match_id`) REFERENCES `match` (`match_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmaker`
--

LOCK TABLES `bookmaker` WRITE;
/*!40000 ALTER TABLE `bookmaker` DISABLE KEYS */;
/*!40000 ALTER TABLE `bookmaker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `club` (
  `club_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `played` int(11) DEFAULT NULL,
  `won` int(11) DEFAULT NULL,
  `lost` int(11) DEFAULT NULL,
  `drawn` int(11) DEFAULT NULL,
  `prestige` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `residency` varchar(45) NOT NULL,
  `logo_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (1,'AS Monaco',6,4,2,0,10,12,'Stade Louis II-Monaco-Castelans, Monaco','/logoclub/monaco.png'),(2,'FC Nantes',6,1,3,2,2,5,'Stade de la Beaujoire, Nantes','/logoclub/nantes.png'),(3,'LOSC',6,2,3,1,1,7,'Stade Pierre Mauroy, Lille','/logoclub/lille.png'),(4,'OGC Nice',6,2,1,3,8,9,'Stade Allianz Riviera, Nice','/logoclub/nice.png'),(5,'OL',7,1,4,2,4,5,'Stade des Lumières, Lyon','/logoclub/lyon.png'),(6,'OM',6,3,2,1,16,10,'Stade Vélodrome, Marseille','/logoclub/om.png'),(7,'Paris SG',6,4,1,1,20,13,'Parc des Princes, Paris','/logoclub/psg.png'),(8,'RC Lens',5,1,2,2,3,5,'Stade Bollaert-Delelis, Lens','/logoclub/lens.png'),(9,'Rennes FC',6,0,3,3,13,3,'Roazhon Park, Rennes','/logoclub/rennes.png'),(10,'Strasbourg RC',7,5,1,1,6,16,'Stade de la Meinau, Strasbourg','/logoclub/strasbourg.png');
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gambling`
--

DROP TABLE IF EXISTS `gambling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gambling` (
  `gambling_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `gambling_date` datetime DEFAULT NULL,
  `gain` float DEFAULT NULL,
  `bet_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`gambling_id`),
  KEY `gambling_user_id_fk_idx` (`user_id`),
  KEY `gambling_bet_id_fk_idx` (`bet_id`),
  CONSTRAINT `gambling_bet_id_fk` FOREIGN KEY (`bet_id`) REFERENCES `bet` (`bet_id`),
  CONSTRAINT `gambling_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gambling`
--

LOCK TABLES `gambling` WRITE;
/*!40000 ALTER TABLE `gambling` DISABLE KEYS */;
INSERT INTO `gambling` VALUES (1,10,'2022-05-10 23:42:39',0,2,1),(2,15,'2022-05-10 23:47:53',20,6,1),(3,5,'2022-05-11 01:46:48',150.667,152,1),(4,5,'2022-05-11 01:49:11',149.639,152,1),(5,20,'2022-05-11 02:01:37',20,152,39),(16,20,'2022-05-11 09:19:12',528,151,49),(17,15,'2022-05-11 09:27:44',-85,151,49),(18,15,'2022-05-11 09:27:54',300.3,151,49),(19,21,'2022-05-11 11:26:49',410.909,151,50),(20,12,'2022-05-11 11:28:29',348.343,152,50);
/*!40000 ALTER TABLE `gambling` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `match` (
  `match_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `club_home` int(11) DEFAULT NULL,
  `club_visitor` int(11) DEFAULT NULL,
  PRIMARY KEY (`match_id`),
  KEY `team_a_club_id_fk_idx` (`club_home`),
  KEY `team_b_club_id_fk_idx` (`club_visitor`),
  CONSTRAINT `team_a_club_id_fk` FOREIGN KEY (`club_home`) REFERENCES `club` (`club_id`),
  CONSTRAINT `team_b_club_id_fk` FOREIGN KEY (`club_visitor`) REFERENCES `club` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `match`
--

LOCK TABLES `match` WRITE;
/*!40000 ALTER TABLE `match` DISABLE KEYS */;
INSERT INTO `match` VALUES (1,'2022-03-02 15:00:00',NULL,2,7),(2,'2022-03-02 16:00:00',NULL,10,8),(3,'2022-03-02 17:00:00',NULL,9,1),(4,'2022-03-02 18:00:00',NULL,4,5),(5,'2022-03-02 19:00:00',NULL,3,6),(6,'2022-03-09 15:00:00',NULL,1,6),(7,'2022-03-09 16:00:00',NULL,9,3),(8,'2022-03-09 17:00:00',NULL,8,4),(9,'2022-03-09 18:00:00',NULL,10,2),(10,'2022-03-09 19:00:00',NULL,7,5),(11,'2022-03-16 15:00:00',NULL,1,8),(12,'2022-03-16 16:00:00',NULL,9,7),(13,'2022-03-16 17:00:00',NULL,3,4),(14,'2022-03-16 18:00:00',NULL,2,5),(15,'2022-03-16 19:00:00',NULL,10,6),(16,'2022-03-23 15:00:00',NULL,7,8),(17,'2022-03-23 16:00:00',NULL,5,10),(18,'2022-03-23 17:00:00',NULL,6,9),(19,'2022-03-23 18:00:00',NULL,3,1),(20,'2022-03-23 19:00:00',NULL,4,2),(21,'2022-03-30 15:00:00',NULL,8,2),(22,'2022-03-30 16:00:00',NULL,9,10),(23,'2022-03-30 17:00:00',NULL,7,3),(24,'2022-03-30 18:00:00',NULL,6,4),(25,'2022-03-30 19:00:00',NULL,5,1),(26,'2022-04-06 15:00:00',NULL,3,10),(27,'2022-04-06 16:00:00',NULL,5,8),(28,'2022-04-06 17:00:00',NULL,6,7),(29,'2022-04-06 18:00:00',NULL,1,2),(30,'2022-04-06 19:00:00',NULL,4,9),(31,'2022-04-13 15:00:00',NULL,8,6),(32,'2022-04-13 16:00:00',NULL,9,5),(33,'2022-04-13 17:00:00',NULL,10,4),(34,'2022-04-13 18:00:00',NULL,7,1),(35,'2022-04-13 19:00:00',NULL,2,3),(36,'2022-04-20 15:00:00',NULL,8,9),(37,'2022-04-20 16:00:00',NULL,5,3),(38,'2022-04-20 17:00:00',NULL,1,4),(39,'2022-04-20 18:00:00',NULL,7,10),(40,'2022-04-20 19:00:00',NULL,6,2),(41,'2022-04-27 15:00:00',NULL,2,9),(42,'2022-04-27 16:00:00',NULL,3,8),(43,'2022-04-27 17:00:00',NULL,5,6),(44,'2022-04-27 18:00:00',NULL,1,10),(45,'2022-04-27 19:00:00',NULL,4,7),(46,'2022-05-04 15:00:00',NULL,5,4),(47,'2022-05-04 16:00:00',NULL,1,9),(48,'2022-05-04 17:00:00',NULL,8,10),(49,'2022-05-04 18:00:00',NULL,7,2),(50,'2022-05-04 19:00:00',NULL,6,3),(51,'2022-05-11 15:00:00',NULL,10,5),(52,'2022-05-11 16:00:00',NULL,1,3),(53,'2022-05-11 17:00:00',NULL,2,4),(54,'2022-05-11 18:00:00',NULL,9,6),(55,'2022-05-11 19:00:00',NULL,8,7),(56,'2022-05-18 15:00:00',NULL,8,1),(57,'2022-05-18 16:00:00',NULL,6,10),(58,'2022-05-18 17:00:00',NULL,4,3),(59,'2022-05-18 18:00:00',NULL,7,9),(60,'2022-05-18 19:00:00',NULL,5,2),(61,'2022-05-25 15:00:00',NULL,2,6),(62,'2022-05-25 16:00:00',NULL,9,8),(63,'2022-05-25 17:00:00',NULL,10,7),(64,'2022-05-25 18:00:00',NULL,3,5),(65,'2022-05-25 19:00:00',NULL,4,1),(66,'2022-06-01 15:00:00',NULL,3,7),(67,'2022-06-01 16:00:00',NULL,10,9),(68,'2022-06-01 17:00:00',NULL,4,6),(69,'2022-06-01 18:00:00',NULL,1,5),(70,'2022-06-01 19:00:00',NULL,2,8),(71,'2022-06-08 15:00:00',NULL,5,7),(72,'2022-06-08 16:00:00',NULL,4,8),(73,'2022-06-08 17:00:00',NULL,3,9),(74,'2022-06-08 18:00:00',NULL,6,1),(75,'2022-06-08 19:00:00',NULL,2,10),(76,'2022-06-15 15:00:00',NULL,8,5),(77,'2022-06-15 16:00:00',NULL,2,1),(78,'2022-06-15 17:00:00',NULL,9,4),(79,'2022-06-15 18:00:00',NULL,7,6),(80,'2022-06-15 19:00:00',NULL,10,3),(81,'2022-06-22 15:00:00',NULL,5,9),(82,'2022-06-22 16:00:00',NULL,1,7),(83,'2022-06-22 17:00:00',NULL,4,10),(84,'2022-06-22 18:00:00',NULL,6,8),(85,'2022-06-22 19:00:00',NULL,3,2),(86,'2022-06-29 15:00:00',NULL,10,1),(87,'2022-06-29 16:00:00',NULL,6,5),(88,'2022-06-29 17:00:00',NULL,8,3),(89,'2022-06-29 18:00:00',NULL,9,2),(90,'2022-06-29 19:00:00',NULL,7,4);
/*!40000 ALTER TABLE `match` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `birth_date` date NOT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `adress` varchar(45) NOT NULL,
  `zip_code` varchar(5) NOT NULL,
  `city_name` varchar(45) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'première','personne','1997-09-15','masculin','1 allee person','92000','Nanterre','600000001'),(2,'Mélanie','personne','1997-09-15','Féminin','2 allee person','92000','Nanterre','600000001'),(3,'Mélanie','VENANT','2022-04-01',NULL,'rue du paradis','10000','love','0600000000'),(4,'Mélanie','VENANT','2022-04-01',NULL,'rue du paradis','10000','love','0600000000'),(5,'Mélanie','VENANT','2022-04-01',NULL,'rue du paradis','10000','love','0600000000'),(10,'Mélanie','VENANT','2022-04-01',NULL,'rue du paradis','10000','love','0600000000'),(11,'Mélanie','VENANT','2022-04-01',NULL,'rue du paradis','10000','love','0600000000'),(12,'Mélanie','VENANT','2022-04-01',NULL,'rue du paradis','10000','love','0600000000'),(26,'Mélanie','VENANT','2022-05-27','Female','rue du paradis','10000','love','0600000000'),(46,'Melou','Vnt','2022-04-07','Female','Hello avenue','50000','Here','0600000000'),(47,'Meline','Vnt','2022-04-28','Female','Route arc-en-ciel','66666','Eden','0600000000'),(48,'Quelqu\'un','Inconnu','2022-03-30','Female','Hello avenue','50000','Here','0600000000'),(49,'Mélanie','personne','1997-09-15','Female','2 allee person','92000','Nanterre','6000000022'),(50,'Melou','Vnt','2022-05-06','Féminin','Hello avenue','50000','Here','6000000015'),(51,'Melimelo','Vnt','2022-04-28','Féminin','Hello avenue','50000','Here','6000000015'),(52,'Melou','Vnt','2022-05-04','Féminin','Hello avenue','50000','Here','6000000015'),(53,'Melou','Vnt','2022-04-25','Féminin','Hello avenue','50000','Here','6000000015'),(54,'Melou','Vnt','2022-04-26','Féminin','Hello avenue','50000','Here','6000000015'),(55,'Melou','Vnt','2022-05-03','Féminin','Hello avenue','50000','Here','6000000015'),(56,'Melou','Vnt','2022-05-03','Féminin','Hello avenue','50000','Here','6000000015'),(57,'Melou','Vnt','2022-05-03','Féminin','Hello avenue','50000','Here','6000000015'),(58,'Melou','Vnt','2022-04-14','Féminin','Hello avenue','50000','Here','6000000015'),(59,'Melou','Vnt','2022-04-11','Féminin','Hello avenue','50000','Here','6000000015'),(60,'Melou','Vnt','2022-05-05','Féminin','Hello avenue','50000','Here','6000000015'),(61,'Melou','Vnt','2022-03-31','Féminin','Hello avenue','50000','Here','6000000015');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `results` (
  `result_id` int(11) NOT NULL AUTO_INCREMENT,
  `match_id` int(11) NOT NULL,
  `victory_id` int(11) DEFAULT NULL,
  `score_a` int(11) DEFAULT NULL,
  `score_b` int(11) DEFAULT NULL,
  `lose_id` int(11) DEFAULT NULL,
  `draw_home_id` int(11) DEFAULT NULL,
  `draw_visitor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`result_id`),
  KEY `victory_club_id_fk_idx` (`victory_id`),
  KEY `results_match_id_fk_idx` (`match_id`),
  KEY `draw_home_club_id_fk_idx` (`draw_home_id`),
  KEY `draw_visitor_club_id_fk_idx` (`draw_visitor_id`),
  KEY `lose_club_id_fk_idx` (`lose_id`),
  CONSTRAINT `draw_home_club_id_fk` FOREIGN KEY (`draw_home_id`) REFERENCES `club` (`club_id`),
  CONSTRAINT `draw_visitor_club_id_fk` FOREIGN KEY (`draw_visitor_id`) REFERENCES `club` (`club_id`),
  CONSTRAINT `lose_club_id_fk` FOREIGN KEY (`lose_id`) REFERENCES `club` (`club_id`),
  CONSTRAINT `results_match_id_fk` FOREIGN KEY (`match_id`) REFERENCES `match` (`match_id`),
  CONSTRAINT `victory_club_id_fk` FOREIGN KEY (`victory_id`) REFERENCES `club` (`club_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
INSERT INTO `results` VALUES (1,1,2,2,1,7,NULL,NULL),(2,2,10,3,2,NULL,NULL,NULL),(3,3,1,1,2,9,NULL,NULL),(4,4,4,1,0,5,NULL,NULL),(5,5,3,3,1,6,NULL,NULL),(6,6,6,0,1,1,NULL,NULL),(7,7,NULL,2,2,NULL,9,3),(8,8,NULL,1,1,NULL,8,4),(9,9,10,2,0,2,NULL,NULL),(10,10,7,2,0,5,NULL,NULL),(11,11,8,0,1,1,NULL,NULL),(12,12,NULL,3,3,NULL,9,7),(13,13,3,1,0,4,NULL,NULL),(14,14,NULL,1,1,NULL,2,5),(15,15,6,2,3,10,NULL,NULL),(16,16,7,3,1,8,NULL,NULL),(17,17,NULL,2,2,NULL,5,10),(18,18,6,2,1,9,NULL,NULL),(19,19,1,0,2,3,NULL,NULL),(20,20,4,3,1,2,NULL,NULL),(21,21,NULL,3,3,NULL,8,2),(22,22,10,1,2,9,NULL,NULL),(23,23,7,5,1,3,NULL,NULL),(24,24,NULL,2,2,NULL,6,4),(25,25,1,2,3,5,NULL,NULL),(26,26,10,1,2,3,NULL,NULL),(27,27,5,3,2,8,NULL,NULL),(28,28,7,3,4,6,NULL,NULL),(29,29,1,2,0,2,NULL,NULL),(30,30,NULL,1,1,NULL,4,9),(31,31,NULL,NULL,NULL,NULL,NULL,NULL),(32,32,NULL,NULL,NULL,NULL,NULL,NULL),(33,33,NULL,NULL,NULL,NULL,NULL,NULL),(34,34,NULL,NULL,NULL,NULL,NULL,NULL),(35,35,NULL,NULL,NULL,NULL,NULL,NULL),(36,36,NULL,NULL,NULL,NULL,NULL,NULL),(37,37,NULL,NULL,NULL,NULL,NULL,NULL),(38,38,NULL,NULL,NULL,NULL,NULL,NULL),(39,39,NULL,NULL,NULL,NULL,NULL,NULL),(40,40,NULL,NULL,NULL,NULL,NULL,NULL),(41,41,NULL,NULL,NULL,NULL,NULL,NULL),(42,42,NULL,NULL,NULL,NULL,NULL,NULL),(43,43,NULL,NULL,NULL,NULL,NULL,NULL),(44,44,NULL,NULL,NULL,NULL,NULL,NULL),(45,45,NULL,NULL,NULL,NULL,NULL,NULL),(46,46,NULL,NULL,NULL,NULL,NULL,NULL),(47,47,NULL,NULL,NULL,NULL,NULL,NULL),(48,48,NULL,NULL,NULL,NULL,NULL,NULL),(49,49,NULL,NULL,NULL,NULL,NULL,NULL),(50,50,NULL,NULL,NULL,NULL,NULL,NULL),(51,51,10,3,1,5,NULL,NULL),(52,52,NULL,NULL,NULL,NULL,NULL,NULL),(53,53,NULL,NULL,NULL,NULL,NULL,NULL),(54,54,NULL,NULL,NULL,NULL,NULL,NULL),(55,55,NULL,NULL,NULL,NULL,NULL,NULL),(56,56,NULL,NULL,NULL,NULL,NULL,NULL),(57,57,NULL,NULL,NULL,NULL,NULL,NULL),(58,58,NULL,NULL,NULL,NULL,NULL,NULL),(59,59,NULL,NULL,NULL,NULL,NULL,NULL),(60,60,NULL,NULL,NULL,NULL,NULL,NULL),(61,61,NULL,NULL,NULL,NULL,NULL,NULL),(62,62,NULL,NULL,NULL,NULL,NULL,NULL),(63,63,NULL,NULL,NULL,NULL,NULL,NULL),(64,64,NULL,NULL,NULL,NULL,NULL,NULL),(65,65,NULL,NULL,NULL,NULL,NULL,NULL),(66,66,NULL,NULL,NULL,NULL,NULL,NULL),(67,67,NULL,NULL,NULL,NULL,NULL,NULL),(68,68,NULL,NULL,NULL,NULL,NULL,NULL),(69,69,NULL,NULL,NULL,NULL,NULL,NULL),(70,70,NULL,NULL,NULL,NULL,NULL,NULL),(71,71,NULL,NULL,NULL,NULL,NULL,NULL),(72,72,NULL,NULL,NULL,NULL,NULL,NULL),(73,73,NULL,NULL,NULL,NULL,NULL,NULL),(74,74,NULL,NULL,NULL,NULL,NULL,NULL),(75,75,NULL,NULL,NULL,NULL,NULL,NULL),(76,76,NULL,NULL,NULL,NULL,NULL,NULL),(77,77,NULL,NULL,NULL,NULL,NULL,NULL),(78,78,NULL,NULL,NULL,NULL,NULL,NULL),(79,79,NULL,NULL,NULL,NULL,NULL,NULL),(80,80,NULL,NULL,NULL,NULL,NULL,NULL),(81,81,NULL,NULL,NULL,NULL,NULL,NULL),(82,82,NULL,NULL,NULL,NULL,NULL,NULL),(83,83,NULL,NULL,NULL,NULL,NULL,NULL),(84,84,NULL,NULL,NULL,NULL,NULL,NULL),(85,85,NULL,NULL,NULL,NULL,NULL,NULL),(86,86,NULL,NULL,NULL,NULL,NULL,NULL),(87,87,NULL,NULL,NULL,NULL,NULL,NULL),(88,88,NULL,NULL,NULL,NULL,NULL,NULL),(89,89,NULL,NULL,NULL,NULL,NULL,NULL),(90,90,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `confirm_password` varchar(200) NOT NULL,
  `picture_path` varchar(200) DEFAULT NULL,
  `last_connection` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `person_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mail_UNIQUE` (`mail`),
  UNIQUE KEY `UK6sou31qus5dnws6dwfu61e71v` (`mail`),
  KEY `gambler_id_fk_idx` (`person_id`),
  CONSTRAINT `gambler_id_fk` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1@hotmail.com','$2a$10$8R7YQ71qhb5ipkfzd9YSPOmMr5/Xlr2uGWJkd/uPT9ug8cNyKmTnm','$2a$10$8R7YQ71qhb5ipkfzd9YSPOmMr5/Xlr2uGWJkd/uPT9ug8cNyKmTnm','12.jpg','2022-04-28','enabled',2),(4,'root@gmail.com','1111,1111','',NULL,NULL,NULL,5),(9,'user2@gmail.com','1111,1111','',NULL,NULL,NULL,10),(36,'user3@hotmail.com','$2a$10$oljAUCzxWR4.TTWHgJsmg.VTEAkXfUKuj9kwpJzpQYFvfEoV0uof6','$2a$10$oljAUCzxWR4.TTWHgJsmg.VTEAkXfUKuj9kwpJzpQYFvfEoV0uof6','8.jpg',NULL,NULL,46),(37,'user4@hotmail.com','$2a$10$HUIZfyQ/FGjxIDMz3fek/uNMEs6iyhv48T5mlm3fbRAJTS6OCNGje','$2a$10$HUIZfyQ/FGjxIDMz3fek/uNMEs6iyhv48T5mlm3fbRAJTS6OCNGje',NULL,NULL,NULL,47),(38,'user6@gmail.com','$2a$10$j4Fb43oOnEID.KDhoztXp.j.v.GOJav06F66L8snMeDsVQEwXy28i','$2a$10$j4Fb43oOnEID.KDhoztXp.j.v.GOJav06F66L8snMeDsVQEwXy28i','1.jpg',NULL,NULL,48),(39,'user8@hotmail.com','$2a$10$sc6wdPL6Gt9nqYsSUKs3ouDGcKI4qwJfcIINHJrbEjuLWg7XgpWEu','$2a$10$sc6wdPL6Gt9nqYsSUKs3ouDGcKI4qwJfcIINHJrbEjuLWg7XgpWEu','2.jpg',NULL,NULL,50),(40,'user9@hotmail.com','$2a$10$5jKlsSHpu6X5SLGU0Tx8DuaB.5aBUe3hge8aRQtOeFpeo9o6d2WDW','$2a$10$5jKlsSHpu6X5SLGU0Tx8DuaB.5aBUe3hge8aRQtOeFpeo9o6d2WDW',NULL,NULL,NULL,51),(41,'user10@hotmail.com','$2a$10$UK7FJrW6ShRHQGubpQDpZev6f0nAL7HkrgNeGwLdAaLHvOhm7REh.','$2a$10$UK7FJrW6ShRHQGubpQDpZev6f0nAL7HkrgNeGwLdAaLHvOhm7REh.',NULL,NULL,NULL,52),(42,'user11@hotmail.com','$2a$10$F87jLo.5PjtyYohrlfGNhO17OwLNUG6dDkZqxIrsrosDZI2J7m8fe','$2a$10$F87jLo.5PjtyYohrlfGNhO17OwLNUG6dDkZqxIrsrosDZI2J7m8fe',NULL,NULL,NULL,53),(43,'user12@hotmail.com','$2a$10$bX/dzlFbMz2jpyDslZX1muTltHM5nITXGld/5cjoF7g6iI7XvAtUS','$2a$10$bX/dzlFbMz2jpyDslZX1muTltHM5nITXGld/5cjoF7g6iI7XvAtUS',NULL,NULL,NULL,54),(44,'user14@hotmail.com','$2a$10$YanK08ogX7MQNcg9juW/he8ZjopuK54oFHR/IxAefgKjdoIZfRJtS','$2a$10$YanK08ogX7MQNcg9juW/he8ZjopuK54oFHR/IxAefgKjdoIZfRJtS',NULL,NULL,NULL,55),(47,'user20@hotmail.com','$2a$10$kfg5aAIcHBau.Q4/QFQmhex63tkSIikLTyiQ25mMwZn6nbVXyq2U2','$2a$10$kfg5aAIcHBau.Q4/QFQmhex63tkSIikLTyiQ25mMwZn6nbVXyq2U2','15.jpg',NULL,NULL,58),(49,'user21@hotmail.com','$2a$10$EqNFzdf4/EVgUxadR6B1MuLRCT7VvGUbdDAQgSTi9KxeQU1KOK4N6','$2a$10$EqNFzdf4/EVgUxadR6B1MuLRCT7VvGUbdDAQgSTi9KxeQU1KOK4N6','3.jpg',NULL,NULL,60),(50,'user22@hotmail.fr','$2a$10$Sq/SOYBsAVXloy5ot4XapefhzVg0VYRr7eq94XfCiURYMgAKqbDhy','$2a$10$Sq/SOYBsAVXloy5ot4XapefhzVg0VYRr7eq94XfCiURYMgAKqbDhy','8.jpg',NULL,NULL,61);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `user_id_fk_idx` (`user_id`),
  CONSTRAINT `user_id_role_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,'ROLE_ADMIN'),(23,36,'ROLE_USER'),(24,37,'ROLE_USER'),(25,38,'ROLE_USER'),(26,39,'ROLE_USER'),(27,40,'ROLE_USER'),(28,41,'ROLE_USER'),(29,42,'ROLE_USER'),(30,43,'ROLE_USER'),(31,44,'ROLE_USER'),(32,47,'ROLE_USER'),(33,49,'ROLE_USER'),(34,50,'ROLE_USER');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `wallet` (
  `wallet_id` int(11) NOT NULL AUTO_INCREMENT,
  `avail_balance` float DEFAULT NULL,
  `last_activity` date DEFAULT NULL,
  `last_recharge` date DEFAULT NULL,
  `recharge_amount` float DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`wallet_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
INSERT INTO `wallet` VALUES (1,363.358,'2022-05-07',NULL,40,1),(2,NULL,NULL,NULL,NULL,36),(3,NULL,NULL,NULL,NULL,37),(4,NULL,NULL,NULL,NULL,38),(5,480,NULL,NULL,500,39),(6,NULL,NULL,NULL,NULL,40),(7,NULL,NULL,NULL,NULL,41),(8,NULL,NULL,NULL,NULL,42),(9,NULL,NULL,NULL,NULL,43),(10,NULL,NULL,NULL,NULL,44),(11,10,NULL,NULL,20,47),(12,889.3,NULL,NULL,400,49),(13,437.909,NULL,NULL,40,50);
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-11 14:56:00
