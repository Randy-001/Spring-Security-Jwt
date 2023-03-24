package com.example.sampleMongoDB.Service;

import com.example.sampleMongoDB.Repository.UserRepository;
import com.example.sampleMongoDB.User;
import com.mongodb.MongoWriteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {
    @Autowired
    private UserRepository userRepository;

    public String addStudent(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            this.userRepository.save(user);
            return "Added Successfully.......";
        } catch (Exception c) {
            return "Duplicate Username found...";
        }


    }
}