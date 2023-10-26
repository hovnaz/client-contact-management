CREATE TABLE client
(
    id          SERIAL PRIMARY KEY,
    clientName  VARCHAR(255),
    email       VARCHAR(255),
    createAt    TIMESTAMP NOT NULL,
    updateAt    TIMESTAMP,
    deletedFlag BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE client_contact_email
(
    id          SERIAL PRIMARY KEY,
    client_id   INT REFERENCES client (id),
    email       VARCHAR(255) NOT NULL,
    createAt    TIMESTAMP    NOT NULL,
    updateAt    TIMESTAMP,
    deletedFlag BOOLEAN,
    PRIMARY KEY (id)
);

CREATE TABLE client_contact_phone_number
(
    id          SERIAL PRIMARY KEY,
    client_id   INT REFERENCES client (id),
    phoneNumber VARCHAR(255) NOT NULL,
    createAt    TIMESTAMP    NOT NULL,
    updateAt    TIMESTAMP,
    deletedFlag BOOLEAN,
    PRIMARY KEY (id)
);
