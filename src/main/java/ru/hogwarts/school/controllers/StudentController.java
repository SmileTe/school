package ru.hogwarts.school.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.services.StudentService;

import java.util.Collection;

@RestController
@RequestMapping( "/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);

    }

    @GetMapping("filter-by-age/{age}")
    public Collection<Student> getStudentsFilteredByAge(@PathVariable int age) {
        return studentService.getStudentsFilteredByAge(age);
    }

    @GetMapping("get-students")
    public Collection<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("find-students")
    public Collection<Student> findStudents(@RequestParam int minAge, @RequestParam int maxAge) {
        return studentService.findStudentsByAgeBetween(minAge, maxAge);
    }

    @GetMapping("get-faculty/{id}")
    public Faculty getFaculty(@PathVariable Long id) {
        return studentService.getFaculty(id);
    }

    @GetMapping("get-numbers-of-students")
        public Integer getNumbersOfStudents() {
        return studentService.getNumbersOfStudents();
    }

    @GetMapping("get-average-age-of-students")
    public Integer getAverageAgeOfStudents() {
        return studentService.getAverageAgeOfStudents();
    }

    @GetMapping("get-last-students")
    public Collection<Student> getLastStudents() {
        return studentService.getLastStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @GetMapping("names-students-begins-with-letter-a")
    public Collection<String> namesStudentsBeginsWithLetter_A() {
        return studentService.getNamesStudentsBeginsWithLetter_A();
    }

    @GetMapping("print-6-students")
    public void print6students(){
        studentService.print6students();
    }

    @GetMapping("print-6-students-synchronized")
    public void print6students_synchronized(){
        studentService.print6students_synchronized();
    }
}
