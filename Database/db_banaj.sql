-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2022 at 07:13 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_banaj`
--

-- --------------------------------------------------------

--
-- Table structure for table `beli_product`
--

CREATE TABLE `beli_product` (
  `id_beliProduct` varchar(11) NOT NULL,
  `supplier` varchar(8) NOT NULL,
  `tanggal_beliProduct` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `kategori` varchar(8) NOT NULL,
  `grand_total` varchar(32) NOT NULL,
  `pegawai` varchar(8) NOT NULL,
  `bayar` int(32) NOT NULL,
  `kembalian` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `beli_product`
--

INSERT INTO `beli_product` (`id_beliProduct`, `supplier`, `tanggal_beliProduct`, `kategori`, `grand_total`, `pegawai`, `bayar`, `kembalian`) VALUES
('TRB05202142', 'S001', '2022-05-20 16:42:31', 'K001', '21000', 'pgw231', 0, 0),
('TRB05204810', 'S002', '2022-05-20 10:32:09', 'K001', '30000', '', 0, 0),
('TRB05205771', 'S001', '2022-05-20 10:38:14', 'K001', '3700000', '', 0, 0),
('TRB05207989', 'S001', '2022-05-20 10:34:01', 'K001', '32000', '', 0, 0),
('TRB05208868', 'S001', '2022-05-20 10:44:53', 'K003', '20000', '', 0, 0),
('TRB05209074', 'S001', '2022-05-20 16:34:04', 'K001', '144', 'pgw231', 0, 0),
('TRB05209532', 'S001', '2022-05-20 16:37:28', 'K001', '2', 'pgw231', 0, 0),
('TRB05209683', 'S001', '2022-05-20 16:40:34', 'K001', '24', 'pgw231', 0, 0),
('TRB05211883', 'S001', '2022-05-21 06:25:49', 'K001', '14808', 'pgw231', 100000, 85192),
('TRB05212052', 'S001', '2022-05-21 06:45:15', 'K001', '149314', 'pgw231', 150000, 686),
('TRB05212214', 'S001', '2022-05-21 07:29:46', 'K001', '2583', 'pgw231', 2600, 17),
('TRB05212279', 'S001', '2022-05-21 06:11:00', 'K001', '14808', 'pgw231', 15000, 192),
('TRB05213657', 'S001', '2022-05-21 06:34:29', 'K001', '2583', 'pgw231', 3000, 417),
('TRB05214244', 'S001', '2022-05-21 14:29:55', 'K001', '10000', 'pgw231', 15000, 5000),
('TRB0521496', 'S001', '2022-05-21 06:31:36', 'K001', '1476', 'pgw231', 20000, 18524),
('TRB05215184', 'S001', '2022-05-21 06:46:40', 'K001', '144', 'pgw231', 150, 6),
('TRB05215185', 'S001', '2022-05-21 06:48:26', 'K001', '24', 'pgw231', 25, 1),
('TRB05216398', 'S001', '2022-05-21 06:49:22', 'K001', '252', 'pgw231', 255, 3),
('TRB05216732', 'S001', '2022-05-21 07:34:36', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05216817', 'S001', '2022-05-21 06:29:42', 'K001', '14808', 'pgw231', 15000, 192),
('TRB05216841', 'S001', '2022-05-21 07:33:10', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05217197', 'S001', '2022-05-21 07:39:29', 'K001', '14808', 'pgw231', 15000, 192),
('TRB05217387', 'S001', '2022-05-21 06:32:57', 'K001', '25893', 'pgw231', 30000, 4107),
('TRB05217649', 'S001', '2022-05-21 06:40:23', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05217824', 'S001', '2022-05-21 06:43:48', 'K001', '14808', 'pgw231', 15000, 192),
('TRB05218180', 'S001', '2022-05-21 07:36:26', 'K001', '14400', 'pgw231', 15000, 600),
('TRB05219468', 'S001', '2022-05-21 07:32:13', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05221562', 'S001', '2022-05-21 19:55:39', 'K001', '1476', 'pgw231', 1470, 0),
('TRB05222468', 'S001', '2022-05-21 19:54:48', 'K003', '144', 'pgw231', 145, 1),
('TRB05224902', 'S001', '2022-05-21 19:46:49', 'K001', '27429', 'pgw231', 30000, 2571),
('TRB05225848', 'S001', '2022-05-21 19:41:49', 'K001', '19602', 'pgw231', 20000, 0),
('TRB0522603', 'S001', '2022-05-21 19:42:56', 'K001', '2952', 'pgw231', 3000, 48),
('TRB05226312', 'S001', '2022-05-21 19:44:57', 'K001', '2952', 'pgw231', 3000, 48),
('TRB05227620', 'S001', '2022-05-21 20:03:27', 'K001', '2', 'pgw231', 3, 1),
('TRB05228642', 'S001', '2022-05-21 20:02:21', 'K001', '16284', 'pgw231', 17000, 716),
('TRB05232233', 'S001', '2022-05-22 18:23:47', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05233069', 'S001', '2022-05-22 18:02:15', 'K001', '1476', 'pgw231', 1400, 71),
('TRB0523397', 'S001', '2022-05-23 04:09:35', 'K004', '151476', 'pgw231', 155000, 3524),
('TRB05233984', 'S001', '2022-05-22 18:39:58', 'K003', '1500000', 'pgw231', 1700000, 200000),
('TRB05234386', 'S001', '2022-05-22 19:40:18', 'K001', '144', 'pgw231', 146, 2),
('TRB05235289', 'S001', '2022-05-22 18:26:31', 'K001', '441', 'pgw231', 500, 59),
('TRB05235295', 'S001', '2022-05-23 03:56:19', 'K001', '2583', 'pgw231', 2600, 17),
('TRB05236181', 'S001', '2022-05-23 04:34:32', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05236258', 'S001', '2022-05-22 18:53:56', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05236519', 'S001', '2022-05-22 18:32:17', 'K001', '48972', 'pgw231', 50000, 1028),
('TRB05236758', 'S001', '2022-05-22 18:24:46', 'K001', '2583', 'pgw231', 2600, 17),
('TRB05238118', 'S001', '2022-05-23 04:14:35', 'K003', '1476', 'pgw231', 1500, 24),
('TRB05238124', 'S001', '2022-05-22 19:11:27', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05238292', 'S001', '2022-05-22 18:33:05', 'K001', '4473', 'pgw231', 5000, 527),
('TRB05238518', 'S001', '2022-05-23 03:57:31', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05238571', 'S001', '2022-05-23 04:16:01', 'K003', '2583', 'pgw231', 2600, 17),
('TRB05239342', 'S001', '2022-05-23 03:58:20', 'K001', '1476', 'pgw231', 1500, 24),
('TRB05239513', 'S001', '2022-05-23 04:45:31', 'K001', '2583', 'pgw231', 2600, 17),
('TRB05239853', 'S001', '2022-05-23 04:36:10', 'K001', '1476', 'pgw231', 12312, 10836),
('TRB05239856', 'S001', '2022-05-22 18:30:42', 'K001', '1476', 'pgw231', 1500, 24);

-- --------------------------------------------------------

--
-- Table structure for table `detail_beli_product`
--

CREATE TABLE `detail_beli_product` (
  `id_beliProduct` varchar(11) NOT NULL,
  `jumlahBeli` int(32) NOT NULL,
  `product` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_beli_product`
