package com.example.login.Service;

import com.example.login.model.Student;
import com.example.login.repo.StudentRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private StudentRepo studentRepo;
    PasswordEncoder passwordEncoder;

    public AdminService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Student createStudent(Student student){
        String encodedPassword = this.passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);
        return studentRepo.save(student);
    }
}
