-- MySQL dump 10.13  Distrib 5.5.46, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cblog
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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `passwd` varchar(60) NOT NULL,
  `username` varchar(20) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `clazz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gfn44sntic2k93auag97juyij` (`username`),
  KEY `FK_1rliwe4gqd9g9ocrj8aog02ci` (`clazz`),
  CONSTRAINT `FK_1rliwe4gqd9g9ocrj8aog02ci` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `album_date` date DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `zan` int(11) DEFAULT NULL,
  `clazz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5bxt4uhdmmiphah4rqth5ef2r` (`clazz`),
  CONSTRAINT `FK_5bxt4uhdmmiphah4rqth5ef2r` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `album_comment`
--

DROP TABLE IF EXISTS `album_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `album_comment_date` datetime DEFAULT NULL,
  `content` varchar(500) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `article` bigint(20) DEFAULT NULL,
  `student` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2ratww7varbfs014ahqqgro2f` (`article`),
  KEY `FK_scfce48yjfdgikgchmgnm9bnv` (`student`),
  CONSTRAINT `FK_scfce48yjfdgikgchmgnm9bnv` FOREIGN KEY (`student`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_2ratww7varbfs014ahqqgro2f` FOREIGN KEY (`article`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album_comment`
--

LOCK TABLES `album_comment` WRITE;
/*!40000 ALTER TABLE `album_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `album_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activity_date` datetime NOT NULL,
  `content` varchar(20000) NOT NULL,
  `participant` varchar(50) NOT NULL,
  `publish_date` datetime NOT NULL,
  `site` varchar(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `clazz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dj6anl0n8y2ltwls2jekq1bdb` (`clazz`),
  CONSTRAINT `FK_dj6anl0n8y2ltwls2jekq1bdb` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_article_comments`
--

DROP TABLE IF EXISTS `article_article_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_article_comments` (
  `article` bigint(20) NOT NULL,
  `article_comments` bigint(20) NOT NULL,
  PRIMARY KEY (`article`,`article_comments`),
  KEY `FK_rww1ku03wjguco4q6acaersf6` (`article_comments`),
  CONSTRAINT `FK_ocvc9g9hbwgh4tl8r9jg96ftk` FOREIGN KEY (`article`) REFERENCES `article` (`id`),
  CONSTRAINT `FK_rww1ku03wjguco4q6acaersf6` FOREIGN KEY (`article_comments`) REFERENCES `article_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_article_comments`
--

LOCK TABLES `article_article_comments` WRITE;
/*!40000 ALTER TABLE `article_article_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_article_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_comment`
--

DROP TABLE IF EXISTS `article_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_comment_date` datetime NOT NULL,
  `content` varchar(2000) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `article` bigint(20) DEFAULT NULL,
  `student` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_6ku4ap2ommxcmsoa6614qw7rg` (`article`),
  KEY `FK_se4y5ety35u8yp0nqohgbva0o` (`student`),
  CONSTRAINT `FK_se4y5ety35u8yp0nqohgbva0o` FOREIGN KEY (`student`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_6ku4ap2ommxcmsoa6614qw7rg` FOREIGN KEY (`article`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_comment`
--

LOCK TABLES `article_comment` WRITE;
/*!40000 ALTER TABLE `article_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_user`
--

DROP TABLE IF EXISTS `blog_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `passwd` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `student` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_nunxr5pa976gmy575b2gpjowp` (`student`),
  CONSTRAINT `FK_nunxr5pa976gmy575b2gpjowp` FOREIGN KEY (`student`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user`
--

LOCK TABLES `blog_user` WRITE;
/*!40000 ALTER TABLE `blog_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clazz` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clazz_img` varchar(255) DEFAULT NULL,
  `clazz_name` varchar(50) NOT NULL,
  `flag_img` varchar(255) DEFAULT NULL,
  `lyric` varchar(255) DEFAULT NULL,
  `major` varchar(100) DEFAULT NULL,
  `overview` varchar(255) DEFAULT NULL,
  `school` varchar(50) DEFAULT NULL,
  `slogan` varchar(255) DEFAULT NULL,
  `song` varchar(255) DEFAULT NULL,
  `song_img` varchar(255) DEFAULT NULL,
  `song_title` varchar(200) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cedl3r8m9sfiq5osd29ew3crs` (`clazz_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz_honor`
--

DROP TABLE IF EXISTS `clazz_honor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clazz_honor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clazz_honor_date` datetime NOT NULL,
  `honor_name` varchar(100) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `clazz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_s6cc689x641ra02rgyugywqhi` (`clazz`),
  CONSTRAINT `FK_s6cc689x641ra02rgyugywqhi` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz_honor`
--

LOCK TABLES `clazz_honor` WRITE;
/*!40000 ALTER TABLE `clazz_honor` DISABLE KEYS */;
/*!40000 ALTER TABLE `clazz_honor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `honor_wall`
--

DROP TABLE IF EXISTS `honor_wall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `honor_wall` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `image` varchar(255) NOT NULL,
  `version` int(11) DEFAULT NULL,
  `clazz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_47k8mpgsn7vnme3ddm3hss0xm` (`clazz`),
  CONSTRAINT `FK_47k8mpgsn7vnme3ddm3hss0xm` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `honor_wall`
--

LOCK TABLES `honor_wall` WRITE;
/*!40000 ALTER TABLE `honor_wall` DISABLE KEYS */;
/*!40000 ALTER TABLE `honor_wall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_honor`
--

DROP TABLE IF EXISTS `personal_honor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_honor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `award` varchar(100) NOT NULL,
  `personal_honor_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `clazz` bigint(20) DEFAULT NULL,
  `student` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4rmqx0cc86apr37iv4996ul5c` (`clazz`),
  KEY `FK_6r4tvq6r8dhqd9ahyg5mxswpr` (`student`),
  CONSTRAINT `FK_6r4tvq6r8dhqd9ahyg5mxswpr` FOREIGN KEY (`student`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_4rmqx0cc86apr37iv4996ul5c` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_honor`
--

LOCK TABLES `personal_honor` WRITE;
/*!40000 ALTER TABLE `personal_honor` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_honor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `access` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `motto` varchar(255) DEFAULT NULL,
  `passwd` varchar(100) DEFAULT NULL,
  `stu_id` varchar(50) DEFAULT NULL,
  `stu_img` varchar(255) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `clazz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_jyet50p17q01ks2bv4sn8i5r7` (`username`),
  KEY `FK_4q0jfv7sgahdhr5kkosj8mn3x` (`clazz`),
  CONSTRAINT `FK_4q0jfv7sgahdhr5kkosj8mn3x` FOREIGN KEY (`clazz`) REFERENCES `clazz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_article_comments`
--

DROP TABLE IF EXISTS `student_article_comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_article_comments` (
  `student` bigint(20) NOT NULL,
  `article_comments` bigint(20) NOT NULL,
  PRIMARY KEY (`student`,`article_comments`),
  KEY `FK_40qlq2dsr4j8jj12wla3x1d1j` (`article_comments`),
  CONSTRAINT `FK_bik7qb29i78c8e5ij63rsu2s8` FOREIGN KEY (`student`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_40qlq2dsr4j8jj12wla3x1d1j` FOREIGN KEY (`article_comments`) REFERENCES `article_comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_article_comments`
--

LOCK TABLES `student_article_comments` WRITE;
/*!40000 ALTER TABLE `student_article_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_article_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_receive`
--

DROP TABLE IF EXISTS `student_receive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_receive` (
  `student` bigint(20) NOT NULL,
  `receive` bigint(20) NOT NULL,
  PRIMARY KEY (`student`,`receive`),
  KEY `FK_47wrvbb5l1hlxx93jxrxdstbe` (`receive`),
  CONSTRAINT `FK_3ppjownxdih3l1mipetyaxktf` FOREIGN KEY (`student`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_47wrvbb5l1hlxx93jxrxdstbe` FOREIGN KEY (`receive`) REFERENCES `tease` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_receive`
--

LOCK TABLES `student_receive` WRITE;
/*!40000 ALTER TABLE `student_receive` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_receive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_send`
--

DROP TABLE IF EXISTS `student_send`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_send` (
  `student` bigint(20) NOT NULL,
  `send` bigint(20) NOT NULL,
  PRIMARY KEY (`student`,`send`),
  KEY `FK_saqwllvlammiveevx7hmngb54` (`send`),
  CONSTRAINT `FK_om5tljoepd35w1in9gnk83uvy` FOREIGN KEY (`student`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_saqwllvlammiveevx7hmngb54` FOREIGN KEY (`send`) REFERENCES `tease` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_send`
--

LOCK TABLES `student_send` WRITE;
/*!40000 ALTER TABLE `student_send` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_send` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `super_admin`
--

DROP TABLE IF EXISTS `super_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `super_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `passwd` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `super_admin`
--

LOCK TABLES `super_admin` WRITE;
/*!40000 ALTER TABLE `super_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `super_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tease`
--

DROP TABLE IF EXISTS `tease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tease` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) NOT NULL,
  `tease_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `receiver` bigint(20) DEFAULT NULL,
  `sender` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q9cc9ctacstyjfbjsv5fscvpi` (`receiver`),
  KEY `FK_ppypd8j3lffwpk7dni18fxxer` (`sender`),
  CONSTRAINT `FK_ppypd8j3lffwpk7dni18fxxer` FOREIGN KEY (`sender`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_q9cc9ctacstyjfbjsv5fscvpi` FOREIGN KEY (`receiver`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tease`
--

LOCK TABLES `tease` WRITE;
/*!40000 ALTER TABLE `tease` DISABLE KEYS */;
/*!40000 ALTER TABLE `tease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_request`
--

DROP TABLE IF EXISTS `user_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clazz_name` varchar(255) DEFAULT NULL,
  `dispose` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `stu_id` varchar(255) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `user_request_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `blog_user` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_qh307cikacwhkv8dg7glks520` (`blog_user`),
  CONSTRAINT `FK_qh307cikacwhkv8dg7glks520` FOREIGN KEY (`blog_user`) REFERENCES `blog_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_request`
--

LOCK TABLES `user_request` WRITE;
/*!40000 ALTER TABLE `user_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_request` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-25 14:31:46
