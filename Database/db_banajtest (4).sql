-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2022 at 08:20 PM
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
('TRB06122760', 'S001', '2022-06-12', 'K001', 1200000, 'PGW004', 1080000, 0, 12, 6),
('TRB06123948', 'S001', '2022-06-12', 'K002', 1500000, 'PGW004', 1500000, 0, 12, 6),
('TRB06125714', 'S001', '2022-06-12', 'K001', 360000, 'PGW004', 360000, 0, 12, 6),
('TRB06126058', 'S002', '2022-06-12', 'K004', 520000, 'PGW004', 520000, 0, 12, 6),
('TRB06127797', 'S001', '2022-06-12', 'K005', 630000, 'PGW004', 630000, 0, 12, 6);

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
('TRB06125714', 12, 'DON0001'),
('TRB06122760', 10, 'DON0002'),
('TRB06122760', 10, 'DON0003'),
('TRB06122760', 10, 'DON0004'),
('TRB06122760', 10, 'DON0005'),
('TRB06123948', 10, 'PFM0001'),
('TRB06123948', 10, 'PFM0002'),
('TRB06123948', 10, 'PFM0003'),
('TRB06123948', 10, 'PFM0004'),
('TRB06126058', 10, 'SAO0001'),
('TRB06126058', 10, 'SAO0002'),
('TRB06127797', 10, 'CNR0001'),
('TRB06127797', 10, 'CNR0002'),
('TRB06127797', 10, 'CNR0003');

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
  `sub_pembelian` int(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_transaksi`, `kode_product`, `sub_total`, `qty`, `sub_pembelian`) VALUES
('TRJ06126738', 'DON0001', '35000', 1, 30000),
('TRJ06125826', 'PFM0002', '45000', 1, 40000),
('TRJ06125826', 'CNR0003', '25000', 1, 23000),
('TRJ06125826', 'CNR0002', '22000', 1, 20000),
('TRJ06125826', 'PFM0003', '35000', 1, 30000),
('TRJ06125826', 'SAO0001', '30000', 1, 27000),
('TRJ06125826', 'SAO0002', '30000', 1, 25000),
('TRJ05121112', 'DON0005', '35000', 1, 30000),
('TRJ05121112', 'PFM0001', '50000', 1, 45000),
('TRJ05121112', 'PFM0002', '45000', 1, 40000),
('TRJ05121112', 'PFM0003', '35000', 1, 30000),
('TRJ05121112', 'CNR0002', '22000', 1, 20000),
('TRJ05121112', 'CNR0003', '25000', 1, 23000),
('TRJ06126418', 'CNR0002', '22000', 1, 20000),
('TRJ06126418', 'SAO0001', '30000', 1, 27000),
('TRJ06126418', 'SAO0002', '30000', 1, 25000),
('TRJ06126418', 'DON0002', '35000', 1, 30000),
('TRJ06126418', 'DON0001', '35000', 1, 30000),
('TRJ06126418', 'DON0003', '35000', 1, 30000),
('TRJ06126418', 'PFM0004', '40000', 1, 35000),
('TRJ03121469', 'CNR0002', '22000', 1, 20000),
('TRJ06128389', 'CNR0002', '22000', 1, 20000),
('TRJ02121872', 'PFM0003', '35000', 1, 30000),
('TRJ06126412', 'SAO0001', '30000', 1, 27000),
('TRJ04121145', 'SAO0002', '30000', 1, 25000),
('TRJ06126617', 'SAO0002', '30000', 1, 25000),
('TRJ01122168', 'SAO0002', '30000', 1, 25000);

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
('K001', 'DEODORAN', '2022-06-12 12:03:57', '2022-06-12 12:03:57'),
('K002', 'PAFRUM', '2022-06-12 15:32:38', '2022-06-12 15:32:38'),
('K003', 'LULUR', '2022-06-12 15:33:02', '2022-06-12 15:33:02'),
('K004', 'SHAMPO', '2022-06-12 15:33:26', '2022-06-12 15:33:26'),
('K005', 'CONDISIONER', '2022-06-12 15:34:42', '2022-06-12 15:34:42'),
('K006', 'MASKER WAJAH', '2022-06-12 15:35:34', '2022-06-12 15:35:34'),
('K007', 'SABUN', '2022-06-12 15:35:45', '2022-06-12 15:35:45');

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
('PGW005', 'ZAM ZAMI', 'KASIR', '2022-06-12 16:14:37', '2022-06-12 16:14:37', 2, 'Aktif', 'kasir');

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
('CNR0001', 'conditioner banaj beauty care', 10, 20000, 22000, 'S001', 'K005', '2022-06-12 08:47:12', '2022-06-12 08:47:12', 0, 10),
('CNR0002', 'condisioner banaj varian dupa', 5, 20000, 22000, 'S001', 'K005', '2022-06-12 08:49:53', '2022-06-12 08:47:12', 0, 5),
('CNR0003', 'condisioner banaj varian jeruk', 8, 23000, 25000, 'S001', 'K005', '2022-06-12 08:48:42', '2022-06-12 08:47:12', 0, 8),
('DON0001', 'DEODORAN ', 10, 30000, 35000, 'S001', 'K001', '2022-06-12 08:49:11', '2022-06-12 05:04:31', 0, 10),
('DON0002', 'deo roll on', 9, 30000, 35000, 'S001', 'K001', '2022-06-12 08:49:11', '2022-06-12 08:38:50', 0, 9),
('DON0003', 'deo roll on dupa', 9, 30000, 35000, 'S001', 'K001', '2022-06-12 08:49:11', '2022-06-12 08:38:50', 0, 9),
('DON0004', 'deo roll on jeruk', 10, 30000, 35000, 'S001', 'K001', '2022-06-12 08:38:50', '2022-06-12 08:38:50', 0, 10),
('DON0005', 'deo roll on rempah', 9, 30000, 35000, 'S001', 'K001', '2022-06-12 08:48:42', '2022-06-12 08:38:50', 0, 9),
('PFM0001', 'parfum premium banaj beauty care', 9, 45000, 50000, 'S001', 'K002', '2022-06-12 08:48:42', '2022-06-12 08:42:09', 0, 9),
('PFM0002', 'parfum aisyah banaj', 8, 40000, 45000, 'S001', 'K002', '2022-06-12 08:48:42', '2022-06-12 08:42:09', 0, 8),
('PFM0003', 'Sabrina Parfum Banaj', 7, 30000, 35000, 'S001', 'K002', '2022-06-12 08:50:02', '2022-06-12 08:42:09', 0, 7),
('PFM0004', 'Parfum Man Banaj', 9, 35000, 40000, 'S001', 'K002', '2022-06-12 08:49:11', '2022-06-12 08:42:09', 0, 9),
('SAO0001', 'Shampo Banaj Beauty Care', 7, 27000, 30000, 'S002', 'K004', '2022-06-12 08:50:16', '2022-06-12 08:45:12', 0, 7),
('SAO0002', 'shampo herbal banaj', 5, 25000, 30000, 'S002', 'K004', '2022-06-12 08:50:42', '2022-06-12 08:45:12', 0, 5);

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
('S001', 'DEODORAN SUPPLIER', '2022-06-12 12:04:09', '2022-06-12 12:04:09'),
('S002', 'banaj', '2022-06-12 15:35:54', '2022-06-12 15:35:54');

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
('TRJ01122168', '2022-01-12', 30000, 3232230, 'PGW004', 3202230, 25000, 1, 12),
('TRJ02121872', '2022-02-12', 35000, 23000, 'PGW004', 0, 30000, 2, 12),
('TRJ03121469', '2022-03-12', 22000, 25000, 'PGW004', 3000, 20000, 3, 12),
('TRJ04121145', '2022-04-12', 30000, 32000, 'PGW004', 2000, 25000, 4, 12),
('TRJ05121112', '2022-05-12', 212000, 215000, 'PGW004', 3000, 188000, 5, 12),
('TRJ06125826', '2022-06-12', 187000, 200000, 'PGW004', 13000, 165000, 6, 12),
('TRJ06126412', '2022-06-12', 30000, 30000, 'PGW004', 0, 27000, 6, 12),
('TRJ06126418', '2022-06-12', 227000, 230000, 'PGW004', 3000, 197000, 6, 12),
('TRJ06126617', '2022-06-12', 30000, 30000, 'PGW004', 0, 25000, 6, 12),
('TRJ06126738', '2022-06-12', 35000, 25000, 'PGW004', 0, 30000, 6, 12),
('TRJ06128389', '2022-06-12', 22000, 22000, 'PGW004', 0, 20000, 6, 12);

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
