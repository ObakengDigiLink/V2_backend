package com.example.login.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="Mark")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Mark implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Integer mark;
    private String markLevel;

    @OneToOne(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "StudentId", referencedColumnName = "id")
    private Student student;

    @OneToOne(targetEntity = Module.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ModuleId", referencedColumnName = "id")
    private Module module;

}
