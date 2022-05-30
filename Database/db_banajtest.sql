-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 30 Bulan Mei 2022 pada 05.52
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.10

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
-- Struktur dari tabel `beli_product`
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
-- Dumping data untuk tabel `beli_product`
--

INSERT INTO `beli_product` (`id_beliProduct`, `supplier`, `tanggal_beliProduct`, `kategori`, `grand_total`, `pegawai`, `bayar`, `kembalian`, `hari`, `bulan`) VALUES
('TRB05301630', 'S001', '2022-05-30', 'K001', 10000, 'PGW004', 15000, 5000, 30, 5),
('TRB05308236', 'S001', '2022-05-30', 'K002', 20000, 'PGW004', 25000, 5000, 30, 5),
('TRB05308712', 'S001', '2022-05-30', 'K001', 20000, 'PGW004', 20000, 0, 30, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_beli_product`
--

CREATE TABLE `detail_beli_product` (
  `id_beliProduct` varchar(11) NOT NULL,
  `jumlahBeli` int(32) NOT NULL,
  `product` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_beli_product`
--

INSERT INTO `detail_beli_product` (`id_beliProduct`, `jumlahBeli`, `product`) VALUES
('TRB05301630', 10, 'SBN0001'),
('TRB05308236', 10, 'SMO0001'),
('TRB05308712', 10, 'SBN0002');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_retur`
--

CREATE TABLE `detail_retur` (
  `id_returSupplier` varchar(11) NOT NULL,
  `product` varchar(32) NOT NULL,
  `jumlah_rusak` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_retur`
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
('TR6204850', 'SBN0020', 12);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_transaksi` varchar(11) NOT NULL,
  `kode_product` varchar(8) NOT NULL,
  `sub_total` varchar(32) NOT NULL,
  `qty` int(32) NOT NULL,
  `sub_pembelian` int(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_transaksi`, `kode_product`, `sub_total`, `qty`, `sub_pembelian`) VALUES
('TRJ05304577', 'SMO0001', '2500', 1, 2000);

--
-- Trigger `detail_transaksi`
--
DELIMITER $$
CREATE TRIGGER `kurang_stok` BEFORE INSERT ON `detail_transaksi` FOR EACH ROW update product
set stok=stok-new.qty , total_stok = stok+rusak where kode_product =new.kode_product
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori`
--

CREATE TABLE `kategori` (
  `kode_kategori` varchar(8) NOT NULL,
  `nama_kategori` varchar(64) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kategori`
--

INSERT INTO `kategori` (`kode_kategori`, `nama_kategori`, `create_at`, `update_at`) VALUES
('K001', 'SABUN', '2022-04-30 19:17:41', '2022-04-30 19:17:41'),
('K002', 'SAMPO', '2022-04-30 19:18:31', '2022-04-30 19:18:31'),
('K003', 'PARFUM', '2022-05-01 09:34:25', '2022-05-01 09:34:25'),
('K004', 'KATEGORI BARU', '2022-05-16 14:31:24', '2022-05-16 14:31:24');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pegawai`
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
-- Dumping data untuk tabel `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `username`, `create_at`, `update_at`, `role`, `status`, `password`) VALUES
('pgw001', 'ucup', 'ucup', '2022-03-23 15:37:52', '2022-03-23 15:37:52', 0, '', ''),
('PGW002', 'NAMA QW', 'qw', '2022-04-26 12:24:24', '2022-04-26 12:24:24', 1, '', 'qw'),
('PGW003', 'SDFD DFD', 'dfd', '2022-04-26 12:35:32', '2022-04-26 12:35:32', 1, '', 'dfd'),
('PGW004', 'ZEN', 'admin', '2022-05-03 12:14:04', '2022-05-03 12:14:04', 1, 'Aktif', 'admin'),
('PGW005', 'USER 12', '12', '2022-05-03 12:14:23', '2022-05-03 12:14:23', 2, '', '12'),
('pgw231', 'ya', 'a', '2022-05-03 14:26:11', '2022-05-03 14:26:11', 1, '', 'a');

-- --------------------------------------------------------

--
-- Struktur dari tabel `product`
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
-- Dumping data untuk tabel `product`
--

INSERT INTO `product` (`kode_product`, `nama_product`, `stok`, `harga_beli`, `harga_jual`, `supplier`, `kategori`, `create_at`, `update_at`, `rusak`, `total_stok`) VALUES
('SBN0001', 'sabun', 8, 1000, 1500, 'S001', 'K001', '2022-05-30 01:58:31', '2022-05-30 01:21:23', 0, 8),
('SBN0002', 'sabun banaj 2', 10, 2000, 3000, 'S001', 'K001', '2022-05-30 02:19:44', '2022-05-30 02:19:44', 0, 10),
('SMO0001', 'sampo', 9, 2000, 2500, 'S001', 'K002', '2022-05-30 02:06:06', '2022-05-30 01:30:54', 0, 9);

