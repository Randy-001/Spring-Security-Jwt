package com.example.sampleMongoDB.Repository;

import com.example.sampleMongoDB.studentSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSequenceRepository extends MongoRepository<studentSequence,String> {
}
