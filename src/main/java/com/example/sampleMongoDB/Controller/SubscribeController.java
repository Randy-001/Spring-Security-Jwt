package com.example.sampleMongoDB.Controller;


import com.example.sampleMongoDB.Service.MyUserDetailsService;
import com.example.sampleMongoDB.Service.SubscribeService;
import com.example.sampleMongoDB.User;
import com.example.sampleMongoDB.dto.AuthRequest;
import com.example.sampleMongoDB.dto.AuthResponse;
import com.example.sampleMongoDB.util.jwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SubscribeController {


    @Autowired
    private SubscribeService subscribeService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private jwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;
    @PostMapping("/subs")
    public String addStudent(@RequestBody User user)
    {
            return subscribeService.addStudent(user);
    }

    @PostMapping("/auth")
    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) throws Exception
    {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
            );

        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authRequest.getUserName());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return new AuthResponse(jwt);
    }




}
