package com.example.sampleMongoDB.Service;

import com.example.sampleMongoDB.Repository.UserRepository;
import com.example.sampleMongoDB.User;
import com.example.sampleMongoDB.dto.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username ;  "+username);
        Optional<User> user = this.userRepository.findByUsername(username);
        user.orElseThrow(()-> new UsernameNotFoundException("Username Notfound"+username));
        return user.map(MyUserDetails::new).get();

    }
}
