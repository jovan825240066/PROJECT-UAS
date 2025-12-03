package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demospringbootss.entity.Ekspedisi;
import com.example.demospringbootss.entity.Gudang;
import com.example.demospringbootss.entity.Paket;
import com.example.demospringbootss.repository.EkspedisiRepository; 
import com.example.demospringbootss.repository.GudangRepository;
import com.example.demospringbootss.repository.PaketRepository;

@Service
public class PaketService {

    @Autowired
    private PaketRepository paketRepository;

    @Autowired
    private GudangRepository gudangRepository; 

    @Autowired
    private EkspedisiRepository ekspedisiRepository; // Inject Repository Ekspedisi

    public List<Paket> getAllPaket() {
        return paketRepository.findAll();
    }

    public List<Paket> getPaketByGudangId(long gudangId) {
        return paketRepository.findByGudangId(gudangId);
    }

    @Transactional
    public Paket addPaket(Paket obj) {
        // ... (Kodingan addPaket TETAP SAMA seperti sebelumnya, tidak usah diubah) ...
        obj.setId(null);
        if (obj.getGudang() != null && obj.getGudang().getId() != null) {
            Gudang gudangTarget = gudangRepository.findById(obj.getGudang().getId()).orElse(null);
            if (gudangTarget != null) {
                if (gudangTarget.getTerisi() < gudangTarget.getKapasitas()) {
                    gudangTarget.setTerisi(gudangTarget.getTerisi() + 1);
                    gudangRepository.save(gudangTarget);
                    obj.setGudang(gudangTarget);
                } else {
                    throw new RuntimeException("Gudang Penuh!");
                }
            }
        }
        return paketRepository.save(obj);
    }

    public Paket getPaketById(long id) {
        return paketRepository.findById(id).orElse(null);
    }

    public Paket updatePaket(long id, Paket obj) {
        obj.setId(id);
        return paketRepository.save(obj);
    }

    @Transactional
    public void deletePaket(long id) {
        Paket existingPaket = paketRepository.findById(id).orElse(null);
        
        // Logika Gudang (Kembalikan Kapasitas)
        if (existingPaket != null && existingPaket.getGudang() != null) {
            Gudang gudangTarget = existingPaket.getGudang();
            if (gudangTarget.getTerisi() > 0) {
                gudangTarget.setTerisi(gudangTarget.getTerisi() - 1);
                gudangRepository.save(gudangTarget);
            }
        }

        // Cari semua ekspedisi yang menggunakan paket ini
        List<Ekspedisi> listEkspedisi = ekspedisiRepository.findByPaketId(id);
        
        for (Ekspedisi eks : listEkspedisi) {
            eks.setPaket(null); 
            ekspedisiRepository.save(eks); // Simpan perubahan ke tabel ekspedisi
        }

        paketRepository.deleteById(id);
    }
}