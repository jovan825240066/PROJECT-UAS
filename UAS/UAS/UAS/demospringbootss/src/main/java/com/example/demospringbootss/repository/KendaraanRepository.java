package com.example.demospringbootss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Kendaraan;

public interface KendaraanRepository extends JpaRepository<Kendaraan, Long> {
}