package org.suptech.springboot1.student;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Add a new student
    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    // Delete a student
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    // Update a student
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,@RequestBody Student student){
        studentService.updateStudent(id, student);
    }

    // Get a student
    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id){
        return studentService.getStudent(id);
    }

    // Get all students
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
}
