-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 26, 2022 at 05:38 PM
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
-- Database: `db_banajtest`
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
  `kembalian` int(32) NOT NULL,
  `bulan` int(12) NOT NULL,
  `hari` int(12) NOT NULL
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
('TR64526849', 'SBN0027', 1),
('TR96060778', 'SBN0002', 1),
('TR63754922', 'PRM0007', 2),
('TR76933264', 'SMO0001', 11);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `kode_product` varchar(8) NOT NULL,
  `sub_total` int(32) NOT NULL,
  `qty` int(32) NOT NULL,
  `sub_pembelian` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
('K004', 'BARU', '2022-05-25 19:51:19', '2022-05-25 19:51:19'),
('K005', 'SA', '2022-05-25 19:53:40', '2022-05-25 19:53:40'),
('K006', 'Y', '2022-05-26 10:32:58', '2022-05-26 10:32:58'),
('K007', 'SA', '2022-05-26 10:36:04', '2022-05-26 10:36:04'),
('K008', 'KO', '2022-05-26 10:39:55', '2022-05-26 10:39:55'),
('K009', 'S', '2022-05-26 10:40:51', '2022-05-26 10:40:51'),
('K010', 'B', '2022-05-26 10:42:56', '2022-05-26 10:42:56'),
('K011', 'W', '2022-05-26 10:43:14', '2022-05-26 10:43:14'),
('K012', 'D', '2022-05-26 10:47:34', '2022-05-26 10:47:34'),
('K013', 'TEST', '2022-05-26 10:48:32', '2022-05-26 10:48:32'),
('K014', 'OH', '2022-05-26 10:58:20', '2022-05-26 10:58:20'),
('K015', '1', '2022-05-26 10:59:21', '2022-05-26 10:59:21'),
('K016', 'D', '2022-05-26 11:00:57', '2022-05-26 11:00:57'),
('K017', 'D', '2022-05-26 11:01:49', '2022-05-26 11:01:49'),
('K018', 'SASD', '2022-05-26 11:03:56', '2022-05-26 11:03:56'),
('K019', 'SADASD', '2022-05-26 11:04:32', '2022-05-26 11:04:32'),
('K020', 'ASD', '2022-05-26 11:05:20', '2022-05-26 11:05:20'),
('K021', 'SD', '2022-05-26 11:09:51', '2022-05-26 11:09:51'),
('K022', 'D', '2022-05-26 11:10:14', '2022-05-26 11:10:14'),
('K023', 'AD', '2022-05-26 11:10:45', '2022-05-26 11:10:45'),
('K024', 'ASD', '2022-05-26 11:11:15', '2022-05-26 11:11:15'),
('K025', 'SAD', '2022-05-26 11:12:30', '2022-05-26 11:12:30'),
('K026', 'ADS', '2022-05-26 11:14:29', '2022-05-26 11:14:29'),
('K027', 'SA', '2022-05-26 15:38:33', '2022-05-26 15:38:33');

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
  `status` enum('Aktif','Tidak Aktif') NOT NULL DEFAULT 'Aktif',
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `username`, `create_at`, `update_at`, `role`, `status`, `password`) VALUES
('PGW001', 'ZAM ZAMI', 'kasir', '2022-05-26 17:34:55', '2022-05-26 17:34:55', 1, 'Aktif', 'kasir'),
('PGW002', 'ZEN', 'admin', '2022-05-26 17:35:28', '2022-05-26 17:35:28', 2, 'Aktif', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `kode_product` varchar(8) NOT NULL,
  `nama_product` varchar(128) NOT NULL,
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
('S001', '2022-05-25 02:50:34', 'TR63754922'),
('S001', '2022-05-19 11:39:42', 'TR64526849'),
('S001', '2022-05-01 02:35:18', 'TR66484943'),
('S001', '2022-04-24 05:18:54', 'TR68143153'),
('S001', '2022-05-16 09:42:24', 'TR68891552'),
('S002', '2022-05-25 02:57:00', 'TR76933264'),
('S001', '2022-04-24 05:09:41', 'TR77425670'),
('S001', '2022-04-25 13:06:19', 'TR7861542'),
('S001', '2022-04-24 05:18:30', 'TR94679531'),
('S001', '2022-04-24 05:04:09', 'TR95120590'),
('S001', '2022-05-25 00:35:06', 'TR96060778'),
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
  `kembali` int(32) NOT NULL,
  `bulan` int(32) NOT NULL,
  `grand_modal` int(32) NOT NULL,
  `hari` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  ADD CONSTRAINT `beli_product_ibfk_1` FOREIGN KEY (`pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
