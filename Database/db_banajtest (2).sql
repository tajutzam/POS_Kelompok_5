-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2022 at 07:56 PM
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
('TRB0653434', 'S001', '2022-06-05', 'K001', 125000, 'PGW004', 125000, 0, 5, 6),
('TRB065457', 'S001', '2022-06-05', 'K001', 500000, 'PGW004', 500000, 0, 5, 6),
('TRB0655884', 'S001', '2022-06-05', 'K001', 1476, 'PGW004', 1500, 24, 5, 6),
('TRB0655920', 'S001', '2022-06-05', 'K001', 500000, 'PGW004', 500000, 0, 5, 6),
('TRB0655998', 'S001', '2022-06-05', 'K001', 600000, 'PGW004', 600000, 0, 5, 6),
('TRB0657367', 'S001', '2022-06-05', 'K001', 984, 'PGW004', 1000, 16, 5, 6),
('TRB0663527', 'S001', '2022-06-06', 'K002', 250000, 'PGW004', 250000, 0, 6, 6),
('TRB0664206', 'S001', '2022-06-06', 'K002', 50000, 'PGW004', 50000, 0, 6, 6);

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
('TRB0655998', 20, 'DON0001'),
('TRB0655920', 20, 'DON0002'),
('TRB065457', 20, 'DON0003'),
('TRB0653434', 5, 'DON0003'),
('TRB0664206', 100, 'SMO0001'),
('TRB0663527', 100, 'SMO0002'),
('TRB0663527', 100, 'SMO0003'),
('TRB0663527', 100, 'SMO0004'),
('TRB0663527', 100, 'SMO0005'),
('TRB0663527', 100, 'SMO0006');

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
('TR19104324', 'SBN0002', 1),
('TR65013380', 'SBN0003', 3),
('TR7366848', 'SBN0004', 4),
('TR55321240', 'SBN0005', 2),
('TR86494290', 'SBN0003', 2);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `kode_product` varchar(8) NOT NULL,
  `sub_total` varchar(32) NOT NULL,
  `qty` int(32) NOT NULL,
  `sub_pembelian` int(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_transaksi`, `kode_product`, `sub_total`, `qty`, `sub_pembelian`) VALUES
('TRJ0652970', 'DON0003', '30000', 1, 25000),
('TRJ065711', 'DON0003', '30000', 1, 25000),
('TRJ0652331', 'DON0003', '30000', 1, 25000),
('TRJ0655294', 'DON0003', '30000', 1, 25000),
('TRJ0654968', 'DON0003', '30000', 1, 25000);

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
('K001', 'DEODORAN', '2022-06-05 17:02:15', '2022-06-05 17:02:15'),
('K002', 'SAMPO', '2022-06-05 17:02:22', '2022-06-05 17:02:22');

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
('PGW004', 'ZEN ZEN', 'admin', '2022-05-03 12:14:04', '2022-05-03 12:14:04', 1, 'Aktif', 'admin'),
('PGW005', 'ZAM ZAM', 'KASIR', '2022-06-05 08:41:51', '2022-06-05 08:41:51', 1, 'Aktif', 'KASIR');

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
('DON0001', 'DEO DUPA WANGY SUSU', 20, 30000, 35000, 'S001', 'K001', '2022-06-05 10:04:24', '2022-06-05 10:04:24', 0, 20),
('DON0002', 'DEO WANGY EXOTIS', 20, 25000, 30000, 'S001', 'K001', '2022-06-05 10:05:18', '2022-06-05 10:05:18', 0, 20),
('DON0003', 'DEO ROLL MULTIFUNGSI', 20, 25000, 30000, 'S001', 'K001', '2022-06-05 10:23:55', '2022-06-05 10:08:38', 0, 20),
('SMO0001', 'SUNSLIK', 100, 500, 1000, 'S001', 'K002', '2022-06-06 12:11:55', '2022-06-06 12:11:55', 0, 100),
('SMO0002', 'PENTENE', 100, 500, 1000, 'S001', 'K002', '2022-06-06 12:17:24', '2022-06-06 12:17:24', 0, 100),
('SMO0003', 'ZINK', 100, 500, 1000, 'S001', 'K002', '2022-06-06 12:17:24', '2022-06-06 12:17:24', 0, 100),
('SMO0004', 'EMERON', 100, 500, 1000, 'S001', 'K002', '2022-06-06 12:17:24', '2022-06-06 12:17:24', 0, 100),
('SMO0005', 'DOVE', 100, 500, 1000, 'S001', 'K002', '2022-06-06 12:17:24', '2022-06-06 12:17:24', 0, 100),
('SMO0006', 'LIVEBOY', 100, 500, 1000, 'S001', 'K002', '2022-06-06 12:17:24', '2022-06-06 12:17:24', 0, 100);

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
('S001', '2022-06-05 05:46:23', 'TR19104324'),
('S001', '2022-06-05 05:57:38', 'TR55321240'),
('S001', '2022-06-05 05:50:08', 'TR65013380'),
('S001', '2022-06-05 05:54:51', 'TR7366848'),
('S001', '2022-06-05 06:11:26', 'TR86494290');

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
('S002', 'PARFUM STORE', '2022-06-05 16:56:08', '2022-06-05 16:56:08');

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
('TRJ0652331', '2022-06-05', 30000, 30000, 'PGW004', 0, 25000, 6, 5),
('TRJ0652970', '2022-06-05', 27000, 30000, 'PGW004', 3000, 25000, 6, 5),
('TRJ0654968', '2022-06-05', 30000, 30000, 'PGW004', 0, 25000, 6, 5),
('TRJ0655294', '2022-06-05', 30000, 30000, 'PGW004', 0, 25000, 6, 5),
('TRJ065711', '2022-06-05', 30000, 30000, 'PGW004', 0, 25000, 6, 5);

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
  ADD CONSTRAINT `detail_transaksi_ibfk_3` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

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
