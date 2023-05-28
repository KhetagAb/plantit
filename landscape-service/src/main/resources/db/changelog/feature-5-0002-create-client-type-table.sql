CREATE TABLE IF NOT EXISTS client_types
(
    id          smallserial PRIMARY KEY,
    client_type text NOT NULL
);

INSERT INTO client_types (client_type)
VALUES ('rancher'),
       ('handyman');

ALTER TABLE client
    ADD COLUMN temp_type smallint NOT NULL REFERENCES client_types (id) default 1;

UPDATE client
    SET temp_type = (SELECT id FROM client_types WHERE client.client_type::text = client_types.client_type);

ALTER TABLE client
    DROP COLUMN client_type;

ALTER TABLE client
    RENAME COLUMN temp_type TO client_type;