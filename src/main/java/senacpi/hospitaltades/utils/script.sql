CREATE DATABASE IF NOT EXISTS `hospital_tades`;
USE `hospital_tades`;

CREATE TABLE `paciente` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `nome` varchar(45) DEFAULT NULL,
    `dataNasc` varchar(11) DEFAULT NULL,
    `rg` varchar(15) DEFAULT NULL,
    `cpf` varchar(15) DEFAULT NULL,
    `sexo` varchar(15) DEFAULT NULL,
    `contato` varchar(15) DEFAULT NULL,
    `email` varchar(15) DEFAULT NULL,
    `cep` varchar(15) DEFAULT NULL,
    `endereco` varchar(45) DEFAULT NULL,
	`bairro` varchar(45) DEFAULT NULL,
    `cidade` varchar(30) DEFAULT NULL,
    `estado` varchar(2) DEFAULT NULL,
    `ativo` boolean,
    `codigoempresa` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `paciente` VALUES (1, 'Maria', '20/01/1997', '532820885', '45861678820', 'Feminino', '11941218970', 'maria@gmail.com', '04850110', 'rua matos de carriço, 77',
									'parque cocaia', 'são paulo', 'SP', true, '123'), (2, 'João', '20/01/1997', '532820885', '45861678820', 'Feminino', '11941218970', 'joao@gmail.com', '04850110', 'rua matos de carriço, 77',
									'parque cocaia', 'são paulo', 'SP', true, '123');