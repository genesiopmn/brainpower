CREATE DATABASE IF NOT EXISTS 'APIREST' DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

CREATE TABLE Client (
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    createdAt DATETIME,
    updatedAt DATETIME,
    active BOOLEAN,
    name VARCHAR(50),
    identificationDocument VARCHAR(50),
    email VARCHAR(50),
    telephone VARCHAR(13),
    birthdate  DATE,
    acceptStorageLgpd BOOLEAN
);

CREATE TABLE Account (
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    transHistId INT(11),
    createdAt DATETIME,
    updatedAt DATETIME,
    active BOOLEAN,
    accountNumber VARCHAR(20),
    agencyNumber CHAR(10),
    agencyTelephone CHAR(13),
    accountStatus INT,
    accountBalance DOUBLE,
    clientId INT(11)
);

CREATE TABLE FullAdress (
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    createdAt DATETIME,
    updatedAt DATETIME,
    active BOOLEAN,
    address VARCHAR(50),
    number INT(11),
    complement VARCHAR(50),
    district VARCHAR(50),
    city VARCHAR(50),
    zipCode VARCHAR(13),
    state VARCHAR(50),
    country VARCHAR(50),
    addressId INT(11)
);

CREATE TABLE TransactionHistory (
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    createdAt DATETIME,
    updatedAt DATETIME,
    active BOOLEAN,
    history CHAR(10),
    date DATETIME,
    value VARCHAR(20),
    issuerAccountId INT(11),
    destinationAccountId INT(11)
);
 
ALTER TABLE Account ADD CONSTRAINT FK_Account_2
    FOREIGN KEY (clientId)
    REFERENCES Client (id);
 
ALTER TABLE FullAdress ADD CONSTRAINT FK_FullAdress_2
    FOREIGN KEY (addressId)
    REFERENCES Client (id);
 
ALTER TABLE TransactionHistory ADD CONSTRAINT FK_TransactionHistory_2
    FOREIGN KEY (issuerAccountId)
    REFERENCES Account (id);
 
ALTER TABLE TransactionHistory ADD CONSTRAINT FK_TransactionHistory_3
    FOREIGN KEY (destinationAccountId)
    REFERENCES Account (id);


INSERT INTO `account` (`id`, `transHistId`, `createdAt`, `updatedAt`, `active`, `accountNumber`, `agencyNumber`, `agencyTelephone`, `accountStatus`, `accountBalance`, `clientId`) VALUES (NULL, NULL, '2021-11-07 19:26:20.000000', '2021-11-07 19:26:20.000000', '1', '243400', '143', '8133449999', '1', '2000', NULL), (NULL, NULL, '2021-11-07 19:26:20.000000', '2021-11-07 19:26:20.000000', '1', '442', '4243400', '1187748889', '1', '3000', NULL);

INSERT INTO `client` (`id`, `createdAt`, `updatedAt`, `active`, `name`, `identificationDocument`, `email`, `telephone`, `birthdate`, `acceptStorageLgpd`) VALUES (NULL, '2021-11-07 19:35:38.000000', '2021-11-07 19:35:38.000000', '1', 'Fernanda Montenegro', '240129482913', 'fmon@hotmail.com', '11988777878', '11/01/1948', '1');

INSERT INTO `client` (`id`, `createdAt`, `updatedAt`, `active`, `name`, `identificationDocument`, `email`, `telephone`, `birthdate`, `acceptStorageLgpd`) VALUES (NULL, '2021-11-07 19:35:38.000000', '2021-11-07 19:35:38.000000', '1', 'Tarcisio Meira', '111928931890', 'tmeira@hotmail.com', '11984427222', '11/01/1948', '1');

INSERT INTO `fulladress` (`id`, `createdAt`, `updatedAt`, `active`, `address`, `number`, `complement`, `district`, `city`, `zipCode`, `state`, `country`, `addressId`) VALUES (NULL, '2021-11-07 19:41:08.000000', '2021-11-07 19:41:08.000000', '1', 'Av João Cabral de Melo Neto', '282', NULL, NULL, 'São Paulo', '1828304', 'São Paulo', 'Brasil', NULL), (NULL, '2021-11-07 19:41:08.000000', '2021-11-07 19:41:08.000000', '1', 'Rua Joaquim José da Silva Xavier', '293', NULL, NULL, 'Recife', '2930910', 'Pernambuco', 'Brasil', NULL);

INSERT INTO `transactionhistory` (`id`, `createdAt`, `updatedAt`, `active`, `history`, `date`, `value`, `issuerAccountId`, `destinationAccountId`) VALUES (NULL, '2021-11-07 19:45:23.000000', '2021-11-07 19:45:23.000000', '1', 'h001', '2021-11-07 19:45:23.000000', '285928358234', '1', '1'), (NULL, '2021-11-07 19:45:23.000000', '2021-11-07 19:45:23.000000', '1', 'h002', '2021-11-07 19:45:23.000000', '1298912389018', '2', '2');
