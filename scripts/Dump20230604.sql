CREATE DATABASE  IF NOT EXISTS `quizzes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quizzes`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quizzes
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `statement` text NOT NULL,
  `display_order` int NOT NULL,
  `is_correct` tinyint(1) NOT NULL,
  `question_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_AnswerQuestion` (`question_id`),
  CONSTRAINT `FK_AnswerQuestion` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (15,'cxv',1,0,8),(16,'cvxb',2,0,8),(17,'cxvb',3,0,8),(18,'cvxb',4,1,8),(19,'cvxb',1,0,9),(20,'cxvb',2,0,9),(21,'cvb',3,0,9),(22,'cxb',4,1,9),(23,'cxbv',1,0,10),(24,'xcvb',2,0,10),(25,'cxbv',3,0,10),(26,'xcvb',4,1,10);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quiz_id` bigint NOT NULL,
  `statement` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK_QuestionQuiz` (`quiz_id`),
  CONSTRAINT `FK_QuestionQuiz` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (8,16,'cxv'),(9,16,'xcvb'),(10,16,'xcvb');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `theory` mediumtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (14,'Family','<h4>The English family</h4><br>\n<b>These are some sentences about family members in English</b>\nI have no siblings but I have a cousin<br>\nI am 30 years old, I am married and I have a daughter<br>\nMy niece is Carla<br>\nShe loves spending time with her son<br>\nMy uncle George is the brother of my mother<br>\nYour daughter is my cousin<br>\nMy grandfather is your uncle<br>\nMy grandmother is from France<br>\nYour brother is my cousin<br>\nYour parents are my grandparents<br>\nYour sister is my stepmother<br>\nMy father is your nephew<br>\nYour sisters are my aunts<br>\nLili is the niece of my grandfather Julius<br>\n<b>Reading about Family Members in English</b><br>\nMy family consists of my dad, mum, one brother, one sister and myself. My mom is a teacher and my dad is a doctor. We all live in a big house in the city. My dad is 50 years old and  my mum is 46 years old.<br>\nMy brother Daniel is a university student and he is 20 years old. Similarly,  my sister is a student at high school and she is 16 years old. I have one aunt and one uncle. I have two nephews and one niece.<br>\nFinally,  I am 19 years old and I am at college studying to be a mechanical engineer. We like to go out to the beach at the weekends. We also like camping during summer holidays.<br>'),(15,'Weather','<h4>The Weather in English</h4> <br>\nIn English, we usually use it is when we talk about the weather.<br>\nThis is normally: It is + adjective OR It is + verb-ing<br>\nIt is + adjective = A description of the weather<br>\nIt is sunny today.<br>\nIt\'s hot and humid today.<br>\nIt\'s a nice day today.<br>\nWe can also say:<br>\nIt is a + adjective + day (or morning/afternoon/night)<br>\nIt\'s a fine day.<br>\nIt\'s a windy afternoon.<br>\nIt is + verb-ing = This type of weather is happening now.<br>\nIt\'s drizzling outside.<br>\nIt\'s snowing.<br>\nTake an umbrella, it\'s raining.<br>\nYou can also use it is in different tenses<br>\nIt was cold yesterday.<br>\nIt will be cloudy tomorrow.<br>'),(16,'Friends','The United Nations declared 30 July as the International Day of Friendship with the idea that \'friendship between peoples, countries, cultures and individuals can inspire peace efforts and build bridges between communities.\'\n<br>\nIn this lesson pupils celebrate friendship.<br>\nFirst, learners are introduced to the topic of friendship through simple drawings.<br>\nThen they join in a teacher-led discussion about what makes a good friend. They do a wordsearch to find keywords and use these to complete a gap-fill text about what makes a good friend.<br>\nFriendship is defined as a bond of affection between two people.<br>\nPeople are referred to as best friends if the friendship is really strong. this relationship is characterized by positive interpersonal qualities such as kindness, generosity, loyalty, and honesty.<br>\nTrue friends choose to be with one another, enjoy time spent together, and can engage in a positive and supportive role to one another.\n'),(17,'Games','Games and fun activities are a vital part of teaching English as a foreign language.<br>\n Whether you’re teaching adults or children, games will liven up your lesson and ensure that your students will leave the classroom wanting more.<br>\n Games can be used to warm up the class before your lesson begins, during the lesson to give students a break when you’re tackling a tough subject, or at the end of class when you have a few minutes left to kill.\n Want to jump right into the list?<br>\nHere are the top 10 games we think your students will love:<br>\n<ol>\n <li>Board Race</li>\n  <li>Call My Bluff / Two Truths and A Lie</li>\n  <li>Simon Says</li>\n  <li>Word Jumble Race</li>\n  <li>Hangman</li>\n  <li>Pictionary</li>\n <li>The Mime</li>\n  <li>Hot Seat</li>\n  <li>Where Shall I Go?</li>\n  <li>What’s My Problem?</li>\n  </ol>'),(19,'Holidays ','Janell recently started a new job. Now she has more free time.<br>\n She is happy because she has more free time. She can do things she’s interested in.<br>\n\nJanell really likes to read. She enjoys reading different kinds of books, such as science fiction, mystery and romance.<br>\nHer favorite book is IQ84 by Haruki Murakami. It is interesting because it is a mystery and a love story.<br>\n\nShe also enjoys listening to music. She likes different kinds of music, such as pop, jazz and rock.<br>     \n She listens to pop music in the gym, jazz at home when she’s relaxing, and rock on her way to work.<br>\n\nOn her days off, Janell likes to play basketball with her friends.<br>\nShe is not very good at basketball, but she thinks it is fun.<br>');
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password_hash` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `is_admin` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'$2a$10$SWBUDiQSI9mCxM4KxmKBt.FtQKflsuqZ4beXA2bPvq2mFzMmNOiEO','gigel',_binary ''),(4,'$2a$10$SWBUDiQSI9mCxM4KxmKBt.FtQKflsuqZ4beXA2bPvq2mFzMmNOiEO','gigel2',_binary ''),(5,'$2a$10$T9Olr8mo0rlFpeZLD23YIeNjKEMzvWsR5KZd0JJ08ASpq9.VdIFqy','Comanel',_binary '\0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_quiz_solution`
--

DROP TABLE IF EXISTS `user_quiz_solution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_quiz_solution` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `quiz_id` bigint NOT NULL,
  `score` int NOT NULL,
  `total` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FK_SolutionQuiz` (`quiz_id`),
  KEY `FK_SolutionUser` (`user_id`),
  CONSTRAINT `FK_SolutionQuiz` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK_SolutionUser` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_quiz_solution`
--

LOCK TABLES `user_quiz_solution` WRITE;
/*!40000 ALTER TABLE `user_quiz_solution` DISABLE KEYS */;
INSERT INTO `user_quiz_solution` VALUES (7,2,14,1,10),(8,2,14,5,10),(9,2,14,8,10),(10,2,15,1,10),(11,2,15,5,10),(12,2,15,6,10),(13,2,16,1,10),(14,2,16,5,10),(15,2,16,8,10);
/*!40000 ALTER TABLE `user_quiz_solution` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-04 22:17:52
