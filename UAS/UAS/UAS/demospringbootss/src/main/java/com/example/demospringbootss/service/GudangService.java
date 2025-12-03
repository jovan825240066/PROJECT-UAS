package com.example.demospringbootss.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Gudang;
import com.example.demospringbootss.repository.GudangRepository;

@Service
public class GudangService {
    @Autowired
    private GudangRepository gudangRepository;

    public List<Gudang> getAllGudang() {
        return gudangRepository.findAll();
    }

    public Gudang addGudang(Gudang obj) {
        obj.setId(null);
        if(obj.getTerisi() == null) {
            obj.setTerisi(0);
        }
        return gudangRepository.save(obj);
    }

    public Gudang getGudangById(long id) {
        return gudangRepository.findById(id).orElse(null);
    }

    public Gudang updateGudang(long id, Gudang obj) {
        obj.setId(id);
        return gudangRepository.save(obj);
    }

    public void deleteGudang(long id) {
        gudangRepository.deleteById(id);
    }
}