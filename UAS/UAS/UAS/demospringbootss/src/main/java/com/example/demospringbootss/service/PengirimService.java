package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Pengirim;
import com.example.demospringbootss.repository.PengirimRepository;

@Service
public class PengirimService {
    
    @Autowired private PengirimRepository repo; //  Koneksi khusus ke tabel Pengirim di database.

    // Ambil daftar semua pengirim yang terdaftar.
    public List<Pengirim> getAll() { return repo.findAll(); }
    
    // Cari detail pengirim tertentu pakai ID.
    public Pengirim getById(long id) { return repo.findById(id).orElse(null); }
    
    // Simpan data: Kalau orang baru dia buat baru, kalau orang lama dia update datanya.
    public void save(Pengirim obj) { repo.save(obj); }
    
    //Hapus data pengirim.
    public void delete(long id) { repo.deleteById(id); }
}