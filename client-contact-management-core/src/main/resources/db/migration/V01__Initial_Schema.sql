CREATE TABLE client
(
    id          SERIAL PRIMARY KEY,
    client_name  VARCHAR(255),
    email       VARCHAR(255),
    create_at    TIMESTAMP NOT NULL,
    update_at    TIMESTAMP,
    deleted_flag BOOLEAN DEFAULT FALSE
);

CREATE TABLE client_contact_email
(
    id          SERIAL PRIMARY KEY,
    client_id   INT REFERENCES client (id),
    email       VARCHAR(255) NOT NULL,
    create_at    TIMESTAMP    NOT NULL,
    update_at    TIMESTAMP,
    deleted_flag BOOLEAN DEFAULT FALSE
);

CREATE TABLE client_contact_phone_number
(
    id          SERIAL PRIMARY KEY,
    client_id   INT REFERENCES client (id),
    phone_number VARCHAR(255) NOT NULL,
    create_at    TIMESTAMP    NOT NULL,
    update_at    TIMESTAMP,
    deleted_flag BOOLEAN DEFAULT FALSE
);
