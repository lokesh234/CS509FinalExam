CREATE DATABASE atm;

USE atm;

CREATE TABLE accounts (
                          accountNumber INT AUTO_INCREMENT PRIMARY KEY,
                          holderName VARCHAR(255),
                          balance DOUBLE,
                          status VARCHAR(50),
                          login VARCHAR(50) UNIQUE,
                          pin INT
);

INSERT INTO accounts (holderName, balance, status, login, pin)
VALUES ('Test User', 1000.0, 'active', 'testuser', 1234);