--
-- Trigger `product`
--
DELIMITER $$
CREATE TRIGGER `delete_retur` BEFORE UPDATE ON `product` FOR EACH ROW DELETE from detail_retur where jumlah_rusak =0
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `retur_customer`
--

CREATE TABLE `retur_customer` (
  `id_transaksi` varchar(11) NOT NULL,
  `tanggal_retur` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `retur_supplier`
--

CREATE TABLE `retur_supplier` (
  `kode_supplier` varchar(8) NOT NULL,
  `tanggal_rtr` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `id_returSupplier` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `retur_supplier`
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
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `kode_supplier` varchar(8) NOT NULL,
  `nama_supplier` varchar(64) NOT NULL,
  `create_at` datetime DEFAULT NULL,
  `update_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`kode_supplier`, `nama_supplier`, `create_at`, `update_at`) VALUES
('S001', 'banaj supplier 1', '2022-04-19 20:00:44', '2022-04-19 20:00:44'),
('S002', 'supplier fragnace', '2022-04-25 20:30:21', '2022-04-30 19:02:15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `toko`
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
-- Dumping data untuk tabel `toko`
--

INSERT INTO `toko` (`id_toko`, `nama_toko`, `alamat_toko`, `create_at`, `update_at`, `no_hp`) VALUES
('TOKO01', 'BANAJ FRAGRANCE MOSLEM', 'Jl. Sumatra Gang 7 Jember', '2022-05-08 21:38:52', '2022-05-30', '085907185972');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
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
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `tanggal_transaksi`, `grand_total`, `bayar`, `id_pegawai`, `kembali`, `grand_modal`, `bulan`, `hari`) VALUES
('TRJ0530276', '2022-05-30', 2500, 3000, 'PGW004', 500, 2000, 5, 30),
('TRJ05304577', '2022-05-30', 2500, 3000, 'PGW004', 500, 2000, 5, 30);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `beli_product`
--
ALTER TABLE `beli_product`
  ADD PRIMARY KEY (`id_beliProduct`),
  ADD KEY `supplier` (`supplier`),
  ADD KEY `kategori` (`kategori`);

--
-- Indeks untuk tabel `detail_beli_product`
--
ALTER TABLE `detail_beli_product`
  ADD KEY `id_beliProduct` (`id_beliProduct`),
  ADD KEY `product` (`product`);

--
-- Indeks untuk tabel `detail_retur`
--
ALTER TABLE `detail_retur`
  ADD KEY `retur_sup` (`id_returSupplier`);

--
-- Indeks untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `kode_product` (`kode_product`);

--
-- Indeks untuk tabel `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kode_kategori`);

--
-- Indeks untuk tabel `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`kode_product`),
  ADD KEY `supplier` (`supplier`),
  ADD KEY `kategori` (`kategori`);

--
-- Indeks untuk tabel `retur_customer`
--
ALTER TABLE `retur_customer`
  ADD KEY `id_transaksi` (`id_transaksi`);

--
-- Indeks untuk tabel `retur_supplier`
--
ALTER TABLE `retur_supplier`
  ADD PRIMARY KEY (`id_returSupplier`),
  ADD KEY `rtr_sup` (`kode_supplier`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`kode_supplier`);

--
-- Indeks untuk tabel `toko`
--
ALTER TABLE `toko`
  ADD PRIMARY KEY (`id_toko`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `beli_product`
--
ALTER TABLE `beli_product`
  ADD CONSTRAINT `beli_product_ibfk_1` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `beli_product_ibfk_2` FOREIGN KEY (`kategori`) REFERENCES `kategori` (`kode_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detail_beli_product`
--
ALTER TABLE `detail_beli_product`
  ADD CONSTRAINT `detail_beli_product_ibfk_1` FOREIGN KEY (`id_beliProduct`) REFERENCES `beli_product` (`id_beliProduct`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_beli_product_ibfk_2` FOREIGN KEY (`product`) REFERENCES `product` (`kode_product`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detail_retur`
--
ALTER TABLE `detail_retur`
  ADD CONSTRAINT `retur_sup` FOREIGN KEY (`id_returSupplier`) REFERENCES `retur_supplier` (`id_returSupplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`kode_product`) REFERENCES `product` (`kode_product`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_ibfk_3` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `product_ibfk_2` FOREIGN KEY (`kategori`) REFERENCES `kategori` (`kode_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `retur_customer`
--
ALTER TABLE `retur_customer`
  ADD CONSTRAINT `retur_customer_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `retur_supplier`
--
ALTER TABLE `retur_supplier`
  ADD CONSTRAINT `rtr_sup` FOREIGN KEY (`kode_supplier`) REFERENCES `supplier` (`kode_supplier`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
