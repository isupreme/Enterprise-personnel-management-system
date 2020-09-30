-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: enterprise
-- ------------------------------------------------------
-- Server version	5.5.62

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(20) NOT NULL,
  `admin_username` varchar(20) NOT NULL,
  `admin_password` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin1','admin1'),(3,'admin2','admin2');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'董事局'),(2,'管理部'),(3,'技术部'),(4,'人事部'),(5,'后勤部'),(6,'财务部');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `pos_id` int(11) NOT NULL,
  `pos_name` varchar(50) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pos_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'董事长',1),(2,'董事',1),(3,'CEO',1),(4,'总监',2),(5,'经理',2),(6,'职员',2),(7,'总监',3),(8,'经理',3),(9,'程序员',3),(10,'总监',4),(11,'经理',4),(12,'职员',4),(13,'总监',5),(14,'经理',5),(15,'职员',5),(16,'总监',6),(17,'经理',6),(18,'职员',6);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `pos_id` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'郭连美','女','博士',4,'在职',2,'1','1'),(2,'李飞天','男','博士',2,'在职',1,'user2','user2'),(3,'林动','男','研究生',4,'在职',2,'user3','user3'),(4,'王铮','男','研究生',8,'在职',3,'1','1'),(5,'牧尘','男','研究生',5,'在职',4,'user5','user5'),(6,'王明伟','男','本科',6,'在职',5,'user6','user6'),(7,'王刚','男','本科',7,'在职',4,'user7','user7'),(8,'李刚','男','本科',8,'在职',6,'user8','user8'),(9,'叶良辰','男','专科',9,'在职',6,'user9','user9'),(10,'龙傲天','男','专科',10,'在职',5,'user10','user10'),(11,'叶萧','男','本科',6,'在职',5,'user11','user11'),(12,'萧炎','男','本科',7,'在职',4,'user12','user12'),(13,'杜国峰','男','本科',8,'在职',6,'user13','user13'),(14,'李兴军','男','专科',9,'在职',6,'user14','user14'),(15,'詹天','男','专科',10,'在职',5,'user15','user15'),(16,'李毅','男','本科',6,'在职',5,'user16','user16'),(17,'赵伟伟','男','博士',1,'在职',1,'user17','user17'),(18,'李洋','男','本科',6,'在职',3,'user18','user18'),(25,'郑商所','女','博士',9,'在职',3,'user19','user19'),(26,'杜家坎','女','博士',9,'在职',3,'user20','user20'),(27,'孙育崧','女','博士',9,'在职',3,'user21','user21'),(28,'韩立','男','博士',1,'在职',1,'user22','user22'),(29,'苏良辰','男','博士',7,'在职',3,'user23','user23'),(30,'叶烨','男','博士',10,'在职',4,'user24','user24'),(31,'刘昂','男','博士',4,'在职',2,'1','1');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_agreement`
--

DROP TABLE IF EXISTS `staff_agreement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff_agreement` (
  `p_id` int(11) NOT NULL,
  `agreement_id` int(11) NOT NULL,
  `agreement_btime` date NOT NULL,
  `agreement_content` varchar(100) NOT NULL,
  PRIMARY KEY (`agreement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_agreement`
--

LOCK TABLES `staff_agreement` WRITE;
/*!40000 ALTER TABLE `staff_agreement` DISABLE KEYS */;
INSERT INTO `staff_agreement` VALUES (1,1,'2020-09-16','职规奖品价格(2).docx'),(2,2,'2020-09-09','奖品.xlsx'),(3,3,'2020-09-17','奖品.xlsx'),(4,4,'2020-09-17','电脑配置单.txt'),(5,5,'2020-09-17','职规奖品价格(2).docx'),(6,6,'2020-09-10','电脑配置单.txt'),(7,7,'2020-09-09','就业登记方法步骤内容.docx'),(8,8,'2020-09-01','校十佳宣传志愿者人员信息表.xlsx'),(10,10,'2020-09-16','奖品.xlsx'),(12,11,'2020-09-16','校十佳宣传志愿者人员信息表.xlsx'),(9,12,'2020-09-16','职规奖品价格(2).docx');
/*!40000 ALTER TABLE `staff_agreement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_alter`
--

DROP TABLE IF EXISTS `staff_alter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff_alter` (
  `alter_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_id` int(11) DEFAULT NULL,
  `alter_btime` datetime DEFAULT NULL,
  `alter_etime` datetime DEFAULT NULL,
  `alter_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`alter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_alter`
