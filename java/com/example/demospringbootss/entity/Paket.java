package com.example.demospringbootss.entity;

import jakarta.persistence.*;

@Entity 
@Table(name = "paket") 
public class Paket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private Double beratBarang; 
    private String jenisLayanan;
    private String nomorResi;
    private Boolean asuransi;
    private String tujuan;
    private String penerima; 
    private String jenisBarang;

    // === RELASI KE GUDANG ===
    @ManyToOne // Relasi Many-to-One: Banyak Paket bisa disimpan di 1 Gudang yang sama
    @JoinColumn(name = "id_gudang") // Membuat kolom Foreign Key di database bernama 'id_gudang'
    private Gudang gudang;

    // Constructor 
    public Paket() {} 

    // Constructor 
    public Paket(Double beratBarang, String jenisLayanan, String nomorResi, Boolean asuransi, String tujuan, String penerima, String jenisBarang, Gudang gudang) {
        this.beratBarang = beratBarang;
        this.jenisLayanan = jenisLayanan;
        this.nomorResi = nomorResi;
        this.asuransi = asuransi;
        this.tujuan = tujuan;
        this.penerima = penerima;
        this.jenisBarang = jenisBarang;
        this.gudang = gudang;
    }

    // === GETTER & SETTER ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getBeratBarang() { return beratBarang; }
    public void setBeratBarang(Double beratBarang) { this.beratBarang = beratBarang; }

    public String getJenisLayanan() { return jenisLayanan; }
    public void setJenisLayanan(String jenisLayanan) { this.jenisLayanan = jenisLayanan; }

    public String getNomorResi() { return nomorResi; }
    public void setNomorResi(String nomorResi) { this.nomorResi = nomorResi; }

    public Boolean getAsuransi() { return asuransi; }
    public void setAsuransi(Boolean asuransi) { this.asuransi = asuransi; }

    public String getTujuan() { return tujuan; }
    public void setTujuan(String tujuan) { this.tujuan = tujuan; }

    public String getPenerima() { return penerima; }
    public void setPenerima(String penerima) { this.penerima = penerima; }

    public String getJenisBarang() { return jenisBarang; }
    public void setJenisBarang(String jenisBarang) { this.jenisBarang = jenisBarang; }

    public Gudang getGudang() { return gudang; }
    public void setGudang(Gudang gudang) { this.gudang = gudang; }
}