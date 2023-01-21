package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;

import javax.swing.text.Position;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAgeEquals(int age);
    List<Student> findStudentsByAgeBetween(int minAge, int maxAge);

}
