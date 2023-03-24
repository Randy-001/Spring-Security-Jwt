package com.example.sampleMongoDB.Repository;

import com.example.sampleMongoDB.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends MongoRepository<Laptop,Integer> {
}
