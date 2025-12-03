package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Kurir;
import com.example.demospringbootss.repository.KurirRepository;

@Service  
public class KurirService {
    
    @Autowired private KurirRepository repo; //  Koneksi khusus ke tabel Kurir.

    // Tampilkan semua kurir yang kita punya.
    public List<Kurir> getAll() { return repo.findAll(); } 
    
    //  Cari profil satu kurir tertentu.
    public Kurir getById(long id) { return repo.findById(id).orElse(null); }
    
    //  Mendaftarkan kurir baru atau mengupdate data kurir lama (misal ganti motor).
    public void save(Kurir obj) { repo.save(obj); }
    
    //  Pecat/Hapus data kurir.
    public void delete(long id) { repo.deleteById(id); }
}