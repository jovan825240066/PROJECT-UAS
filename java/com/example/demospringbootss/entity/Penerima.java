package com.example.demospringbootss.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "penerima")
public class Penerima extends Orang {
    
    private String tandaTerima;

    public Penerima() {}

    // Tambahkan constructor
    public Penerima(String nama, String alamat, String noHP, String tandaTerima) {
        super(nama, alamat, noHP);
        this.tandaTerima = tandaTerima;
    }

    // Getter dan Setter
    public String getTandaTerima() { return tandaTerima; }
    public void setTandaTerima(String tandaTerima) { this.tandaTerima = tandaTerima; }

    @Override
    public String getTipe() {
        return "Penerima";
    }
}