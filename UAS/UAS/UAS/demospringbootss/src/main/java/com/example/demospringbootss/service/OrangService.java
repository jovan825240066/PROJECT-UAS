package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Orang;
import com.example.demospringbootss.repository.OrangRepository;

@Service 
public class OrangService {
    @Autowired private OrangRepository repo; // Meminta alat koneksi ke database.

    //  Ambil semua daftar orang dari database.
    public List<Orang> getAllOrang() { return repo.findAll(); }
    
    //  Cari orang berdasarkan ID, kalau tidak ketemu hasilnya kosong (null).
    public Orang getOrangById(long id) { return repo.findById(id).orElse(null); }
    
    // Hapus data orang dari sistem.
    public void deleteOrang(long id) { repo.deleteById(id); }
}