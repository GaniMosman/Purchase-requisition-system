-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: purchasereq
-- ------------------------------------------------------
-- Server version	8.0.16

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
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('C0001','46, Jalan Jade Hills 10/4, Jade Hills, 43000, Kajang Selangor','MSI Sdn Bhd','012-3456789');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `finance_staff`
--

LOCK TABLES `finance_staff` WRITE;
/*!40000 ALTER TABLE `finance_staff` DISABLE KEYS */;
INSERT INTO `finance_staff` VALUES ('FS0001','Gabriel Lim','123','gabriellim97@yahoo.com','010-5040309','C0001'),('FS0002','John','123','john@gmail.coom','012-4567891','C0001'),('FS0003','Tao','123','tao@gmail.com','010-1234567','C0001');
/*!40000 ALTER TABLE `finance_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('IT1001',200,'Steelseries Keyboard'),('IT1002',100,'LogitechG Mouse'),('IT1003',400,'BenQ Monitor'),('IT1004',50,'Mousepad'),('IT1005',120,'SATA SSD'),('IT1006',3000,'RTX2080Ti'),('IT1007',20,'HDMI Cable');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES ('MN0001','John Cena','12345'),('MN0002','Ian Tan','123'),('MN0003','Amy Lim','123'),('MN0004','Angeline Pang','123');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pr`
--

LOCK TABLES `pr` WRITE;
/*!40000 ALTER TABLE `pr` DISABLE KEYS */;
INSERT INTO `pr` VALUES ('PR1001','2001-11-01','declined',NULL,'ST0003','MN0001'),('PR1002','2019-01-01','approved',NULL,'ST0003','MN0001'),('PR1003','2019-02-03','approved',NULL,'ST0003','MN0001'),('PR1004','2019-02-22','approved',NULL,'ST0002','MN0002'),('PR1005','2019-03-15','pending',NULL,'ST0002','MN0002'),('PR1006','2019-04-25','approved',NULL,'ST0001','MN0003'),('PR1007','2019-04-30','approved',NULL,'ST0001','MN0001'),('PR1008','2019-05-12','approved',NULL,'ST0002','MN0002'),('PR1009','2019-05-18','approved',NULL,'St0003','MN0003');
/*!40000 ALTER TABLE `pr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `pr_item`
--

LOCK TABLES `pr_item` WRITE;
/*!40000 ALTER TABLE `pr_item` DISABLE KEYS */;
INSERT INTO `pr_item` VALUES ('PR1001','IT1001','5'),('PR1002','IT1001','5'),('PR1002','IT1002','3'),('PR1002','IT1005','4'),('PR1003','IT1004','2'),('PR1003','IT1007','20'),('PR1004','IT1003','5'),('PR1004','IT1006','2'),('PR1006','IT1001','2'),('PR1006','IT1003','6'),('PR1006','IT1004','5'),('PR1007','IT1001','5'),('PR1007','IT1002','3'),('PR1008','IT1001','10'),('PR1008','IT1004','10'),('PR1009','IT1003','10'),('PR1009','IT1005','10');
/*!40000 ALTER TABLE `pr_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `quotation`
--

LOCK TABLES `quotation` WRITE;
/*!40000 ALTER TABLE `quotation` DISABLE KEYS */;
INSERT INTO `quotation` VALUES ('QT1000','VN0001','C0001','RFQ1000',1900,'2019-07-01','2019-06-01',50),('QT1001','VN0002','C0001','RFQ1001',250,'2019-08-19','2019-05-19',50);
/*!40000 ALTER TABLE `quotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `quotation_item`
--

LOCK TABLES `quotation_item` WRITE;
/*!40000 ALTER TABLE `quotation_item` DISABLE KEYS */;
INSERT INTO `quotation_item` VALUES ('QT1000','IT1001',5,200),('QT1000','IT1002',3,100),('QT1000','IT1005',4,120),('QT1001','IT1004',5,20),('QT1001','IT1007',5,20);
/*!40000 ALTER TABLE `quotation_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rfq`
--

LOCK TABLES `rfq` WRITE;
/*!40000 ALTER TABLE `rfq` DISABLE KEYS */;
INSERT INTO `rfq` VALUES ('RFQ1000','PR1002','C0001','FS0001','2019-05-01','2019-05-18'),('RFQ1001','PR1003','C0001','FS0001','2019-05-18','2019-06-01'),('RFQ1002','PR1004','C0001','FS0002','2019-05-18','2019-05-25'),('RFQ1003','PR1006','C0001','FS0001','2019-05-19','2019-05-26');
/*!40000 ALTER TABLE `rfq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `rfq_item`
--

LOCK TABLES `rfq_item` WRITE;
/*!40000 ALTER TABLE `rfq_item` DISABLE KEYS */;
INSERT INTO `rfq_item` VALUES ('RFQ1000','IT1001',5),('RFQ1000','IT1002',3),('RFQ1000','IT1005',4),('RFQ1001','IT1004',2),('RFQ1001','IT1007',20),('RFQ1002','IT1003',8),('RFQ1003','IT1001',2),('RFQ1003','IT1003',6),('RFQ1003','IT1004',5);
/*!40000 ALTER TABLE `rfq_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES ('ST0001','moom','123'),('ST0002','yousef','123'),('ST0003','Gabriel','123');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` VALUES ('VN0001','Ayyash','46, Jalan Jade Hills 10/2, Jade Hills, 43000 Kajang, Selangor','Ayyash@gmail.com','012-5678945','123'),('VN0002','Gani','102, Jalan Bukit Indah 1, Taman Bukit Indah, 14000 Bukit Mertajam, Penang','Gani@gmail.com','012-5987894','123');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-19 19:30:52
