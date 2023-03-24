package com.example.sampleMongoDB.Controller;

import com.example.sampleMongoDB.Repository.StudentRepository;
import com.example.sampleMongoDB.Service.StudentSequenceService;
import com.example.sampleMongoDB.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

        @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private StudentSequenceService studentSequenceService;

        @PreAuthorize("hasAuthority('ROLE_ADMIN')")
        @PostMapping("/api")
        public String addStudent(@RequestBody Student s, Authentication authentication)
        {
            System.out.println(authentication.getName());
            System.out.println(s.getLaptop());
            s.setId(studentSequenceService.getSequence(Student.USER_SEQUENCE_NAME));
            this.studentRepository.save(s);
            return "Added successfully";
        }

        @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
        @GetMapping("/api")
        public List<Student> getStudent(Authentication authentication)
        {
            System.out.println(authentication.getName());
            return this.studentRepository.findAll();
        }


}
