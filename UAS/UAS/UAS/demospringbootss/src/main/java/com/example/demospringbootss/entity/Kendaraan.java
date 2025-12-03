package com.example.demospringbootss.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Kendaraan { 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String merk;
    private Integer tahun;

    public Kendaraan() {}

    public Kendaraan(String merk, Integer tahun) {
        this.merk = merk;
        this.tahun = tahun;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }
    
    public Integer getTahun() { return tahun; }
    public void setTahun(Integer tahun) { this.tahun = tahun; }

    // ABSTRACT METHOD - INI YANG HARUS DIIMPLEMENTASI
    public abstract String getTipe();
}