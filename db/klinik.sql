-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Okt 2024 pada 11.02
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `klinik`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pasien`
--

CREATE TABLE `pasien` (
  `ID` int(32) NOT NULL,
  `NAMA` char(20) NOT NULL,
  `ALAMAT` char(50) NOT NULL,
  `NIK` bigint(15) NOT NULL,
  `TANGGAL_LAHIR` date NOT NULL,
  `NO_TLP` char(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pasien`
--

INSERT INTO `pasien` (`ID`, `NAMA`, `ALAMAT`, `NIK`, `TANGGAL_LAHIR`, `NO_TLP`) VALUES
(3, 'Kiara', 'Pancoran, Jakarta Selatan', 321059011120333, '2024-10-30', '081902201135'),
(6, 'Gabriel', 'Araya, Malang', 319876543210123, '2000-05-30', '081234567890'),
(7, 'Kaivan', 'Campurdarat, Tulungagung', 321234567890456, '2020-01-27', '082345678901'),
(8, 'Lili', 'Kedungwaru, Tulungagung', 312345678901234, '2002-12-03', '081234567890'),
(9, 'Safira', 'Sleman, DI Yogyakarta', 317890123456789, '1995-07-11', '082345678901'),
(10, 'Niagara', 'Tangerang, Banten', 365432109876543, '2005-08-07', '083456789012'),
(11, 'Kaluna', 'Jatiasih, Bekasi', 345678901234567, '2006-01-09', '084567890123');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pasien`
--
ALTER TABLE `pasien`
  MODIFY `ID` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
