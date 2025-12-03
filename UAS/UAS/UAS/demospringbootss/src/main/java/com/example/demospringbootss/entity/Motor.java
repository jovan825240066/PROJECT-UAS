package com.example.demospringbootss.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "motor")
public class Motor extends Kendaraan {
    
    private Integer kapasitasMesin;
    private String jenisMotor;
    private String nomorRangka;
    
    public Motor() {}

    public Motor(String merk, Integer tahun, Integer kapasitasMesin, String jenisMotor, String nomorRangka) {
        super(merk, tahun);
        this.kapasitasMesin = kapasitasMesin;
        this.jenisMotor = jenisMotor;
        this.nomorRangka = nomorRangka;
    }

    public Integer getKapasitasMesin() { return kapasitasMesin; }
    public void setKapasitasMesin(Integer kapasitasMesin) { this.kapasitasMesin = kapasitasMesin; }

    public String getJenisMotor() { return jenisMotor; }
    public void setJenisMotor(String jenisMotor) { this.jenisMotor = jenisMotor; }

    public String getNomorRangka() { return nomorRangka; }
    public void setNomorRangka(String nomorRangka) { this.nomorRangka = nomorRangka; }

    @Override
    public String getTipe() {
        return "Motor";
    }
}