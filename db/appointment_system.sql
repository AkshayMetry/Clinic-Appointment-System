-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 03, 2021 at 09:26 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appointment_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointments`
--

CREATE TABLE `appointments` (
  `apt_id` int(11) NOT NULL,
  `patient_id` int(20) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `doctor` varchar(100) NOT NULL,
  `date` varchar(20) NOT NULL,
  `time` varchar(20) NOT NULL,
  `dateofbooking` datetime(6) NOT NULL DEFAULT current_timestamp(6)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointments`
--

INSERT INTO `appointments` (`apt_id`, `patient_id`, `doctor_id`, `doctor`, `date`, `time`, `dateofbooking`) VALUES
(1, 1, 1, '1. doctor1 -- Dentist', '31-03-2021', '10:00am - 10:30', '2021-03-30 15:39:17.460993'),
(2, 2, 1, '1. doctor1 -- Dentist', '02-04-2021', '11.00 - 11:30', '2021-03-30 21:23:37.192566'),
(4, 1, 2, '2. doctor2 -- Pediatrician', '01-04-2021', '11.30 - 12:00', '2021-03-31 12:34:56.399984'),
(7, 1, 1, '1. doctor1 -- Dentist', '31-03-2021', '10:00am - 10:30', '2021-03-31 20:29:02.343764');

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE `doctors` (
  `id` int(11) NOT NULL,
  `doctor_name` varchar(30) NOT NULL,
  `doctor_email` varchar(30) NOT NULL,
  `doctor_address` text NOT NULL,
  `doctor_age` int(100) NOT NULL,
  `doctor_gender` varchar(10) NOT NULL,
  `doctor_specialization` varchar(50) NOT NULL,
  `doctor_experience` int(10) NOT NULL,
  `doctor_username` varchar(30) NOT NULL,
  `doctor_password` varchar(30) NOT NULL,
  `doctor_join_date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`id`, `doctor_name`, `doctor_email`, `doctor_address`, `doctor_age`, `doctor_gender`, `doctor_specialization`, `doctor_experience`, `doctor_username`, `doctor_password`, `doctor_join_date`) VALUES
(1, 'doctor1', 'doctor1@gmail.com', 'some place', 30, 'Male', 'Dentist', 4, 'doctor1', 'doctor1', '2021-03-24 18:05:02'),
(2, 'doctor2', 'doctor2@gmail.com', 'some place	', 31, 'Male', 'Pediatrician', 5, 'doctor2', 'dcotor2', '2021-03-27 10:12:05');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `users_id` int(10) NOT NULL,
  `name` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `mobile_no` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`users_id`, `name`, `email`, `username`, `password`, `mobile_no`) VALUES
(1, 'test', 'test@gmail.com', 'test', 'test', 1234567890),
(2, 'test1', 'test1@gmail.com', 'test1', 'test1', 1234567890);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointments`
--
ALTER TABLE `appointments`
  ADD PRIMARY KEY (`apt_id`);

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`users_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointments`
--
ALTER TABLE `appointments`
  MODIFY `apt_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `doctors`
--
ALTER TABLE `doctors`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `users_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
