CREATE TABLE human (
                       id SERIAL,
                       age INTEGER,
                       haveDriverLicence boolean,
                       car_id bigint
);

CREATE TABLE car (
                     id SERIAL,
                     brand text,
                     model text,
                     price numeric
);
