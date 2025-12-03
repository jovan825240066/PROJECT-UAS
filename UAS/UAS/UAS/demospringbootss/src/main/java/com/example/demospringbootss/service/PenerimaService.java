package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Penerima;
import com.example.demospringbootss.repository.PenerimaRepository;

@Service 
public class PenerimaService {
    
    @Autowired private PenerimaRepository repo; // Koneksi khusus ke tabel Penerima.

    // Lihat semua daftar penerima paket.
    public List<Penerima> getAll() { return repo.findAll(); }
    
    // Cari penerima spesifik by ID.
    public Penerima getById(long id) { return repo.findById(id).orElse(null); }
    
    //Simpan atau Update info penerima.
    public void save(Penerima obj) { repo.save(obj); }
    
    // Hapus data penerima dari database.
    public void delete(long id) { repo.deleteById(id); }
}