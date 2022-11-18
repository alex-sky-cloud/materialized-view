CREATE TABLE purchase_orders
(
    id         BIGSERIAL,
    user_id    BIGINT,
    product_id BIGINT,
    CONSTRAINT pk_purchase_orders PRIMARY KEY (id)
);