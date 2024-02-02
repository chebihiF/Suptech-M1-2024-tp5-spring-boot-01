package org.suptech.springboot1.student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Long id, Student student);
    Student getStudent(Long id);
    List<Student> getStudents();
}
