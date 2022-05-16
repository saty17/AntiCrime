-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 16, 2022 at 09:23 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `anticrime`
--
CREATE DATABASE IF NOT EXISTS `anticrime` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `anticrime`;

-- --------------------------------------------------------

--
-- Table structure for table `complaintregister`
--

DROP TABLE IF EXISTS `complaintregister`;
CREATE TABLE IF NOT EXISTS `complaintregister` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CompAddress` varchar(200) NOT NULL,
  `CompCity` varchar(100) NOT NULL,
  `CompPincode` varchar(100) NOT NULL,
  `CompSubject` varchar(200) NOT NULL,
  `Complaint` varchar(200) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complaintregister`
--

INSERT INTO `complaintregister` (`Id`, `CompAddress`, `CompCity`, `CompPincode`, `CompSubject`, `Complaint`, `UserName`, `Status`) VALUES
(31, 'null', 'null', '00000', 'null', 'null', 'Prince', 'Submitted'),
(30, 'Kalyan', 'Kalyan', '432122', 'Robbery', 'Robbery', 'Prince', 'Submitted'),
(15, 'ass', 'dsa', '345', 'sdas', 'qqqq', 'root', 'Submitted'),
(16, 'ajhsdgjsavd', 'hjasjvas', '10000', ' cjsbc', 'kjadskjasd', 'pinaki', 'Submitted'),
(17, 'temghar, pipeline', 'bhiwandi', '421302', 'robbery', 'Robbery in home', 'hello', 'Submitted'),
(18, 'Oswal college', 'dadar', '423212', 'bullying', 'some boys bullying on some girls', 'hello', 'Submitted'),
(29, 'Enclave', 'navi Mumbai', '421322', 'kidnapping', '3 men kidnapped a 6 years child', 'Prince', 'Submitted');

-- --------------------------------------------------------

--
-- Table structure for table `crimeregister`
--

