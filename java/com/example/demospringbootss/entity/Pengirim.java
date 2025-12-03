package com.example.demospringbootss.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pengirim")
public class Pengirim extends Orang { // extends Orang: Artinya dia mewarisi Nama, Alamat, & NoHP dari Orang.
    
    private String email; //  Data Khusus: Cuma Pengirim yang perlu simpan email (untuk notifikasi).

    public Pengirim() {}

    public Pengirim(String nama, String alamat, String noHP, String email) {
        super(nama, alamat, noHP); // super(..): Oper data umum ke bapaknya (Orang) untuk disimpan.
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String getTipe() {
        return "Pengirim"; //Identitas diri: Sistem tahu ini adalah Pengirim.
    }
}