--

INSERT INTO `detail_beli_product` (`id_beliProduct`, `jumlahBeli`, `product`) VALUES
('TRB05209683', 12, 'SBN0001'),
('TRB05218180', 12, 'SBN0003'),
('TRB05217197', 12, 'SBN0004'),
('TRB05214244', 10, 'SBN0005'),
('TRB05225848', 21, 'SBN0006'),
('TRB05225848', 123, 'SBN0007'),
('TRB0522603', 12, 'SBN0008'),
('TRB0522603', 12, 'SBN0009'),
('TRB05226312', 12, 'SBN0012'),
('TRB05226312', 12, 'SBN0013'),
('TRB05224902', 211, 'SBN0014'),
('TRB05224902', 12, 'SBN0015'),
('TRB05222468', 12, 'PRM0001'),
('TRB05221562', 12, 'SBN0016'),
('TRB05221562', 12, 'SBN0016'),
('TRB05228642', 12, 'SBN0017'),
('TRB05228642', 12, 'SBN0018'),
('TRB05227620', 1, 'SBN0019'),
('TRB05232233', 12, 'SBN0021'),
('TRB05236758', 21, 'SBN0022'),
('TRB05235289', 21, 'SBN0023'),
('TRB05239856', 12, 'SBN0024'),
('TRB05236519', 21, 'SBN0025'),
('TRB05238292', 21, 'SBN0026'),
('TRB05233984', 100, 'PRM0002'),
('TRB05236258', 12, 'SBN0027'),
('TRB05238124', 12, 'SBN0030'),
('TRB05234386', 12, 'SBN0031'),
('TRB05235295', 21, 'SBN0032'),
('TRB05238518', 12, 'SBN0033'),
('TRB05239342', 12, 'SBN0034'),
('TRB0523397', 12, 'KTU0001'),
('TRB0523397', 10, 'KTU0002'),
('TRB05238118', 12, 'PRM0003'),
('TRB05238571', 21, 'PRM0004'),
('TRB05236181', 12, 'SBN0035'),
('TRB05236181', 12, 'SBN0035'),
('TRB05239853', 12, 'SBN0036'),
('TRB05239513', 21, 'SBN0037');

