CREATE SCHEMA IF NOT EXISTS reactive_product_service;

CREATE TABLE IF NOT EXISTS reactive_product_service.product
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,

    CONSTRAINT ux_product_code UNIQUE (code)
);

COMMENT ON TABLE reactive_product_service.product IS 'Товары';
COMMENT ON COLUMN reactive_product_service.product.id IS 'Идентификатор товара';
COMMENT ON COLUMN reactive_product_service.product.code IS 'Код товара';
COMMENT ON COLUMN reactive_product_service.product.name IS 'Наименование товара';
COMMENT ON COLUMN reactive_product_service.product.price IS 'Цена товара';