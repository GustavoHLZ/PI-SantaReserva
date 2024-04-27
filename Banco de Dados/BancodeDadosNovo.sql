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
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `admin` INT NULL DEFAULT '0',
  `email` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idUsuario`));


-- -----------------------------------------------------
-- Table `hospedes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospedes` (
  `idHospede` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `nascimento` DATE NOT NULL,
  `telefone` CHAR(15) NOT NULL,
  `fkidUsuario` INT NOT NULL,
  PRIMARY KEY (`idHospede`),
  CONSTRAINT `fkHospedesInfologin1`
    FOREIGN KEY (`fkidUsuario`)
    REFERENCES `infologin` (`idUsuario`));

-- -----------------------------------------------------
-- Table `avaliacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `avaliacoes` (
  `idAvaliacao` INT NOT NULL AUTO_INCREMENT,
  `avaliacao` FLOAT NOT NULL,
  `avaliador` VARCHAR(45) NOT NULL,
  `fkIDHospede` INT NOT NULL,
  PRIMARY KEY (`idAvaliacao`, `fkIDHospede`),
  INDEX `fkAvaliacoesHospedes1` (`fkIDHospede`),
  CONSTRAINT `fkAvaliacoesHospedes1`
    FOREIGN KEY (`fkIDHospede`)
    REFERENCES `hospedes` (`idHospede`));

-- -----------------------------------------------------
-- Table `computadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computadores` (
  `idPC` INT NOT NULL,
  `num` INT NOT NULL,
  `temp` INT NOT NULL,
  `preco` FLOAT NOT NULL,
  `disp` TINYINT NOT NULL,
  PRIMARY KEY (`idPC`));


-- -----------------------------------------------------
-- Table `pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pagamento` (
  `idPagamento` INT NOT NULL AUTO_INCREMENT,
  `nometitular` VARCHAR(255) NOT NULL,
  `numeroCartao` VARCHAR(16) NOT NULL,
  `dataValidade` VARCHAR(4) NOT NULL,
  `codigoSeguranca` VARCHAR(3) NOT NULL,
  `numeroBoleto` VARCHAR(48) NOT NULL,
  `numeroPix` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`idPagamento`));


-- -----------------------------------------------------
-- Table `quartos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quartos` (
  `idQuarto` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `preco` FLOAT NOT NULL,
  `disp` TINYINT NOT NULL,
  `cap` INT NOT NULL,
  `temp` INT NOT NULL,
  PRIMARY KEY (`idQuarto`));


-- -----------------------------------------------------
-- Table `salareunioes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `salareunioes` (
  `idSala` INT NOT NULL,
  `disp` TINYINT NOT NULL,
  `temp` INT NOT NULL,
  `cap` INT NOT NULL,
  `preco` FLOAT NOT NULL,
  PRIMARY KEY (`idSala`));


-- -----------------------------------------------------
-- Table `espacos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `espacos` (
  `idEspaco` INT NOT NULL AUTO_INCREMENT,
  `ocupante` INT NOT NULL,
  `checkIn` DATE NOT NULL,
  `checkOut` DATE NOT NULL,
  `fkidComputador` INT NOT NULL,
  `fkidSalaReuniao` INT NOT NULL,
  `fkidQuartos` INT NOT NULL,
  `fkidHospede` INT NOT NULL,
  `fkidPagamento` INT NOT NULL,
  PRIMARY KEY (`idEspaco`),
  CONSTRAINT `fk_espacos_hospedes1`
    FOREIGN KEY (`fkidHospede`)
    REFERENCES `hospedes` (`idHospede`),
  CONSTRAINT `fk_espacos_Pagamento1`
    FOREIGN KEY (`fkidPagamento`)
    REFERENCES `pagamento` (`idPagamento`),
  CONSTRAINT `fkEspacosComputadores1`
    FOREIGN KEY (`fkidComputador`)
    REFERENCES `computadores` (`idPC`),
  CONSTRAINT `fkEspacosQuartos1`
    FOREIGN KEY (`fkidQuartos`)
    REFERENCES `quartos` (`idQuarto`),
  CONSTRAINT `fkEspacosSalaReunioes1`
    FOREIGN KEY (`fkidSalaReuniao`)
    REFERENCES `salareunioes` (`idSala`));


-- -----------------------------------------------------
-- Table `servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicos` (
  `idServico` INT NOT NULL,
  `nomeServico` VARCHAR(45) NOT NULL,
  `precoServico` FLOAT NOT NULL,
  `pagEfetuado` TINYINT NOT NULL,
  PRIMARY KEY (`idServico`));


