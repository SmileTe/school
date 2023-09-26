alter table student
    add constraint age_constraint check ( age>=16 );

alter table student
    add constraint name_unique UNIQUE  (name),
alter column name set not null;

alter table faculty
    add constraint name_color_unique UNIQUE  (name,color);

ALTER TABLE student
    ALTER age SET DEFAULT 20;




