-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2022 at 05:00 PM
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
  `tanggal_beliProduct` date NOT NULL,
  `kategori` varchar(8) NOT NULL,
  `grand_total` int(32) NOT NULL,
  `pegawai` varchar(8) NOT NULL,
  `bayar` int(32) NOT NULL,
  `kembalian` int(32) NOT NULL,
  `hari` int(12) NOT NULL,
  `bulan` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `beli_product`
--

INSERT INTO `beli_product` (`id_beliProduct`, `supplier`, `tanggal_beliProduct`, `kategori`, `grand_total`, `pegawai`, `bayar`, `kembalian`, `hari`, `bulan`) VALUES
('TRB06235589', 'S001', '2022-06-23', 'K002', 900000, 'PGW004', 900000, 0, 23, 6),
('TRB06235765', 'S001', '2022-06-23', 'K005', 1050000, 'PGW004', 1050000, 0, 23, 6),
('TRB06236874', 'S001', '2022-06-23', 'K001', 300000, 'PGW004', 300000, 0, 23, 6),
('TRB06237679', 'S001', '2022-06-23', 'K003', 800000, 'PGW004', 800000, 0, 23, 6),
('TRB06237913', 'S001', '2022-06-23', 'K001', 300000, 'PGW004', 300000, 0, 23, 6),
('TRB062382', 'S001', '2022-06-23', 'K001', 300000, 'PGW004', 300000, 0, 23, 6);

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
('TRB062382', 10, 'DON0001'),
('TRB06236874', 10, 'DON0002'),
('TRB06237679', 10, 'SAO0001'),
('TRB06237679', 10, 'SAO0002'),
('TRB06237679', 10, 'SAO0003'),
('TRB06235589', 10, 'PRM0001'),
('TRB06235589', 10, 'PRM0002'),
('TRB06235765', 10, 'SBN0001'),
('TRB06235765', 10, 'SBN0002'),
('TRB06235765', 10, 'SBN0003');

-- --------------------------------------------------------

--
-- Table structure for table `detail_retur`
--

