package org.suptech.springboot1.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new IllegalStateException("Email already taken");
        }
        if(student.getAge() < 18){
            throw new IllegalStateException("Age must be greater than 18");
        }
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
}
