CREATE TABLE Board(
	num			BIGINT			PRIMARY KEY AUTO_INCREMENT,
	title		VARCHAR(20)		NOT NULL,
	content		VARCHAR(200)	NOT NULL,
	regDate		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

SELECT * FROM Board;

DROP TABLE Board;

UPDATE Board SET title = '게시판', content = '등록' WHERE num = 1


