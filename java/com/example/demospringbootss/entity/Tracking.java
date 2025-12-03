package com.example.demospringbootss.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tracking")
public class Tracking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String nomorResi;
    
    @Column(nullable = false)
    private String jenisBarang;
    
    private String tujuan;
    
    @Enumerated(EnumType.STRING)
    private StatusPaket status;
    
    private LocalDateTime tanggalDibuat;
    private LocalDateTime tanggalUpdate;
    
    // Relasi dengan Pengirim
    @ManyToOne
    @JoinColumn(name = "pengirim_id")
    private Pengirim pengirim;
    
    // Relasi dengan Penerima
    @ManyToOne
    @JoinColumn(name = "penerima_id")
    private Penerima penerima;
    
    // Relasi dengan Kurir
    @ManyToOne
    @JoinColumn(name = "kurir_id")
    private Kurir kurir;
    
    // Enum untuk status paket
    public enum StatusPaket {
        DITERIMA, 
        DALAM_PENGIRIMAN, 
        SELESAI,
        GAGAL
    }
    
    public Tracking() {
        this.tanggalDibuat = LocalDateTime.now();
        this.status = StatusPaket.DITERIMA;
    }
    
    public Tracking(String nomorResi, String jenisBarang, String tujuan) {
        this();
        this.nomorResi = nomorResi;
        this.jenisBarang = jenisBarang;
        this.tujuan = tujuan;
    }
    
    // Getter dan Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNomorResi() { return nomorResi; }
    public void setNomorResi(String nomorResi) { this.nomorResi = nomorResi; }
    
    public String getJenisBarang() { return jenisBarang; }
    public void setJenisBarang(String jenisBarang) { this.jenisBarang = jenisBarang; }
    
    public String getTujuan() { return tujuan; }
    public void setTujuan(String tujuan) { this.tujuan = tujuan; }
    
    public StatusPaket getStatus() { return status; }
    public void setStatus(StatusPaket status) { 
        this.status = status;
        this.tanggalUpdate = LocalDateTime.now();
    }
    
    public LocalDateTime getTanggalDibuat() { return tanggalDibuat; }
    public void setTanggalDibuat(LocalDateTime tanggalDibuat) { this.tanggalDibuat = tanggalDibuat; }
    
    public LocalDateTime getTanggalUpdate() { return tanggalUpdate; }
    public void setTanggalUpdate(LocalDateTime tanggalUpdate) { this.tanggalUpdate = tanggalUpdate; }
    
    public Pengirim getPengirim() { return pengirim; }
    public void setPengirim(Pengirim pengirim) { this.pengirim = pengirim; }
    
    public Penerima getPenerima() { return penerima; }
    public void setPenerima(Penerima penerima) { this.penerima = penerima; }
    
    public Kurir getKurir() { return kurir; }
    public void setKurir(Kurir kurir) { this.kurir = kurir; }
    
    // Method untuk mendapatkan status dalam bentuk String yang lebih user-friendly
    public String getStatusDisplay() {
        switch (this.status) {
            case DITERIMA: return "Paket Diterima di Gudang";
            case DALAM_PENGIRIMAN: return "Sedang Dalam Pengiriman";
            case SELESAI: return "Paket Telah Sampai";
            case GAGAL: return "Pengiriman Gagal";
            default: return "Status Tidak Diketahui";
        }
    }
}