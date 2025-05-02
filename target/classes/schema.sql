CREATE TABLE IF NOT EXISTS  libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fechaIngreso TIMESTAMP NOT NULL,
    activo BOOLEAN NOT NULL,
    autor VARCHAR(255) NOT NULL,
    editorial VARCHAR(255) NOT NULL,
    anio VARCHAR(4) NOT NULL
);

CREATE TABLE IF NOT EXISTS  periodico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fechaIngreso TIMESTAMP NOT NULL,
    activo BOOLEAN NOT NULL,
    fechaPublicacion DATE NOT NULL,
    editorial VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS  computador (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(255) NOT NULL,
     fechaIngreso TIMESTAMP NOT NULL,
     activo BOOLEAN NOT NULL,
     marca VARCHAR(255) NOT NULL,
     modelo VARCHAR(255) NOT NULL,
     sistema_operativo VARCHAR(255) NOT NULL,
     tipo VARCHAR(20) NOT NULL
);
