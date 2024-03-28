-- MySQL Script generated by MySQL Workbench
-- Mon Mar 11 17:15:20 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `mydb`;

CREATE DATABASE IF NOT EXISTS `mydb`;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `Hospedes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospedes` (
  `ID_Hospede` INT NOT NULL AUTO_INCREMENT,
  `Nome_Hospede` VARCHAR(45) NOT NULL,
  `sobrenome_hospede` VARCHAR(45) NOT NULL,
  `nascimento_hospede` DATE NOT NULL,
  `telefone_hospede` CHAR(14) NOT NULL,
  `email_hospede` VARCHAR(255) NOT NULL,
  `senha_hospede` VARCHAR(50) NOT NULL,
  `FK_ID_usuario` INT NOT NULL,
  PRIMARY KEY (`ID_Hospede`),
  CONSTRAINT `fk_Hospedes_Info_Login1`
    FOREIGN KEY (`FK_ID_Usuario`)
    REFERENCES `Info_Login` (`ID_usuario`));


-- -----------------------------------------------------
-- Table `Avaliacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Avaliacoes` (
  `ID_Avaliacao` INT NOT NULL AUTO_INCREMENT,
  `Avaliacao` FLOAT NOT NULL,
  `Avaliador` VARCHAR(45) NOT NULL,
  `FK_ID_Hospede` INT NOT NULL,
  PRIMARY KEY (`ID_Avaliacao`, `FK_ID_Hospede`),
  CONSTRAINT `fk_Avaliacoes_Hospedes1`
    FOREIGN KEY (`FK_ID_Hospede`)
    REFERENCES `Hospedes` (`ID_Hospede`));


-- -----------------------------------------------------
-- Table `Computadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Computadores` (
  `ID_PC` INT NOT NULL,
  `Num_PC` INT NOT NULL,
  `Temp_Alugado` INT NOT NULL,
  PRIMARY KEY (`ID_PC`));


-- -----------------------------------------------------
-- Table `Sala_Reunioes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sala_Reunioes` (
  `ID_Sala` INT NOT NULL,
  `Disp_Sala` TINYINT NOT NULL,
  `Temp_Alugado` INT NOT NULL,
  `Cap_Max` INT NOT NULL,
  PRIMARY KEY (`ID_Sala`));


-- -----------------------------------------------------
-- Table `Quartos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Quartos` (
  `ID_Quarto` INT NOT NULL AUTO_INCREMENT,
  `Tipo_Quarto` VARCHAR(45) NOT NULL,
  `Preco_Diaria` FLOAT NOT NULL,
  `Dispo_Quarto` TINYINT NOT NULL,
  `Cap_max` INT NOT NULL,
  PRIMARY KEY (`ID_Quarto`));


-- -----------------------------------------------------
-- Table `Espacos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Espacos` (
  `ID_Espaco` INT NOT NULL AUTO_INCREMENT,
  `Ocupante_Espaco` INT NOT NULL,
  `Check_In` DATE NOT NULL,
  `Check_Out` DATE NOT NULL,
  `FK_ID_Computador` INT NOT NULL,
  `FK_ID_Sala_Reuniao` INT NOT NULL,
  `Quartos_ID_Quarto` INT NOT NULL,
  PRIMARY KEY (`ID_Espaco`, `FK_ID_Computador`, `FK_ID_Sala_Reuniao`, `Quartos_ID_Quarto`),
  CONSTRAINT `fk_Espacos_Computadores1`
    FOREIGN KEY (`FK_ID_Computador`)
    REFERENCES `Computadores` (`ID_PC`),
  CONSTRAINT `fk_Espacos_Sala_Reunioes1`
    FOREIGN KEY (`FK_ID_Sala_Reuniao`)
    REFERENCES `Sala_Reunioes` (`ID_Sala`),
  CONSTRAINT `fk_Espacos_Quartos1`
    FOREIGN KEY (`Quartos_ID_Quarto`)
    REFERENCES `Quartos` (`ID_Quarto`));


