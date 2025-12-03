package com.example.demospringbootss.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gudang")
public class Gudang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String idGudang; 
    private String lokasi;
    private Integer kapasitas;
    private Integer terisi;

    public Gudang() {
        this.terisi = 0;
    }

    public Gudang(String idGudang, String lokasi, Integer kapasitas, Integer terisi) {
        this.idGudang = idGudang;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
        this.terisi = terisi;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIdGudang() { return idGudang; }
    public void setIdGudang(String idGudang) { this.idGudang = idGudang; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public Integer getKapasitas() { return kapasitas; }
    public void setKapasitas(Integer kapasitas) { this.kapasitas = kapasitas; }

    public Integer getTerisi() { return terisi; }
    public void setTerisi(Integer terisi) { this.terisi = terisi; }
}