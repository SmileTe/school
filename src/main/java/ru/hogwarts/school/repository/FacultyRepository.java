package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.entities.Faculty;

import javax.swing.text.Position;


public interface FacultyRepository extends JpaRepository<Faculty, Long>{

}
