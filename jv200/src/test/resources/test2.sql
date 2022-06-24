INSERT INTO CUSTOMER(name, Ssn)
VALUES('James Bond', '900101-1234567');

INSERT INTO ACCOUNT (accType, interestRate, overdraftAmount, customerId)
VALUES('C', '2000.0', '0.0', 1001);

UPDATE COUSTOMER SET name="Jason Bourne" WHERE cid = 1002;

DELETE FROM CUSTOMER WHERE cid = 1002;

SELECT accType, balance FROM ACCOUNT WHERE aid = '3001';