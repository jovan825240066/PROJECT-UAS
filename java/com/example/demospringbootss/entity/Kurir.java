package com.example.demospringbootss.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "kurir")
public class Kurir extends Orang {
    
    private String perusahaan;
    private String kendaraan;

    public Kurir() {}

    // Tambahkan constructor
    public Kurir(String nama, String alamat, String noHP, String perusahaan, String kendaraan) {
        super(nama, alamat, noHP);
        this.perusahaan = perusahaan;
        this.kendaraan = kendaraan;
    }

    // Getter dan Setter
    public String getPerusahaan() { return perusahaan; }
    public void setPerusahaan(String perusahaan) { this.perusahaan = perusahaan; }
    
    public String getKendaraan() { return kendaraan; }
    public void setKendaraan(String kendaraan) { this.kendaraan = kendaraan; }
    
    @Override
    public String getTipe() {
        return "Kurir";
    }
}