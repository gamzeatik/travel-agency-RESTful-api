alter table if exists reservation
    add column if not exists flight_number varchar;

alter table if exists reservation
    add column if not exists note text;

alter table if exists reservation
    drop column if exists first_name;

alter table if exists reservation
    drop column if exists last_name;

alter table if exists reservation
    drop column if exists email;


alter table if exists reservation
    drop column if exists phone;


alter table if exists reservation
    drop column if exists address;


CREATE TABLE IF NOT EXISTS customer
(
    id                  UUID PRIMARY KEY,
    first_name          VARCHAR(255),
    last_name           VARCHAR(255),
    passenger_full_name text,
    email               VARCHAR(255),
    phone               VARCHAR(20),
    address             TEXT,
    nationality         varchar(255)
);


CREATE TABLE reservation_customer
(
    reservation_id UUID NOT NULL,
    customer_id    UUID NOT NULL,
    PRIMARY KEY (reservation_id, customer_id),
    CONSTRAINT fk_reservation
        FOREIGN KEY (reservation_id)
            REFERENCES reservation (id)
            ON DELETE CASCADE,
    CONSTRAINT fk_customer
        FOREIGN KEY (customer_id)
            REFERENCES customer (id)
            ON DELETE CASCADE
);
