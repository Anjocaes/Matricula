CREATE database `moviles` ;
  
  CREATE TABLE `moviles`.`carrera` (
  `Codigo` VARCHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Titulo` VARCHAR(255) NOT NULL,
  `Curso` INT NOT NULL,
  PRIMARY KEY (`Codigo`),
  CONSTRAINT `fk_curso` FOREIGN KEY (Curso) REFERENCES `moviles`.`curso`(Codigo));
  
  CREATE TABLE `moviles`.`curso` (
  `Codigo` VARCHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Credito` INT NOT NULL,
  `HSemanal` INT NOT NULL,
  `Ciclo` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`Codigo`)); 
  
  CREATE TABLE `moviles`.`grupo` (
  `Numero` INT NOT NULL,
  `Horario` VARCHAR(255) NOT NULL,
  `Curso` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`Numero`),
  CONSTRAINT `fk_curso` FOREIGN KEY (Curso) REFERENCES `moviles`.`curso`(Codigo));
  
CREATE TABLE `moviles`.`matricula` (
  `CedProfesor` VARCHAR(12) NOT NULL,
  `CedAlumno` VARCHAR(12) NOT NULL,
  `Grupo` INT NOT NULL,
  `Nota` INT,
  PRIMARY KEY (`Grupo`, `CedAlumno`, `CedProfesor`, `Nota`),
  CONSTRAINT `fk_profesor` FOREIGN KEY (CedProfesor) REFERENCES `moviles`.`persona`(cedula),
  CONSTRAINT `fk_alumno` FOREIGN KEY (CedAlumno) REFERENCES `moviles`.`persona`(cedula),
  CONSTRAINT `fk_grupo` FOREIGN KEY (Grupo) REFERENCES `moviles`.`grupo`(Codigo));
  
  
CREATE TABLE `moviles`.`persona` (
  `Cedula` VARCHAR(12) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Telefono` VARCHAR(12) NOT NULL,
  `Correo` VARCHAR(45) NOT NULL,
  `Clave` VARCHAR(8) NOT NULL ,
  `Tipo` INT NOT NULL ,
  `Fecha_Nacimiento` VARCHAR(15),
  PRIMARY KEY (`Cedula`)); 