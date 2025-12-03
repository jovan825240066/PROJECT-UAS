package com.example.demospringbootss.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import com.example.demospringbootss.entity.*;
import com.example.demospringbootss.service.*;

@Controller
public class OrangController {

    @Autowired private OrangService orangService;
    @Autowired private PengirimService pengirimService;
    @Autowired private PenerimaService penerimaService;
    @Autowired private KurirService kurirService;

    // ========================================================================
    // BAGIAN LOGIN & AUTHENTICATION
    // ========================================================================

    // Halaman login (jika ingin dipisah)
    @GetMapping("/login")
    public String loginPage(HttpServletRequest request) {
        if (request.getSession().getAttribute("USER_LOGGED_IN") != null) {
            return "redirect:/orang";
        }
        return "Login"; // Buat file Login.html jika perlu
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

    // ========================================================================
    // BAGIAN DASHBOARD & MANAJEMEN ORANG
    // ========================================================================

    // Dashboard utama setelah login
    @GetMapping(value={"/orang", "/orang/", "/dashboard"})
    public String orangPage(Model model, HttpServletRequest request) {
        // Cek login
        if (request.getSession().getAttribute("USER_LOGGED_IN") == null) 
            return "redirect:/";
        
        // Set session untuk menandai user sudah login
        HttpSession session = request.getSession();
        session.setAttribute("USER_LOGGED_IN", "admin");

        List<Orang> orangList = orangService.getAllOrang();
        model.addAttribute("orangList", orangList);
        return "Orang";
    }

    @PostMapping("/orang/delete/{id}")
    public String orangDeleteGlobal(@PathVariable("id") Long id) { // Ubah ke Long
        orangService.deleteOrang(id);
        return "redirect:/orang";
    }

    // ========================================================================
    // BAGIAN PENGIRIM
    // ========================================================================

    @GetMapping("/pengirim")
    public String pengirimPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("USER_LOGGED_IN") == null) 
            return "redirect:/";

        model.addAttribute("listData", pengirimService.getAll());
        model.addAttribute("formData", new Pengirim());
        return "Pengirim";
    }

    @GetMapping("/pengirim/{id}")
    public String pengirimEdit(Model model, @PathVariable("id") Long id, HttpServletRequest request) { // Ubah ke Long
        if (request.getSession().getAttribute("USER_LOGGED_IN") == null) 
            return "redirect:/";

        model.addAttribute("listData", pengirimService.getAll());
        model.addAttribute("formData", pengirimService.getById(id));
        return "Pengirim";
    }

    @PostMapping(value="/pengirim/save", params="add")
    public String pengirimAdd(@ModelAttribute("formData") Pengirim obj) {
        obj.setId(null);
        pengirimService.save(obj);
        return "redirect:/pengirim";
    }

    @PostMapping(value="/pengirim/save", params="edit")
    public String pengirimUpdate(@ModelAttribute("formData") Pengirim obj) {
        pengirimService.save(obj);
        return "redirect:/pengirim";
    }

    @PostMapping("/pengirim/delete/{id}")
    public String pengirimDelete(@PathVariable("id") Long id) { // Ubah ke Long
        pengirimService.delete(id);
        return "redirect:/pengirim";
    }

    // ========================================================================
    // BAGIAN PENERIMA
    // ========================================================================

    @GetMapping("/penerima")
    public String penerimaPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("USER_LOGGED_IN") == null)
            return "redirect:/";

        model.addAttribute("listData", penerimaService.getAll());
        model.addAttribute("formData", new Penerima());
        return "Penerima";
    }

    @GetMapping("/penerima/{id}")
    public String penerimaEdit(Model model, @PathVariable("id") Long id, HttpServletRequest request) { // Ubah ke Long
        if (request.getSession().getAttribute("USER_LOGGED_IN") == null)
            return "redirect:/";

        model.addAttribute("listData", penerimaService.getAll());
        model.addAttribute("formData", penerimaService.getById(id));
        return "Penerima";
    }

    @PostMapping(value="/penerima/save", params="add")
    public String penerimaAdd(@ModelAttribute("formData") Penerima obj) {
        obj.setId(null);
        penerimaService.save(obj);
        return "redirect:/penerima";
    }

    @PostMapping(value="/penerima/save", params="edit")
    public String penerimaUpdate(@ModelAttribute("formData") Penerima obj) {
        penerimaService.save(obj);
        return "redirect:/penerima";
    }

    @PostMapping("/penerima/delete/{id}")
    public String penerimaDelete(@PathVariable("id") Long id) { // Ubah ke Long
        penerimaService.delete(id);
        return "redirect:/penerima";
    }

    // ========================================================================
    // BAGIAN KURIR
    // ========================================================================

    @GetMapping("/kurir")
    public String kurirPage(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("USER_LOGGED_IN") == null)
            return "redirect:/";

        model.addAttribute("listData", kurirService.getAll());
        model.addAttribute("formData", new Kurir());
        return "Kurir";
    }

    @GetMapping("/kurir/{id}")
    public String kurirEdit(Model model, @PathVariable("id") Long id, HttpServletRequest request) { // Ubah ke Long
        if (request.getSession().getAttribute("USER_LOGGED_IN") == null)
            return "redirect:/";

        model.addAttribute("listData", kurirService.getAll());
        model.addAttribute("formData", kurirService.getById(id));
        return "Kurir";
    }

    @PostMapping(value="/kurir/save", params="add")
    public String kurirAdd(@ModelAttribute("formData") Kurir obj) {
        obj.setId(null);
        kurirService.save(obj);
        return "redirect:/kurir";
    }

    @PostMapping(value="/kurir/save", params="edit")
    public String kurirUpdate(@ModelAttribute("formData") Kurir obj) {
        kurirService.save(obj);
        return "redirect:/kurir";
    }

    @PostMapping("/kurir/delete/{id}")
    public String kurirDelete(@PathVariable("id") Long id) { // Ubah ke Long
        kurirService.delete(id);
        return "redirect:/kurir";
    }
}