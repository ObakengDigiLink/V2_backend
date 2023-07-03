package com.example.login.repo;

import com.example.login.model.Mark;
import com.example.login.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepo extends JpaRepository<Mark, Long> {

    Student findByStudentId(Long id);

}
