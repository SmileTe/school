package ru.hogwarts.school.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultiesFilteredByColor(String perColor) {
        return facultyRepository.findFacultyByColorContainingIgnoreCase(perColor);
    }

    public Collection<Faculty> getFaculties() {
        return facultyRepository.findAll().stream().toList();
    }

    public Set<Student> getStudents(Long id) {
        return facultyRepository.findById(id).get().getStudents();
    }

    public Collection<Faculty> findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(String text) {
        return facultyRepository.findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(text, text);
    }

}
