CREATE TABLE human (
                       id SERIAL PRIMARY KEY ,
                       name TEXT,
                       age INTEGER,
                       haveDriverLicence boolean,
                       car_id bigint references car (id)
);

CREATE TABLE car (
                     id SERIAL PRIMARY KEY ,
                     brand text,
                     model text,
                     price numeric
);
