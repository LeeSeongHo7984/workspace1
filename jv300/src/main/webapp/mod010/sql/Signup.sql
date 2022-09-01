CREATE TABLE Signup (
<<<<<<< HEAD
<<<<<<< HEAD
	sid 	BIGINT		PRIMARY KEY AUTO_INCREMENT,
	userName 	VARCHAR(6) 	NOT NULL,
	ssn 	VARCHAR(14) NOT NULL,
	phone 	VARCHAR(14) NOT NULL,
	userId 	VARCHAR(16) NOT NULL,
	passwd 	VARCHAR(60) NOT NULL
=======
=======
>>>>>>> main
	sid 		BIGINT		PRIMARY KEY AUTO_INCREMENT,
	userName 	VARCHAR(6) 	NOT NULL,
	ssn 		VARCHAR(14) NOT NULL,
	phone 		VARCHAR(14) NOT NULL,
	userId 		VARCHAR(16) NOT NULL,
	passwd 		VARCHAR(60) NOT NULL
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
)AUTO_INCREMENT = 1001;

DROP TABLE SignUp;

SELECT * FROM SignUp;

DELETE FROM Signup WHERE sid = 2;

ALTER TABLE Signup
RENAME COLUMN userId TO userId;