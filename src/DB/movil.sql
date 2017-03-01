CREATE database `moviles` ;

CREATE TABLE `moviles`.`nota` (
	`Nota` INT NOT NULL,
    `Identificador` VARCHAR(12) NOT NULL,
	CONSTRAINT `fk_identificador ` FOREIGN KEY (Identificador) REFERENCES `moviles`.`persona`(cedula));
  
CREATE TABLE `moviles`.`persona` (
  `Cedula` VARCHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(12) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `Clave` VARCHAR(8) NOT NULL ,
  `Tipo` INT NOT NULL ,
  `Fecha_Nacimiento` VARCHAR(15),
  PRIMARY KEY (`Cedula`)); 
  
  CREATE TABLE `moviles`.`carrera` (
  `Codigo` VARCHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Titulo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Codigo`)); 
  
  CREATE TABLE `moviles`.`curso` (
  `Codigo` VARCHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Credito` INT NOT NULL,
  `HSemanal` INT NOT NULL,
  PRIMARY KEY (`Codigo`)); 
  
  CREATE TABLE `moviles`.`grupo` (
  `Numero` INT NOT NULL,
  `Horario` VARCHAR(255) NOT NULL,
  `CedProfesor` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`Numero`));