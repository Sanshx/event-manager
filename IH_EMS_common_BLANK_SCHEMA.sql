-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: IH_EMS_common
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
-- Table structure for table `event_vendor_details`
--

DROP TABLE IF EXISTS `event_vendor_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_vendor_details` (
  `vendor_id` int(8) NOT NULL AUTO_INCREMENT,
  `vendor_name` varchar(100) NOT NULL,
  `password` varchar(80) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `vendor_address` varchar(200) DEFAULT NULL,
  `contact_number` varchar(15) DEFAULT NULL,
  `alternate_contact` varchar(15) DEFAULT NULL,
  `number_of_bookings` smallint(2) DEFAULT NULL,
  `average_rating` decimal(2,1) DEFAULT NULL,
  `vendor_desc` text,
  `vendor_price` text,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_vendor_details`
--

LOCK TABLES `event_vendor_details` WRITE;
/*!40000 ALTER TABLE `event_vendor_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_vendor_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_vendor_locations`
--

DROP TABLE IF EXISTS `event_vendor_locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event_vendor_locations` (
  `vendor_id` int(8) NOT NULL,
  `vendor_country_name` varchar(50) NOT NULL,
  `vendor_city_name` varchar(50) NOT NULL,
  KEY `vendor_id` (`vendor_id`),
  CONSTRAINT `event_vendor_locations_ibfk_1` FOREIGN KEY (`vendor_id`) REFERENCES `event_vendor_details` (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_vendor_locations`
--

LOCK TABLES `event_vendor_locations` WRITE;
/*!40000 ALTER TABLE `event_vendor_locations` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_vendor_locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `org_record`
--

DROP TABLE IF EXISTS `org_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `org_record` (
  `org_id` int(8) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(50) NOT NULL,
  `org_desc` text,
  `org_db_name` varchar(50) DEFAULT NULL,
  `org_anniversary` date DEFAULT NULL,
  `org_recovery_email` varchar(50) NOT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `org_record`
--

LOCK TABLES `org_record` WRITE;
/*!40000 ALTER TABLE `org_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `org_record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-06 22:25:40
