-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Feb 26, 2022 at 07:29 AM
-- Server version: 8.0.28
-- PHP Version: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `select_question`
--

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `id` int NOT NULL,
  `id_question` int NOT NULL,
  `content` text NOT NULL,
  `results` enum('TRUE','FALSE') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`id`, `id_question`, `content`, `results`) VALUES
(1, 1, 'next year', 'TRUE'),
(2, 1, 'in fact', 'FALSE'),
(3, 1, 'possible', 'FALSE'),
(4, 1, 'sometimes', 'FALSE'),
(5, 2, 'yet', 'TRUE'),
(6, 2, 'just', 'FALSE'),
(7, 2, 'although', 'FALSE'),
(8, 2, 'moreover', 'FALSE'),
(9, 3, 'in fact', 'TRUE'),
(10, 3, 'at', 'FALSE'),
(11, 3, 'on', 'FALSE'),
(12, 3, 'into', 'FALSE'),
(13, 4, 'during the last', 'TRUE'),
(14, 4, 'since the last', 'FALSE'),
(15, 4, 'in the following', 'FALSE'),
(16, 4, 'periodically over', 'FALSE'),
(17, 5, 'has been checked', 'TRUE'),
(18, 5, 'was checked', 'FALSE'),
(19, 5, 'check', 'FALSE'),
(20, 5, 'was being checked', 'FALSE');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` int NOT NULL,
  `content` text NOT NULL,
  `levels` enum('beginner','intermediate','advanced') DEFAULT NULL,
  `slection_type` enum('single','multi') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `content`, `levels`, `slection_type`) VALUES
(1, 'The new law will encourage growth in the export market _________.', 'beginner', 'single'),
(2, 'The new service was expected to be a success; __________ very few customers upgraded their accounts.', 'beginner', 'single'),
(3, 'The flight arrives __________ Tokyo in three hours.', 'intermediate', 'single'),
(4, 'The report showed that overall prices are up 3.1 percent _________ 12 months.', 'intermediate', 'single'),
(5, 'While the stock ________ the staff worked in the evenings.', 'advanced', 'single');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_question` (`id_question`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`id_question`) REFERENCES `question` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
