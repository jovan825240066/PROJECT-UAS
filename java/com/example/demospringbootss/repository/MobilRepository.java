package com.example.demospringbootss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Mobil;

public interface MobilRepository extends JpaRepository<Mobil, Long> {
}