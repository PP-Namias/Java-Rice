CREATE DATABASE  IF NOT EXISTS `java-rice` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `java-rice`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: java-rice
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `tblcostumer`
--

DROP TABLE IF EXISTS `tblcostumer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcostumer` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(200) NOT NULL,
  `lname` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcostumer`
--

LOCK TABLES `tblcostumer` WRITE;
/*!40000 ALTER TABLE `tblcostumer` DISABLE KEYS */;
INSERT INTO `tblcostumer` VALUES (1,'Namias','Keneth','69420','Male','Llano','07:29:20 PM','03-01-2023','jkrbn99@gmail.com'),(2,'Mike','Caram','69','Male','Caloocan','01:30:34 PM','03-05-2023','mike@gmail.com');
/*!40000 ALTER TABLE `tblcostumer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblinvoice`
--

DROP TABLE IF EXISTS `tblinvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblinvoice` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `user` varchar(50) NOT NULL,
  `costumer` varchar(50) NOT NULL,
  `paid_amount` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `balance` varchar(50) NOT NULL,
  `sub_total` varchar(50) NOT NULL,
  `total_quantity` varchar(50) NOT NULL,
  `transaction_no` int NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblinvoice`
--

LOCK TABLES `tblinvoice` WRITE;
/*!40000 ALTER TABLE `tblinvoice` DISABLE KEYS */;
INSERT INTO `tblinvoice` VALUES (5,'User','Regular Costumer','100','Paid','88.0','12.0','4.0',6,'02-05-2023','07:07:44 PM'),(6,'User','Regular Costumer','1000','Paid','655.0','345.0','23.0',7,'02-05-2023','07:24:25 PM'),(7,'User','Regular Costumer','1000','Paid','765.0','235.0','15.0',8,'02-05-2023','07:34:06 PM'),(8,'Namias','Regular Costumer','1000','Paid','593.00','407.00','22',9,'02-05-2023','07:54:53 AM'),(9,'Namias','Regular Costumer','40','Paid','10.0','30.0','2.0',10,'02-05-2023','03:22:11 PM'),(10,'Namias','Regular Costumer','100','Paid','35.0','65.0','5.0',11,'09-05-2023','09:57:12 AM'),(11,'Caram','Namias','3','Partial','-24.0','27.0','3',12,'13-05-2023','06:23:45 PM'),(12,'Guest','Mike','0.0','Unpaid','0.0','147.0','3',13,'20-05-2023','10:41:47 AM');
/*!40000 ALTER TABLE `tblinvoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbllog`
--

DROP TABLE IF EXISTS `tbllog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbllog` (
  `Logid` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `type` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`Logid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllog`
--

LOCK TABLES `tbllog` WRITE;
/*!40000 ALTER TABLE `tbllog` DISABLE KEYS */;
INSERT INTO `tbllog` VALUES (1,'Namias','admin',1),(2,'User','User',2),(3,'Caram','User',2),(4,'Llanes','User',2);
/*!40000 ALTER TABLE `tbllog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblnum`
--

DROP TABLE IF EXISTS `tblnum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblnum` (
  `numid` int NOT NULL AUTO_INCREMENT,
  `value` int NOT NULL,
  PRIMARY KEY (`numid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblnum`
--

LOCK TABLES `tblnum` WRITE;
/*!40000 ALTER TABLE `tblnum` DISABLE KEYS */;
INSERT INTO `tblnum` VALUES (1,13);
/*!40000 ALTER TABLE `tblnum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblproduct`
--

DROP TABLE IF EXISTS `tblproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblproduct` (
  `prod_id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) NOT NULL,
  `bar_code` varchar(50) NOT NULL,
  `price` int NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `mark_up` int NOT NULL,
  `exp_date` varchar(50) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL,
  PRIMARY KEY (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblproduct`
--

LOCK TABLES `tblproduct` WRITE;
/*!40000 ALTER TABLE `tblproduct` DISABLE KEYS */;
INSERT INTO `tblproduct` VALUES (1,'Java Rice','1',9,'22.0',6,'09-09-2021','01-05-2023','02:58:52 PM'),(2,'Egg','2',9,'20.0',6,'12-23-2023','01-05-2023','07:04:19 PM'),(3,'Java Rice w/ Egg','3',25,'35',13,'12-23-2023','01-05-2023','07:06:24 PM'),(4,'Java Rice w/ Bacon','4',39,'23',13,'12-4-2024','01-05-2023','07:07:21 PM'),(5,'Java Rice w/ Chicken','5',49,'30.0',13,'1-3-2030','01-05-2023','07:10:12 PM'),(6,'Java Rice w/ Ham','6',39,'-1.0',12,'12-2-2030','01-05-2023','07:11:30 PM'),(7,'Java Rice w/ Hotdog','7',39,'25.0',15,'22-21-2030','01-05-2023','07:12:28 PM'),(8,'Java Rice w/ Pork','8',49,'0.0',15,'12-2-2030','01-05-2023','07:14:32 PM'),(9,'Java Rice w/ Shanghai','9',39,'9.0',11,'12-9-2030','01-05-2023','07:18:39 PM'),(10,'Java Rice w/ Tapa','10',49,'28.0',15,'10-9-2023','01-05-2023','07:19:18 PM'),(11,'Java Rice w/ Tocino','11',39,'9.0',15,'13-9-2034','01-05-2023','07:20:51 PM'),(12,'Pancit Bihon','12',25,'56',10,'12-28-2034','01-05-2023','07:21:27 PM'),(13,'Vitsen','13',3,'12',25,'12-09-2074','01-05-2023','07:21:55 PM');
/*!40000 ALTER TABLE `tblproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblremove`
--

DROP TABLE IF EXISTS `tblremove`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblremove` (
  `remove_id` int NOT NULL AUTO_INCREMENT,
  `remove_by` varchar(50) NOT NULL,
  `product_id` int NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `unit_price` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `time` varchar(30) NOT NULL,
  PRIMARY KEY (`remove_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblremove`
--

LOCK TABLES `tblremove` WRITE;
/*!40000 ALTER TABLE `tblremove` DISABLE KEYS */;
INSERT INTO `tblremove` VALUES (1,'Namias',1,'Java Rice w/ Hotdog','9','39','29-04-2023','07:23:59 PM'),(2,'Namias',7,'Java Rice w/ Hotdog','9','39','29-04-2023','na'),(3,'Namias',2,'Java Rice w/ Hotdog','9','39','29-04-2023','na'),(4,'Caram',6,'Java Rice w/ Hotdog','9','39','29-04-2023','na'),(5,'Caram',8,'Java Rice w/ Hotdog','9','39','29-04-2023','na'),(6,'Namias',3,'Java Rice w/ Hotdog','9','39','29-04-2023','na'),(7,'Caram',12,'Java Rice w/ Hotdog','9','39','29-04-2023','na'),(8,'Namias',5,'Java Rice w/ Hotdog','9','39','29-04-2023','na'),(9,'Namias',11,'Java Rice w/ Hotdog','9','39','19-05-2023','12:36:08 AM'),(10,'Namias',2,'Egg','3','9','20-05-2023','03:42:13 AM'),(11,'Namias',9,'Java Rice w/ Shanghai','4','39','20-05-2023','03:42:37 AM'),(12,'Namias',9,'Java Rice w/ Shanghai','3','39','20-05-2023','03:46:02 AM'),(13,'Guest',7,'Java Rice w/ Hotdog','9','39','21-05-2023','06:18:18 PM');
/*!40000 ALTER TABLE `tblremove` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblselling`
--

DROP TABLE IF EXISTS `tblselling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblselling` (
  `selling_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `product_name` varchar(50) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `total_price` varchar(50) NOT NULL,
  `unit_price` varchar(50) NOT NULL,
  `profit` varchar(50) NOT NULL,
  `date` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL,
  PRIMARY KEY (`selling_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblselling`
--

LOCK TABLES `tblselling` WRITE;
/*!40000 ALTER TABLE `tblselling` DISABLE KEYS */;
INSERT INTO `tblselling` VALUES (47,6,'Java Rice w/ Ham','3','117.0','39','36.0','19-05-2023','10:24:34 AM'),(48,9,'Java Rice w/ Shanghai','3','117.0','39','33.0','19-05-2023','10:24:51 AM'),(49,11,'Java Rice w/ Tocino','4','156.0','39','60.0','19-05-2023','10:24:58 AM'),(50,2,'Egg','1','9.0','9','6.0','19-05-2023','10:33:45 AM'),(51,6,'Java Rice w/ Ham','3','117.0','39','36.0','19-05-2023','11:15:16 AM'),(52,7,'Java Rice w/ Hotdog','3','117.0','39','45.0','19-05-2023','02:30:50 PM'),(53,9,'Java Rice w/ Shanghai','3','117.0','39','33.0','19-05-2023','02:30:55 PM'),(54,8,'Java Rice w/ Pork','6','294.0','49','90.0','19-05-2023','02:31:04 PM'),(55,7,'Java Rice w/ Hotdog','3','117.0','39','45.0','19-05-2023','04:13:42 PM'),(56,6,'Java Rice w/ Ham','5','195.0','39','60.0','19-05-2023','05:32:54 PM'),(57,2,'Egg','4','36.0','9','24.0','19-05-2023','07:08:09 PM'),(58,1,'Java Rice','3','27.0','9','18.0','19-05-2023','11:45:12 PM'),(62,6,'Java Rice w/ Ham','3','117.0','39','36.0','20-05-2023','10:11:11 AM'),(63,5,'Java Rice w/ Chicken','4','196.0','49','52.0','20-05-2023','10:12:00 AM'),(64,8,'Java Rice w/ Pork','3','147.0','49','45.0','20-05-2023','10:41:42 AM'),(65,9,'Java Rice w/ Shanghai','3','117.0','39','33.0','20-05-2023','11:43:32 AM'),(66,10,'Java Rice w/ Tapa','4','196.0','49','60.0','20-05-2023','11:43:35 AM'),(68,7,'Java Rice w/ Hotdog','3','117.0','39','45.0','21-05-2023','05:30:34 PM'),(69,8,'Java Rice w/ Pork','3','147.0','49','45.0','21-05-2023','07:02:30 PM');
/*!40000 ALTER TABLE `tblselling` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22  0:27:52
