package com.example.sampleMongoDB.Controller;

import com.example.sampleMongoDB.Laptop;
import com.example.sampleMongoDB.Repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

    @Autowired
    private LaptopRepository laptopRepository;

    @PostMapping("/api")
    public String addLaptop(@RequestBody Laptop laptop)
    {
        this.laptopRepository.save(laptop);
        return "Added Successfully";
    }
    @GetMapping("/api")
    public List<Laptop> getLaptop()
    {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return this.laptopRepository.findAll();
    }

}
