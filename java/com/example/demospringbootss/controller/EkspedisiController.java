package com.example.demospringbootss.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demospringbootss.entity.Ekspedisi;
import com.example.demospringbootss.service.EkspedisiService;
import com.example.demospringbootss.service.PaketService;     
import com.example.demospringbootss.service.KendaraanService;

@Controller
public class EkspedisiController {

    @Autowired 
    private EkspedisiService ekspedisiService;

    @Autowired private PaketService paketService;    
    @Autowired private KendaraanService kendaraanService; 

    @GetMapping(value={"/ekspedisi", "/ekspedisi/"})    
    public String ekspedisiPage(Model model) {  

        List<Ekspedisi> ekspedisiList = ekspedisiService.getAllEkspedisi(); 
        
        // Mengirim daftar ekspedisi untuk ditampilkan di tabel HTML
        model.addAttribute("ekspedisiList", ekspedisiList);

        // Membuat objek kosong untuk menampung inputan form BARU
        model.addAttribute("ekspedisiInfo", new Ekspedisi());      

        // Mengirim data Paket & Kendaraan untuk pilihan Dropdown 
        model.addAttribute("listPaket", paketService.getAllPaket());       
        model.addAttribute("listKendaraan", kendaraanService.getAll());    
        
        return "ekspedisi.html";   
    }

    // --- MODE EDIT  ---
    @GetMapping("/ekspedisi/{id}")
    public String ekspedisiGetRec(Model model, @PathVariable("id") int id) {
        
        // Mengambil 1 data spesifik berdasarkan ID yang diklik
        Ekspedisi ekspedisiRec = ekspedisiService.getEkspedisiById(id);
        
        model.addAttribute("ekspedisiList", ekspedisiService.getAllEkspedisi());
        model.addAttribute("ekspedisiRec", ekspedisiRec); 

        // Mengisi form input dengan data lama agar bisa diedit
        model.addAttribute("ekspedisiInfo", ekspedisiRec);

        model.addAttribute("listPaket", paketService.getAllPaket());  
        model.addAttribute("listKendaraan", kendaraanService.getAll()); 

        return "ekspedisi.html";
    }

    // ---  TOMBOL ADD  ---
    @PostMapping(value={"/ekspedisi/submit/", "/ekspedisi/submit/{id}"}, params={"add"})    // params={"add"} method ini jalan CUMA kalau tombol bernama 'add' diklik
    public String ekspedisiAdd(@ModelAttribute("ekspedisiInfo") Ekspedisi ekspedisiInfo) {
        
        // Service menyimpan data baru ke database
        ekspedisiService.addEkspedisi(ekspedisiInfo);
        
        return "redirect:/ekspedisi"; 
    }

    // --- TOMBOL EDIT  ---
    @PostMapping(value="/ekspedisi/submit/{id}", params={"edit"})
    public String ekspedisiEdit(@ModelAttribute("ekspedisiInfo") Ekspedisi ekspedisiInfo, @PathVariable("id") int id) {
        
        // Service meng-update data berdasarkan ID
        ekspedisiService.updateEkspedisi(id, ekspedisiInfo);
        
        return "redirect:/ekspedisi";
    }

    // --- TOMBOL DELETE ---
    @PostMapping(value="/ekspedisi/submit/{id}", params={"delete"})
    public String ekspedisiDelete(@PathVariable("id") int id) {
        
        // Service menghapus data berdasarkan ID
        ekspedisiService.deleteEkspedisi(id);
        
        return "redirect:/ekspedisi";
    }
}