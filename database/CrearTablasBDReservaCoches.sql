DROP DATABASE IF EXISTS UD02BDReservaCoches;
CREATE DATABASE IF NOT EXISTS UD02BDReservaCoches;
USE UD02BDReservaCoches;

CREATE TABLE IF NOT EXISTS Garajes(
gaCodigo INT AUTO_INCREMENT PRIMARY KEY,
gaNombre VARCHAR(20) NOT NULL,
gaDireccion VARCHAR(20) NOT NULL)Engine = InnoDB;

CREATE TABLE IF NOT EXISTS Clientes(
clNif CHAR(9) PRIMARY KEY,
clNombre VARCHAR(50) NOT NULL,
clDireccion VARCHAR(50) NOT NULL,
clTelefono INT(9) NOT NULL)Engine = InnoDB;

CREATE TABLE IF NOT EXISTS Coches(
coMatricula CHAR(10) PRIMARY KEY,
coMarca VARCHAR(20) NOT NULL,
coModelo VARCHAR(30) NOT NULL,
coColor VARCHAR(20) NOT NULL,
coPrecio INT NOT NULL,
coDisponible BOOLEAN NOT NULL DEFAULT true,
coGaraje INT NOT NULL,
FOREIGN KEY (coGaraje) REFERENCES Garajes (gaCodigo))Engine = InnoDB;

CREATE TABLE IF NOT EXISTS Reservas(
reCodigo INT PRIMARY KEY,
reFecInicio DATE NOT NULL,
reFecFinal DATE);

CREATE TABLE IF NOT EXISTS Involucra(
inCodigo INT AUTO_INCREMENT PRIMARY KEY,
inMatricula CHAR(10) NOT NULL,
inCliente CHAR(9) NOT NULL,
inReserva INT NOT NULL,
inLitros INT NOT NULL,
FOREIGN KEY (inMatricula) REFERENCES Coches (coMatricula),
FOREIGN KEY (inCliente) REFERENCES Clientes (clNif),
FOREIGN KEY (inReserva) REFERENCES Reservas (reCodigo))Engine = InnoDB;



