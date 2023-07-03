package com.example.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Role")
@Data
public class Role {
    @Id
    private Integer id;
    private String Description;
}