--

LOCK TABLES `staff_alter` WRITE;
/*!40000 ALTER TABLE `staff_alter` DISABLE KEYS */;
INSERT INTO `staff_alter` VALUES (1,1,'2020-09-17 00:00:00','2020-09-24 00:00:00','要去北京'),(2,2,'2017-01-08 00:00:00','2017-01-22 00:00:00','要去上海'),(3,3,'2020-09-09 00:00:00','2020-09-25 00:00:00','要去广东'),(4,4,'2017-01-08 00:00:00','2017-01-22 00:00:00','要去深圳'),(5,5,'2017-01-08 00:00:00','2017-01-22 00:00:00','要去海南'),(6,6,'2017-03-01 00:00:00','2017-03-21 00:00:00','要去石家庄'),(7,7,'2017-03-04 00:00:00','2017-03-23 00:00:00','要去河北'),(8,8,'2017-03-03 00:00:00','2017-03-25 00:00:00','要去湖南'),(9,9,'2017-03-18 00:00:00','2017-03-24 00:00:00','要去贵州'),(10,10,'2017-03-09 00:00:00','2017-03-25 00:00:00','要去西藏'),(11,5,'2019-01-15 00:00:00','2019-01-15 00:00:00','要去新疆'),(13,11,'2019-01-14 00:00:00','2019-01-15 00:00:00','要去武汉'),(14,7,'2020-09-01 00:00:00','2020-09-18 00:00:00','要去南京'),(15,7,'2020-09-09 00:00:00','2020-10-02 00:00:00','要去四川');
/*!40000 ALTER TABLE `staff_alter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `train_id` int(11) NOT NULL,
  `type_code` int(12) DEFAULT NULL,
  `train_btime` datetime DEFAULT NULL,
  `train_etime` datetime DEFAULT NULL,
  `train_expense` varchar(20) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1,1,'2017-01-18 00:00:00','2017-01-24 00:00:00','测试培训心得',1),(2,2,'2017-03-09 00:00:00','2017-03-30 00:00:00','很棒',3),(3,3,'2017-03-01 00:00:00','2017-03-16 00:00:00','很nice',2),(4,4,'2017-01-01 00:00:00','2017-01-17 00:00:00','hhh',1),(5,4,'2017-03-09 00:00:00','2017-03-24 00:00:00','完美',4),(6,5,'2017-03-01 00:00:00','2017-03-31 00:00:00','棒极了',1),(7,7,'2017-03-16 00:00:00','2017-03-23 00:00:00','无敌',2),(8,6,'2017-03-15 00:00:00','2017-03-23 00:00:00','新人加入',3),(9,8,'2017-03-09 00:00:00','2017-03-25 00:00:00','培训开始',4),(10,9,'2017-03-16 00:00:00','2017-03-30 00:00:00','努力学习',3);
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_type`
--

DROP TABLE IF EXISTS `train_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_type` (
  `type_code` int(255) NOT NULL,
  `type_name` varchar(255) NOT NULL,
  `type_info` varchar(255) NOT NULL,
  PRIMARY KEY (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_type`
--

LOCK TABLES `train_type` WRITE;
/*!40000 ALTER TABLE `train_type` DISABLE KEYS */;
INSERT INTO `train_type` VALUES (1,'IT培训','IT专业技能培训'),(2,'Office培训','训练office技能'),(3,'团队建设培训','增强团队合作能力'),(4,'礼仪培训','熟悉礼仪'),(5,'入职培训','新人必须参加'),(6,'业务培训','熟悉业务'),(7,'SAP培训','掌握SAP技能'),(8,'Oracle培训','掌握Oracle技能'),(9,'Android培训','掌握Android技能'),(10,'Java培训','掌握Java技能');
/*!40000 ALTER TABLE `train_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'enterprise'
--

--
-- Dumping routines for database 'enterprise'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-30  9:45:20
