select  * from student as t
where t.age between 10 and 15;

select  t.name from student as t;

select * from student as t
where t.name like '%1%';

select  * from student as t
where t.age < t.id;

select  * from student
order by student.age;

select * from student, faculty
where student.faculty_id = faculty.id