-- -----------------------------------------------------
-- Table `Servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Servicos` (
  `ID_Servico` INT NOT NULL,
  `Nome_Servico` VARCHAR(45) NOT NULL,
  `Preco_Servico` FLOAT NOT NULL,
  `Pag_Efetuado` TINYINT NOT NULL,
  PRIMARY KEY (`ID_Servico`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Servicos_Consumidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Servicos_Consumidos` (
  `ID_Servico_Consumido` INT NOT NULL AUTO_INCREMENT,
  `FK_ID_Hospede` INT NOT NULL,
  `FK_Servico` INT NOT NULL,
  PRIMARY KEY (`ID_Servico_Consumido`, `FK_ID_Hospede`, `FK_Servico`),
  CONSTRAINT `fk_Servicos_Consumidos_Hospedes1`
    FOREIGN KEY (`FK_ID_Hospede`)
    REFERENCES `Hospedes` (`ID_Hospede`),
  CONSTRAINT `fk_Servicos_Consumidos_Servicos1`
    FOREIGN KEY (`FK_Servico`)
    REFERENCES `Servicos` (`ID_Servico`));


-- -----------------------------------------------------
-- Table `Info_Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Info_Login` (
  `ID_usuario` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(50) NOT NULL,
  `Senha` VARCHAR(50) NOT NULL,
  `FK_ID_Hospede` INT NOT NULL,
  PRIMARY KEY (`ID_usuario`));




-- -----------------------------------------------------
-- Table `Espacos_Reservados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Espacos_Reservados` (
  `FK_ID_Espaco` INT NOT NULL,
  `FK_ID_Hospede` INT NOT NULL,
  `ID_Espacos_Reservados` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_Espacos_Reservados`),
  CONSTRAINT `fk_Espacos_has_Hospedes_Espacos1`
    FOREIGN KEY (`FK_ID_Espaco`)
    REFERENCES `Espacos` (`ID_Espaco`),
  CONSTRAINT `fk_Espacos_has_Hospedes_Hospedes1`
    FOREIGN KEY (`FK_ID_Hospede`)
    REFERENCES `Hospedes` (`ID_Hospede`)
);

insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (101, true, 149.99, 'Frigobar1');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (102, true, 249.99, 'Frigobar2');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (103, false, 399.99, 'Frigobar3');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (104, true, 29.99, 'Reposição1');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (105, false, 59.99, 'Reposição2');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (106, false, 99.99, 'Reposição3');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (107, true, 34.99, 'Café da manhã');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (108, false, 44.99, 'Almoço');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (109, false, 44.99, 'Jantar');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (110, true, 28.99, 'Espumante Salton Brut');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (111, true, 188.99, 'Vinho Villaggio');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (112, false, 39.99, 'Espumante Casa Perini Moscatel');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (113, false, 76.99, 'Whisky Johnnie Walker Red Label');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (114, true, 99.99, 'Whiskey Bourbon Jim Beam White');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (115, false, 17.99, 'Cerveja Belgian Blond Ale');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (116, true, 28.99, 'Cerveja Duvel Belgian Golden Ale');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (117, true, 20.99, 'Cerveja Belgian Dark Strong Ale');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (118, false, 26.80, 'Bloody Mary');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (119, true, 28.60, 'Cuervo Margarita‫');
insert into Servicos (ID_Servico, Pag_Efetuado, Preco_Servico, Nome_Servico) values (120, false, 28.60, 'Negroni');

insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (81, 'Solteiro', 4099427424.22, false, 1);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (82, 'Suíte', 8174618376.73, true, 2);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (83, 'Cama Dupla', 3440196511.28, true, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (84, 'Cama Dupla', 6803365501.62, true, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (85, 'Cama Dupla', 5808994985.61, false, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (86, 'Cama Dupla', 5706131096.03, false, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (87, 'Suíte', 4867550475.94, false, 2);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (88, 'Suíte', 1088227692.06, false, 2);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (89, 'Cama Dupla', 2388249698.15, true, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (90, 'Solteiro', 393493386.23, true, 1);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (91, 'Solteiro', 8015993029.39, false, 1);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (92, 'Cama Dupla', 6177861157.81, false, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (93, 'Cama Dupla', 7330932083.33, false, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (94, 'Suíte', 6314751111.59, true, 2);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (95, 'Solteiro', 750962244.65, false, 1);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (96, 'Solteiro', 529583171.98, false, 1);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (97, 'Cama Dupla', 490544772.94, true, 4);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (98, 'Suíte', 8261645856.87, true, 2);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (99, 'Solteiro', 4504021984.02, false, 1);
insert into Quartos (ID_Quarto, Tipo_Quarto, Preco_Diaria, Dispo_Quarto, Cap_max) values (100, 'Suíte', 7209148493.83, false, 2);

insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (41, 1, 1);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (42, 2, 2);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (43, 3, 3);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (44, 4, 4);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (45, 5, 5);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (46, 6, 6);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (47, 7, 7);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (48, 8, 8);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (49, 9, 9);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (50, 10, 10);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (51, 11, 11);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (52, 12, 12);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (53, 13, 13);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (54, 14, 14);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (55, 15, 15);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (56, 16, 16);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (57, 17, 17);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (58, 18, 18);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (59, 19, 19);
insert into Computadores (ID_PC, Num_PC, Temp_Alugado) values (60, 20, 20);

insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (61, false, 80, 4);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (62, false, 90, 8);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (63, true, 60, 6);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (64, false, 70, 4);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (65, false, 100, 6);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (66, false, 60, 6);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (67, false, 70, 10);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (68, true, 90, 8);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (69, true, 60, 6);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (70, true, 100, 10);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (71, false, 100, 8);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (72, true, 100, 8);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (73, true, 60, 10);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (74, false, 70, 4);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (75, false, 90, 4);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (76, false, 100, 10);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (77, false, 70, 10);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (78, true, 60, 4);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (79, true, 90, 6);
insert into Sala_Reunioes (ID_Sala, Disp_Sala, Temp_Alugado, Cap_Max) values (80, false, 60, 8);
