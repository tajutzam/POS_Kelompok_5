-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2022 at 03:23 AM
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
  `tanggal_beliProduct` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detail_beli_product`
--

CREATE TABLE `detail_beli_product` (
  `id_beliProduct` varchar(11) NOT NULL,
  `jumlahBeli` int(32) NOT NULL,
  `product` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
('TR7861542', 'SBK0011', 1);

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
('TRJ05947219', 'SBN0001', 34000, 2),
('TRJ05947219', 'SBN0002', 30000, 2),
('TRJ05913771', 'SBN0001', 85000, 5),
('TRJ05913771', 'SBN0002', 135000, 9),
('TRJ05913771', 'SBN0003', 17500, 7),
('TRJ05984362', 'SBN0001', 170000, 10),
('TRJ05984362', 'SBN0003', 30000, 12),
('TRJ05984362', 'SBN0002', 45000, 3),
('TRJ05983197', 'SBN0001', 17000, 1),
('TRJ05983197', 'SBN0002', 15000, 1),
('TRJ05976764', 'SBN0002', 15000, 1),
('TRJ05976764', 'SBN0003', 2500, 1),
('TRJ05976764', 'SBN0001', 17000, 1),
('TRJ0594832', 'SBN0002', 15000, 1),
('TRJ05981161', 'SBN0003', 2500, 1),
('TRJ0596522', 'SBN0002', 15000, 1),
('TRJ0596522', 'SBN0003', 5000, 2),
('TRJ05910879', 'SBN0002', 15000, 1),
('TRJ05910879', 'SBN0001', 34000, 2),
('TRJ05910879', 'SBN0003', 7500, 3),
('TRJ05962552', 'SBN0002', 15000, 1),
('TRJ05964562', 'SBN0002', 15000, 1),
('TRJ05968231', 'SBN0002', 15000, 1),
('TRJ0596945', 'SBN0002', 15000, 1),
('TRJ05988218', 'SBN0002', 15000, 1),
('TRJ05988218', 'SBN0001', 17000, 1),
('TRJ05988218', 'SBN0003', 5000, 2),
('TRJ0595442', 'SBN0002', 15000, 1),
('TRJ05931324', 'SBN0003', 2500, 1),
('TRJ0597890', 'SBN0003', 50000, 20),
('TRJ0597890', 'SBN0002', 150000, 10),
('TRJ0597890', 'SBN0001', 170000, 10),
('TRJ05998722', 'SBN0002', 15000, 1),
('TRJ05998722', 'SBN0001', 51000, 3),
('TRJ05998722', 'SBN0003', 2500, 1),
('TRJ05981880', 'SBN0002', 30000, 2),
('TRJ05981880', 'SBN0003', 7500, 3),
('TRJ05981880', 'SBN0001', 17000, 1),
('TRJ05916804', 'SBN0002', 15000, 1),
('TRJ05916804', 'SBN0003', 5000, 2),
('TRJ05959942', 'SBN0001', 17000, 1),
('TRJ05959942', 'SBN0002', 15000, 1),
('TRJ05959942', 'SBN0003', 2500, 1),
('TRJ05981778', 'SBN0002', 15000, 1),
('TRJ05981778', 'SBN0001', 34000, 2),
('TRJ0595138', 'SBN0001', 17000, 1),
('TRJ0595138', 'SBN0002', 45000, 3),
('TRJ0595138', 'SBN0003', 5000, 2),
('TRJ05975540', 'SBN0002', 15000, 1),
('TRJ05975540', 'SBN0001', 34000, 2),
('TRJ05975540', 'SBN0003', 7500, 3),
('TRJ05927744', 'SBN0001', 204000, 12),
('TRJ05927744', 'SBN0003', 5000, 2),
('TRJ05927744', 'SBN0002', 15000, 1),
('TRJ05965337', 'SBN0001', 204000, 12),
('TRJ05965337', 'SBN0002', 180000, 12),
('TRJ05965337', 'SBN0003', 2500, 1),
('TRJ05942041', 'PRM0001', 25000, 1),
('TRJ05942041', 'PRM0002', 40000, 2),
('TRJ05942041', 'PRM0003', 27000, 1),
('TRJ05942041', 'SBN0001', 51000, 3),
('TRJ05942041', 'SBN0002', 60000, 4),
('TRJ05942041', 'SBN0003', 5000, 2),
('TRJ05942041', 'SBN0004', 20000, 1),
('TRJ05942041', 'SBN0005', 40000, 2),
('TRJ05942041', 'SBN0006', 15000, 1),
('TRJ05942041', 'SBN0007', 15000, 1),
('TRJ05942041', 'SMO0001', 48000, 2),
('TRJ05916313', 'PRM0001', 25000, 1),
('TRJ05973206', 'SBN0007', 15000, 1),
('TRJ05949250', 'PRM0001', 25000, 1),
('TRJ05949250', 'PRM0002', 40000, 2),
('TRJ05949250', 'PRM0003', 27000, 1),
('TRJ05949250', 'SBN0002', 30000, 2),
('TRJ05949250', 'SBN0001', 17000, 1),
('TRJ05949250', 'SBN0007', 15000, 1),
('TRJ05949250', 'SMO0001', 48000, 2),
('TRJ05921380', 'SMO0001', 24000, 1),
('TRJ05930284', 'PRM0002', 40000, 2),
('TRJ05930284', 'PRM0001', 25000, 1),
('TRJ05930284', 'SBN0001', 34000, 2),
('TRJ05930284', 'PRM0003', 54000, 2),
('TRJ05930284', 'SBN0007', 45000, 3),
('TRJ05930284', 'SMO0001', 96000, 4),
('TRJ05983942', 'PRM0003', 27000, 1),
('TRJ05958625', 'PRM0001', 25000, 1),
('TRJ05958625', 'PRM0002', 40000, 2),
('TRJ05958625', 'PRM0003', 81000, 3),
('TRJ05958625', 'SBN0001', 17000, 1),
('TRJ05958625', 'SBN0002', 30000, 2),
('TRJ05995850', 'SBN0001', 17000, 1),
('TRJ05973209', 'PRM0003', 27000, 1),
('TRJ05954700', 'PRM0001', 25000, 1),
('TRJ05954700', 'PRM0003', 54000, 2),
('TRJ05954700', 'PRM0002', 60000, 3),
('TRJ05954700', 'SBN0006', 15000, 1),
('TRJ05954700', 'SBN0007', 15000, 1),
('TRJ05954700', 'SMO0001', 48000, 2),
('TRJ05916037', 'PRM0002', 20000, 1),
('TRJ05916037', 'SBN0001', 34000, 2),
('TRJ05916037', 'SBN0002', 45000, 3),
('TRJ05968522', 'PRM0002', 240000, 12),
('TRJ05968522', 'SBN0001', 17000, 1),
('TRJ05968522', 'SBN0002', 15000, 1),
('TRJ05968522', 'PRM0003', 27000, 1),
('TRJ05992796', 'PRM0003', 27000, 1),
('TRJ05993399', 'PRM0003', 27000, 1),
('TRJ05997088', 'PRM0003', 27000, 1),
('TRJ05949005', 'PRM0003', 27000, 1),
('TRJ0591213', 'PRM0001', 25000, 1),
('TRJ05913735', 'PRM0002', 20000, 1),
('TRJ05941731', 'SBN0001', 17000, 1),
('TRJ05921787', 'SBN0001', 17000, 1),
('TRJ05964532', 'PRM0001', 25000, 1),
('TRJ05964132', 'PRM0003', 27000, 1),
('TRJ05962904', 'PRM0003', 27000, 1),
('TRJ05984948', 'SBN0001', 17000, 1),
('TRJ05972650', 'SBN0001', 17000, 1),
('TRJ0596696', 'SBN0001', 17000, 1),
('TRJ0596696', 'PRM0003', 54000, 2),
('TRJ05945028', 'PRM0001', 25000, 1),
('TRJ05990610', 'SBN0001', 17000, 1),
('TRJ05948823', 'SBN0001', 17000, 1),
('TRJ05978419', 'PRM0003', 27000, 1),
('TRJ05954857', 'PRM0002', 20000, 1),
('TRJ05107015', 'PRM0002', 20000, 1),
('TRJ05109990', 'PRM0003', 54000, 2),
('TRJ05107877', 'PRM0002', 20000, 1),
('TRJ05107877', 'SBN0001', 17000, 1),
('TRJ05107877', 'PRM0003', 54000, 2),
('TRJ05107877', 'SBN0007', 45000, 3),
('TRJ05102847', 'SBN0001', 17000, 1),
('TRJ05102847', 'PRM0002', 20000, 1),
('TRJ05105388', 'PRM0003', 27000, 1),
('TRJ05106781', 'PRM0002', 20000, 1),
('TRJ05106537', 'SBN0001', 17000, 1),
('TRJ05106537', 'SBN0001', 17000, 1),
('TRJ05102170', 'SBN0001', 17000, 1),
('TRJ05102951', 'SBN0001', 17000, 1),
('TRJ05102951', 'PRM0002', 40000, 2),
('TRJ05109176', 'SBN0002', 15000, 1),
('TRJ05104064', 'PRM0001', 25000, 1),
('TRJ05104064', 'PRM0002', 40000, 2),
('TRJ05104064', 'PRM0003', 81000, 3);

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
('K003', 'PARFUM', '2022-05-01 09:34:25', '2022-05-01 09:34:25');

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
('PRM0001', 'parfum 1', 90, 10000, 25000, 'S001', 'K003', '2022-05-10 00:53:27', '2022-05-09 09:59:58', 0, 90),
('PRM0002', 'parfum 2', 66, 10000, 20000, 'S001', 'K003', '2022-05-10 00:53:27', '2022-05-09 10:00:16', 0, 66),
('PRM0003', 'parfum 3', 71, 25000, 27000, 'S001', 'K003', '2022-05-10 00:53:27', '2022-05-09 10:00:33', 0, 71),
('PRM0004', 'parfum ke 4', 12, 1, 2, 'S001', 'K003', '2022-05-10 00:50:12', '2022-05-10 00:50:12', 0, 12),
('SBN0001', 'sampo', 909, 15000, 17000, 'S001', 'K001', '2022-05-10 00:41:15', '2022-05-08 19:36:19', 0, 909),
('SBN0002', 'sampo condisioner', 52, 12300, 15000, 'S001', 'K001', '2022-05-10 00:43:11', '2022-05-08 19:36:40', 0, 52),
('SBN0003', 'sampo ke 3', 34, 2100, 2500, 'S001', 'K001', '2022-05-09 10:02:31', '2022-05-08 19:36:57', 0, 34),
('SBN0004', 'sabun ke 4', 99, 19000, 20000, 'S001', 'K001', '2022-05-09 10:02:31', '2022-05-09 10:00:51', 0, 99),
('SBN0005', 'sabun ke 5', 98, 10000, 20000, 'S001', 'K001', '2022-05-09 10:02:31', '2022-05-09 10:01:06', 0, 98),
('SBN0006', 'sabun ke 6', 98, 12000, 15000, 'S001', 'K001', '2022-05-09 14:47:38', '2022-05-09 10:01:19', 0, 98),
('SBN0007', 'sabun ke 7', 990, 12000, 15000, 'S001', 'K001', '2022-05-10 00:30:36', '2022-05-09 10:01:34', 0, 990),
('SMO0001', 'sampo ke 1', 989, 17000, 24000, 'S001', 'K002', '2022-05-09 14:47:38', '2022-05-09 10:01:51', 0, 989);

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
('S001', '2022-04-24 05:36:56', 'TR11638646'),
('S001', '2022-04-24 05:26:41', 'TR20611103'),
('S001', '2022-04-22 02:51:32', 'TR22503483'),
('S001', '2022-04-24 05:29:10', 'TR25121045'),
('S001', '2022-04-24 05:37:41', 'TR27982731'),
('S001', '2022-04-24 05:38:04', 'TR36500376'),
('S001', '2022-04-24 05:29:37', 'TR41126549'),
('S001', '2022-04-24 05:39:50', 'TR55881626'),
('S001', '2022-04-20 05:42:44', 'TR62166744'),
('S001', '2022-04-24 05:12:52', 'TR63713657'),
('S001', '2022-05-01 02:35:18', 'TR66484943'),
('S001', '2022-04-24 05:18:54', 'TR68143153'),
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
('234234', '2022-05-02 23:36:47', 23, 23, 'pgw001', 2323),
('TRJ05102170', '2022-05-10 00:39:09', 15300, 10000, 'pgw231', 0),
('TRJ05102847', '2022-05-10 00:36:59', 33300, 40000, 'pgw231', 6700),
('TRJ05102951', '2022-05-10 00:41:15', 57000, 60000, 'pgw231', 3000),
('TRJ05104064', '2022-05-10 00:53:27', 131400, 140000, 'pgw231', 8600),
('TRJ05105388', '2022-05-10 00:37:25', 24300, 25000, 'pgw231', 700),
('TRJ05106537', '2022-05-10 00:38:41', 16830, 10000, 'pgw231', 0),
('TRJ05106781', '2022-05-10 00:38:17', 18000, 20000, 'pgw231', 2000),
('TRJ05107015', '2022-05-10 00:23:02', 20000, 25000, 'pgw231', 5000),
('TRJ05107877', '2022-05-10 00:30:36', 136000, 140000, 'pgw231', 4000),
('TRJ05109176', '2022-05-10 00:43:11', 15000, 17000, 'pgw231', 2000),
('TRJ05109990', '2022-05-10 00:28:37', 54000, 60000, 'pgw231', 6000),
('TRJ05678627', '2022-05-06 14:28:39', 17000, 20000, 'pgw231', 3000),
('TRJ05720239', '2022-05-07 10:03:09', 2, 3, 'pgw231', 1),
('TRJ05726777', '2022-05-07 09:26:22', 19468, 20000, 'pgw231', 532),
('TRJ05727347', '2022-05-07 10:38:01', 2, 10, 'pgw231', 8),
('TRJ0572967', '2022-05-07 09:38:25', 6, 7, 'pgw231', 1),
('TRJ05730436', '2022-05-07 09:36:42', 4, 5, 'pgw231', 1),
('TRJ05734668', '2022-05-07 10:23:20', 2, 3, 'pgw231', 1),
('TRJ05735430', '2022-05-07 09:11:31', 17000, 17000, 'pgw231', 0),
('TRJ05736533', '2022-05-07 09:30:57', 1583468, 1583468, 'pgw231', 0),
('TRJ05741483', '2022-05-07 10:37:32', 30, 35, 'pgw231', 5),
('TRJ05741825', '2022-05-07 10:38:40', 4, 5, 'pgw231', 1),
('TRJ05745421', '2022-05-07 09:29:19', 6170, 7000, 'pgw231', 830),
('TRJ05751961', '2022-05-07 09:33:50', 20, 21, 'pgw231', 1),
('TRJ05762742', '2022-05-07 10:17:32', 2, 2, 'pgw231', 0),
('TRJ05766970', '2022-05-07 09:27:20', 19468, 20000, 'pgw231', 532),
('TRJ05783074', '2022-05-07 14:30:15', 11, 100000, 'pgw231', 99989),
('TRJ05783112', '2022-05-07 09:13:18', 17000, 18000, 'pgw231', 1000),
('TRJ05791405', '2022-05-07 10:04:14', 2, 3, 'pgw231', 1),
('TRJ05797576', '2022-05-07 09:14:11', 17000, 18000, 'pgw231', 1000),
('TRJ05830356', '2022-05-08 14:42:28', 439287, 439288, 'pgw231', 1),
('TRJ05860273', '2022-05-08 14:41:53', 439287, 5000000, 'pgw231', 4560713),
('TRJ05864060', '2022-05-08 14:44:08', 4344, 5000, 'pgw231', 656),
('TRJ05899816', '2022-05-08 14:45:38', 213123, 213124, 'pgw231', 1),
('TRJ05910879', '2022-05-08 20:01:31', 56500, 60000, 'pgw231', 3500),
('TRJ0591213', '2022-05-09 15:32:01', 25000, 30000, 'pgw231', 5000),
('TRJ05913735', '2022-05-09 15:34:56', 20000, 23333, 'pgw231', 3333),
('TRJ05913771', '2022-05-08 19:40:00', 237500, 240000, 'pgw231', 2500),
('TRJ05915054', '2022-05-08 18:27:58', 213123, 213124, 'pgw231', 1),
('TRJ05916037', '2022-05-09 15:15:16', 99000, 100000, 'pgw231', 1000),
('TRJ05916313', '2022-05-09 10:14:38', 25000, 27000, 'pgw231', 2000),
('TRJ05916804', '2022-05-08 20:19:53', 20000, 20000, 'pgw231', 0),
('TRJ05921380', '2022-05-09 11:08:37', 23760, 25000, 'pgw231', 1240),
('TRJ05921787', '2022-05-09 15:38:52', 17000, 20000, 'pgw231', 3000),
('TRJ05927744', '2022-05-09 09:43:05', 224000, 300000, 'pgw231', 76000),
('TRJ05930284', '2022-05-09 11:12:59', 291060, 2910600, 'pgw231', 2619540),
('TRJ05930824', '2022-05-08 18:32:43', 4344, 4344, 'pgw231', 0),
('TRJ05931324', '2022-05-08 20:14:13', 2500, 3000, 'pgw231', 500),
('TRJ05934493', '2022-05-08 18:28:47', 213123, 213124, 'pgw231', 1),
('TRJ05941587', '2022-05-08 17:43:37', 4344, 4345, 'pgw231', 1),
('TRJ05941731', '2022-05-09 15:37:45', 17000, 20000, 'pgw231', 3000),
('TRJ05942041', '2022-05-09 10:02:31', 346000, 400000, 'pgw231', 54000),
('TRJ05945028', '2022-05-09 15:55:58', 25000, 30000, 'pgw231', 5000),
('TRJ05947219', '2022-05-08 19:37:59', 67735, 70000, 'pgw231', 2265),
('TRJ0594730', '2022-05-08 18:29:55', 213123, 213123, 'pgw231', 0),
('TRJ0594832', '2022-05-08 19:56:52', 16245, 20000, 'pgw231', 3755),
('TRJ05948823', '2022-05-09 16:03:25', 17000, 20000, 'pgw231', 3000),
('TRJ05949005', '2022-05-09 15:28:46', 27000, 30000, 'pgw231', 3000),
('TRJ05949250', '2022-05-09 10:23:36', 202000, 205000, 'pgw231', 3000),
('TRJ0595138', '2022-05-09 09:36:23', 67000, 70000, 'pgw231', 3000),
('TRJ05952870', '2022-05-08 17:33:05', 4344, 4345, 'pgw231', 1),
('TRJ05953447', '2022-05-08 20:03:57', 1245, 2000, 'pgw231', 755),
('TRJ0595442', '2022-05-08 20:13:10', 15000, 20000, 'pgw231', 5000),
('TRJ05954700', '2022-05-09 14:47:38', 217000, 300000, 'pgw231', 83000),
('TRJ05954857', '2022-05-09 16:05:11', 20000, 25000, 'pgw231', 5000),
('TRJ05957489', '2022-05-08 18:35:57', 213123, 213123, 'pgw231', 0),
('TRJ05958625', '2022-05-09 13:54:02', 193000, 193000, 'pgw231', 0),
('TRJ05959084', '2022-05-08 18:31:41', 213123, 213124, 'pgw231', 1),
('TRJ05959942', '2022-05-08 20:23:01', 34500, 40000, 'pgw231', 5500),
('TRJ05962552', '2022-05-08 20:02:52', 15000, 20000, 'pgw231', 5000),
('TRJ05962904', '2022-05-09 15:46:38', 27000, 30000, 'pgw231', 3000),
('TRJ05964132', '2022-05-09 15:44:16', 27000, 30000, 'pgw231', 3000),
('TRJ05964532', '2022-05-09 15:40:05', 25000, 30000, 'pgw231', 5000),
('TRJ05964562', '2022-05-08 20:05:30', 16245, 20000, 'pgw231', 3755),
('TRJ0596522', '2022-05-08 19:59:07', 20000, 25000, 'pgw231', 5000),
('TRJ05965337', '2022-05-09 09:43:58', 386500, 400000, 'pgw231', 13500),
('TRJ0596696', '2022-05-09 15:50:06', 71000, 80000, 'pgw231', 9000),
('TRJ05968231', '2022-05-08 20:07:08', 17490, 20000, 'pgw231', 2510),
('TRJ05968522', '2022-05-09 15:16:54', 299000, 300000, 'pgw231', 1000),
('TRJ05969', '2022-05-08 17:49:58', 213123, 213124, 'pgw231', 1),
('TRJ0596945', '2022-05-08 20:09:11', 15000, 20000, 'pgw231', 5000),
('TRJ0597254', '2022-05-08 18:23:17', 213123, 213124, 'pgw231', 1),
('TRJ05972650', '2022-05-09 15:49:11', 17000, 20000, 'pgw231', 3000),
('TRJ05973206', '2022-05-09 10:18:33', 15000, 17000, 'pgw231', 2000),
('TRJ05973209', '2022-05-09 14:16:27', 27000, 28000, 'pgw231', 1000),
('TRJ05975540', '2022-05-09 09:39:27', 56500, 60000, 'pgw231', 3500),
('TRJ05976764', '2022-05-08 19:56:12', 35745, 40000, 'pgw231', 4255),
('TRJ05978419', '2022-05-09 16:03:54', 27000, 30000, 'pgw231', 3000),
('TRJ0597890', '2022-05-08 20:15:01', 371245, 400000, 'pgw231', 28755),
('TRJ05981161', '2022-05-08 19:58:12', 2500, 3000, 'pgw231', 500),
('TRJ05981778', '2022-05-08 20:24:26', 49000, 50000, 'pgw231', 1000),
('TRJ05981880', '2022-05-08 20:18:50', 54500, 60000, 'pgw231', 5500),
('TRJ05983197', '2022-05-08 19:50:09', 32000, 40000, 'pgw231', 8000),
('TRJ05983942', '2022-05-09 11:43:32', 27000, 30000, 'pgw231', 3000),
('TRJ05984362', '2022-05-08 19:45:12', 245000, 250000, 'pgw231', 5000),
('TRJ05984948', '2022-05-09 15:48:19', 17000, 20000, 'pgw231', 3000),
('TRJ05988218', '2022-05-08 20:12:07', 39490, 40000, 'pgw231', 510),
('TRJ05990610', '2022-05-09 16:00:26', 17000, 20000, 'pgw231', 3000),
('TRJ05990985', '2022-05-08 17:36:13', 4344, 4345, 'pgw231', 1),
('TRJ05992796', '2022-05-09 15:18:08', 27000, 30000, 'pgw231', 3000),
('TRJ05993399', '2022-05-09 15:26:30', 27000, 30000, 'pgw231', 3000),
('TRJ05995002', '2022-05-08 18:26:45', 4344, 4444, 'pgw231', 100),
('TRJ05995850', '2022-05-09 14:15:20', 17000, 18000, 'pgw231', 1000),
('TRJ05997088', '2022-05-09 15:27:28', 27000, 30000, 'pgw231', 3000),
('TRJ05998722', '2022-05-08 20:17:10', 68500, 70000, 'pgw231', 1500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beli_product`
--
ALTER TABLE `beli_product`
  ADD PRIMARY KEY (`id_beliProduct`),
  ADD KEY `supplier` (`supplier`);

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
  ADD CONSTRAINT `beli_product_ibfk_1` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

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
