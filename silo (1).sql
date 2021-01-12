-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 12, 2021 at 09:57 PM
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
('D1', 'cus 1', 'status', 'IN1', '2021-01-01', '2021-01-02'),
('DN2', 'Cusname2', 'status2', 'IN2', '2009-01-07', '2009-01-08');

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
('IN1', 'PN1', 'sup1', 'status', '2021-01-04', '2021-01-03'),
('IN2', 'PN2', 'supname2', 'status2', '2021-01-13', '2021-01-13'),
('IN3', 'PN3', 'supname3', 'status3', '2009-01-05', '2009-01-06');

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
('IT1', 'satu', 'satu', 'satu', 'satu', 'satu', 1),
('IT2', 'dua', 'dua', 'dua', 'dua', 'dua', 2),
('IT3', 'tiga', 'tiga', 'tiga', 'tiga', 'tiga', 3);

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
