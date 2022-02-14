CREATE TABLE IF NOT EXISTS public.category
(
    category_id     INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    category_name VARCHAR(255),
    parent_id    INTEGER,
    good_id      INTEGER REFERENCES public.good(good_id)
);