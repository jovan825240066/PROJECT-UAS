package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Kendaraan;
import com.example.demospringbootss.repository.KendaraanRepository;

@Service
public class KendaraanService {
    @Autowired private KendaraanRepository repo;

    public List<Kendaraan> getAll() { return repo.findAll(); }
    public Kendaraan getById(long id) { return repo.findById(id).orElse(null); } // TAMBAHKAN INI
    public void delete(long id) { repo.deleteById(id); }
}