-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Feb 22, 2022 at 09:23 AM
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
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int NOT NULL,
  `name` text NOT NULL,
  `birthday` date DEFAULT NULL,
  `nationality` text,
  `avatar` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`, `birthday`, `nationality`, `avatar`) VALUES
(1, 'Paulo Coelho', NULL, NULL, NULL),
(2, 'Nguyễn Nhật Ánh', NULL, NULL, NULL),
(3, 'Tony Buổi Sáng', NULL, NULL, NULL),
(4, 'Thảo Thảo', NULL, NULL, NULL),
(5, 'Mặc Hương Đồng Khứu', NULL, NULL, NULL),
(6, 'Diêu Dao', NULL, NULL, NULL),
(7, 'Keigo Higashino', NULL, NULL, NULL),
(8, 'Conan Doyle', NULL, NULL, NULL),
(9, 'Albert Rutherford', NULL, NULL, NULL),
(10, 'TS David J Lieberman', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int NOT NULL,
  `title` text NOT NULL,
  `quantity` int NOT NULL,
  `publishingYear` text,
  `id_publisher` int NOT NULL,
  `page` int DEFAULT NULL,
  `thumbnail` text,
  `description` text,
  `price` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `title`, `quantity`, `publishingYear`, `id_publisher`, `page`, `thumbnail`, `description`, `price`) VALUES
(1, 'Nhà Giả Kim', 50, '2020', 1, 227, NULL, NULL, 68000),
(2, 'Mắt Biếc', 100, '2019', 2, 300, NULL, NULL, 75000),
(3, 'Cà Phê Cùng Tony', 60, '2017', 2, 268, NULL, NULL, 55000),
(4, 'Chúng Ta Rồi Sẽ Hạnh Phúc, Theo Những Cách Khác Nhau', 50, '2021', 3, 208, NULL, NULL, 90000),
(5, 'Thiên Quan Tứ Phúc', 70, '2021', 4, 416, NULL, NULL, 150000),
(6, 'Rạp Chiếu Phim Thời Gian', 50, '2021', 5, 280, NULL, NULL, 73000),
(7, 'Sau Giờ Học', 50, '2021', 4, 320, NULL, NULL, 114000),
(8, 'Sherlock Holmes (Trọn Bộ 3 Cuốn)', 50, '2019', 3, NULL, NULL, NULL, 293000),
(9, 'Rèn Luyện Tư Duy Phản Biện', 50, '2020', 6, NULL, NULL, NULL, 79200),
(10, 'Đọc Vị Bất Kỳ Ai', 50, '2019', 7, 223, NULL, NULL, 63200);

-- --------------------------------------------------------

--
-- Table structure for table `book_author`
--

CREATE TABLE `book_author` (
  `id_book` int NOT NULL,
  `id_author` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `book_author`
--

INSERT INTO `book_author` (`id_book`, `id_author`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- --------------------------------------------------------

--
-- Table structure for table `book_category`
--

CREATE TABLE `book_category` (
  `id_book` int NOT NULL,
  `id_category` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `book_category`
--

INSERT INTO `book_category` (`id_book`, `id_category`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 3),
(6, 3),
(7, 4),
(8, 4),
(9, 5),
(10, 5);

-- --------------------------------------------------------

--
-- Table structure for table `borrow_detail`
--

CREATE TABLE `borrow_detail` (
  `id` int NOT NULL,
  `id_borrow` int NOT NULL,
  `id_book` int NOT NULL,
  `borrow_quantity` int NOT NULL,
  `return_at` date DEFAULT NULL,
  `return_quantity` int DEFAULT NULL,
  `id_staff_receive` int DEFAULT NULL,
  `status` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `borrow_detail`
--

INSERT INTO `borrow_detail` (`id`, `id_borrow`, `id_book`, `borrow_quantity`, `return_at`, `return_quantity`, `id_staff_receive`, `status`) VALUES
(1, 1, 2, 2, '2021-01-17', 2, 1, NULL),
(2, 1, 5, 1, '2021-01-17', 1, 1, NULL),
(3, 1, 8, 1, '2021-01-18', 1, 2, NULL),
(4, 2, 6, 1, '2021-02-13', 1, 2, NULL),
(5, 2, 9, 3, '2021-02-12', 2, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `borrow_shelf`
--

CREATE TABLE `borrow_shelf` (
  `id` int NOT NULL,
  `id_customer` int NOT NULL,
  `id_staff` int NOT NULL,
  `create_at` date NOT NULL,
  `status` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `borrow_shelf`
--

INSERT INTO `borrow_shelf` (`id`, `id_customer`, `id_staff`, `create_at`, `status`) VALUES
(1, 1, 1, '2021-01-15', NULL),
(2, 3, 2, '2021-02-10', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(3, 'Ngôn tình'),
(5, 'Tâm lý-Kỹ Năng Sống'),
(1, 'Tiểu thuyết'),
(4, 'Trinh thám-Kiếm hiệp'),
(2, 'Truyện ngắn - tản văn');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `fullname` text NOT NULL,
  `birthday` date NOT NULL,
  `email` text NOT NULL,
  `address` text NOT NULL,
  `avatar` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `mobile`, `password`, `fullname`, `birthday`, `email`, `address`, `avatar`) VALUES
(1, '0985647512', 'son1234', 'Trần Văn Sơn', '1995-05-31', 'son@gmail.com', 'Đống Đa', NULL),
(2, '0758426852', 'ha1234', 'Trần Thị Hà', '1996-06-25', 'ha@gmail.com', 'Cầu Giấy', NULL),
(3, '0958745624', 'nam1234', 'Trần Hoàng Nam', '1997-07-30', 'nam@gmail.com', 'Hoàng Mai', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `id` int NOT NULL,
  `name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `name`) VALUES
