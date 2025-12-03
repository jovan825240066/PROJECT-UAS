package com.example.demospringbootss.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demospringbootss.entity.*;
import com.example.demospringbootss.service.*;

@Controller
public class KendaraanController {

    @Autowired private KendaraanService kendaraanService;
    @Autowired private MobilService mobilService;
    @Autowired private MotorService motorService;

    @GetMapping(value={"/kendaraan", "/kendaraan/"})
    public String kendaraanPage(Model model) {
        List<Kendaraan> list = kendaraanService.getAll();
        model.addAttribute("kendaraanList", list);
        return "kendaraan.html";
    }

    @PostMapping("/kendaraan/delete/{id}")
    public String deleteGlobal(@PathVariable("id") Long id) { // UBAH KE Long
        kendaraanService.delete(id);
        return "redirect:/kendaraan";
    }

    @GetMapping("/mobil")
    public String mobilPage(Model model) {
        model.addAttribute("listData", mobilService.getAll());
        model.addAttribute("formData", new Mobil());
        return "mobil.html";
    }

    @GetMapping("/mobil/{id}")
    public String mobilEdit(Model model, @PathVariable("id") Long id) { // UBAH KE Long
        model.addAttribute("listData", mobilService.getAll());
        model.addAttribute("formData", mobilService.getById(id));
        return "mobil.html";
    }

    @PostMapping(value="/mobil/save", params="add")
    public String mobilAdd(@ModelAttribute("formData") Mobil obj) {
        // HAPUS obj.setId(null); - biar JPA handle
        mobilService.save(obj);
        return "redirect:/mobil";
    }

    @PostMapping(value="/mobil/save", params="edit")
    public String mobilUpdate(@ModelAttribute("formData") Mobil obj) {
        mobilService.save(obj);
        return "redirect:/mobil";
    }

    @PostMapping("/mobil/delete/{id}")
    public String mobilDelete(@PathVariable("id") Long id) { // UBAH KE Long
        mobilService.delete(id);
        return "redirect:/mobil";
    }

    @GetMapping("/motor")
    public String motorPage(Model model) {
        model.addAttribute("listData", motorService.getAll());
        model.addAttribute("formData", new Motor());
        return "motor.html";
    }

    @GetMapping("/motor/{id}")
    public String motorEdit(Model model, @PathVariable("id") Long id) { // UBAH KE Long
        model.addAttribute("listData", motorService.getAll());
        model.addAttribute("formData", motorService.getById(id));
        return "motor.html";
    }

    @PostMapping(value="/motor/save", params="add")
    public String motorAdd(@ModelAttribute("formData") Motor obj) {
        // HAPUS obj.setId(null); - biar JPA handle
        motorService.save(obj);
        return "redirect:/motor";
    }

    @PostMapping(value="/motor/save", params="edit")
    public String motorUpdate(@ModelAttribute("formData") Motor obj) {
        motorService.save(obj);
        return "redirect:/motor";
    }

    @PostMapping("/motor/delete/{id}")
    public String motorDelete(@PathVariable("id") Long id) { // UBAH KE Long
        motorService.delete(id);
        return "redirect:/motor";
    }
}