-- CREATE SEQUENCE IF NOT EXISTS sequence_user START WITH 1 INCREMENT BY 1;

CREATE TABLE users(
    id    BIGSERIAL NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    state      VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);