(1, 'NXB Hội Nhà Văn'),
(2, 'NXB Trẻ'),
(3, 'NXB Văn Học'),
(4, 'NXB Hà Nội'),
(5, 'NXB Thanh Niên'),
(6, 'NXB Phụ Nữ Việt Nam'),
(7, 'NXB Lao Động');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `fullname` text NOT NULL,
  `email` text NOT NULL,
  `avatar` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id`, `mobile`, `password`, `fullname`, `email`, `avatar`) VALUES
(1, '0984256842', 'quang1234', 'Trần Ngọc Quang', 'quang@gmail.com', NULL),
(2, '0865425875', 'cong1234', 'Hoàng Chí Công', 'cong@gmail.com', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_publisher` (`id_publisher`);

--
-- Indexes for table `book_author`
--
ALTER TABLE `book_author`
  ADD PRIMARY KEY (`id_book`,`id_author`),
  ADD KEY `id_author` (`id_author`);

--
-- Indexes for table `book_category`
--
ALTER TABLE `book_category`
  ADD PRIMARY KEY (`id_book`,`id_category`),
  ADD KEY `id_category` (`id_category`);

--
-- Indexes for table `borrow_detail`
--
ALTER TABLE `borrow_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_borrow` (`id_borrow`),
  ADD KEY `id_book` (`id_book`),
  ADD KEY `id_staff_receive` (`id_staff_receive`);

--
-- Indexes for table `borrow_shelf`
--
ALTER TABLE `borrow_shelf`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_customer` (`id_customer`),
  ADD KEY `id_staff` (`id_staff`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `mobile` (`mobile`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `mobile` (`mobile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `borrow_detail`
--
ALTER TABLE `borrow_detail`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `borrow_shelf`
--
ALTER TABLE `borrow_shelf`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`id_publisher`) REFERENCES `publisher` (`id`);

--
-- Constraints for table `book_author`
--
ALTER TABLE `book_author`
  ADD CONSTRAINT `book_author_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `book_author_ibfk_2` FOREIGN KEY (`id_author`) REFERENCES `author` (`id`);

--
-- Constraints for table `book_category`
--
ALTER TABLE `book_category`
  ADD CONSTRAINT `book_category_ibfk_1` FOREIGN KEY (`id_book`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `book_category_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);

--
-- Constraints for table `borrow_detail`
--
ALTER TABLE `borrow_detail`
  ADD CONSTRAINT `borrow_detail_ibfk_1` FOREIGN KEY (`id_borrow`) REFERENCES `borrow_shelf` (`id`),
  ADD CONSTRAINT `borrow_detail_ibfk_2` FOREIGN KEY (`id_book`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `borrow_detail_ibfk_3` FOREIGN KEY (`id_staff_receive`) REFERENCES `staff` (`id`);

--
-- Constraints for table `borrow_shelf`
--
ALTER TABLE `borrow_shelf`
  ADD CONSTRAINT `borrow_shelf_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `borrow_shelf_ibfk_2` FOREIGN KEY (`id_staff`) REFERENCES `staff` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
