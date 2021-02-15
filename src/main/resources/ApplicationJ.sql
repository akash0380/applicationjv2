-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Feb 15, 2021 at 10:47 PM
-- Server version: 10.3.25-MariaDB-0ubuntu0.20.04.1
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
-- Table structure for table `auth_uri`
--

CREATE TABLE `auth_uri` (
  `id` int(11) NOT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `auth_uri`
--

INSERT INTO `auth_uri` (`id`, `uri`, `role_id`) VALUES
(1, '***', 1),
(2, 'users/list', 1);

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
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `name`, `status`) VALUES
(1, 'Admin', b'1'),
(2, 'Manager', b'1');

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
  `id` bigint(20) NOT NULL,
  `created_at` datetime NOT NULL,
  `created_by` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_at` datetime NOT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `food_type_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `created_at`, `created_by`, `email`, `name`, `password`, `updated_at`, `updated_by`, `username`, `food_type_id`, `status_id`, `role_id`) VALUES
(1, '2021-02-15 22:28:02', 1, 'akash@gmail.com', 'akash', '$2a$10$0fMSpV.UltNO7coBKWl1EOHo7Pruc/ZVk9JgPhE92.6.kVY.yaTYO', '2021-02-15 22:28:02', 1, 'akash', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_token`
--

CREATE TABLE `user_token` (
  `id` bigint(20) NOT NULL,
  `token` varchar(3000) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_token`
--

INSERT INTO `user_token` (`id`, `token`, `user_id`) VALUES
(1, 'eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyIjp7Im5hbWUiOiJha2FzaCIsImlkIjoxLCJlbWFpbCI6ImFrYXNoQGdtYWlsLmNvbSJ9LCJqdGkiOiIxIiwiaWF0IjoxNjEzNDA4MjgzLCJleHAiOjE2MTM0OTQ2ODN9.hRT6bIdWbSj8he8zsEZrubwZWXsYOmxqbYGU0lKA8sYII-Zlbi4FiL3LRdBBUyJw5ggUOwcUsnt4H5YhGeLALg', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `auth_uri`
--
ALTER TABLE `auth_uri`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK18fieuu7nkkvv58g9jherhx84` (`role_id`);

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
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

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
  ADD KEY `FKgt7l6dw1xavs1cvgkfly4d2n1` (`food_type_id`),
  ADD KEY `FK3m08uc0bd36m6tgp3g65m20dl` (`status_id`),
  ADD KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`);

--
-- Indexes for table `user_token`
--
ALTER TABLE `user_token`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_dsueu4oggfo11n7trivi7vvyt` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `auth_uri`
--
ALTER TABLE `auth_uri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user_token`
--
ALTER TABLE `user_token`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auth_uri`
--
ALTER TABLE `auth_uri`
  ADD CONSTRAINT `FK18fieuu7nkkvv58g9jherhx84` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`);

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
  ADD CONSTRAINT `FKgt7l6dw1xavs1cvgkfly4d2n1` FOREIGN KEY (`food_type_id`) REFERENCES `food_type` (`food_type_id`),
  ADD CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`);

--
-- Constraints for table `user_token`
--
ALTER TABLE `user_token`
  ADD CONSTRAINT `FKfadr8tg4d19axmfe9fltvrmqt` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
