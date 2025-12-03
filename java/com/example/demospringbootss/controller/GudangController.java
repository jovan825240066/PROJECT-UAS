package com.example.demospringbootss.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demospringbootss.entity.Gudang;
import com.example.demospringbootss.entity.Paket;
import com.example.demospringbootss.service.GudangService;
import com.example.demospringbootss.service.KendaraanService;
import com.example.demospringbootss.service.PaketService; 

@Controller
public class GudangController {

    @Autowired private GudangService gudangService;
    @Autowired private KendaraanService kendaraanService;
    
    @Autowired 
    private PaketService paketService; 

    @GetMapping(value={"/gudang", "/gudang/"})
    public String gudangPage(Model model) {
        model.addAttribute("gudangList", gudangService.getAllGudang());
        model.addAttribute("kendaraanList", kendaraanService.getAll());
        
        model.addAttribute("listPaketGudang", null); 

        model.addAttribute("gudangInfo", new Gudang());
        return "gudang.html";
    }

    @GetMapping("/gudang/{id}")
    public String gudangGetRec(Model model, @PathVariable("id") int id) {
        Gudang gudangRec = gudangService.getGudangById(id);
        
        List<Paket> listPaketGudang = paketService.getPaketByGudangId(id);

        model.addAttribute("gudangList", gudangService.getAllGudang());
        model.addAttribute("kendaraanList", kendaraanService.getAll());
        
        model.addAttribute("listPaketGudang", listPaketGudang);
        
        model.addAttribute("gudangRec", gudangRec);
        model.addAttribute("gudangInfo", gudangRec);
        return "gudang.html";
    }

    @PostMapping(value={"/gudang/submit/", "/gudang/submit/{id}"}, params={"add"})
    public String gudangAdd(@ModelAttribute("gudangInfo") Gudang gudangInfo) {
        gudangService.addGudang(gudangInfo);
        return "redirect:/gudang";
    }

    @PostMapping(value="/gudang/submit/{id}", params={"edit"})
    public String gudangEdit(@ModelAttribute("gudangInfo") Gudang gudangInfo, @PathVariable("id") int id) {
        gudangService.updateGudang(id, gudangInfo);
        return "redirect:/gudang";
    }

    @PostMapping(value="/gudang/submit/{id}", params={"delete"})
    public String gudangDelete(@PathVariable("id") int id) {
        gudangService.deleteGudang(id);
        return "redirect:/gudang";
    }
}