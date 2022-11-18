CREATE TABLE products
(
    id          BIGSERIAL,
    description VARCHAR(255),
    price       DOUBLE PRECISION NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);