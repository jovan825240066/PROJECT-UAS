package com.example.demospringbootss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Pengirim;
public interface PengirimRepository extends JpaRepository<Pengirim, Long> {}