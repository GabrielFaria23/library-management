CREATE TABLE library(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    library_name VARCHAR(200) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE hall(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    hall_name VARCHAR(100) NOT NULL,
    library_id BIGINT(20) NOT NULL,
    FOREIGN KEY (library_id) REFERENCES library(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE shelf(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    shelf_name VARCHAR(100) NOT NULL,
    hall_id BIGINT(20) NOT NULL,
    FOREIGN KEY (hall_id) REFERENCES hall(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE book(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(300) NOT NULL,
    publication_date DATE NOT NULL,
    author VARCHAR(100) NOT NULL,
    hall_id BIGINT(20) NOT NULL,
    shelf_id BIGINT(20) NOT NULL,
    FOREIGN KEY (hall_id) REFERENCES hall(id),
    FOREIGN KEY (shelf_id) REFERENCES shelf(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO library (library_name) values ("library 1");

INSERT INTO hall (hall_name,library_id) values("1", 1);

INSERT INTO shelf (shelf_name, hall_id) values ("A", 1);

INSERT INTO book (title, description, publication_date, author, hall_id, shelf_id) values("JavaEE", "book about programing with java and some frameworks like spring boot", '2010-11-10', "richard", 1, 1);