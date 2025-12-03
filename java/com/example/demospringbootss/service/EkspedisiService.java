package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Ekspedisi;
import com.example.demospringbootss.repository.EkspedisiRepository;

@Service 
public class EkspedisiService {

    @Autowired
    private EkspedisiRepository ekspedisiRepository;

    public List<Ekspedisi> getAllEkspedisi() {
        return ekspedisiRepository.findAll(); 
    }

    // --- (CREATE) ---
    public Ekspedisi addEkspedisi(Ekspedisi obj) {
        obj.setId(null); //ID diset null supaya Database tahu ini data BARU 
        return ekspedisiRepository.save(obj); 
    }

    public Ekspedisi getEkspedisiById(long id) {
        //  Mencari ID. Kalau ada kembalikan datanya, kalau tidak ada kembalikan 'null'
        return ekspedisiRepository.findById(id).orElse(null);
    }

    // --- (UPDATE) ---
    public Ekspedisi updateEkspedisi(long id, Ekspedisi obj) {
        obj.setId(id); // ID harus diisi supaya Database menimpa data LAMA, bukan buat baru
        return ekspedisiRepository.save(obj); 
    }

    // --- (DELETE) ---
    public void deleteEkspedisi(long id) {
        ekspedisiRepository.deleteById(id); // Menghapus baris berdasarkan ID
    }
}