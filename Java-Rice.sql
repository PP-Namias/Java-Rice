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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblinvoice`
--

LOCK TABLES `tblinvoice` WRITE;
/*!40000 ALTER TABLE `tblinvoice` DISABLE KEYS */;
INSERT INTO `tblinvoice` VALUES (5,'bcopointofsale','Regular Costumer','100','Paid','88.0','12.0','4.0',6,'29-04-2021','07:07:44 PM'),(6,'bcopointofsale','Regular Costumer','1000','Paid','655.0','345.0','23.0',7,'29-04-2021','07:24:25 PM'),(7,'User','Regular Costumer','1000','Paid','765.0','235.0','15.0',8,'29-04-2021','07:34:06 PM'),(8,'glenn','Regular Costumer','1000','Paid','593.00','407.00','22',9,'16-05-2021','07:54:53 AM'),(9,'glenn','Regular Costumer','40','Paid','10.0','30.0','2.0',10,'02-05-2023','03:22:11 PM'),(10,'Namias','Regular Costumer','100','Paid','35.0','65.0','5.0',11,'09-05-2023','09:57:12 AM');
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
INSERT INTO `tblnum` VALUES (1,11);
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
INSERT INTO `tblproduct` VALUES (1,'Nescafe','877-090',3,'956.0',1,'09-09-2021','18-09-2020','02:58:52 PM'),(2,'Milo','12-11',9,'982.0',3,'12-23-2023','29-04-2021','07:04:19 PM'),(3,'Coke 12oz','1221-1111',15,'998.0',4,'12-23-2023','29-04-2021','07:06:24 PM'),(4,'Silver swan ','12-2222',10,'990.0',4,'12-4-2024','29-04-2021','07:07:21 PM'),(5,'3 $ 1 nescafe ','1211-111',9,'970.0',3,'1-3-2030','29-04-2021','07:10:12 PM'),(6,'Colgate','13-33',10,'998.0',3,'12-2-2030','29-04-2021','07:11:30 PM'),(7,'Coke 1 liter','13-22-222',50,'996.0',10,'22-21-2030','29-04-2021','07:12:28 PM'),(8,'Beer','14-111111',30,'1000.0',8,'12-2-2030','29-04-2021','07:14:32 PM'),(9,'Meat loaf','19-999',23,'996.0',4,'12-9-2030','29-04-2021','07:18:39 PM'),(10,'Beef loaf','15-222222',24,'997',5,'10-9-2023','29-04-2021','07:19:18 PM'),(11,'Corn beef','26-1111',25,'980.0',4,'13-9-2034','29-04-2021','07:20:51 PM'),(12,'Asin','111-1111',5,'1000.0',2,'12-28-2034','29-04-2021','07:21:27 PM'),(13,'Vitsen','122333',3,'992.0',1,'12-09-2074','29-04-2021','07:21:55 PM');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblremove`
--

LOCK TABLES `tblremove` WRITE;
/*!40000 ALTER TABLE `tblremove` DISABLE KEYS */;
INSERT INTO `tblremove` VALUES (1,'Namias',1,'Nescafe','4','3','29-04-2023','07:23:59 PM'),(2,'Namias',7,'Coke 1 liter','3','50','29-04-2023','na'),(3,'Namias',2,'Milo','5','9','29-04-2023','na'),(4,'Caram',6,'Colgate','3','10','29-04-2023','na'),(5,'Caram',8,'Beer','4','30','29-04-2023','na'),(6,'Namias',3,'Coke 12oz','3','15','29-04-2023','na'),(7,'Caram',12,'Asin','5','5','29-04-2023','na'),(8,'Namias',5,'3 $ 1 nescafe ','34','9','29-04-2023','na');
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblselling`
--

LOCK TABLES `tblselling` WRITE;
/*!40000 ALTER TABLE `tblselling` DISABLE KEYS */;
INSERT INTO `tblselling` VALUES (1,1,'Nescafe','5','15.0','3','5.0','03-05-2023','02:59:04 PM'),(2,1,'Nescafe','5','15.0','3','5.0','03-05-2023','02:59:49 PM'),(3,1,'Nescafe','1','3.0','3','1.0','03-05-2023','03:01:47 PM'),(4,1,'Nescafe','9','27.0','3','9.0','03-05-2023','03:02:30 PM'),(5,1,'Nescafe','8','24.0','3','8.0','03-05-2023','06:35:14 PM'),(6,1,'Nescafe','6','18.0','3','6.0','03-05-2023','06:35:22 PM'),(7,1,'Nescafe','4','12.0','3','4.0','03-05-2023','07:07:33 PM'),(8,11,'Corn beef','6','150.0','25','24.0','03-05-2023','07:22:04 PM'),(9,11,'Corn beef','4','100.0','25','16.0','03-05-2023','07:22:12 PM'),(10,4,'Silver swan ','4','40.0','10','16.0','03-05-2023','07:22:17 PM'),(11,4,'Silver swan ','4','40.0','10','16.0','03-05-2023','07:22:21 PM'),(13,13,'Vitsen','5','15.0','3','5.0','03-05-2023','07:22:30 PM'),(14,11,'Corn beef','5','125.0','25','20.0','03-05-2023','07:33:45 PM'),(15,9,'Meat loaf','4','92.0','23','16.0','03-05-2023','07:33:48 PM'),(16,13,'Vitsen','3','9.0','3','3.0','03-05-2023','07:33:52 PM'),(17,1,'Nescafe','3','9.0','3','3.0','03-05-2023','07:33:55 PM'),(18,7,'Coke 1 liter','4','200.0','50','40.0','03-05-2023','na'),(19,10,'Beef loaf','3','72.0','24','15.0','03-05-2023','na'),(20,2,'Milo','15','135.0','9','45.0','03-05-2023','na'),(26,5,'3 $ 1 nescafe ','10','90.0','9','30.0','03-05-2023','na'),(27,5,'3 $ 1 nescafe ','20','180.0','9','60.0','03-05-2023','na'),(30,11,'Corn beef','4','100.0','25','16.0','03-05-2023','10:52:51 AM'),(31,2,'Milo','3','27.0','9','9.0','03-05-2023','10:52:56 AM'),(32,1,'Nescafe','3','9.0','3','3.0','03-05-2023','10:53:06 AM'),(33,3,'Coke 12oz','2','30.0','15','8.0','03-05-2023','03:21:27 PM'),(34,6,'Colgate','2','20.0','10','6.0','09-05-2023','09:56:42 AM'),(35,11,'Corn beef','1','25.0','25','4.0','09-05-2023','09:56:47 AM'),(36,4,'Silver swan ','2','20.0','10','8.0','09-05-2023','09:56:51 AM');
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

-- Dump completed on 2023-05-09 10:02:33
