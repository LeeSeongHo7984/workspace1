use jv250;

show tables;

select * from CUSTOMER;

CREATE INDEX CustomerIndex ON Customer(ssn);

SELECT aid, accountNum, accountType, balance FROM Account a INNER JOIN Customer c 
on a.customerId = c.cid
WHERE c.Ssn = "900101-1234567"