DROP TABLE IF EXISTS `crimeregister`;
CREATE TABLE IF NOT EXISTS `crimeregister` (
  `Id` int(50) NOT NULL AUTO_INCREMENT,
  `CrimeStreet` varchar(50) NOT NULL,
  `CrimeCity` varchar(50) NOT NULL,
  `CrimePincode` varchar(50) NOT NULL,
  `CrimeDetails` varchar(100) NOT NULL,
  `ImageTitle` varchar(50) NOT NULL,
  `ImageLocation` varchar(50) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `crimeregister`
--

INSERT INTO `crimeregister` (`Id`, `CrimeStreet`, `CrimeCity`, `CrimePincode`, `CrimeDetails`, `ImageTitle`, `ImageLocation`, `UserName`, `Status`) VALUES
(1, 'temghar', 'bhiwandi', ' 421302', 'murder', 'myImage', 'crimeimages/temghar.jpg', 'root', 'Submitted'),
(4, 'railway station', 'thane', ' 423213', 'a man shoot the another man', '', 'crimeimages/railway station.jpg', 'root', 'Submitted'),
(3, 'durgadi', 'kalyan', ' 421305', 'hit and run\n', '', 'crimeimages/durgadi.jpg', 'root', 'Submitted'),
(5, 'D-Mart', 'kalyan', ' 421300', 'Robbery', 'myImage', 'crimeimages/D-Mart.jpg', 'root', 'Submitted'),
(6, 'unknown', 'bandra', ' 0000000', 'hhhaa', 'myImage', 'crimeimages/unknown.jpg', 'aza', 'submitted'),
(7, 'Shastrinagar', 'bandra', ' 431231', 'Murder', 'myImage', 'crimeimages/Shastrinagar.jpg', 'Prince', 'Submitted'),
(8, 'nul', 'null', ' null', 'null', 'myImage', 'crimeimages/nul.jpg', 'Prince', 'Submitted');

-- --------------------------------------------------------

--
-- Table structure for table `missingregister`
--

DROP TABLE IF EXISTS `missingregister`;
CREATE TABLE IF NOT EXISTS `missingregister` (
  `Id` int(50) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Age` varchar(50) NOT NULL,
  `LastSeen` varchar(50) NOT NULL,
  `Details` varchar(100) NOT NULL,
  `ImageTitle` varchar(100) NOT NULL,
  `ImageLocation` varchar(100) NOT NULL,
  `UserName` varchar(50) NOT NULL,
  `Status` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `missingregister`
--

INSERT INTO `missingregister` (`Id`, `Name`, `Age`, `LastSeen`, `Details`, `ImageTitle`, `ImageLocation`, `UserName`, `Status`) VALUES
(1, 'Her', '40', 'home', 'black', 'myImage', 'images/myImage.jpg', '', 'Submitted'),
(4, 'Umesh', '20', 'batchroom', 'Think body,\nfair skin, \nsmart boy,\ntopper', 'myImage', 'images/myImage.jpg', 'pinaki', 'Submitted'),
(5, 'amit', '20', 'home', 'tall, fair, moron', 'myImage', 'images/amit.jpg', 'pinaki', 'Submitted'),
(6, 'pinaki', '05', 'chocolate shop', 'chota mota gol matol', 'myImage', 'images/pinaki.jpg', 'root', 'Submitted'),
(7, 'harsh', '21', 'Temple', 'long hair, fat boy, height 5.5', 'myImage', 'images/harsh.jpg', 'hello', 'Submitted'),
(8, 'Rahul', '22', 'At college', 'Tall, fair skin, 5.9 ft hight', 'myImage', 'images/Rahul.jpg', 'hello', 'Submitted'),
(9, 'Sima', '27', 'At Home', 'healthy, fair skin, 4.9 ft hight', 'myImage', 'images/Sima.jpg', 'hello', 'Submitted'),
(10, 'Rahul', '30', 'at work', 'Tall, 6.1ft hight, fair skin', 'myImage', 'images/Rahul.jpg', 'Ram', 'Submitted'),
(11, 'seema', '20', 'At home', 'tall, healthy, fair skin , 5.7ft hight', 'myImage', 'images/seema.jpg', 'shubham', 'Submitted'),
(12, 'kali', '20', 'school', 'black', 'myImage', 'images/kali.jpg', 'sarto', 'submitted'),
(13, 'golu', '15', 'playground', '4.5ft hight, black eye, black hair', 'myImage', 'images/golu.jpg', 'Prince', 'Submitted'),
(14, 'Riya', '19', 'Park', 'Fair, healthy, black hair', 'myImage', 'images/Riya.jpg', 'Prince', 'Submitted'),
(16, 'Shyam', '23', 'At College', 'Tall, Fair skin, Black Hair', 'myImage', 'images/Shyam.jpg', 'Prince', 'Submitted'),
(17, 'umesh', '19', 'In college', 'xyz', 'myImage', 'images/umesh.jpg', 'Prince', 'Submitted');

-- --------------------------------------------------------

--
-- Table structure for table `regtable`
--

DROP TABLE IF EXISTS `regtable`;
CREATE TABLE IF NOT EXISTS `regtable` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Aadhar_no` varchar(16) NOT NULL,
  `Phone_no` varchar(10) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `UserName` (`UserName`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regtable`
--

INSERT INTO `regtable` (`Id`, `UserName`, `Email`, `Password`, `Aadhar_no`, `Phone_no`, `created_at`) VALUES
(1, 'abc', 'abc@gmail.com', '123', '1232432434', '21323232', '2022-03-07 15:18:41'),
(2, 'saty', 'sa@gmail.com', '111', '12131231', '21321213', '2022-03-07 15:18:41'),
(3, '', '', 'd41d8cd98f00b204e9800998ecf8427e', '', '', '2022-03-07 15:25:54'),
(4, 'satyam', 'sat1y@gmail.com ', '827ccb0eea8a706c4c34a16891f84e7b', '4241234', '21324124', '2022-03-07 15:26:55'),
(5, 'Amit', 'amit@gmail.com', 'a4c1ff5aae5cd09dd562a48e8ecd2b41', '345637457658', '8970987654', '2022-03-07 16:20:24'),
(6, 'pinaki', 'pinaki@gmail.com', '2509bff3047eefa48183e8f602c03891', '232343423341', '9748548343', '2022-03-07 22:40:33'),
(7, 'abhi', 'abhi@gmail.com', '76e3e07d735e14de9d768d8fe05c39a8', '908767490876', '9807685649', '2022-03-07 23:20:44'),
(8, 'umesh', 'umyanoob@gmail.com', '83714cdce6eb3f342a0122f90dda45e3', '714027996343', '8652857077', '2022-03-08 15:03:07'),
(9, 'shubham', 'shubham@gmail.com', '6a95c0df38e54945180f4d5e66b69b86', '986712341267', '3246789506', '2022-03-08 21:45:09'),
(10, 'ravi', 'ravi@gmail.com', 'ae2eb3a82aa8c5a706691b7fe9903421', '981231112311', '9800012234', '2022-03-09 00:36:01'),
(11, 'navi', 'navi@gmail.com', '80eb36b1abb1b783216ed97c759106ee', '987666656789', '9890987789', '2022-03-09 10:18:20'),
(12, 'suraj', 'suraj@gmail.com', '8127a1ad276367223d9d0a2d264e4b2e', '908697865998', '9999857685', '2022-03-09 18:31:21'),
(13, 'root', 'root@gmail.com', 'aabb2100033f0352fe7458e412495148', '234111112342', '9000000001', '2022-03-09 18:51:29'),
(14, 'rahul', 'rahul@gmail.com', '2acb7811397a5c3bea8cba57b0388b79', '213242423423', '9432384234', '2022-03-14 02:40:25'),
(15, 'hello', 'hello@gmail.com', '9a1996efc97181f0aee18321aa3b3b12', '432123234231', '5453564534', '2022-03-14 02:43:23'),
(16, 'Karan', 'karan@gmail.com', '535f2f43eef55f6285a8fc838dfe51cf', '653411112321', '9876666453', '2022-03-15 22:51:17'),
(17, 'Ram', 'ram@gmail.com', 'de946f85b16ef4769c55ce1d4bce2c4a', '909999777840', '9878889786', '2022-03-15 22:53:40'),
(18, 'Prince', 'prince@gmail.com', '05fa200ad197c821af655455b999b0a4', '9000092132322', '9077777678', '2022-03-16 17:54:59'),
(19, 'Ronaldo', 'ronaldo@gmail.com', 'ad70f4bc1c44e7b2a395262d69272653', '907866667908', '9999078967', '2022-03-16 17:57:45'),
(20, 'Rupa', 'rupa@gmail.com', '5a27a12afb2dc9b85a4e8c432954a689', '712341231231', '9092313333', '2022-03-16 18:02:50'),
(21, 'sos', 'sos@gmail.com', '369434181f222654f1463daec2e3add5', '121212123123', '1231232312', '2022-05-16 14:09:54');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
