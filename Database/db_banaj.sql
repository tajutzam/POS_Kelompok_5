-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2022 at 03:12 AM
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
('TR90743025', 'SMO0005', 0);

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
-- Triggers `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `kurang_stok` BEFORE INSERT ON `detail_transaksi` FOR EACH ROW update product
set stok=stok-new.qty
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
('kt001', 'sampo', '2022-03-23 15:36:49', '2022-03-23 15:36:49'),
('kt002', 'sabun', '2022-04-03 09:55:29', '2022-04-03 09:55:29'),
('kt003', 'sabun wajah', '2022-04-03 09:55:38', '2022-04-03 09:55:38');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(8) NOT NULL,
  `nama_pegawai` varchar(64) NOT NULL,
  `username` varchar(32) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `username`, `create_at`, `update_at`) VALUES
('pgw001', 'ucup', 'ucup', '2022-03-23 15:37:52', '2022-03-23 15:37:52');

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
('SBN0001', 'sabun 1', 990, 10000, 20000, 'sup001', 'kt002', '2022-04-08 13:04:57', '2022-04-08 13:04:57', 10, 1000),
('SMO0001', 'sampo 1', 100, 20000, 25000, 'sup001', 'kt001', '2022-04-08 13:02:26', '2022-04-08 13:02:26', 0, 100),
('SMO0002', 'sampo 2', 100, 12000, 15000, 'sup001', 'kt001', '2022-04-08 13:02:49', '2022-04-08 13:02:49', 20, 120),
('SMO0003', 'sampo 3', 100, 10000, 15000, 'sup001', 'kt001', '2022-04-08 13:04:28', '2022-04-08 13:04:28', 20, 120),
('SMO0004', 'sampo 4', 12, 123, 1234, 'sup001', 'kt001', '2022-04-10 12:39:16', '2022-04-10 12:39:16', 0, 12),
('SMO0005', 'sampo 5', 10, 123, 124, 'sup001', 'kt001', '2022-04-12 09:36:17', '2022-04-12 09:36:17', 0, 10);

--
-- Triggers `product`
--
DELIMITER $$
CREATE TRIGGER `delete_retur` AFTER UPDATE ON `product` FOR EACH ROW DELETE from detail_retur where jumlah_rusak =0
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
('sup001', '2022-04-12 02:37:57', 'TR90743025');

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
('sup001', 'banaj', '2022-03-23 15:36:18', '2022-03-23 15:36:18');

-- --------------------------------------------------------

--
-- Table structure for table `toko`
--

CREATE TABLE `toko` (
  `id_toko` varchar(8) NOT NULL,
  `nama_toko` varchar(64) NOT NULL,
  `alamat_toko` varchar(128) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `tanggal_transaksi` datetime NOT NULL,
  `grand_total` int(32) NOT NULL,
  `bayar` int(32) NOT NULL,
  `id_pegawai` varchar(8) NOT NULL,
  `kembali` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal_transaksi`, `grand_total`, `bayar`, `id_pegawai`, `kembali`) VALUES
('tr0012', '2022-03-23 15:38:26', 100000, 1000000, 'pgw001', 0);

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
  ADD CONSTRAINT `beli_product_ibfk_2` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

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
