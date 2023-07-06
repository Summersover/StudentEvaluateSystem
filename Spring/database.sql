-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: teststu
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `gpalist`
--

DROP TABLE IF EXISTS `gpalist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gpalist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `grade` varchar(255) DEFAULT NULL COMMENT '成绩',
  `gpa` varchar(255) DEFAULT NULL COMMENT 'GPA',
  `gpmark` varchar(255) DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gpalist`
--

LOCK TABLES `gpalist` WRITE;
/*!40000 ALTER TABLE `gpalist` DISABLE KEYS */;
INSERT INTO `gpalist` VALUES (1,'2200022701','茶同学','90','3.8','9'),(2,'2200022702','哈同学','85','3.7','8'),(3,'2200022703','果同学','80','3.6','7');
/*!40000 ALTER TABLE `gpalist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marklist`
--

DROP TABLE IF EXISTS `marklist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marklist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `rsmark` varchar(255) DEFAULT NULL COMMENT '科研评分',
  `wsmark` varchar(255) DEFAULT NULL COMMENT '学生骨干服务岗位评分',
  `spmark` varchar(255) DEFAULT NULL COMMENT '社会实践评分',
  `psmark` varchar(255) DEFAULT NULL COMMENT '个人学年总结评分',
  `gpmark` varchar(255) DEFAULT NULL COMMENT 'GPA评分',
  `vsmark` varchar(255) DEFAULT NULL COMMENT '志愿服务评分',
  `totmark` varchar(255) DEFAULT NULL COMMENT '总评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marklist`
--

LOCK TABLES `marklist` WRITE;
/*!40000 ALTER TABLE `marklist` DISABLE KEYS */;
INSERT INTO `marklist` VALUES (1,'2200022701','茶同学','4','5','9','1','9','7','35'),(2,'2200022702','哈同学',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'2200022703','果同学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `marklist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Menu`
--

DROP TABLE IF EXISTS `Menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Menu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `component` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menu`
--

LOCK TABLES `Menu` WRITE;
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
INSERT INTO `Menu` VALUES (1,'科研情况填报','/student/SRS','student/StudentResearchSituation'),(2,'社会实践填报','/student/SSP','student/StudentSocialPractice'),(3,'学生骨干岗位填报','/student/SWS','student/StudentWorkService'),(4,'个人学年总结填报','/student/SPS','student/StudentPersonalStatement'),(5,'学生成绩填报','/student/SGE','student/StudentGradeEvaluation'),(6,'志愿服务填报','/student/SVS','student/StudentVolunteerService'),(7,'科研情况评分','/judge/JRS','judge/JudgeResSituList'),(8,'社会实践评分','/judge/JSP','judge/JudgeSocPracList'),(9,'学生骨干岗位服务评分','/judge/JWS','judge/JudgeWorServList'),(10,'个人学年总结评分','/judge/JPS','judge/JudgePerStatList'),(11,'学生成绩导入','/judge/JGE','judge/JudgeGradeEvaluation'),(12,'志愿服务导入','/judge/JVS','judge/JudgeVolunteerService'),(13,'学生信息导入','/staff/SNA','staff/StaffNotAssessed'),(14,'测评结果汇总','/staff/SA','staff/StaffAssessed');
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Permission`
--

DROP TABLE IF EXISTS `Permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Permission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Permission`
--

LOCK TABLES `Permission` WRITE;
/*!40000 ALTER TABLE `Permission` DISABLE KEYS */;
INSERT INTO `Permission` VALUES (1,'/admin-api/user/profile/get'),(2,'/admin-api/student/get'),(3,'/admin-api/student/updateResSitu'),(4,'/admin-api/student/getResSitu'),(5,'/admin-api/student/updateWorServ'),(6,'/admin-api/student/getWorServ'),(7,'/admin-api/student/updateSocPrac'),(8,'/admin-api/student/getSocPrac'),(9,'/admin-api/student/updatePerStat'),(10,'/admin-api/student/getPerStat1'),(11,'/admin-api/student/getPerStat2'),(12,'/admin-api/judge/resSitu/getStuList'),(13,'/admin-api/judge/resSitu/sendStuNum'),(14,'/admin-api/judge/resSitu/getResSitu'),(15,'/admin-api/judge/resSitu/getResSituMarkList'),(16,'/admin-api/judge/resSitu/updateResSituMark'),(17,'/admin-api/judge/workServe/getStuList'),(18,'/admin-api/judge/workServe/sendStuNum'),(19,'/admin-api/judge/workServe/getWorServ'),(20,'/admin-api/judge/workServe/getWorServMarkList'),(21,'/admin-api/judge/workServe/updateWorServMark'),(22,'/admin-api/judge/socPrac/getStuList'),(23,'/admin-api/judge/socPrac/sendStuNum'),(24,'/admin-api/judge/socPrac/getSocPrac'),(25,'/admin-api/judge/socPrac/getSocPracMarkList'),(26,'/admin-api/judge/socPrac/updateSocPracMark'),(27,'/admin-api/judge/perStat/getStuList'),(28,'/admin-api/judge/perStat/sendStuNum'),(29,'/admin-api/judge/perStat/getPerStat1'),(30,'/admin-api/judge/perStat/getPerStat2'),(31,'/admin-api/judge/perStat/getPerStatMarkList'),(32,'/admin-api/judge/perStat/updatePerStatMark'),(33,'/admin-api/studentInfo/get'),(34,'/admin-api/totalMark/getTotalMarkList'),(35,'/admin-api/auth/login'),(36,'/admin-api/auth/captcha'),(37,'/admin-api/menu/getMenu'),(38,'/admin-api/menu/getRole'),(39,'/admin-api/studentVolSer/upload'),(40,'/admin-api/studentGPA/upload'),(41,'/admin-api/studentVolSer/getStudentVolSerData'),(42,'/admin-api/studentGPA/getStudentGPAData'),(43,'/admin-api/studentVolSer/getVolSer'),(44,'/admin-api/studentGPA/getGPA'),(45,'/admin-api/file/upload'),(46,'/admin-api/studentInfo/upload');
/*!40000 ALTER TABLE `Permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personalstatement1`
--

DROP TABLE IF EXISTS `personalstatement1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personalstatement1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `spot` varchar(255) DEFAULT NULL COMMENT '地点',
  `level` varchar(255) DEFAULT NULL COMMENT '活动级别',
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  `eventname` varchar(255) DEFAULT NULL COMMENT '活动名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personalstatement1`
--

LOCK TABLES `personalstatement1` WRITE;
/*!40000 ALTER TABLE `personalstatement1` DISABLE KEYS */;
/*!40000 ALTER TABLE `personalstatement1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personalstatement2`
--

DROP TABLE IF EXISTS `personalstatement2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personalstatement2` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `behaviour` varchar(255) DEFAULT NULL COMMENT '行为规范',
  `study` varchar(255) DEFAULT NULL COMMENT '学习态度',
  `health` varchar(255) DEFAULT NULL COMMENT '身体健康',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personalstatement2`
--

LOCK TABLES `personalstatement2` WRITE;
/*!40000 ALTER TABLE `personalstatement2` DISABLE KEYS */;
/*!40000 ALTER TABLE `personalstatement2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `researchsituation`
--

DROP TABLE IF EXISTS `researchsituation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `researchsituation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `rank` varchar(255) DEFAULT NULL COMMENT '名称',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `place` varchar(255) DEFAULT NULL COMMENT '地点',
  `prize` varchar(255) DEFAULT NULL COMMENT '奖项',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `researchsituation`
--

LOCK TABLES `researchsituation` WRITE;
/*!40000 ALTER TABLE `researchsituation` DISABLE KEYS */;
/*!40000 ALTER TABLE `researchsituation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1,1,'学生'),(2,2,'评委老师'),(3,3,'学工老师');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RoleMenu`
--

DROP TABLE IF EXISTS `RoleMenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RoleMenu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `menu_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RoleMenu`
--

LOCK TABLES `RoleMenu` WRITE;
/*!40000 ALTER TABLE `RoleMenu` DISABLE KEYS */;
INSERT INTO `RoleMenu` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,2,7),(8,2,8),(9,2,9),(10,2,10),(11,2,11),(12,2,12),(13,3,13),(14,3,14);
/*!40000 ALTER TABLE `RoleMenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RolePermission`
--

DROP TABLE IF EXISTS `RolePermission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RolePermission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_id` int DEFAULT NULL,
  `permission_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RolePermission`
--

LOCK TABLES `RolePermission` WRITE;
/*!40000 ALTER TABLE `RolePermission` DISABLE KEYS */;
INSERT INTO `RolePermission` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7),(8,1,8),(9,1,9),(10,1,10),(11,1,11),(12,1,35),(13,1,36),(14,1,37),(15,1,38),(16,1,43),(17,1,44),(18,1,45),(19,2,1),(20,2,12),(21,2,13),(22,2,14),(23,2,15),(24,2,16),(25,2,17),(26,2,18),(27,2,19),(28,2,20),(29,2,21),(30,2,22),(31,2,23),(32,2,24),(33,2,25),(34,2,26),(35,2,27),(36,2,28),(37,2,29),(38,2,30),(39,2,31),(40,2,32),(41,2,35),(42,2,36),(43,2,37),(44,2,38),(45,2,39),(46,2,40),(47,2,41),(48,2,42),(49,3,1),(50,3,33),(51,3,34),(52,3,35),(53,3,36),(54,3,37),(55,3,38),(56,3,46);
/*!40000 ALTER TABLE `RolePermission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socialpractice`
--

DROP TABLE IF EXISTS `socialpractice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socialpractice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `initiator` varchar(255) DEFAULT NULL COMMENT '发起单位',
  `spot` varchar(255) DEFAULT NULL COMMENT '地点',
  `days` varchar(255) DEFAULT NULL COMMENT '天数',
  `size` varchar(255) DEFAULT NULL COMMENT '团队人数',
  `post` varchar(255) DEFAULT NULL COMMENT '团队职务',
  `online` varchar(255) DEFAULT NULL COMMENT '是否线上',
  `award` varchar(255) DEFAULT NULL COMMENT '是否获得奖励',
  `awardname` varchar(255) DEFAULT NULL COMMENT '奖励名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socialpractice`
--

LOCK TABLES `socialpractice` WRITE;
/*!40000 ALTER TABLE `socialpractice` DISABLE KEYS */;
/*!40000 ALTER TABLE `socialpractice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentlist`
--

DROP TABLE IF EXISTS `studentlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentlist`
--

LOCK TABLES `studentlist` WRITE;
/*!40000 ALTER TABLE `studentlist` DISABLE KEYS */;
INSERT INTO `studentlist` VALUES (1,'2200022701','茶同学'),(2,'2200022702','哈同学'),(3,'2200022703','果同学');
/*!40000 ALTER TABLE `studentlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2200022701','123456'),(2,'2200022702','123456'),(3,'2200022703','123456'),(4,'1200012700','123456'),(5,'1300012700','123456');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserRole`
--

DROP TABLE IF EXISTS `UserRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `UserRole` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserRole`
--

LOCK TABLES `UserRole` WRITE;
/*!40000 ALTER TABLE `UserRole` DISABLE KEYS */;
INSERT INTO `UserRole` VALUES (1,'2200022701',1),(2,'1200012700',2),(3,'1300012700',3);
/*!40000 ALTER TABLE `UserRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volserlist`
--

DROP TABLE IF EXISTS `volserlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `volserlist` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '学号',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `time` varchar(255) DEFAULT NULL COMMENT '志愿时长',
  `vsmark` varchar(255) DEFAULT NULL COMMENT '评分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volserlist`
--

LOCK TABLES `volserlist` WRITE;
/*!40000 ALTER TABLE `volserlist` DISABLE KEYS */;
INSERT INTO `volserlist` VALUES (1,'2200022701','茶同学','90','7'),(2,'2200022702','哈同学','30','2'),(3,'2200022703','果同学','60','4');
/*!40000 ALTER TABLE `volserlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workservice`
--

DROP TABLE IF EXISTS `workservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workservice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `time` varchar(255) DEFAULT NULL COMMENT '起始时间',
  `job` varchar(255) DEFAULT NULL COMMENT '服务岗位名称',
  `post` varchar(255) DEFAULT NULL COMMENT '职务',
  `level` varchar(255) DEFAULT NULL COMMENT '考核级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workservice`
--

LOCK TABLES `workservice` WRITE;
/*!40000 ALTER TABLE `workservice` DISABLE KEYS */;
/*!40000 ALTER TABLE `workservice` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-04 23:03:21
