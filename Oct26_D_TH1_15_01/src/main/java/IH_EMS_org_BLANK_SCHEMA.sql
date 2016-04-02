-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: IH_EMS_org
-- ------------------------------------------------------
-- Server version	5.5.46-0ubuntu0.14.04.2

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
-- Table structure for table `bulk_filter_invite`
--

DROP TABLE IF EXISTS `bulk_filter_invite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bulk_filter_invite` (
  `event_id` int(8) NOT NULL,
  `department_id` int(6) DEFAULT NULL,
  `location_id` int(6) DEFAULT NULL,
  KEY `event_id` (`event_id`),
  KEY `department_id` (`department_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `bulk_filter_invite_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event_details` (`event_id`),
  CONSTRAINT `bulk_filter_invite_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `department_details` (`department_id`),
  CONSTRAINT `bulk_filter_invite_ibfk_3` FOREIGN KEY (`location_id`) REFERENCES `location_details` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulk_filter_invite`
--

LOCK TABLES `bulk_filter_invite` WRITE;
/*!40000 ALTER TABLE `bulk_filter_invite` DISABLE KEYS */;
/*!40000 ALTER TABLE `bulk_filter_invite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_details`
--

DROP TABLE IF EXISTS `city_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_details` (
  `city_id` smallint(4) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(50) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_details`
--

LOCK TABLES `city_details` WRITE;
/*!40000 ALTER TABLE `city_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `city_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country_details`
--

DROP TABLE IF EXISTS `country_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_details` (
  `country_id` smallint(4) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(50) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_details`
--

LOCK TABLES `country_details` WRITE;
/*!40000 ALTER TABLE `country_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `country_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_details`
--

DROP TABLE IF EXISTS `department_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department_details` (
  `department_id` int(6) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(50) NOT NULL,
  `work_anniversary` date DEFAULT NULL,
  `department_desc` text,
  `anniversary_msg` text,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_details`
--

LOCK TABLES `department_details` WRITE;
/*!40000 ALTER TABLE `department_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `department_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_details`
--

DROP TABLE IF EXISTS `employee_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_details` (
  `employee_id` varchar(10) NOT NULL DEFAULT '',
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `work_anniversary` date DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `location_id` int(4) NOT NULL,
  `user_type_id` smallint(2) DEFAULT NULL,
  `email_id` varchar(50) NOT NULL,
  `department_id` int(6) DEFAULT NULL,
  `employee_contact` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `location_id` (`location_id`),
  KEY `user_type_id` (`user_type_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `employee_details_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location_details` (`location_id`),
  CONSTRAINT `employee_details_ibfk_2` FOREIGN KEY (`user_type_id`) REFERENCES `user_type_details` (`user_type_id`),
  CONSTRAINT `employee_details_ibfk_3` FOREIGN KEY (`department_id`) REFERENCES `department_details` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_details`
--

LOCK TABLES `employee_details` WRITE;
/*!40000 ALTER TABLE `employee_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_details`
--

DROP TABLE IF EXISTS `event_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_details` (
  `event_id` int(8) NOT NULL AUTO_INCREMENT,
  `event_name` varchar(200) NOT NULL,
  `event_desc` text,
  `event_venue` varchar(200) NOT NULL,
  `event_date` date NOT NULL,
  `event_time` varchar(10) DEFAULT NULL,
  `event_added_by` varchar(10) DEFAULT NULL,
  `event_invite_msg` text,
  PRIMARY KEY (`event_id`),
  KEY `event_added_by` (`event_added_by`),
  CONSTRAINT `event_details_ibfk_2` FOREIGN KEY (`event_added_by`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_details`
--

LOCK TABLES `event_details` WRITE;
/*!40000 ALTER TABLE `event_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_invite_list`
--

DROP TABLE IF EXISTS `event_invite_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_invite_list` (
  `event_id` int(8) NOT NULL,
  `employee_id` varchar(10) NOT NULL,
  KEY `event_id` (`event_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `event_invite_list_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event_details` (`event_id`),
  CONSTRAINT `event_invite_list_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_invite_list`
--

LOCK TABLES `event_invite_list` WRITE;
/*!40000 ALTER TABLE `event_invite_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_invite_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_details`
--

DROP TABLE IF EXISTS `location_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_details` (
  `location_id` int(6) NOT NULL AUTO_INCREMENT,
  `country_id` smallint(4) DEFAULT NULL,
  `city_id` smallint(4) DEFAULT NULL,
  `office_id` int(6) NOT NULL,
  `location_timezone` varchar(10) NOT NULL,
  PRIMARY KEY (`location_id`),
  KEY `country_id` (`country_id`),
  KEY `city_id` (`city_id`),
  KEY `office_id` (`office_id`),
  CONSTRAINT `location_details_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country_details` (`country_id`),
  CONSTRAINT `location_details_ibfk_2` FOREIGN KEY (`city_id`) REFERENCES `city_details` (`city_id`),
  CONSTRAINT `location_details_ibfk_3` FOREIGN KEY (`office_id`) REFERENCES `office_details` (`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_details`
--

LOCK TABLES `location_details` WRITE;
/*!40000 ALTER TABLE `location_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mailling_list`
--

DROP TABLE IF EXISTS `mailling_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mailling_list` (
  `employee_id` varchar(10) NOT NULL,
  `wish_type` smallint(2) NOT NULL,
  `location_id` int(6) NOT NULL,
  KEY `employee_id` (`employee_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `mailling_list_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location_details` (`location_id`),
  CONSTRAINT `mailling_list_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mailling_list`
--

LOCK TABLES `mailling_list` WRITE;
/*!40000 ALTER TABLE `mailling_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `mailling_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages_anniversary`
--

DROP TABLE IF EXISTS `messages_anniversary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages_anniversary` (
  `message_id` smallint(2) NOT NULL AUTO_INCREMENT,
  `message_text` text NOT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages_anniversary`
--

LOCK TABLES `messages_anniversary` WRITE;
/*!40000 ALTER TABLE `messages_anniversary` DISABLE KEYS */;
/*!40000 ALTER TABLE `messages_anniversary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages_birthday`
--

DROP TABLE IF EXISTS `messages_birthday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages_birthday` (
  `message_id` smallint(2) NOT NULL AUTO_INCREMENT,
  `message_text` text NOT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages_birthday`
--

LOCK TABLES `messages_birthday` WRITE;
/*!40000 ALTER TABLE `messages_birthday` DISABLE KEYS */;
/*!40000 ALTER TABLE `messages_birthday` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office_details`
--

DROP TABLE IF EXISTS `office_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `office_details` (
  `office_id` int(6) NOT NULL AUTO_INCREMENT,
  `office_address` varchar(200) NOT NULL,
  PRIMARY KEY (`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office_details`
--

LOCK TABLES `office_details` WRITE;
/*!40000 ALTER TABLE `office_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `office_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizer_access`
--

DROP TABLE IF EXISTS `organizer_access`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizer_access` (
  `employee_id` varchar(10) NOT NULL,
  `location_access` int(6) NOT NULL,
  KEY `location_access` (`location_access`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `organizer_access_ibfk_1` FOREIGN KEY (`location_access`) REFERENCES `location_details` (`location_id`),
  CONSTRAINT `organizer_access_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizer_access`
--

LOCK TABLES `organizer_access` WRITE;
/*!40000 ALTER TABLE `organizer_access` DISABLE KEYS */;
/*!40000 ALTER TABLE `organizer_access` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizer_login`
--

DROP TABLE IF EXISTS `organizer_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizer_login` (
  `employee_id` varchar(10) NOT NULL,
  `password` varchar(80) NOT NULL,
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `organizer_login_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizer_login`
--

LOCK TABLES `organizer_login` WRITE;
/*!40000 ALTER TABLE `organizer_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `organizer_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_event_invite`
--

DROP TABLE IF EXISTS `personal_event_invite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_event_invite` (
  `event_id` int(8) NOT NULL,
  `employee_id` varchar(10) NOT NULL,
  KEY `event_id` (`event_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `personal_event_invite_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `event_details` (`event_id`),
  CONSTRAINT `personal_event_invite_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_event_invite`
--

LOCK TABLES `personal_event_invite` WRITE;
/*!40000 ALTER TABLE `personal_event_invite` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_event_invite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_details`
--

DROP TABLE IF EXISTS `team_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_details` (
  `team_id` int(8) NOT NULL AUTO_INCREMENT,
  `team_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_details`
--

LOCK TABLES `team_details` WRITE;
/*!40000 ALTER TABLE `team_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_members`
--

DROP TABLE IF EXISTS `team_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_members` (
  `team_id` int(8) NOT NULL,
  `employee_id` varchar(10) NOT NULL,
  KEY `team_id` (`team_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `team_members_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team_details` (`team_id`),
  CONSTRAINT `team_members_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee_details` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_members`
--

LOCK TABLES `team_members` WRITE;
/*!40000 ALTER TABLE `team_members` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type_details`
--

DROP TABLE IF EXISTS `user_type_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_type_details` (
  `user_type_id` smallint(2) NOT NULL DEFAULT '0',
  `user_type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type_details`
--

LOCK TABLES `user_type_details` WRITE;
/*!40000 ALTER TABLE `user_type_details` DISABLE KEYS */;
INSERT INTO `user_type_details` VALUES (1,'Super Admin'),(2,'Sub Admin'),(3,'Employee');
/*!40000 ALTER TABLE `user_type_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-06 22:25:53
