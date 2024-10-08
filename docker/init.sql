CREATE Database campusDb;

CREATE TABLE product IF NOT EXISTS campusDb.product
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name              VARCHAR(255)                            NOT NULL,
    photo_name        VARCHAR(255)                            NOT NULL,
    purchase_price    DOUBLE PRECISION                        NOT NULL,
    selling_price     DOUBLE PRECISION                        NOT NULL,
    promotional_price DOUBLE PRECISION,
    stock             BIGINT                                  NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
    );