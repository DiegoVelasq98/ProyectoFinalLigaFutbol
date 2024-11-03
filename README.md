# ProyectoFinalLigaFutbol
Proyecto Final de Base de Datos 1

Link del video explicando el funcionamiento del proyecto
https://youtu.be/oY6I9K1k_OY  


QUERY DE BASE DE DATOS QUE SE UTILIZO

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS ligadefutbolproyecto;
USE ligadefutbolproyecto;

-- Crear la tabla posicion primero
CREATE TABLE `posicion` (
  `codigo_posicion` int NOT NULL AUTO_INCREMENT,
  `nombre_posicion` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo_posicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AUTO_INCREMENT=0;

-- Crear la tabla equipo
CREATE TABLE `equipo` (
  `codigo_equipo` int NOT NULL AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `nombre_estadio` varchar(100) NOT NULL,
  `aforo` varchar(100) NOT NULL,
  `anio_fundacion` date NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AUTO_INCREMENT=0;

-- Crear la tabla jugador
CREATE TABLE `jugador` (
  `codigo_jugador` int NOT NULL AUTO_INCREMENT,
  `nombre1` varchar(100) NOT NULL,
  `nombre2` varchar(100) DEFAULT NULL,
  `nombre3` varchar(100) DEFAULT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) DEFAULT NULL,
  `correo_electronico` varchar(100) DEFAULT NULL,
  `ciudad_residencia` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `codigo_posicion` int DEFAULT NULL,
  `codigo_equipo` int DEFAULT NULL,
  PRIMARY KEY (`codigo_jugador`),
  KEY `codigo_posicion` (`codigo_posicion`),
  KEY `codigo_equipo` (`codigo_equipo`),
  CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`codigo_posicion`) REFERENCES `posicion` (`codigo_posicion`),
  CONSTRAINT `jugador_ibfk_2` FOREIGN KEY (`codigo_equipo`) REFERENCES `equipo` (`codigo_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AUTO_INCREMENT=0;

-- Crear la tabla presidente
CREATE TABLE `presidente` (
  `id_presidente` int NOT NULL AUTO_INCREMENT,
  `dpi` varchar(13) NOT NULL,
  `nombre1` varchar(100) NOT NULL,
  `nombre2` varchar(100) DEFAULT NULL,
  `nombre3` varchar(100) DEFAULT NULL,
  `apellido1` varchar(100) NOT NULL,
  `apellido2` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `correo_electronico` varchar(100) DEFAULT NULL,
  `ciudad_residencia` varchar(100) DEFAULT NULL,
  `anio_eleccion` date NOT NULL,
  `codigo_equipo` int DEFAULT NULL,
  PRIMARY KEY (`id_presidente`),
  KEY `codigo_equipo` (`codigo_equipo`),
  CONSTRAINT `presidente_ibfk_1` FOREIGN KEY (`codigo_equipo`) REFERENCES `equipo` (`codigo_equipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AUTO_INCREMENT=0;

-- Crear la tabla goleador
CREATE TABLE `goleador` (
  `codigo_goleador` int NOT NULL AUTO_INCREMENT,
  `codigo_jugador` int NOT NULL,
  `total_goles` int NOT NULL,
  PRIMARY KEY (`codigo_goleador`),
  KEY `codigo_jugador` (`codigo_jugador`),
  CONSTRAINT `goleador_ibfk_1` FOREIGN KEY (`codigo_jugador`) REFERENCES `jugador` (`codigo_jugador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AUTO_INCREMENT=0;