-- --------------------------------------------------------

--
-- Table structure for table `detail_retur`
--

CREATE TABLE `detail_retur` (
  `id_returSupplier` varchar(11) NOT NULL,
  `product` varchar(32) NOT NULL,
  `jumlah_rusak` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_retur`
--

INSERT INTO `detail_retur` (`id_returSupplier`, `product`, `jumlah_rusak`) VALUES
('TR20611103', 'SM0003', 1),
('TR25121045', 'SM0003', 1),
('TR41126549', 'SM0003', 1),
('TR11638646', 'SM0004', 11),
('TR27982731', 'SM0003', 1),
('TR36500376', 'SM0004', 11),
('TR55881626', 'SM0001', 1),
('TR7861542', 'SBK0011', 1),
('TR20748453', 'SBN0011', 1),
('TR68891552', 'SMO0002', 1),
('TR44378962', 'SMO0003', 1),
('TR44338136', 'SBN0012', 1),
('TR46104636', 'SBN0013', 1),
('TR25235012', 'SBN0014', 1),
('TR35328049', 'SBN0015', 1),
('TR11479720', 'SBN0018', 1),
('TR2471787', 'SBN0018', 1),
('TR6204850', 'SBN0020', 12),
('TR64526849', 'SBN0027', 1);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `kode_product` varchar(8) NOT NULL,
  `sub_total` int(32) NOT NULL,
  `qty` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_transaksi`, `kode_product`, `sub_total`, `qty`) VALUES
('TRJ05221350', 'SBN0003', 1500, 1),
('TRJ05231497', 'SBN0002', 1234, 1),
('TRJ05231497', 'SBN0003', 3000, 2),
('TRJ05234325', 'PRM0001', 123, 1),
('TRJ05234325', 'SBN0002', 2468, 2),
('TRJ05234759', 'SBN0002', 1234, 1),
('TRJ05234759', 'SBN0003', 3000, 2);

