-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema de_compras_store
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema de_compras_store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `de_compras_store` ;
USE `de_compras_store` ;

-- -----------------------------------------------------
-- Table `de_compras_store`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`administrador` (
  `idadministrador` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT(8) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` INT(9) NOT NULL,
  `estado` INT(1) NOT NULL,
  PRIMARY KEY (`idadministrador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`logistica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`logistica` (
  `idlogistica` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT(8) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` INT(9) NOT NULL,
  `estado` INT(1) NOT NULL,
  PRIMARY KEY (`idlogistica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`vendedor` (
  `idvendedor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT(8) NOT NULL,
  `rol` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` INT(9) NOT NULL,
  `estado` INT(1) NOT NULL,
  PRIMARY KEY (`idvendedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`proveedor` (
  `idproveedor` INT NOT NULL,
  `razon_social` VARCHAR(45) NOT NULL,
  `ruc` VARCHAR(45) NOT NULL,
  `representante` VARCHAR(45) NOT NULL,
  `telefono` INT(9) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `distrito` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `descripcion` VARCHAR(250) NULL,
  PRIMARY KEY (`idproveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`producto` (
  `codigo` INT NOT NULL,
  `proveedor_idproveedor` INT NOT NULL,
  `fecha_venc` TIME NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` FLOAT NOT NULL,
  `stock` INT(11) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `estado` INT(1) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_producto_proveedor1_idx` (`proveedor_idproveedor` ASC) VISIBLE,
  CONSTRAINT `fk_producto_proveedor1`
    FOREIGN KEY (`proveedor_idproveedor`)
    REFERENCES `de_compras_store`.`proveedor` (`idproveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`cliente` (
  `idcliente` INT NOT NULL,
  `nombres` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `estado` INT(1) NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`boleta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`boleta` (
  `idboleta` INT NOT NULL,
  `vendedor_idvendedor` INT NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  `producto_codigo` INT NOT NULL,
  `fecha_venta` DATE NOT NULL,
  `monto` FLOAT NOT NULL,
  `estado` INT(1) NOT NULL,
  PRIMARY KEY (`idboleta`),
  INDEX `fk_ventas_vendedor_idx` (`vendedor_idvendedor` ASC) VISIBLE,
  INDEX `fk_ventas_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_boleta_producto1_idx` (`producto_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_ventas_vendedor`
    FOREIGN KEY (`vendedor_idvendedor`)
    REFERENCES `de_compras_store`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ventas_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `de_compras_store`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_boleta_producto1`
    FOREIGN KEY (`producto_codigo`)
    REFERENCES `de_compras_store`.`producto` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`ventas` (
  `idventas` INT NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  `vendedor_idvendedor` INT NOT NULL,
  `num_ventas` VARCHAR(100) NOT NULL,
  `fecha_ventas` DATE NOT NULL,
  `monto` FLOAT NOT NULL,
  `estado` VARCHAR(45) NULL,
  `ventascol` INT(1) NOT NULL,
  PRIMARY KEY (`idventas`),
  INDEX `fk_ventas_cliente2_idx` (`cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_ventas_vendedor1_idx` (`vendedor_idvendedor` ASC) VISIBLE,
  CONSTRAINT `fk_ventas_cliente2`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `de_compras_store`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ventas_vendedor1`
    FOREIGN KEY (`vendedor_idvendedor`)
    REFERENCES `de_compras_store`.`vendedor` (`idvendedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`logistica_has_proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`logistica_has_proveedor` (
  `logistica_idlogistica` INT NOT NULL,
  `proveedor_idproveedor` INT NOT NULL,
  PRIMARY KEY (`logistica_idlogistica`, `proveedor_idproveedor`),
  INDEX `fk_logistica_has_proveedor_proveedor1_idx` (`proveedor_idproveedor` ASC) VISIBLE,
  INDEX `fk_logistica_has_proveedor_logistica1_idx` (`logistica_idlogistica` ASC) VISIBLE,
  CONSTRAINT `fk_logistica_has_proveedor_logistica1`
    FOREIGN KEY (`logistica_idlogistica`)
    REFERENCES `de_compras_store`.`logistica` (`idlogistica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_logistica_has_proveedor_proveedor1`
    FOREIGN KEY (`proveedor_idproveedor`)
    REFERENCES `de_compras_store`.`proveedor` (`idproveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`detalle_ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`detalle_ventas` (
  `iddetalleventa` INT NOT NULL,
  `ventas_idventas` INT NOT NULL,
  `producto_codigo` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precioVentas` FLOAT NOT NULL,
  INDEX `fk_ventas_has_producto_producto1_idx` (`producto_codigo` ASC) VISIBLE,
  INDEX `fk_ventas_has_producto_ventas1_idx` (`ventas_idventas` ASC) VISIBLE,
  PRIMARY KEY (`iddetalleventa`, `ventas_idventas`, `producto_codigo`),
  CONSTRAINT `fk_ventas_has_producto_ventas1`
    FOREIGN KEY (`ventas_idventas`)
    REFERENCES `de_compras_store`.`ventas` (`idventas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ventas_has_producto_producto1`
    FOREIGN KEY (`producto_codigo`)
    REFERENCES `de_compras_store`.`producto` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`pagos` (
  `idpagos` INT NOT NULL,
  `titulo` VARCHAR(80) NOT NULL,
  `monto` FLOAT NOT NULL,
  `entidad` VARCHAR(100) NOT NULL,
  `descripcion` VARCHAR(250) NOT NULL,
  `fecha_pago` DATE NOT NULL,
  `imagen` VARCHAR(250) NOT NULL,
  `administrador_idadministrador` INT NOT NULL,
  PRIMARY KEY (`idpagos`),
  INDEX `fk_pagos_administrador1_idx` (`administrador_idadministrador` ASC) VISIBLE,
  CONSTRAINT `fk_pagos_administrador1`
    FOREIGN KEY (`administrador_idadministrador`)
    REFERENCES `de_compras_store`.`administrador` (`idadministrador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`roles` (
  `idrol` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrol`),
  UNIQUE INDEX `idrol_UNIQUE` (`idrol` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `de_compras_store`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `de_compras_store`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT(8) NOT NULL,
  `roles_idrol` INT NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `contrasena` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` INT(9) NOT NULL,
  `estado` INT(1) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuarios_roles1_idx` (`roles_idrol` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_usuarios_roles1`
    FOREIGN KEY (`roles_idrol`)
    REFERENCES `de_compras_store`.`roles` (`idrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
