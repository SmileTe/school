select student.*, faculty.name from student
 left join faculty on student.faculty_id = faculty.id;

select student.* , avatar.file_path from student
    inner join avatar  on student.id = avatar.student_id;