-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 13, 2021 at 07:36 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `silo`
--

-- --------------------------------------------------------

--
-- Table structure for table `deliverynote`
--

CREATE TABLE `deliverynote` (
  `deliveryNoteNumber` varchar(1024) NOT NULL,
  `customerName` varchar(1024) NOT NULL,
  `status` varchar(1024) NOT NULL,
  `invoiceNumber` varchar(1024) NOT NULL,
  `orderDate` date NOT NULL,
  `deliveryDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deliverynote`
--

INSERT INTO `deliverynote` (`deliveryNoteNumber`, `customerName`, `status`, `invoiceNumber`, `orderDate`, `deliveryDate`) VALUES
('DN1', 'Customer 1', 'completed', 'IN1', '2021-01-01', '2021-01-02'),
('DN2', 'Cusname 2', 'completed', 'IN2', '2009-01-07', '2009-01-08'),
('DN3', 'Customer 3', 'completed', 'IN3', '2009-01-05', '2009-01-06');

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoiceNumber` varchar(1024) NOT NULL,
  `poNumber` varchar(1024) NOT NULL,
  `supplierName` varchar(1024) NOT NULL,
  `status` varchar(1024) NOT NULL,
  `orderDate` date NOT NULL,
  `deliveryDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoiceNumber`, `poNumber`, `supplierName`, `status`, `orderDate`, `deliveryDate`) VALUES
('IN1', 'PN1', 'supplier 1', 'completed', '2021-01-04', '2021-01-03'),
('IN2', 'PN2', 'supplier 2', 'completed', '2021-01-13', '2021-01-13'),
('IN3', 'PN3', 'supplier 3', 'completed', '2009-01-05', '2009-01-06'),
('IN4', 'PN4', 'supplier 4', 'completed', '2009-01-05', '2009-01-06');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` varchar(1024) NOT NULL,
  `barcode` varchar(1024) DEFAULT NULL,
  `title` varchar(1024) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `manufacturer` varchar(1024) DEFAULT NULL,
  `url` varchar(1024) DEFAULT NULL,
  `stocks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `barcode`, `title`, `description`, `manufacturer`, `url`, `stocks`) VALUES
('IT1', 'barcode_1', 'Item 1', 'description 1', 'manufacturer 1', 'url 1', 1),
('IT2', 'barcode_2', 'Item 2', 'description 2', 'manufacturer 2', 'url 2', 2),
('IT3', 'barcode_3', 'Item 3', 'description 3', 'manufaturer 3', 'url 3', 3),
('IT4', 'barcode 4', 'Item 4', 'description 4', 'manufacturere 4', 'url 4', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deliverynote`
--
ALTER TABLE `deliverynote`
  ADD PRIMARY KEY (`deliveryNoteNumber`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoiceNumber`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;