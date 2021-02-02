-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 10, 2021 at 10:03 PM
-- Server version: 10.3.22-MariaDB-1ubuntu1
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ApplicationJ`
--

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `food_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `status` tinyint(1) DEFAULT 1,
  `food_type_id` int(11) NOT NULL,
  `type_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`food_id`, `name`, `description`, `status`, `food_type_id`, `type_id`) VALUES
(1, 'MixVeg', 'MixVeg for dinner', 1, 1, 1),
(2, 'Biryani', 'Biryani for all time', 1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `food_type`
--

CREATE TABLE `food_type` (
  `food_type_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food_type`
--

INSERT INTO `food_type` (`food_type_id`, `name`, `status`) VALUES
(1, 'Veg', 1),
(2, 'NonVeg', 1);

-- --------------------------------------------------------

--
-- Table structure for table `knowledge`
--

CREATE TABLE `knowledge` (
  `id` int(11) NOT NULL,
  `ans` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `qus` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `tag_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `knowledge`
--

INSERT INTO `knowledge` (`id`, `ans`, `created_at`, `created_by`, `file`, `qus`, `remarks`, `updated_at`, `updated_by`, `tag_id`) VALUES
(1, 'this is our first ans', '2021-01-10 21:59:14', NULL, NULL, 'this is our first qus', 'this is our first remark', '2021-01-10 21:59:14', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `server_cred`
--

CREATE TABLE `server_cred` (
  `id` int(11) NOT NULL,
  `domain` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `client` varchar(255) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `server_cred`
--

INSERT INTO `server_cred` (`id`, `domain`, `username`, `password`, `client`, `created_by`, `created_at`, `updated_by`, `updated_at`) VALUES
(1, 'localhost.com', 'akash', 'super password', 'american', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `status_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`status_id`, `name`, `status`) VALUES
(1, 'Active', 1),
(2, 'Deactive', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tags`
--

CREATE TABLE `tags` (
  `tag_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tags`
--

INSERT INTO `tags` (`tag_id`, `name`, `status`) VALUES
(1, 'java', b'1'),
(2, 'angular', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `status_id` int(11) NOT NULL,
  `food_type_id` int(11) NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `email`, `status_id`, `food_type_id`, `created_by`, `created_at`, `updated_by`, `updated_at`, `user_id`, `enabled`, `role_id`) VALUES
(1, 'vaibhav', 'vaibhav', '$2a$10$IoX/5ofvwwtuEQwwCgiNaOiGgaPvL7b.uXUrmI70Rvn1ACW7C5G0a', 'vaibhav@gmail.com', 1, 1, 1, '2018-07-31 18:30:00', 1, '2018-07-31 18:30:00', 0, b'0', 0),
(2, 'akash', 'akash', '$2a$10$pMnfLfBxRgVOpqDC.lF4JOJCUgIe45hdKubHa86kx6jD/vhxFi0qK', 'akash@gmail.com', 1, 2, 1, '2018-07-31 18:30:00', 1, '2018-07-31 18:30:00', 0, b'0', 0),
(3, 'akshat', 'akshat', '$2a$10$hwZmEBuuoOgNWjyMImjPBO3CSJs/4gkxHzRKszUKHlpoOPcUnbPhy', 'akshat@gmail.com', 2, 1, 1, '2018-07-31 18:30:00', 1, '2018-07-31 18:30:00', 0, b'0', 0),
(4, 'rohit', 'rohit', '$2a$10$VVLPeQUQBsUqJyia8AbtdO4ltyrLjntNSKL5jpYK48e9olmX5r.OW', 'rohit@gmail.com', 1, 1, 1, '2020-09-27 15:22:47', 1, '2020-09-27 15:22:47', 0, b'0', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`food_id`),
  ADD KEY `FKf3bmvf487ya6cqglsh3lotiiq` (`food_type_id`),
  ADD KEY `FK1xxp5osqkx3gxmdfqsqwhm1fw` (`type_id`);

--
-- Indexes for table `food_type`
--
ALTER TABLE `food_type`
  ADD PRIMARY KEY (`food_type_id`);

--
-- Indexes for table `knowledge`
--
ALTER TABLE `knowledge`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8reffy7fs34ifiriahb3a9evs` (`tag_id`);

--
-- Indexes for table `server_cred`
--
ALTER TABLE `server_cred`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`status_id`);

--
-- Indexes for table `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`tag_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3m08uc0bd36m6tgp3g65m20dl` (`status_id`),
  ADD KEY `FKgt7l6dw1xavs1cvgkfly4d2n1` (`food_type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `food_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `food_type`
--
ALTER TABLE `food_type`
  MODIFY `food_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `knowledge`
--
ALTER TABLE `knowledge`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `server_cred`
--
ALTER TABLE `server_cred`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `status_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tags`
--
ALTER TABLE `tags`
  MODIFY `tag_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `food`
--
ALTER TABLE `food`
  ADD CONSTRAINT `FK1xxp5osqkx3gxmdfqsqwhm1fw` FOREIGN KEY (`type_id`) REFERENCES `food_type` (`food_type_id`),
  ADD CONSTRAINT `FKf3bmvf487ya6cqglsh3lotiiq` FOREIGN KEY (`food_type_id`) REFERENCES `food_type` (`food_type_id`);

--
-- Constraints for table `knowledge`
--
ALTER TABLE `knowledge`
  ADD CONSTRAINT `FK8reffy7fs34ifiriahb3a9evs` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`tag_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FK3m08uc0bd36m6tgp3g65m20dl` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`),
  ADD CONSTRAINT `FKgt7l6dw1xavs1cvgkfly4d2n1` FOREIGN KEY (`food_type_id`) REFERENCES `food_type` (`food_type_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
