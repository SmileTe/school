package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;

import javax.swing.text.Position;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{

    List<Faculty> findFacultyByColorContainingIgnoreCase(String perColor);

    List<Faculty> findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(String color, String name);


}