-- -----------------------------------------------------
-- Table `servicosconsumidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `servicosconsumidos` (
  `idServicoConsumido` INT NOT NULL AUTO_INCREMENT,
  `fkIDHospede` INT NOT NULL,
  `fkServico` INT NOT NULL,
  PRIMARY KEY (`idServicoConsumido`, `fkIDHospede`, `fkServico`),
  CONSTRAINT `fkServicosConsumidosHospedes1`
    FOREIGN KEY (`fkIDHospede`)
    REFERENCES `hospedes` (`idHospede`),
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

insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (81, 'Solteiro', 250.00, false, 1,1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (82, 'Suíte', 350.00, true, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (83, 'Cama Dupla', 450.00, true, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (84, 'Cama Dupla', 450.00, true, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (85, 'Cama Dupla', 450.00, false, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (86, 'Cama Dupla', 450.00, false, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (87, 'Suíte', 350.00, false, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (88, 'Suíte', 350.00, false, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (89, 'Cama Dupla', 450.00, true, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (90, 'Solteiro', 250.00, true, 1, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (91, 'Solteiro', 250.00, false, 1, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (92, 'Cama Dupla', 450.00, false, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (93, 'Cama Dupla', 450.00, false, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (94, 'Suíte', 350.00, true, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (95, 'Solteiro', 250.00, false, 1, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (96, 'Solteiro', 250.00, false, 1, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (97, 'Cama Dupla', 450.00, true, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (98, 'Suíte', 350.00, true, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (99, 'Solteiro', 250.00, false, 1, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (100, 'Suíte', 350.00, false, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (121, 'Solteiro', 250.00, false, 1,1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (122, 'Solteiro', 250.00, true, 1,1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (123, 'Solteiro', 250.00, false, 1,1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (124, 'Solteiro', 250.00, true, 1,1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (125, 'Suíte', 350.00, true, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (126, 'Suíte', 350.00, false, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (127, 'Suíte', 350.00, true, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (128, 'Suíte', 350.00, false, 2, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (129, 'Cama Dupla', 450.00, true, 4, 1);
insert into Quartos (idQuarto, tipo, preco, disp, cap, temp) values (130, 'Cama Dupla', 450.00, false, 4, 1);

insert into Computadores (idPC, num, temp, preco, disp) values (41, 1, 1, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (42, 2, 2, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (43, 3, 3, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (44, 4, 4, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (45, 5, 5, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (46, 6, 6, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (47, 7, 7, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (48, 8, 8, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (49, 9, 9, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (50, 10, 10, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (51, 11, 11, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (52, 12, 12, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (53, 13, 13, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (54, 14, 14, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (55, 15, 15, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (56, 16, 16, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (57, 17, 17, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (58, 18, 18, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (59, 19, 19, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (60, 20, 20, 250.00,1);

insert into Computadores (idPC, num, temp, preco, disp) values (131, 1, 1, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (132, 2, 2, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (133, 3, 3, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (134, 4, 4, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (135, 5, 5, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (136, 6, 6, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (137, 7, 7, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (138, 8, 8, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (139, 9, 9, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (140, 10, 10, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (141, 11, 11, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (142, 12, 12, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (143, 13, 13, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (144, 14, 14, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (145, 15, 15, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (146, 16, 16, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (147, 17, 17, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (148, 18, 18, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (149, 19, 19, 250.00,1);
insert into Computadores (idPC, num, temp, preco, disp) values (150, 20, 20, 250.00,1);

insert into SalaReunioes (idSala, disp, temp, cap, preco) values (61, false, 80, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (62, false, 90, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (63, true, 60, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (64, false, 70, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (65, false, 100, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (66, false, 60, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (67, false, 70, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (68, true, 90, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (69, true, 60, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (70, true, 100, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (71, false, 100, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (72, true, 100, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (73, true, 60, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (74, false, 70, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (75, false, 90, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (76, false, 100, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (77, false, 70, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (78, true, 60, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (79, true, 90, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (80, false, 60, 8, 100.00);

insert into SalaReunioes (idSala, disp, temp, cap, preco) values (151, false, 80, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (152, false, 90, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (153, true, 60, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (154, false, 70, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (155, false, 100, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (156, false, 60, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (157, false, 70, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (158, true, 90, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (159, true, 60, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (160, true, 100, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (161, false, 100, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (162, true, 100, 8, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (163, true, 60, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (164, false, 70, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (165, false, 90, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (166, false, 100, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (167, false, 70, 10, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (168, true, 60, 4, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (169, true, 90, 6, 100.00);
insert into SalaReunioes (idSala, disp, temp, cap, preco) values (170, false, 60, 8, 100.00);

