CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.good
(
    good_id    INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    good_price INT NOT NULL
);
