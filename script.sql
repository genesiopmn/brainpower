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
