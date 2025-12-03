package com.example.demospringbootss.entity;

import jakarta.persistence.*; 

@Entity 
@Table(name = "ekspedisi") 
public class Ekspedisi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String idEkspedisi;     
    private String tanggalKirim; 
    private String statusPengiriman;
    private String asal;
    private String tujuan;

    // --- RELASI KE TABEL PAKET ---
    @ManyToOne 
    @JoinColumn(name = "id_paket") 
    private Paket paket;

    // --- RELASI KE TABEL KENDARAAN ---
    @ManyToOne
    @JoinColumn(name = "id_kendaraan")
    private Kendaraan kendaraan;

    // --- RELASI KE TABEL GUDANG (Opsional/Tambahan) ---
    // Tambahkan ini agar sesuai diagram jika ada garis langsung Ekspedisi -> Gudang
    @ManyToOne 
    @JoinColumn(name = "id_gudang") 
    private Gudang gudang;

    // --- CONSTRUCTOR KOSONG (Wajib untuk JPA) ---
    public Ekspedisi() {}

    // --- CONSTRUCTOR LENGKAP ---
    public Ekspedisi(String idEkspedisi, String tanggalKirim, String statusPengiriman, String asal, String tujuan, Paket paket, Kendaraan kendaraan, Gudang gudang) {
        this.idEkspedisi = idEkspedisi;
        this.tanggalKirim = tanggalKirim;
        this.statusPengiriman = statusPengiriman;
        this.asal = asal;
        this.tujuan = tujuan;
        this.paket = paket;
        this.kendaraan = kendaraan;
        this.gudang = gudang;
    }

    // ==========================================================
    // GETTER & SETTER LENGKAP
    // (Ini yang membuat warning "The value of the field is not used" hilang)
    // ==========================================================

    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }
    
    public String getIdEkspedisi() { 
        return idEkspedisi; 
    }
    public void setIdEkspedisi(String idEkspedisi) { 
        this.idEkspedisi = idEkspedisi; 
    }
    
    public String getTanggalKirim() { 
        return tanggalKirim; 
    }
    public void setTanggalKirim(String tanggalKirim) { 
        this.tanggalKirim = tanggalKirim; 
    }
    
    public String getStatusPengiriman() { 
        return statusPengiriman; 
    }
    public void setStatusPengiriman(String statusPengiriman) { 
        this.statusPengiriman = statusPengiriman; 
    }
    
    public String getAsal() { 
        return asal; 
    }
    public void setAsal(String asal) { 
        this.asal = asal; 
    }
    
    public String getTujuan() { 
        return tujuan; 
    }
    public void setTujuan(String tujuan) { 
        this.tujuan = tujuan; 
    }

    // --- Getter & Setter untuk Relasi ---

    public Paket getPaket() { 
        return paket; 
    }
    public void setPaket(Paket paket) { 
        this.paket = paket; 
    }

    public Kendaraan getKendaraan() { 
        return kendaraan; 
    }
    public void setKendaraan(Kendaraan kendaraan) { 
        this.kendaraan = kendaraan; 
    }

    public Gudang getGudang() { 
        return gudang; 
    }
    public void setGudang(Gudang gudang) { 
        this.gudang = gudang; 
    }
}