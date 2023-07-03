package com.example.login.DTO;

import com.example.login.model.Mark;
import com.example.login.model.Student;
import lombok.Data;

@Data
public class StudentMarksDTO {

    private Long id;
    private Integer mark;
    private String markCode;
    private Student student;
    private Module module;

}
