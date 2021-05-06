ALTER TABLE book ADD COLUMN `available` BOOLEAN NOT NULL, ADD COLUMN `quantity` BIGINT(20) NOT NULL, ADD COLUMN `price` FLOAT NOT NULL;
ALTER TABLE shelf ADD COLUMN `quantity` BIGINT(20) NOT NULL;

INSERT INTO hall (hall_name,library_id) values("2", 1);
INSERT INTO hall (hall_name,library_id) values("3", 1);
INSERT INTO hall (hall_name,library_id) values("4", 1);
INSERT INTO hall (hall_name,library_id) values("5", 1);

INSERT INTO shelf (shelf_name, hall_id, quantity) values ("A", 1, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("B", 1, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("C", 1, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("D", 1, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("E", 1, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("A", 2, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("B", 2, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("C", 2, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("D", 2, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("E", 2, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("A", 3, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("B", 3, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("C", 3, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("D", 3, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("E", 3, 10);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("A", 4, 20);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("B", 4, 20);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("C", 4, 20);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("D", 4, 20);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("E", 4, 20);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("A", 5, 30);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("B", 5, 30);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("C", 5, 30);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("D", 5, 30);
INSERT INTO shelf (shelf_name, hall_id, quantity) values ("E", 5, 30);

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("JavaEE", "book about programing with java and some frameworks like spring boot", '2010-11-10', "richard", 1, 1, true, 10, 50.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("JavaOO", "book about programing with java and some frameworks like spring boot", '2010-11-10', "richard", 1, 1, true, 10, 60.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("A Fuga das galinhas", "book about chickens", '2010-11-10', "richard", 1, 1, true, 5, 100.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("Esqueceram de mim 2", "book about forgot children", '2010-10-20', "richard", 1, 1, true, 20, 30.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("Interistelar", ".", '2010-11-10', "richard", 1, 1, true, 50, 70.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("Marvel vs Capcom", "Super Hero", '2010-11-10', "richard", 1, 1, true, 100, 80.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("Capitão America", "Captain America", '2016-11-17', "richard", 1, 1, true, 10, 100.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("Edd Murf", "Comedy with edd murf", '2015-12-05', "richard", 1, 1, true, 10, 150.00);
INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, price) values("Do 1 ao 1 milhão", "investimentos", '2017-11-10', "richard", 1, 1, true, 100, 35.00);