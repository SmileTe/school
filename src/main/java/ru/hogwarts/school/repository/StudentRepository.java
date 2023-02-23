package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;

import javax.swing.text.Position;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAgeEquals(int age);
    List<Student> findStudentsByAgeBetween(int minAge, int maxAge);

    @Query(value = "select count (*) from student", nativeQuery = true)
    Integer getNumbersOfStudents();

    @Query(value = "select avg (Age) from student", nativeQuery = true)
    Integer getAveregeAgeOfStudents();

    @Query(value = "select * from student order by  id desc limit 5", nativeQuery = true)
    List<Student> getLastStudents();
}
