package com.example.demospringbootss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demospringbootss.entity.Tracking;
import com.example.demospringbootss.repository.TrackingRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TrackingService {
    
    @Autowired
    private TrackingRepository trackingRepository;
    
    public Optional<Tracking> cariPaketByResi(String nomorResi) {
        return trackingRepository.findByNomorResi(nomorResi);
    }
    
    public Tracking simpanTracking(Tracking tracking) {
        return trackingRepository.save(tracking);
    }
    
    public boolean resiExists(String nomorResi) {
        return trackingRepository.existsByNomorResi(nomorResi);
    }
    
    public List<Tracking> getAllTracking() {
        return trackingRepository.findAll();
    }
}