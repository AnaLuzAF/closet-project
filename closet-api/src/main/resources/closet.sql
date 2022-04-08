SET NAMES utf8;
DROP DATABASE Library;
CREATE DATABASE IF NOT EXISTS Library;
    
USE Library;

CREATE TABLE IF NOT EXISTS book (
isbn				VARCHAR (20) PRIMARY KEY,
title		        VARCHAR (40) NOT NULL,
author		        VARCHAR (80) NOT NULL,
year				INT NOT NULL
);

CREATE TABLE IF NOT EXISTS member (
nif					VARCHAR (10) PRIMARY KEY,
name		        VARCHAR (40) NOT NULL,
surname		        VARCHAR (80) NOT NULL
);

CREATE TABLE IF NOT EXISTS status (
id					INT AUTO_INCREMENT PRIMARY KEY,
name		        VARCHAR (40) NOT NULL
);

CREATE TABLE IF NOT EXISTS book_lend(
id                  INT AUTO_INCREMENT PRIMARY KEY,
nif                 VARCHAR (10) NOT NULL,
isbn				VARCHAR (20) NOT  NULL,
lend_date			DATETIME NOT NULL,
return_date         DATETIME NULL,
status_id           INT NOT NULL,
CONSTRAINT FK_LEND_MEMBER
FOREIGN KEY (nif)
REFERENCES member (nif)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
    
CONSTRAINT FK_LEND_BOOK
FOREIGN KEY (isbn)
REFERENCES book (isbn)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_LEND_STATUS
FOREIGN KEY (status_id)
REFERENCES status (id)
	ON UPDATE CASCADE
    ON DELETE RESTRICT
);

INSERT INTO status(id, name) VALUES(1, 'Prestado');
INSERT INTO status(id, name) VALUES(2, 'Devuelto');

INSERT INTO book(isbn, title, author, year) VALUES('A344343', 'El pollo pepe', 'Carlos Martínez', 2005);
INSERT INTO book(isbn, title, author, year) VALUES('A344332', '1984', 'George Orwell', 1949);

INSERT INTO member(nif, name, surname) VALUES('00000000X', 'Peppa', 'Pig');
INSERT INTO member(nif, name, surname) VALUES('00000001X', 'Bob', 'Esponja');

INSERT INTO book_lend(nif, isbn, lend_date, status_id) VALUES('00000001X', 'A344332',  CURRENT_TIME(), 1);
INSERT INTO book_lend(nif, isbn, lend_date, return_date, status_id) VALUES('00000001X', 'A344343',  subdate(curdate(), 1), CURRENT_TIME(), 2);

INSERT INTO book_lend(nif, isbn, lend_date, status_id) VALUES('00000000X', 'A344343',  CURRENT_TIME(), 1);
