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

CREATE TABLE IF NOT EXISTS item (
id				    INT AUTO_INCREMENT PRIMARY KEY,
item_type	        VARCHAR (40) NOT NULL,
imagename		    VARCHAR (40) NOT NULL,
user_id             INT,
FOREIGN KEY(user_id) REFERENCES user(id)
);


CREATE TABLE IF NOT EXISTS item_type (
id				 INT AUTO_INCREMENT PRIMARY KEY,
top		         VARCHAR (40) NOT NULL,
bottom		     VARCHAR (40) NOT NULL,
shoes		     VARCHAR (40) NOT NULL
);

CREATE TABLE IF NOT EXISTS category(
id                  INT AUTO_INCREMENT PRIMARY KEY,
name                VARCHAR (50) NOT NULL
);

CREATE TABLE IF NOT EXISTS outfit(
id                                INT AUTO_INCREMENT PRIMARY KEY,
top_id                              INT NOT NULL,
bottom_id                            INT NOT NULL,
shoes_id                            INT NOT NULL,
categories                        VARCHAR (50) NOT NULL,
user_id                           INT NOT NULL,
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
    ON DELETE CASCADE
);

INSERT INTO user(nickname,password,email) VALUES('UserTester','1234','usertester@gmail.com');


INSERT INTO item(item_type,  imagename, user_id) VALUES('top','camisaUno', 1);
INSERT INTO item(item_type,  imagename, user_id) VALUES('bottom', 'vaquerosUno', 1);
INSERT INTO item(item_type,  imagename, user_id) VALUES('shoes' ,'zapatosUno', 1);

INSERT INTO item_type(top, bottom, shoes) VALUES('top', 'bottom', 'shoes');


INSERT INTO category(name) VALUES('sport');


INSERT INTO outfit(top_id, bottom_id, shoes_id, categories, user_id) VALUES(1, 2, 3,'sport',1);