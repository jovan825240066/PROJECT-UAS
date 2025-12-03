package com.example.demospringbootss.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demospringbootss.entity.Paket;
import com.example.demospringbootss.service.GudangService; 
import com.example.demospringbootss.service.PaketService;

@Controller
public class PaketController {

    @Autowired
    private PaketService paketService;

    @Autowired
    private GudangService gudangService; // Mengambil daftar gudang untuk pilihan di Form

    // === HALAMAN UTAMA PAKET ===
    @GetMapping(value={"/paket", "/paket/"})
    public String paketPage(Model model) {
        List<Paket> paketList = paketService.getAllPaket();
        model.addAttribute("paketList", paketList);
        
        // Data ini dipakai untuk mengisi Dropdown (Select Option) di form tambah paket.
        model.addAttribute("listGudang", gudangService.getAllGudang());
        
        model.addAttribute("paketInfo", new Paket());
        return "paket.html";
    }

    // === MODE EDIT ===
    @GetMapping("/paket/{id}")
    public String paketGetRec(Model model, @PathVariable("id") int id) {
        List<Paket> paketList = paketService.getAllPaket();
        Paket paketRec = paketService.getPaketById(id);
        
        model.addAttribute("paketList", paketList);
        
        // dropdown gudang 
        model.addAttribute("listGudang", gudangService.getAllGudang()); 
        
        model.addAttribute("paketRec", paketRec);
        model.addAttribute("paketInfo", paketRec);
        return "paket.html";
    }

    // === PROSES SIMPAN DATA BARU (ADD) ===
    @PostMapping(value={"/paket/submit/", "/paket/submit/{id}"}, params={"add"})
    public String paketAdd(@ModelAttribute("paketInfo") Paket paketInfo) {
        try {
            // Coba simpan paket lewat service
            paketService.addPaket(paketInfo);
            
        } catch (RuntimeException e) {
            // ERROR HANDLING: 
            // Jika Service Menampilkan "Gudang Penuh!"
            return "redirect:/paket?error=full"; 
        }
        
        // Jika sukses, kembali ke halaman paket biasa
        return "redirect:/paket";
    }

    // === PROSES UPDATE DATA (EDIT) ===
    @PostMapping(value="/paket/submit/{id}", params={"edit"})
    public String paketEdit(@ModelAttribute("paketInfo") Paket paketInfo, @PathVariable("id") int id) {
        paketService.updatePaket(id, paketInfo);
        return "redirect:/paket";
    }

    // === PROSES HAPUS DATA (DELETE) ===
    @PostMapping(value="/paket/submit/{id}", params={"delete"})
    public String paketDelete(@PathVariable("id") int id) {
        // Service akan otomatis mengembalikan kapasitas gudang (+1 slot kosong) & menghapus relasi ekspedisi
        paketService.deletePaket(id);
        return "redirect:/paket";
    }
}