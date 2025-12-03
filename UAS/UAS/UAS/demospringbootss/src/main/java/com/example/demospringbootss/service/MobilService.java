package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Mobil;
import com.example.demospringbootss.repository.MobilRepository;

@Service
public class MobilService {
    @Autowired private MobilRepository repo;

    public List<Mobil> getAll() { return repo.findAll(); }
    public Mobil getById(long id) { return repo.findById(id).orElse(null); }
    public void save(Mobil obj) { 
        // HAPUS LOGIKA SET ID NULL, biar JPA yang handle
        repo.save(obj); 
    }
    public void delete(long id) { repo.deleteById(id); }
}