--
-- Triggers `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `kurang_stok` BEFORE INSERT ON `detail_transaksi` FOR EACH ROW update product
set stok=stok-new.qty , total_stok = stok+rusak where kode_product =new.kode_product
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `kode_kategori` varchar(8) NOT NULL,
  `nama_kategori` varchar(64) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`kode_kategori`, `nama_kategori`, `create_at`, `update_at`) VALUES
('K001', 'SABUN', '2022-04-30 19:17:41', '2022-04-30 19:17:41'),
('K002', 'SAMPO', '2022-04-30 19:18:31', '2022-04-30 19:18:31'),
('K003', 'PARFUM', '2022-05-01 09:34:25', '2022-05-01 09:34:25'),
('K004', 'KATEGORI BARU', '2022-05-16 14:31:24', '2022-05-16 14:31:24');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(8) NOT NULL,
  `nama_pegawai` varchar(64) NOT NULL,
  `username` varchar(32) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `role` int(2) NOT NULL,
  `status` enum('Aktive','Tidak Aktive') NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `username`, `create_at`, `update_at`, `role`, `status`, `password`) VALUES
('pgw001', 'ucup', 'ucup', '2022-03-23 15:37:52', '2022-03-23 15:37:52', 0, 'Aktive', ''),
('PGW002', 'NAMA QW', 'qw', '2022-04-26 12:24:24', '2022-04-26 12:24:24', 1, 'Aktive', 'qw'),
('PGW003', 'SDFD DFD', 'dfd', '2022-04-26 12:35:32', '2022-04-26 12:35:32', 1, 'Aktive', 'dfd'),
('PGW004', 'AS U', 'admin', '2022-05-03 12:14:04', '2022-05-03 12:14:04', 1, 'Aktive', 'admin'),
('PGW005', 'USER 12', '12', '2022-05-03 12:14:23', '2022-05-03 12:14:23', 2, 'Aktive', '12'),
('pgw231', 'ya', 'a', '2022-05-03 14:26:11', '2022-05-03 14:26:11', 1, 'Aktive', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `kode_product` varchar(8) NOT NULL,
  `nama_product` varchar(64) NOT NULL,
  `stok` int(32) NOT NULL,
  `harga_beli` int(32) NOT NULL,
  `harga_jual` int(32) NOT NULL,
  `supplier` varchar(8) NOT NULL,
  `kategori` varchar(8) NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `update_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `rusak` int(32) DEFAULT 0,
  `total_stok` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`kode_product`, `nama_product`, `stok`, `harga_beli`, `harga_jual`, `supplier`, `kategori`, `create_at`, `update_at`, `rusak`, `total_stok`) VALUES