CREATE TABLE `detail_retur` (
  `id_returSupplier` varchar(11) NOT NULL,
  `product` varchar(32) NOT NULL,
  `jumlah_rusak` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `kode_product` varchar(8) NOT NULL,
  `sub_total` varchar(32) NOT NULL,
  `qty` int(32) NOT NULL,
  `sub_pembelian` int(64) NOT NULL,
  `kode_kategori` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_transaksi`, `kode_product`, `sub_total`, `qty`, `sub_pembelian`, `kode_kategori`) VALUES
('TRJ06238476', 'SAO0001', '30000', 1, 25000, 'K003'),
('TRJ06238476', 'SAO0002', '30000', 1, 25000, 'K003'),
('TRJ06233102', 'PRM0002', '47000', 1, 45000, 'K002'),
('TRJ06233102', 'PRM0001', '50000', 1, 45000, 'K002'),
('TRJ06233102', 'DON0002', '35000', 1, 30000, 'K001'),
('TRJ06233102', 'DON0001', '35000', 1, 30000, 'K001'),
('TRJ06233102', 'SAO0003', '35000', 1, 30000, 'K003'),
('TRJ06233102', 'SBN0001', '37000', 1, 35000, 'K005'),
('TRJ06233102', 'SBN0002', '37000', 1, 35000, 'K005'),
('TRJ06233102', 'SBN0003', '37000', 1, 35000, 'K005');

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
('K001', 'DEODORAN', '2022-06-23 17:20:04', '2022-06-23 17:20:04'),
('K002', 'PARFUM', '2022-06-23 17:39:14', '2022-06-23 17:39:14'),
('K003', 'SHAMPO', '2022-06-23 17:39:23', '2022-06-23 17:39:23'),
('K004', 'LULUR', '2022-06-23 17:39:31', '2022-06-23 17:39:31'),
('K005', 'SABUN', '2022-06-23 17:39:40', '2022-06-23 17:39:40');

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
  `status` enum('Aktif','Tidak Aktif') NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `username`, `create_at`, `update_at`, `role`, `status`, `password`) VALUES
('PGW004', 'ZENN ZEN', 'admin', '2022-06-12 16:57:33', '2022-06-12 16:57:33', 1, 'Aktif', 'admin'),
('PGW005', 'ZAM ZAMI', 'kasir', '2022-06-23 17:45:45', '2022-06-23 17:45:45', 2, 'Aktif', 'kasir');

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
('DON0001', 'DEO ROLL ON 25 ML DEODORANT BANAJ BEAUTY CARE', 9, 30000, 35000, 'S001', 'K001', '2022-06-23 10:50:37', '2022-06-23 10:36:24', 0, 9),
('DON0002', 'DEO BANAJ', 9, 30000, 35000, 'S001', 'K001', '2022-06-23 10:50:37', '2022-06-23 10:38:58', 0, 9),
('PRM0001', 'PARFUM PREMIUM BANAJ BEAUTY CARE', 9, 45000, 50000, 'S001', 'K002', '2022-06-23 10:50:37', '2022-06-23 10:42:39', 0, 9),
('PRM0002', 'Parfum Banaj-Parfum All in 1', 9, 45000, 47000, 'S001', 'K002', '2022-06-23 10:50:37', '2022-06-23 10:42:39', 0, 9),
('SAO0001', 'Shampo Herbal Banaj', 9, 25000, 30000, 'S001', 'K003', '2022-06-23 10:49:55', '2022-06-23 10:41:12', 0, 9),
('SAO0002', 'shampo banaj varian dupa', 9, 25000, 30000, 'S001', 'K003', '2022-06-23 10:49:55', '2022-06-23 10:41:12', 0, 9),
('SAO0003', 'shampo banaj varian susu', 9, 30000, 35000, 'S001', 'K003', '2022-06-23 10:50:37', '2022-06-23 10:41:12', 0, 9),
('SBN0001', 'Sabun banaj', 9, 35000, 37000, 'S001', 'K005', '2022-06-23 10:50:37', '2022-06-23 10:44:50', 0, 9),
('SBN0002', 'Sabun rempah ', 9, 35000, 37000, 'S001', 'K005', '2022-06-23 10:50:37', '2022-06-23 10:44:50', 0, 9),
('SBN0003', 'Sabun susu dupa', 9, 35000, 37000, 'S001', 'K005', '2022-06-23 10:50:37', '2022-06-23 10:44:50', 0, 9);

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
('S001', 'BANAJ', '2022-06-23 17:35:45', '2022-06-23 17:35:45');

-- --------------------------------------------------------

--
-- Table structure for table `toko`
--

CREATE TABLE `toko` (
  `id_toko` varchar(8) NOT NULL,
  `nama_toko` varchar(64) NOT NULL,
  `alamat_toko` varchar(128) NOT NULL,
  `create_at` datetime NOT NULL,
  `update_at` date NOT NULL,
  `no_hp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `toko`
--

INSERT INTO `toko` (`id_toko`, `nama_toko`, `alamat_toko`, `create_at`, `update_at`, `no_hp`) VALUES
('TOKO01', 'BANAJ FRAGRANCE MOSLEM', 'Jl. Sumatra Gang 7 Jember', '2022-05-08 21:38:52', '2022-05-30', '085907185972');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `tanggal_transaksi` date NOT NULL,
  `grand_total` int(32) NOT NULL,
  `bayar` int(32) NOT NULL,
  `id_pegawai` varchar(8) NOT NULL,
  `kembali` int(32) NOT NULL,
  `grand_modal` int(64) NOT NULL,
  `bulan` int(12) NOT NULL,
  `hari` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal_transaksi`, `grand_total`, `bayar`, `id_pegawai`, `kembali`, `grand_modal`, `bulan`, `hari`) VALUES
('TRJ06233102', '2022-06-23', 313000, 313000, 'PGW004', 0, 285000, 6, 23),
('TRJ06238476', '2022-06-23', 60000, 60000, 'PGW004', 0, 50000, 6, 23);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `beli_product`
--
ALTER TABLE `beli_product`
  ADD PRIMARY KEY (`id_beliProduct`),
  ADD KEY `supplier` (`supplier`),
  ADD KEY `kategori` (`kategori`);

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
  ADD KEY `kode_product` (`kode_product`),
  ADD KEY `kode_kategori` (`kode_kategori`);

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
  ADD CONSTRAINT `beli_product_ibfk_2` FOREIGN KEY (`kategori`) REFERENCES `kategori` (`kode_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`kode_product`) REFERENCES `product` (`kode_product`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_ibfk_3` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_ibfk_4` FOREIGN KEY (`kode_kategori`) REFERENCES `kategori` (`kode_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

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
