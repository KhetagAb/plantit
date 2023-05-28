CREATE DOMAIN email AS citext
    CHECK (
        VALUE ~ '^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$'
        );

CREATE DOMAIN login AS citext
    CHECK (
        VALUE ~ '^[\w\d]{5,42}$'
        );

CREATE DOMAIN phone AS text
    CHECK (
        VALUE ~ '^\d{1,2}\d{3}\d{7}$'
        );

CREATE TYPE client_type AS ENUM ('rancher', 'handyman');

CREATE TABLE IF NOT EXISTS client
(
    id       UUID DEFAULT uuid_generate_v4(),
    c_type   client_type NOT NULL,
    login    login NOT NULL UNIQUE,
    email    email NOT NULL UNIQUE,
    phone    phone NOT NULL UNIQUE,
    creation timestamp DEFAULT current_timestamp,
    updating timestamp DEFAULT current_timestamp
);