package com.example.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="module")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Module implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String moduleCode;
    private String moduleName;
}
