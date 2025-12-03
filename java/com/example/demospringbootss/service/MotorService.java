package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Motor;
import com.example.demospringbootss.repository.MotorRepository;

@Service
public class MotorService {
    @Autowired private MotorRepository repo;

    public List<Motor> getAll() { return repo.findAll(); }
    public Motor getById(long id) { return repo.findById(id).orElse(null); }
    public void save(Motor obj) { 
        // HAPUS LOGIKA SET ID NULL, biar JPA yang handle
        repo.save(obj); 
    }
    public void delete(long id) { repo.deleteById(id); }
}