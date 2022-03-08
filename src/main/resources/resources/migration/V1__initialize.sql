SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS fresh_market;

CREATE TABLE categories (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO categories (name)
VALUES('Vegatable'),('Friut'),('Meat');

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO products (name)
VALUES
('tomato'),
('orange'),
('corn'),
('beef'),
('apple'),
('potato'),
('chicken');

DROP TABLE IF EXISTS products_categories;

CREATE TABLE products_categories (
  product_id int(11) NOT NULL,
  category_id int(11) NOT NULL,

  PRIMARY KEY (product_id, category_id),

  KEY FK_ROLE_idx (category_id),

  CONSTRAINT FK_PRODUCT_05 FOREIGN KEY (product_id)
  REFERENCES products (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_CATEGORY FOREIGN KEY (category_id)
  REFERENCES categories (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO products_categories (product_id, category_id)
VALUES
(1, 1),
(2, 2),
(3, 1),
(4, 3),
(5, 2),
(6, 1),
(7, 3);
