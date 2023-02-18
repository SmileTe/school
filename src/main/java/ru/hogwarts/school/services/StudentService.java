package ru.hogwarts.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.debug("Requesting create student");
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.debug("find student by id");
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        logger.debug("edit student");
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.debug("delete student by id");
        studentRepository.deleteById(id);
    }

    public Collection<Student> getStudentsFilteredByAge(int perAge) {
        logger.debug("Requesting get students by age");
        return studentRepository.findStudentsByAgeEquals(perAge);
    }

    public Collection<Student> getStudents() {
        logger.debug("Requesting get all students");
        return studentRepository.findAll().stream().toList();
    }

    public Faculty getFaculty(Long id){
        logger.debug("Requesting get faculty by id");
        return studentRepository.findById(id).get().getFaculty();
    }

    public Collection<Student> findStudentsByAgeBetween(int minAge, int maxAge) {
        logger.debug("Requesting find students by age between");
        return studentRepository.findStudentsByAgeBetween(minAge, maxAge);
    }

    public Integer getNumbersOfStudents(){
        logger.debug("Requesting get number of students");
        return studentRepository.getNumbersOfStudents();
    }

    public Integer getAverageAgeOfStudents(){
        logger.debug("Requesting get average age of students");
        //return studentRepository.getAveregeAgeOfStudents();
        int[] arr =  studentRepository.findAll().stream()
                .mapToInt(s->s.getAge()).toArray();
                return Arrays.stream(arr).sum()/ arr.length;
    }

    public Collection<Student> getLastStudents(){
        logger.debug("Requesting get last students");
        return studentRepository.getLastStudents();
    }

    public Collection<String> getNamesStudentsBeginsWithLetter_A() {
        logger.debug("Requesting get names of all students whose name begins with the letter A");
        return studentRepository.findAll().stream()
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .filter(s -> s.startsWith("А")).toList();
    }

}
