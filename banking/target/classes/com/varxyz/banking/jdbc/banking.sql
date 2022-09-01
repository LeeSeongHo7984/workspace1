CREATE TABLE Customer(
	userId			VARCHAR(20)		PRIMARY KEY NOT NULL,
	passwd			VARCHAR(20)		NOT NULL,
	name			VARCHAR(20)		NOT NULL,
	ssn				VARCHAR(20)		NOT NULL,
	phone			VARCHAR(20)		NOT NULL
)

-- 컬럼명 바꾸기
ALTER TABLE Customer
RENAME COLUMN customerId TO userId;

SELECT * FROM Customer; 

DROP TABLE Customer;

INSERT INTO Customer (userId, passwd, name, ssn, phone) VALUES("asd", "1234", "asd", "1111", "1111");

CREATE TABLE Account(
	aid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	customerId		VARCHAR(20)		NOT NULL,
	accountNum		CHAR(11)		NOT NULL, -- 000-00-0000
	accType			CHAR(1)			NOT NULL DEFAULT 'S',
	balance			DOUBLE			NOT NULL DEFAULT 0.0,	-- 잔고
	interestRate	DOUBLE			NOT NULL DEFAULT 0.0,	-- 이자율
	overAmount		DOUBLE			NOT NULL DEFAULT 0.0,	-- 한도액
	
	CONSTRAINT Account_customerId_FK
		FOREIGN KEY(customerId) REFERENCES Customer(userId)
)AUTO_INCREMENT = 3001;

SELECT * FROM Account;

DELETE FROM Account WHERE aid = 3011;

DROP TABLE Account