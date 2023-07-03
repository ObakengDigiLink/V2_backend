package com.example.login.controller;

import com.example.login.DTO.StudentMarksDTO;
import com.example.login.Service.AdminService;
import com.example.login.Service.MarkService;
import com.example.login.model.Admin;
import com.example.login.model.Student;
import com.example.login.repo.AdminRepo;
import com.example.login.repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    private AdminRepo adminRepo;
    private UserRepo userRepo;
    private AdminService adminService;
    private MarkService markService;
    PasswordEncoder passwordEncoder;

    public AdminController(AdminService adminService, AdminRepo adminRepo , UserRepo userRepo, MarkService markService) {
        this.adminRepo = adminRepo;
        this.userRepo = userRepo;
        this.markService =  markService;
        this.adminService = adminService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody Admin adminData){
        Admin admin= adminRepo.findByEmail(adminData.getEmail());

        if(admin.getPassword().equals(adminData.getPassword())){
            return ResponseEntity.ok(admin);
        }
        return (ResponseEntity<?>) ResponseEntity.ok();
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getByEmail(@PathVariable("email") String email){
        if(adminRepo.findByEmail(email) != null){
            return new ResponseEntity<>(adminRepo.findByEmail(email), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable Long id){
        userRepo.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id){
        Student old = null;
        Optional<Student> optionalStudent = userRepo.findById(student.getId());
        if(optionalStudent.isPresent()){
            old = optionalStudent.get();
            old.setFirstName(student.getFirstName());
            old.setLastName(student.getLastName());
            old.setEmail(student.getEmail());
            old.setPhoneNum(student.getPhoneNum());
            old.setPassword(student.getPassword());
        }
        userRepo.save(old);
        System.out.print(old);
        return new ResponseEntity<>(old, HttpStatus.OK);
    }

    @GetMapping("/allmarks/{id}")
    public List<StudentMarksDTO> getStudentMarks(@PathVariable Long id){
        return markService.getMarksModules(id);
    }

    @PostMapping("/create")
    public Student addStudent(@RequestBody Student student){
        return adminService.createStudent(student);
    }
}
