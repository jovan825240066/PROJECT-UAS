package com.example.demospringbootss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demospringbootss.entity.Tracking;
import com.example.demospringbootss.entity.Paket;
import com.example.demospringbootss.service.TrackingService;
import com.example.demospringbootss.repository.PaketRepository;
import java.util.Optional;

@Controller
public class TrackingController {
    
    @Autowired
    private TrackingService trackingService;
    
    @Autowired
    private PaketRepository paketRepository;
    
    @GetMapping("/")
    public String homePage() {
        return "Tracking";
    }
    
    @GetMapping("/tracking")
    public String trackingPage() {
        return "Tracking";
    }
    
    @PostMapping("/cek-resi")
    public String cekResi(@RequestParam String noResi, Model model) {
        if (noResi == null || noResi.trim().isEmpty()) {
            model.addAttribute("error", "Nomor resi tidak boleh kosong!");
            return "Tracking";
        }
        
        String cleanResi = noResi.trim();
        
        // 1. Cari di Entity Tracking (sistem baru)
        Optional<Tracking> trackingOpt = trackingService.cariPaketByResi(cleanResi);
        
        if (trackingOpt.isPresent()) {
            // Data sudah ada di sistem baru
            Tracking paket = trackingOpt.get();
            model.addAttribute("paketInfo", paket);
        } else {
            // 2. Data belum ada di Tracking, cari di Paket (sistem lama)
            Paket paketLama = paketRepository.findByNomorResi(cleanResi);
            
            if (paketLama != null) {
                // 3. Auto-migrasi on-demand: Pindahkan data dari Paket ke Tracking
                Tracking trackingBaru = migratePaketToTracking(paketLama);
                model.addAttribute("paketInfo", trackingBaru);
            } else {
                model.addAttribute("error", "Paket dengan nomor resi '" + cleanResi + "' tidak ditemukan!");
            }
        }
        
        return "Tracking";
    }
    
    /**
     * Migrasi data dari Paket (lama) ke Tracking (baru)
     * Paket tidak punya status, jadi kita pakai default
     */
    private Tracking migratePaketToTracking(Paket paketLama) {
        Tracking tracking = new Tracking();
        tracking.setNomorResi(paketLama.getNomorResi());
        tracking.setJenisBarang(paketLama.getJenisBarang());
        tracking.setTujuan(paketLama.getTujuan());
        
        tracking.setStatus(Tracking.StatusPaket.DALAM_PENGIRIMAN);
        
        return trackingService.simpanTracking(tracking);
    }
    
    @PostMapping("/masuk-sistem")
    public String masukDashboard() {
        return "redirect:/orang";
    }
}