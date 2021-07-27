CREATE TABLE library(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    library_name VARCHAR(200) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE hall(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    hall_name VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE shelf(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    shelf_name VARCHAR(100) NOT NULL,
    quantity_books BIGINT(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(300) NOT NULL,
    publication_date DATE NOT NULL,
    author VARCHAR(100) NOT NULL,
    hall_id BIGINT(20) NOT NULL,
    shelf_id BIGINT(20) NOT NULL,
    available BOOLEAN NOT NULL,
    quantity BIGINT(20) NOT NULL,
    sale_price FLOAT NOT NULL,
    rented BOOLEAN NOT NULL,
    rent_price FLOAT NOT NULL,
    date_deliver_book DATE NOT NULL,
    FOREIGN KEY (hall_id) REFERENCES hall(id),
    FOREIGN KEY (shelf_id) REFERENCES shelf(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO library (library_name) values ("library 1");

INSERT INTO hall (hall_name) values("1");

INSERT INTO shelf (shelf_name,quantity_books) values ("A",50);

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id, available, quantity, sale_price,
                  rented, rent_price, date_deliver_book) values("JavaEE", "book about programing with java and some
                    frameworks like spring boot", '2010-11-10', "richard", 1, 1, True, 5, 10.0, False, 2.0, '2021-02-20');