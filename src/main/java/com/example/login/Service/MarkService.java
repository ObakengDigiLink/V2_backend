package com.example.login.Service;

import com.example.login.DTO.StudentMarksDTO;
import com.example.login.model.Student;
import com.example.login.repo.MarkRepo;
import com.example.login.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarkService {

    private MarkRepo markRepo;
    private UserRepo userRepo;

    public MarkService(MarkRepo markRepo, UserRepo userRepo) {
        this.markRepo = markRepo;
        this.userRepo = userRepo;

    }

    public List<StudentMarksDTO> getMarksModules(Long id) {
        final Optional<Student> student = Optional.ofNullable(markRepo.findByStudentId(id));
        List<StudentMarksDTO> studentMarksDTO = null;
        if (student.isPresent()) {
            studentMarksDTO = new ArrayList<>();
        }
        return studentMarksDTO;
    }

}
