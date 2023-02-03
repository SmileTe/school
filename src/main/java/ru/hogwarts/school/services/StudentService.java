package ru.hogwarts.school.services;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {

        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudentsFilteredByAge(int perAge) {
        return studentRepository.findStudentsByAgeEquals(perAge);
    }

    public Collection<Student> getStudents() {
        return studentRepository.findAll().stream().toList();
    }

    public Faculty getFaculty(Long id){
        return studentRepository.findById(id).get().getFaculty();
    }

    public Collection<Student> findStudentsByAgeBetween(int minAge, int maxAge) {
        return studentRepository.findStudentsByAgeBetween(minAge, maxAge);
    }

    public Integer getNumbersOfStudents(){
        return studentRepository.getNumbersOfStudents();
    }

    public Integer getAveregeAgeOfStudents(){
        return studentRepository.getAveregeAgeOfStudents();
    }

    public Collection<Student> getLastStudents(){
        return studentRepository.getLastStudents();
    }

}
