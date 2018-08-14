CREATE DATABASE inventario;
USE inventario;
CREATE TABLE `articulos` (
	`codigo` INT(11) NOT NULL,
	`nombre` VARCHAR(65) NULL DEFAULT NULL COLLATE 'utf8_spanish_ci',
	`precio` DECIMAL(6,2) NULL DEFAULT NULL,
	`stock` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`codigo`)
);