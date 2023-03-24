package com.example.sampleMongoDB;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "laptop")
public class Laptop {
    @Id
    private int laptopId;
    private String lapName;

    public Laptop(int laptopId, String lapName) {
        this.laptopId = laptopId;
        this.lapName = lapName;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getLapName() {
        return lapName;
    }

    public void setLapName(String lapName) {
        this.lapName = lapName;
    }
}
