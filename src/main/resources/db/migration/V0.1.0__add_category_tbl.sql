--CREATE SCHEMA IF NOT EXISTS public;

CREATE TABLE IF NOT EXISTS public.category
(
    category_id     INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--     good_id      INTEGER REFERENCES good(good_id),
    category_name VARCHAR(255) not null
);