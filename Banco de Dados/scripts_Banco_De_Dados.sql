-- MySQL Script generated by MySQL Workbench
-- Mon Apr 22 10:54:14 2024
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
-- Table `infologin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `infologin` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `admin` INT(11) NULL DEFAULT '0',
  `email` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idUsuario`));


-- -----------------------------------------------------
-- Table `hospedes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospedes` (
  `idHospede` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `nascimento` DATE NOT NULL,
  `telefone` CHAR(15) NOT NULL,
  `fkidUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idHospede`),
  INDEX `fkHospedesInfologin1` (`fkidUsuario`),
  CONSTRAINT `fkHospedesInfologin1`
    FOREIGN KEY (`fkidUsuario`)
    REFERENCES `infologin` (`idUsuario`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );


-- -----------------------------------------------------
-- Table `avaliacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacoes` (
  `idAvaliacao` INT(11) NOT NULL AUTO_INCREMENT,
  `avaliacao` FLOAT NOT NULL,
  `avaliador` VARCHAR(45) NOT NULL,
  `fkIDHospede` INT(11) NOT NULL,
  PRIMARY KEY (`idAvaliacao`, `fkIDHospede`),
  INDEX `fkAvaliacoesHospedes1` (`fkIDHospede` ASC),
  CONSTRAINT `fkAvaliacoesHospedes1`
    FOREIGN KEY (`fkIDHospede`)
    REFERENCES `hospedes` (`idHospede`));

-- -----------------------------------------------------
-- Table `computadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computadores` (
  `idPC` INT(11) NOT NULL,
  `num` INT(11) NOT NULL,
  `temp` INT(11) NOT NULL,
  PRIMARY KEY (`idPC`));

-- -----------------------------------------------------
-- Table `quartos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quartos` (
  `idQuarto` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `preco` FLOAT NOT NULL,
  `dispo` TINYINT(4) NOT NULL,
  `cap` INT(11) NOT NULL,
  PRIMARY KEY (`idQuarto`));


-- -----------------------------------------------------
-- Table `salareunioes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salareunioes` (
  `idSala` INT(11) NOT NULL,
  `disp` TINYINT(4) NOT NULL,
  `temp` INT(11) NOT NULL,
  `cap` INT(11) NOT NULL,
  PRIMARY KEY (`idSala`));



-- -----------------------------------------------------
-- Table `espacos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `espacos` (
  `idEspaco` INT(11) NOT NULL AUTO_INCREMENT,
  `ocupante` INT(11) NOT NULL,
  `checkIn` DATE NOT NULL,
  `checkOut` DATE NOT NULL,
  `fkidComputador` INT(11) NOT NULL,
  `fkidSalaReuniao` INT(11) NOT NULL,
  `fkidQuartos` INT(11) NOT NULL,
  PRIMARY KEY (`idEspaco`, `fkidComputador`, `fkidSalaReuniao`, `fkidQuartos`),
  INDEX `fkEspacosComputadores1` (`fkidComputador` ),
  INDEX `fkEspacosSalaReunioes1` (`fkidSalaReuniao`),
  INDEX `fkEspacosQuartos1` (`fkidQuartos`),
  CONSTRAINT `fkEspacosComputadores1`
    FOREIGN KEY (`fkidComputador`)
    REFERENCES `mydb`.`computadores` (`idPC`),
  CONSTRAINT `fkEspacosQuartos1`
    FOREIGN KEY (`fkidQuartos`)
    REFERENCES `mydb`.`quartos` (`idQuarto`),
  CONSTRAINT `fkEspacosSalaReunioes1`
    FOREIGN KEY (`fkidSalaReuniao`)
    REFERENCES `salareunioes` (`idSala`));



-- -----------------------------------------------------
-- Table `espacosreservados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `espacosreservados` (
  `fkidEspaco` INT(11) NOT NULL,
  `fkIDHospede` INT(11) NOT NULL,
  `idEspacosReservados` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idEspacosReservados`),
  INDEX `fkEspacoshasHospedesEspacos1` (`fkidEspaco`),
  INDEX `fkEspacoshasHospedesHospedes1` (`fkIDHospede`),
  CONSTRAINT `fkEspacoshasHospedesEspacos1`
    FOREIGN KEY (`fkidEspaco`)
    REFERENCES `mydb`.`espacos` (`idEspaco`),
  CONSTRAINT `fkEspacoshasHospedesHospedes1`
    FOREIGN KEY (`fkIDHospede`)
    REFERENCES `hospedes` (`idHospede`));



-- -----------------------------------------------------
-- Table `servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicos` (
  `idServico` INT(11) NOT NULL,
  `nomeServico` VARCHAR(45) NOT NULL,
  `precoServico` FLOAT NOT NULL,
  `pagEfetuado` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idServico`));



-- -----------------------------------------------------
-- Table `servicosconsumidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicosconsumidos` (
  `idServicoConsumido` INT(11) NOT NULL AUTO_INCREMENT,
  `fkIDHospede` INT(11) NOT NULL,
  `fkServico` INT(11) NOT NULL,
  PRIMARY KEY (`idServicoConsumido`, `fkIDHospede`, `fkServico`),
  INDEX `fkServicosConsumidosHospedes1` (`fkIDHospede`),
  INDEX `fkServicosConsumidosServicos1` (`fkServico`),
  CONSTRAINT `fkServicosConsumidosHospedes1`
    FOREIGN KEY (`fkIDHospede`)
    REFERENCES `mydb`.`hospedes` (`idHospede`),
  CONSTRAINT `fkServicosConsumidosServicos1`
    FOREIGN KEY (`fkServico`)
    REFERENCES `servicos` (`idServico`));

insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (101, true, 149.99, 'Frigobar1');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (102, true, 249.99, 'Frigobar2');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (103, false, 399.99, 'Frigobar3');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (104, true, 29.99, 'Reposição1');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (105, false, 59.99, 'Reposição2');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (106, false, 99.99, 'Reposição3');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (107, true, 34.99, 'Café da manhã');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (108, false, 44.99, 'Almoço');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (109, false, 44.99, 'Jantar');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (110, true, 28.99, 'Espumante Salton Brut');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (111, true, 188.99, 'Vinho Villaggio');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (112, false, 39.99, 'Espumante Casa Perini Moscatel');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (113, false, 76.99, 'Whisky Johnnie Walker Red Label');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (114, true, 99.99, 'Whiskey Bourbon Jim Beam White');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (115, false, 17.99, 'Cerveja Belgian Blond Ale');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (116, true, 28.99, 'Cerveja Duvel Belgian Golden Ale');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (117, true, 20.99, 'Cerveja Belgian Dark Strong Ale');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (118, false, 26.80, 'Bloody Mary');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (119, true, 28.60, 'Cuervo Margarita‫');
insert into Servicos (idServico, pagEfetuado, precoServico, nomeServico) values (120, false, 28.60, 'Negroni');

insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (81, 'Solteiro', 4099427424.22, false, 1);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (82, 'Suíte', 8174618376.73, true, 2);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (83, 'Cama Dupla', 3440196511.28, true, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (84, 'Cama Dupla', 6803365501.62, true, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (85, 'Cama Dupla', 5808994985.61, false, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (86, 'Cama Dupla', 5706131096.03, false, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (87, 'Suíte', 4867550475.94, false, 2);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (88, 'Suíte', 1088227692.06, false, 2);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (89, 'Cama Dupla', 2388249698.15, true, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (90, 'Solteiro', 393493386.23, true, 1);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (91, 'Solteiro', 8015993029.39, false, 1);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (92, 'Cama Dupla', 6177861157.81, false, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (93, 'Cama Dupla', 7330932083.33, false, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (94, 'Suíte', 6314751111.59, true, 2);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (95, 'Solteiro', 750962244.65, false, 1);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (96, 'Solteiro', 529583171.98, false, 1);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (97, 'Cama Dupla', 490544772.94, true, 4);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (98, 'Suíte', 8261645856.87, true, 2);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (99, 'Solteiro', 4504021984.02, false, 1);
insert into Quartos (idQuarto, tipo, preco, dispo, cap) values (100, 'Suíte', 7209148493.83, false, 2);

insert into Computadores (idPC, num, temp) values (41, 1, 1);
insert into Computadores (idPC, num, temp) values (42, 2, 2);
insert into Computadores (idPC, num, temp) values (43, 3, 3);
insert into Computadores (idPC, num, temp) values (44, 4, 4);
insert into Computadores (idPC, num, temp) values (45, 5, 5);
insert into Computadores (idPC, num, temp) values (46, 6, 6);
insert into Computadores (idPC, num, temp) values (47, 7, 7);
insert into Computadores (idPC, num, temp) values (48, 8, 8);
insert into Computadores (idPC, num, temp) values (49, 9, 9);
insert into Computadores (idPC, num, temp) values (50, 10, 10);
insert into Computadores (idPC, num, temp) values (51, 11, 11);
insert into Computadores (idPC, num, temp) values (52, 12, 12);
insert into Computadores (idPC, num, temp) values (53, 13, 13);
insert into Computadores (idPC, num, temp) values (54, 14, 14);
insert into Computadores (idPC, num, temp) values (55, 15, 15);
insert into Computadores (idPC, num, temp) values (56, 16, 16);
insert into Computadores (idPC, num, temp) values (57, 17, 17);
insert into Computadores (idPC, num, temp) values (58, 18, 18);
insert into Computadores (idPC, num, temp) values (59, 19, 19);
insert into Computadores (idPC, num, temp) values (60, 20, 20);

insert into SalaReunioes (idSala, disp, temp, cap) values (61, false, 80, 4);
insert into SalaReunioes (idSala, disp, temp, cap) values (62, false, 90, 8);
insert into SalaReunioes (idSala, disp, temp, cap) values (63, true, 60, 6);
insert into SalaReunioes (idSala, disp, temp, cap) values (64, false, 70, 4);
insert into SalaReunioes (idSala, disp, temp, cap) values (65, false, 100, 6);
insert into SalaReunioes (idSala, disp, temp, cap) values (66, false, 60, 6);
insert into SalaReunioes (idSala, disp, temp, cap) values (67, false, 70, 10);
insert into SalaReunioes (idSala, disp, temp, cap) values (68, true, 90, 8);
insert into SalaReunioes (idSala, disp, temp, cap) values (69, true, 60, 6);
insert into SalaReunioes (idSala, disp, temp, cap) values (70, true, 100, 10);
insert into SalaReunioes (idSala, disp, temp, cap) values (71, false, 100, 8);
insert into SalaReunioes (idSala, disp, temp, cap) values (72, true, 100, 8);
insert into SalaReunioes (idSala, disp, temp, cap) values (73, true, 60, 10);
insert into SalaReunioes (idSala, disp, temp, cap) values (74, false, 70, 4);
insert into SalaReunioes (idSala, disp, temp, cap) values (75, false, 90, 4);
insert into SalaReunioes (idSala, disp, temp, cap) values (76, false, 100, 10);
insert into SalaReunioes (idSala, disp, temp, cap) values (77, false, 70, 10);
insert into SalaReunioes (idSala, disp, temp, cap) values (78, true, 60, 4);
insert into SalaReunioes (idSala, disp, temp, cap) values (79, true, 90, 6);
insert into SalaReunioes (idSala, disp, temp, cap) values (80, false, 60, 8);

