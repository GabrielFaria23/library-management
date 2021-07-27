INSERT INTO hall (hall_name) values("2");
INSERT INTO hall (hall_name) values("3");
INSERT INTO hall (hall_name) values("4");
INSERT INTO hall (hall_name) values("5");

INSERT INTO shelf (shelf_name, quantity_books) values ("A", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("B", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("C", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("D", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("E", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("A", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("B", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("C", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("D", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("E", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("A", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("B", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("C", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("D", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("E", 10);
INSERT INTO shelf (shelf_name, quantity_books) values ("A", 20);
INSERT INTO shelf (shelf_name, quantity_books) values ("B", 20);
INSERT INTO shelf (shelf_name, quantity_books) values ("C", 20);
INSERT INTO shelf (shelf_name, quantity_books) values ("D", 20);
INSERT INTO shelf (shelf_name, quantity_books) values ("E", 20);
INSERT INTO shelf (shelf_name, quantity_books) values ("A", 30);
INSERT INTO shelf (shelf_name, quantity_books) values ("B", 30);
INSERT INTO shelf (shelf_name, quantity_books) values ("C", 30);
INSERT INTO shelf (shelf_name, quantity_books) values ("D", 30);
INSERT INTO shelf (shelf_name, quantity_books) values ("E", 30);

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                    rented, rent_price, date_deliver_book) values("JavaEE", "book about programing with java and some
                    frameworks like spring boot", '2010-11-10', "richard", 1, 1, true, 10, 50.00, false, 5.00, '2015-11-20');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("JavaOO", "book about programing with java and some
                  frameworks like spring boot", '2010-11-10', "richard", 1, 1, true, 10, 60.00, false, 5.00, '2016-11-20');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("A Fuga das galinhas", "book about chickens", '2010-11-10',
                   "richard", 1, 1, true, 5, 100.00, false, 0.0, '2015-11-20');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("Esqueceram de mim 2", "book about forgot children",
                   '2010-10-20', "richard", 1, 1, true, 20, 30.00, true, 5.00, '2019-11-11');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("Interistelar", ".", '2010-11-10', "richard", 1, 1, true,
                   50, 70.00, false, 7.00, '2016-1-20');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("Marvel vs Capcom", "Super Hero", '2010-11-10', "richard",
                  1, 1, true, 100, 80.00, false, 8.00, '2012-11-21');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("Capitão America", "Captain America", '2016-11-17',
                  "richard", 1, 1, true, 10, 100.00, false, 10.00, '2013-11-20');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("Edd Murf", "Comedy with edd murf", '2015-12-05',
                  "richard", 1, 1, true, 10, 150.00, false, 15.00, '2017-05-20');

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("Do 1 ao 1 milhão", "investimentos", '2017-11-10',
                  "richard", 1, 1, true, 100, 35.00, false, 5.00, '2015-11-20');