('KTU0001', 'sabun', 12, 123, 124, 'S001', 'K004', '2022-05-23 04:10:13', '2022-05-23 04:10:13', 0, 12),
('KTU0002', 'sabun ke 21', 10, 15000, 17000, 'S001', 'K004', '2022-05-23 04:10:13', '2022-05-23 04:10:13', 0, 10),
('PRM0001', 'sa', 11, 12, 123, 'S001', 'K003', '2022-05-23 04:00:23', '2022-05-21 19:55:03', 0, 11),
('PRM0002', 'PARFUM 2', 100, 15000, 17000, 'S001', 'K003', '2022-05-22 18:39:58', '2022-05-22 18:39:58', 0, 100),
('PRM0003', 'as', 12, 123, 1235, 'S001', 'K003', '2022-05-23 04:14:59', '2022-05-23 04:14:59', 0, 12),
('PRM0004', 'as', 21, 123, 2134, 'S001', 'K003', '2022-05-23 04:16:13', '2022-05-23 04:16:13', 0, 21),
('SBN0001', 'saf', 12, 2, 3, 'S001', 'K001', '2022-05-20 16:40:39', '2022-05-20 16:40:39', 0, 12),
('SBN0002', 'sabun', 8, 123, 1234, 'S001', 'K001', '2022-05-23 04:01:14', '2022-05-21 07:34:36', 0, 8),
('SBN0003', 'sabun', 7, 1200, 1500, 'S001', 'K001', '2022-05-23 04:01:14', '2022-05-21 07:36:26', 0, 7),
('SBN0004', 'sabun ', 12, 1234, 1235, 'S001', 'K001', '2022-05-21 07:39:29', '2022-05-21 07:39:29', 0, 12),
('SBN0005', 'as', 10, 1000, 2000, 'S001', 'K001', '2022-05-21 14:29:55', '2022-05-21 14:29:55', 0, 10),
('SBN0006', 'as', 21, 213, 1234, 'S001', 'K001', '2022-05-21 19:42:19', '2022-05-21 19:42:19', 0, 21),
('SBN0007', 'asd', 123, 123, 124, 'S001', 'K001', '2022-05-21 19:42:21', '2022-05-21 19:42:21', 0, 123),
('SBN0008', 'as', 12, 123, 124, 'S001', 'K001', '2022-05-21 19:43:11', '2022-05-21 19:43:11', 0, 12),
('SBN0009', 'ad', 12, 123, 124, 'S001', 'K001', '2022-05-21 19:43:16', '2022-05-21 19:43:16', 0, 12),
('SBN0010', 'as', 12, 123, 124, 'S001', 'K001', '2022-05-21 19:44:45', '2022-05-21 19:44:45', 0, 12),
('SBN0011', 'ads', 12, 123, 124, 'S001', 'K001', '2022-05-21 19:44:50', '2022-05-21 19:44:50', 0, 12),
('SBN0012', 'sd', 12, 123, 124, 'S001', 'K001', '2022-05-21 19:45:22', '2022-05-21 19:45:22', 0, 12),
('SBN0013', '12', 12, 123, 1234, 'S001', 'K001', '2022-05-21 19:45:32', '2022-05-21 19:45:32', 0, 12),
('SBN0014', 'as', 211, 123, 124, 'S001', 'K001', '2022-05-21 19:47:04', '2022-05-21 19:47:04', 0, 211),
('SBN0015', 'sada', 12, 123, 124, 'S001', 'K001', '2022-05-21 19:47:04', '2022-05-21 19:47:04', 0, 12),
('SBN0016', 'as', 12, 123, 124, 'S001', 'K001', '2022-05-21 19:55:51', '2022-05-21 19:55:51', 0, 12),
('SBN0017', 'sabun', 12, 123, 1234, 'S001', 'K001', '2022-05-21 20:02:48', '2022-05-21 20:02:48', 0, 12),
('SBN0018', 'sda', 12, 1234, 21314, 'S001', 'K001', '2022-05-21 20:02:48', '2022-05-21 20:02:48', 0, 12),
('SBN0019', 'a', 1, 2, 3, 'S001', 'K001', '2022-05-21 20:03:35', '2022-05-21 20:03:35', 0, 1),
('SBN0021', 'sa', 12, 123, 1234, 'S001', 'K001', '2022-05-22 18:23:47', '2022-05-22 18:23:47', 0, 12),
('SBN0022', 'sa', 21, 123, 124, 'S001', 'K001', '2022-05-22 18:24:46', '2022-05-22 18:24:46', 0, 21),
('SBN0023', 'sa', 21, 21, 23, 'S001', 'K001', '2022-05-22 18:26:31', '2022-05-22 18:26:31', 0, 21),
('SBN0024', 'sa', 12, 123, 124, 'S001', 'K001', '2022-05-22 18:30:42', '2022-05-22 18:30:42', 0, 12),
('SBN0025', 'sa', 21, 2332, 2444, 'S001', 'K001', '2022-05-22 18:32:17', '2022-05-22 18:32:17', 0, 21),
('SBN0026', 'sa', 21, 213, 232, 'S001', 'K001', '2022-05-22 18:33:05', '2022-05-22 18:33:05', 0, 21),
('SBN0027', 'sa', 12, 123, 1234, 'S001', 'K001', '2022-05-22 18:53:56', '2022-05-22 18:53:56', 0, 12),
('SBN0028', 'sa', 12, 123, 124, 'S001', 'K001', '2022-05-22 19:03:49', '2022-05-22 19:03:49', 0, 12),
('SBN0029', 'unik', 12, 123, 124, 'S001', 'K001', '2022-05-22 19:05:52', '2022-05-22 19:05:52', 0, 12),
('SBN0030', 'sa', 12, 123, 124, 'S001', 'K001', '2022-05-22 19:11:27', '2022-05-22 19:11:27', 0, 12),
('SBN0031', 'sa', 12, 12, 123, 'S001', 'K001', '2022-05-22 19:40:18', '2022-05-22 19:40:18', 0, 12),
('SBN0032', 'sa', 21, 123, 124, 'S001', 'K001', '2022-05-23 03:56:19', '2022-05-23 03:56:20', 0, 21),
('SBN0033', 'sa', 12, 123, 214, 'S001', 'K001', '2022-05-23 03:57:31', '2022-05-23 03:57:31', 0, 12),
('SBN0034', 'sabun', 12, 123, 1234, 'S001', 'K001', '2022-05-23 03:58:20', '2022-05-23 03:58:20', 0, 12),
('SBN0035', 'jk', 12, 123, 1234, 'S001', 'K001', '2022-05-23 04:34:51', '2022-05-23 04:34:51', 0, 12),
('SBN0036', 'sa', 12, 123, 12434, 'S001', 'K001', '2022-05-23 04:36:28', '2022-05-23 04:36:28', 0, 12),
('SBN0037', 'sa', 21, 123, 2134124, 'S001', 'K001', '2022-05-23 04:45:52', '2022-05-23 04:45:52', 0, 21);

