package ru.hogwarts.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.debug("Requesting create faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.debug("Requesting find faculty by id");
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.debug("Requesting edit factory");
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.debug("Requesting delete faculty");
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultiesFilteredByColor(String perColor) {
        logger.debug("Requesting get faculties by color");
        return facultyRepository.findFacultyByColorContainingIgnoreCase(perColor);
    }

    public Collection<Faculty> getFaculties() {
        logger.debug("get all faculties");
        return facultyRepository.findAll().stream().toList();
    }

    public Set<Student> getStudents(Long id) {
        logger.debug("get students by id");
        return facultyRepository.findById(id).get().getStudents();
    }

    public Collection<Faculty> findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(String text) {
        logger.debug("Requesting find faculties by color");
        return facultyRepository.findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(text, text);
    }

    public String getLongestNameFaculty() {
        logger.debug("get longest faculty name");
        int maxNameLenght = facultyRepository.findAll().stream()
                .mapToInt(s->s.getName().length())
                .max().getAsInt();
        return facultyRepository.findAll().stream()
                .map(b -> b.getName())
                .filter(d->d.length()==maxNameLenght).findAny().get();
    }

}
