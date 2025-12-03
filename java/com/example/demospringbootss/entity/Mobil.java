package com.example.demospringbootss.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mobil")
public class Mobil extends Kendaraan {
    
    private Integer jumlahPintu;
    private String tipeMobil;
    private Integer kapasitasPenumpang; 

    public Mobil() {}

    public Mobil(String merk, Integer tahun, Integer jumlahPintu, String tipeMobil, Integer kapasitasPenumpang) {
        super(merk, tahun);
        this.jumlahPintu = jumlahPintu;
        this.tipeMobil = tipeMobil;
        this.kapasitasPenumpang = kapasitasPenumpang;
    }

    public Integer getJumlahPintu() { return jumlahPintu; }
    public void setJumlahPintu(Integer jumlahPintu) { this.jumlahPintu = jumlahPintu; }

    public String getTipeMobil() { return tipeMobil; }
    public void setTipeMobil(String tipeMobil) { this.tipeMobil = tipeMobil; }

    public Integer getKapasitasPenumpang() { return kapasitasPenumpang; }
    public void setKapasitasPenumpang(Integer kapasitasPenumpang) { this.kapasitasPenumpang = kapasitasPenumpang; }

    @Override
    public String getTipe() {
        return "Mobil";
    }
}