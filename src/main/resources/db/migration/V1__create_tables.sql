CREATE TABLE IF NOT EXISTS about_us
(
    id          UUID PRIMARY KEY,
    title       VARCHAR(255),
    description TEXT,
    is_active   BOOLEAN DEFAULT true,
    create_at   TIMESTAMP WITH TIME ZONE
);
CREATE TABLE IF NOT EXISTS blogs
(
    id          UUID PRIMARY KEY,
    title       VARCHAR(255),
    description TEXT,
    is_active   BOOLEAN DEFAULT true,
    create_at   TIMESTAMP WITH TIME ZONE
);

CREATE TABLE IF NOT EXISTS contact_message
(
    id      UUID PRIMARY KEY,
    subject VARCHAR(255),
    message TEXT,
    name    VARCHAR(255),
    surname VARCHAR(255),
    phone   VARCHAR(20),
    email   VARCHAR(255),
    sent_at TIMESTAMP WITH TIME ZONE
);
CREATE TABLE IF NOT EXISTS reservation
(
    id               UUID PRIMARY KEY,
    first_name       VARCHAR(255),
    last_name        VARCHAR(255),
    email            VARCHAR(255),
    phone            VARCHAR(20),
    address          TEXT,
    reservation_type VARCHAR(20),
    transfer_id      UUID,
    tour_id          UUID,
    create_at        TIMESTAMP WITH TIME ZONE
);
CREATE TABLE IF NOT EXISTS token
(
    id         UUID PRIMARY KEY,
    token      TEXT,
    token_type VARCHAR(20),
    revoked    BOOLEAN DEFAULT false,
    expired    BOOLEAN DEFAULT false,
    user_id    UUID
);

CREATE TABLE IF NOT EXISTS tour
(
    id            UUID PRIMARY KEY,
    name          VARCHAR(255),
    description   TEXT,
    from_location VARCHAR(255),
    to_location   VARCHAR(255),
    start_date    TIMESTAMP WITH TIME ZONE,
    end_date      TIMESTAMP WITH TIME ZONE,
    price         DOUBLE PRECISION
);
CREATE TABLE IF NOT EXISTS transfer
(
    id               UUID PRIMARY KEY,
    from_destination UUID,
    to_destination   UUID,
    price            DOUBLE PRECISION,
    vehicle          UUID,
    is_round_trip    BOOLEAN DEFAULT false
);
CREATE TABLE IF NOT EXISTS transfer_destinations
(
    id        UUID PRIMARY KEY,
    name      VARCHAR(255),
    code      VARCHAR(10),
    address   TEXT,
    latitude  DOUBLE PRECISION,
    longitude DOUBLE PRECISION
);
CREATE TABLE IF NOT EXISTS users
(
    id       UUID PRIMARY KEY,
    username VARCHAR(255),
    email    VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS vehicle
(
    id                UUID PRIMARY KEY,
    name              VARCHAR(255),
    car_image         VARCHAR(255),
    pax               INTEGER,
    is_vip            BOOLEAN DEFAULT false,
    type              VARCHAR(255),
    price             DOUBLE PRECISION,
    description       TEXT,
    luggage_allowance INTEGER
);
