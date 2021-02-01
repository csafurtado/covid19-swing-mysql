CREATE DATABASE
 IF NOT EXISTS covid19;

USE covid19;


-- TABELA
CREATE TABLE pessoa (
  idPessoa INT               NOT NULL AUTO_INCREMENT,
	nomeCompleto     VARCHAR(90)       NOT NULL,
	genero   ENUM('M','F')     NOT NULL,
  situacaoSaude    ENUM('C','E','F') DEFAULT NULL,
  idade    INT               DEFAULT NULL,
 CONSTRAINT PACIENTES_PK PRIMARY KEY (idPessoa)
)ENGINE InnoDB AUTO_INCREMENT = 1;