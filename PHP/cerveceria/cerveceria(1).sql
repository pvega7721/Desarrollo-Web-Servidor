-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 19-02-2025 a las 20:50:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cerveceria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cervezas`
--

CREATE TABLE `cervezas` (
  `Id_Cerveza` int(3) NOT NULL,
  `Denominacion_Cerveza` varchar(100) NOT NULL,
  `Marca` varchar(20) NOT NULL,
  `Tipo_Cerveza` varchar(100) NOT NULL,
  `Formato` varchar(100) NOT NULL,
  `Tamanyo` varchar(100) NOT NULL,
  `Alergenos` varchar(40) NOT NULL,
  `Fecha_Consumo` date NOT NULL,
  `Foto` varchar(255) NOT NULL,
  `Precio` decimal(10,0) NOT NULL,
  `Observaciones` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cervezas`
--

INSERT INTO `cervezas` (`Id_Cerveza`, `Denominacion_Cerveza`, `Marca`, `Tipo_Cerveza`, `Formato`, `Tamanyo`, `Alergenos`, `Fecha_Consumo`, `Foto`, `Precio`, `Observaciones`) VALUES
(28, 'ffafasdfsd fd', 'Heiniken', 'cerveza_negra', 'Lata', 'botellin', 'Huevo', '2025-02-19', '', 142, 'asdfasdf'),
(30, 'fdasdsffdsaasdffdasasdffdassdfasfda', 'Heiniken', 'abadia', 'Lata', 'botellin', 'Gluten, Huevo, Cacahuete', '2025-02-19', 'Imagenes/Captura de pantalla 2024-10-27 122713.png', 9876543, 'adfadsfasfasdfas'),
(31, '5234fd', 'Heiniken', 'rubia', 'Lata', 'botellin', 'Sin Alergenos', '2025-02-20', 'Imagenes/Captura de pantalla 2025-02-09 171315.png', 6543, 'fdassdf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id_Usuario` int(3) NOT NULL,
  `Correo` varchar(100) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Edad` int(3) NOT NULL,
  `Perfil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Id_Usuario`, `Correo`, `Password`, `Edad`, `Perfil`) VALUES
(1, 'ejemplo@ejemplo.com', '1234', 19, 'usuario'),
(2, 'admin@admin.com', 'root', 24, 'administrador');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cervezas`
--
ALTER TABLE `cervezas`
  ADD PRIMARY KEY (`Id_Cerveza`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_Usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cervezas`
--
ALTER TABLE `cervezas`
  MODIFY `Id_Cerveza` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_Usuario` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
