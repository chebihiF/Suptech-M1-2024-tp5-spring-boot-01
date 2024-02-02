package org.suptech.springboot1.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class StudentConfig {
    private final StudentRepository studentRepository;

    public StudentConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    CommandLineRunner student_Config() {
        return args -> {
            studentRepository.save(new Student(null,"John", "john@gmail.com", 20, LocalDate.of(2000, 1, 1)));
            studentRepository.save(new Student(null,"Jane", "Jane@gmail.com", 22, LocalDate.of(1998, 1, 1)));
            studentRepository.save(new Student(null,"Mary", "Mary@gmail.com", 25, LocalDate.of(1995, 1, 1)));
            studentRepository.findAll().forEach(System.out::println);
        };
    }
}
