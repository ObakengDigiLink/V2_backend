package com.example.login.repo;

import com.example.login.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Student, Long> {

    Student findByEmail(String email);
}
