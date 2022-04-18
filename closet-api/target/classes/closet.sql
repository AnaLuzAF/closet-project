SET NAMES utf8;
DROP DATABASE Closet;
CREATE DATABASE IF NOT EXISTS Closet;
    
USE Closet;

CREATE TABLE IF NOT EXISTS user (
id				    INT AUTO_INCREMENT PRIMARY KEY,
nickname		    VARCHAR (30) NOT NULL,
password		    VARCHAR (20) NOT NULL,
email 				VARCHAR (50) NOT NULL
);

CREATE TABLE IF NOT EXISTS item_type (
type_name		         VARCHAR (50) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS item (
id				    INT AUTO_INCREMENT PRIMARY KEY,
item_type	        VARCHAR (40) NOT NULL,
imagename		    VARCHAR (40) NOT NULL,
user_id             INT,
CONSTRAINT FK_ITEM_USER
FOREIGN KEY(user_id)
REFERENCES user(id)
ON UPDATE CASCADE
ON DELETE CASCADE,
CONSTRAINT FK_ITEM_TYPE
FOREIGN KEY(item_type)
REFERENCES item_type(type_name)
ON UPDATE CASCADE
ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS category (
name                VARCHAR (50) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS outfit (
id                                INT AUTO_INCREMENT PRIMARY KEY,
top_id                              INT NOT NULL,
bottom_id                            INT NOT NULL,
shoes_id                            INT NOT NULL,
categories                        VARCHAR (50) NOT NULL,
user_id                           INT,
CONSTRAINT FK_OUTFIT_TOP
FOREIGN KEY (top_id)
REFERENCES item (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_BOTTOM
FOREIGN KEY (bottom_id)
REFERENCES item (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_SHOES
FOREIGN KEY (shoes_id)
REFERENCES item (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_USER
FOREIGN KEY (user_id)
REFERENCES user (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_CATEGORY
FOREIGN KEY(categories)
REFERENCES category(name)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

INSERT INTO user(nickname,password,email) VALUES('testUser','1234','testUser@gmail.com');

INSERT INTO item_type(type_name) VALUES('top');
INSERT INTO item_type(type_name) VALUES('bottom');
INSERT INTO item_type(type_name) VALUES('shoes');

INSERT INTO item(item_type,  imagename) VALUES('top','shirt');
INSERT INTO item(item_type,  imagename) VALUES('bottom', 'shorts');
INSERT INTO item(item_type,  imagename) VALUES('shoes' ,'sneakers');


INSERT INTO category(name) VALUES('sport');


INSERT INTO outfit(top_id, bottom_id, shoes_id, categories) VALUES(1, 2, 3,'sport');