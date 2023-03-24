package com.example.sampleMongoDB.Service;


import com.example.sampleMongoDB.Repository.StudentSequenceRepository;
import com.example.sampleMongoDB.studentSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentSequenceService {
    @Autowired
    private StudentSequenceRepository studentSequenceRepository;

    public int getSequence(String name) {
        Optional<studentSequence> studentsequence = this.studentSequenceRepository.findById(name);
        if (!studentsequence.isPresent()) {
            studentsequence = Optional.of(new studentSequence());
            studentsequence.get().setId(name);
            studentsequence.get().setCounter(1);
        } else {
            int a = studentsequence.get().getCounter();
            a++;
            studentsequence.get().setCounter(a);
        }
        this.studentSequenceRepository.save(studentsequence.get());
        return studentsequence.get().getCounter();
    }


}
