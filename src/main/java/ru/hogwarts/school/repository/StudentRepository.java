package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.entities.Student;

import javax.swing.text.Position;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
