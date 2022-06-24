CREATE TABLE Customer (
   cid         BIGINT         PRIMARY KEY AUTO_INCREMENT,
   name       VARCHAR(10)    NOT NULL,
   Ssn       VARCHAR(14)    NOT NULL,
   regDate    TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 1001;

INSERT INTO CUSTOMER (name, ssn) 
VALUES ('홍길동', '801225-1234567');


CREATE TABLE Account (
   aid            BIGINT      PRIMARY KEY AUTO_INCREMENT,
   accType         CHAR       NOT NULL   DEFAULT 'S',
   balance       DOUBLE      NOT NULL   DEFAULT 0.0,
   interestRate    DOUBLE       NOT NULL   DEFAULT 0.0,
   overdraftAmount DOUBLE      NOT NULL   DEFAULT 0.0,
   customerId      BIGINT      NOT NULL,
   regDate         TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
   CONSTRAINT Account_customerId_FK FOREIGN KEY (customerId) REFERENCES Customer(cid)
) AUTO_INCREMENT = 2001;

INSERT INTO Account (accType, balance, interestRate, overdraftAmount, customerId)
VALUES ('C', '2000.0', '0.03', '0.0', 1001);
