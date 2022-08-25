CREATE TABLE Menu(
	name			VARCHAR(500)		PRIMARY KEY,
	price			VARCHAR(20)			NOT NULL DEFAULT 0,
	categoryName	VARCHAR(500)		NOT NULL,
	imgName			VARCHAR(100)		DEFAULT NULL,	
	
	CONSTRAINT Menu_categoryName_FK
		FOREIGN KEY(categoryName) REFERENCES Category(name)
)


DROP TABLE Menu

SELECT * FROM Menu

CREATE TABLE Category(
	name	VARCHAR(20)		PRIMARY KEY
--		CONSTRAINT Category_name_FK
--		FOREIGN KEY(name) REFERENCES Menu(categoryName)
)

SELECT * FROM Category

DROP TABLE Category