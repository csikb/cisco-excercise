CREATE SCHEMA cisco_exercise;

CREATE TABLE cisco_exercise.user
(
    id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name     TEXT UNIQUE NOT NULL,
    password TEXT        NOT NULL,
    email    TEXT        NOT NULL
);

CREATE TABLE cisco_exercise.phone_model
(
    model TEXT PRIMARY KEY
);

CREATE TABLE cisco_exercise.phone
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name         TEXT NOT NULL,
    model        TEXT NOT NULL REFERENCES cisco_exercise.phone_model (model),
    phone_number TEXT NOT NULL UNIQUE,
    user_id      UUID NOT NULL REFERENCES cisco_exercise.user (id)
);


ALTER TABLE cisco_exercise.user
    ADD COLUMN preferred_phone_id UUID REFERENCES cisco_exercise.phone (id);
