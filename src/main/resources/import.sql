DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, title VARCHAR(255), unit VARCHAR(30), cost float, PRIMARY KEY (id));
INSERT INTO products (title, unit, cost) VALUES ('Хлеб', 'бух.', 68.95), ('Молоко', 'л', 75.35), ('Яйцо','дес. шт.',  59.99), ('Сыр', 'кг', 585.69), ('Мясо','кг',  480.99);
