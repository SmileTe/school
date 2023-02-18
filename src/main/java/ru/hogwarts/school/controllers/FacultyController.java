package ru.hogwarts.school.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.services.FacultyService;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @GetMapping("filter-by-color/{color}")
    public Collection<Faculty> getFacultiesFilteredByColor(@PathVariable String color) {
        return facultyService.getFacultiesFilteredByColor(color);
    }

    @GetMapping("get-faculties")
    public Collection<Faculty> getFaculties() {
        return facultyService.getFaculties();
    }

    @GetMapping("find-faculties")
    public Collection<Faculty> findFaculties(@RequestParam String filter) {
        return facultyService.findAllByColorContainingIgnoreCaseOrNameContainingIgnoreCase(filter);
    }

    @GetMapping("get-students/{id}")
    public Set<Student> getStudents(@PathVariable Long id) {
        return facultyService.getStudents(id);
    }

    @GetMapping("longest-name-faculty")
    public String getLongestNameFaculty() {
        return facultyService.getLongestNameFaculty();
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = facultyService.editFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

}