--
-- Triggers `product`
--
DELIMITER $$
CREATE TRIGGER `delete_retur` BEFORE UPDATE ON `product` FOR EACH ROW DELETE from detail_retur where jumlah_rusak =0
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `retur_customer`
--

CREATE TABLE `retur_customer` (
  `id_transaksi` varchar(11) NOT NULL,
  `tanggal_retur` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `retur_supplier`
--

CREATE TABLE `retur_supplier` (
  `kode_supplier` varchar(8) NOT NULL,
  `tanggal_rtr` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_returSupplier` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `retur_supplier`
--

INSERT INTO `retur_supplier` (`kode_supplier`, `tanggal_rtr`, `id_returSupplier`) VALUES
('S001', '2022-05-16 10:01:50', 'TR11479720'),
('S001', '2022-04-24 05:36:56', 'TR11638646'),
('S001', '2022-04-24 05:26:41', 'TR20611103'),
('S001', '2022-05-14 05:48:09', 'TR20748453'),
('S001', '2022-04-22 02:51:32', 'TR22503483'),
('S001', '2022-05-16 10:01:56', 'TR2471787'),
('S001', '2022-04-24 05:29:10', 'TR25121045'),
('S001', '2022-05-16 09:55:22', 'TR25235012'),
('S001', '2022-04-24 05:37:41', 'TR27982731'),
('S001', '2022-05-16 09:55:23', 'TR35328049'),
('S001', '2022-04-24 05:38:04', 'TR36500376'),
('S001', '2022-04-24 05:29:37', 'TR41126549'),
('S001', '2022-05-16 09:52:09', 'TR44338136'),
('S001', '2022-05-16 09:42:28', 'TR44378962'),
('S001', '2022-05-16 09:52:11', 'TR46104636'),
('S001', '2022-04-24 05:39:50', 'TR55881626'),
('S001', '2022-05-16 10:11:35', 'TR6204850'),
('S001', '2022-04-20 05:42:44', 'TR62166744'),
('S001', '2022-04-24 05:12:52', 'TR63713657'),
('S001', '2022-05-19 11:39:42', 'TR64526849'),
('S001', '2022-05-01 02:35:18', 'TR66484943'),
('S001', '2022-04-24 05:18:54', 'TR68143153'),
('S001', '2022-05-16 09:42:24', 'TR68891552'),
('S001', '2022-04-24 05:09:41', 'TR77425670'),
('S001', '2022-04-25 13:06:19', 'TR7861542'),
('S001', '2022-04-24 05:18:30', 'TR94679531'),
('S001', '2022-04-24 05:04:09', 'TR95120590'),
('S001', '2022-04-20 05:11:12', 'TR96146366');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` varchar(8) NOT NULL,
  `nama_supplier` varchar(64) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`kode_supplier`, `nama_supplier`, `create_at`, `update_at`) VALUES
('S001', 'banaj supplier 1', '2022-04-19 20:00:44', '2022-04-19 20:00:44'),
('S002', 'supplier fragnace', '2022-04-25 20:30:21', '2022-04-30 19:02:15');

-- --------------------------------------------------------

--
-- Table structure for table `toko`
--

CREATE TABLE `toko` (
  `id_toko` varchar(8) NOT NULL,
  `nama_toko` varchar(64) NOT NULL,
  `alamat_toko` varchar(128) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL,
  `no_hp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `toko`
--

INSERT INTO `toko` (`id_toko`, `nama_toko`, `alamat_toko`, `create_at`, `update_at`, `no_hp`) VALUES
('TOKO01', 'BANAJ FRAGRANCE MOSLEM', 'Jl. Sumatra Gang 7 Jember', '2022-05-08 21:38:52', '2022-05-08 21:38:52', '085907185972');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `tanggal_transaksi` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `grand_total` int(32) NOT NULL,
  `bayar` int(32) NOT NULL,
  `id_pegawai` varchar(8) NOT NULL,
  `kembali` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal_transaksi`, `grand_total`, `bayar`, `id_pegawai`, `kembali`) VALUES
('TRJ05221350', '2022-05-21 18:33:32', 1500, 1700, 'pgw231', 200),
('TRJ05231497', '2022-05-22 18:04:20', 4234, 5000, 'pgw231', 766),
('TRJ0523398', '2022-05-23 03:58:39', 14808, 15000, 'pgw231', 192),
('TRJ05234325', '2022-05-23 04:00:23', 2591, 2600, 'pgw231', 9),
('TRJ05234759', '2022-05-23 04:01:14', 4234, 5000, 'pgw231', 766),
('TRJ0523992', '2022-05-23 05:03:10', 16942, 1, 'pgw231', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beli_product`
--
ALTER TABLE `beli_product`
  ADD PRIMARY KEY (`id_beliProduct`),
  ADD KEY `supplier` (`supplier`),
  ADD KEY `kategori` (`kategori`),
  ADD KEY `pegawai` (`pegawai`);

--
-- Indexes for table `detail_beli_product`
--
ALTER TABLE `detail_beli_product`
  ADD KEY `id_beliProduct` (`id_beliProduct`),
  ADD KEY `product` (`product`);

--
-- Indexes for table `detail_retur`
--
ALTER TABLE `detail_retur`
  ADD KEY `retur_sup` (`id_returSupplier`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `kode_product` (`kode_product`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kode_kategori`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`kode_product`),
  ADD KEY `supplier` (`supplier`),
  ADD KEY `kategori` (`kategori`);

--
-- Indexes for table `retur_customer`
--
ALTER TABLE `retur_customer`
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indexes for table `retur_supplier`
--
ALTER TABLE `retur_supplier`
  ADD PRIMARY KEY (`id_returSupplier`),
  ADD KEY `rtr_sup` (`kode_supplier`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- Indexes for table `toko`
--
ALTER TABLE `toko`
  ADD PRIMARY KEY (`id_toko`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `beli_product`
--
ALTER TABLE `beli_product`
  ADD CONSTRAINT `beli_product_ibfk_1` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `beli_product_ibfk_2` FOREIGN KEY (`kategori`) REFERENCES `kategori` (`kode_kategori`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `beli_product_ibfk_3` FOREIGN KEY (`pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_beli_product`
--
ALTER TABLE `detail_beli_product`
  ADD CONSTRAINT `detail_beli_product_ibfk_1` FOREIGN KEY (`id_beliProduct`) REFERENCES `beli_product` (`id_beliProduct`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_beli_product_ibfk_2` FOREIGN KEY (`product`) REFERENCES `product` (`kode_product`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_retur`
--
ALTER TABLE `detail_retur`
  ADD CONSTRAINT `retur_sup` FOREIGN KEY (`id_returSupplier`) REFERENCES `retur_supplier` (`id_returSupplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`kode_product`) REFERENCES `product` (`kode_product`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`kategori`) REFERENCES `kategori` (`kode_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `retur_customer`
--
ALTER TABLE `retur_customer`
  ADD CONSTRAINT `retur_customer_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `retur_supplier`
--
ALTER TABLE `retur_supplier`
  ADD CONSTRAINT `rtr_sup` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
