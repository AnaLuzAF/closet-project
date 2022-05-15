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
image_item          VARCHAR (9900) NOT NULL,
user_id             INT NOT NULL,
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
category                        VARCHAR (50) NOT NULL,
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
    ON DELETE CASCADE,
CONSTRAINT FK_OUTFIT_CATEGORY
FOREIGN KEY(category)
REFERENCES category(name)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

INSERT INTO user(nickname,password,email) VALUES('testUser','1234','testUser@gmail.com');

INSERT INTO item_type(type_name) VALUES('top');
INSERT INTO item_type(type_name) VALUES('bottom');
INSERT INTO item_type(type_name) VALUES('shoes');

INSERT INTO item(item_type,image_item, user_id) VALUES('top','https://m.media-amazon.com/images/I/41AJRi4twYS._SL500_.jpg', 1);
INSERT INTO item(item_type, image_item ,user_id) VALUES('bottom','https://www.emp-online.es/dw/image/v2/BBQV_PRD/on/demandware.static/-/Sites-master-emp/default/dwa79c0133/images/5/0/8/2/508208a.jpg?sw=1000&sh=800&sm=fit&sfrm=png', 1);
INSERT INTO item(item_type,image_item, user_id) VALUES('shoes','https://www.emp-online.es/dw/image/v2/BBQV_PRD/on/demandware.static/-/Sites-master-emp/default/dw839947bd/images/4/9/9/5/499553a.jpg?sw=1000&sh=800&sm=fit&sfrm=png', 1);

INSERT INTO item(item_type,image_item, user_id) VALUES('top','https://b2c-media.maxmara.com/sys-master/m0/MM/2022/1/5111122106/001/s3details/5111122106001-y-lord_thumbnail.jpg', 1);
INSERT INTO item(item_type, image_item ,user_id) VALUES('bottom','https://cdn.fashiola.es/L592917803/sandro-pantalones-de-vestir-anchos.jpg', 1);
INSERT INTO item(item_type,image_item, user_id) VALUES('shoes','https://m.media-amazon.com/images/I/41xjpblvwqL._SL500_.jpg', 1);

INSERT INTO item(item_type,image_item, user_id) VALUES('top','https://m.media-amazon.com/images/I/517Z9hJSamL._AC_SX425_.jpg', 1);
INSERT INTO item(item_type, image_item ,user_id) VALUES('bottom','https://m.media-amazon.com/images/I/61ee-M+J9QL._AC_UL320_.jpg', 1);
INSERT INTO item(item_type,image_item, user_id) VALUES('shoes','https://images-na.ssl-images-amazon.com/images/I/71k7Gfw1mAL._AC_UY395_.jpg', 1);

INSERT INTO item(item_type,image_item, user_id) VALUES('top','https://cdn.fashiola.es/L574473267/wowsome-unicornio-levantamiento-de-pesas-camisa-deadlift-fitness-gym-mujeres-camiseta-sin-mangas.jpg', 1);
INSERT INTO item(item_type, image_item ,user_id) VALUES('bottom','https://s3-eu-west-1.amazonaws.com/images.linnlive.com/3f25aa9d1567d021dac96f3dcb03559f/548427a7-27d4-4902-b7a0-0bfe6b0499b2.jpg', 1);
INSERT INTO item(item_type,image_item, user_id) VALUES('shoes','https://m.media-amazon.com/images/I/417jrvIMh8L.jpg', 1);

INSERT INTO item(item_type,image_item, user_id) VALUES('top','https://ae01.alicdn.com/kf/HTB1a1hhcBWD3KVjSZFsq6AqkpXaE/Camisetas-de-vendaje-cruzado-para-mujer-Top-corto-camiseta-de-manga-corta-para-mujer-ropa-femenina.jpg_q50.jpg', 1);
INSERT INTO item(item_type, image_item ,user_id) VALUES('bottom','https://www.redvalentino.com/13/13454411rg_22_a.jpg', 1);
INSERT INTO item(item_type,image_item, user_id) VALUES('shoes','https://cdn.grupoelcorteingles.es/SGFM/dctm/MEDIA03/201907/05/00182368201552____7__516x640.jpg', 1);




INSERT INTO category(name) VALUES('all');
INSERT INTO category(name) VALUES('sport');
INSERT INTO category(name) VALUES('classy');
INSERT INTO category(name) VALUES('casual');


INSERT INTO outfit(top_id, bottom_id, shoes_id, category, user_id) VALUES(1, 2, 3,'sport',1);
INSERT INTO outfit(top_id, bottom_id, shoes_id, category, user_id) VALUES(1, 2, 3,'classy',1);
INSERT INTO outfit(top_id, bottom_id, shoes_id, category, user_id) VALUES(1, 2, 3,'casual',1);