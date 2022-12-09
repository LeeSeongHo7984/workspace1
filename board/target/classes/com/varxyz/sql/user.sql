CREATE TABLE User(
	userId		VARCHAR(20)		PRIMARY KEY,
	passwd		VARCHAR(20)		NOT NULL,
	name		VARCHAR(20)		NOT NULL,
	ssn			VARCHAR(20)		NOT NULL,
	address		VARCHAR(30)		NOT NULL,
	phone		VARCHAR(20)		NOT NULL
);

select * from user;


drop table user;