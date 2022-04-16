SET NAMES utf8;
DROP DATABASE Closet;
CREATE DATABASE IF NOT EXISTS Closet;
    
USE Closet;

CREATE TABLE IF NOT EXISTS user (
id				    INT AUTO_INCREMENT PRIMARY KEY,
nick_name		    VARCHAR (30) NOT NULL,
password		    VARCHAR (20) NOT NULL,
email 				VARCHAR (50) NOT NULL
);

CREATE TABLE IF NOT EXISTS item (
id				    INT AUTO_INCREMENT PRIMARY KEY,
modeling	        VARCHAR (40) NOT NULL,
name		        VARCHAR (40) NOT NULL,
image               VARCHAR (100) NOT NULL,
user_id             INT,
FOREIGN KEY(user_id) REFERENCES user(id)
);


CREATE TABLE IF NOT EXISTS type (
id				 INT AUTO_INCREMENT PRIMARY KEY,
top		         VARCHAR (40) NOT NULL,
bottom		     VARCHAR (40) NOT NULL,
shoes		     VARCHAR (40) NOT NULL
);

CREATE TABLE IF NOT EXISTS tag(
id                  INT AUTO_INCREMENT PRIMARY KEY,
name                VARCHAR (50) NOT NULL
);

CREATE TABLE IF NOT EXISTS outfit(
id                                INT AUTO_INCREMENT PRIMARY KEY,
tags                              VARCHAR (50) NOT NULL,
clothing_id_one                   INT NOT NULL,
clothing_id_two                   INT NOT NULL,
clothing_id_three                 INT NOT NULL,
user_id                           INT NOT NULL,
CONSTRAINT FK_OUTFIT_ITEM_ONE
FOREIGN KEY (clothing_id_one)
REFERENCES item (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_ITEM_TWO
FOREIGN KEY (clothing_id_two)
REFERENCES item (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_ITEM_THREE
FOREIGN KEY (clothing_id_three)
REFERENCES item (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_USER
FOREIGN KEY (user_id)
REFERENCES user (id)
	ON UPDATE CASCADE
    ON DELETE CASCADE
);

INSERT INTO user(nick_name,password,email) VALUES('UserTester','1234','usertester@gmail.com');


INSERT INTO item(modeling, name, image, user_id) VALUES('parte de arriba', 'camisa de cuadros', 'camisaUno', 1);
INSERT INTO item(modeling, name, image, user_id) VALUES('parte de abajo', 'vaqueros','vaquerosUno', 1);
INSERT INTO item(modeling, name, image, user_id) VALUES('zapatos', 'tacones rojos','zapatosUno', 1);

INSERT INTO type(top, bottom, shoes) VALUES('top', 'bottom', 'shoes');


INSERT INTO tag(name) VALUES('sport');


INSERT INTO outfit(clothing_id_one, clothing_id_two, clothing_id_three, tags, user_id) VALUES(1, 2, 3, 'sport',1);