
CREATE TABLE IF NOT EXISTS public.category_goods(
    category_id INTEGER REFERENCES category(category_id),
    good_id INTEGER REFERENCES good(good_id),
    primary key (category_id, good_id)
);