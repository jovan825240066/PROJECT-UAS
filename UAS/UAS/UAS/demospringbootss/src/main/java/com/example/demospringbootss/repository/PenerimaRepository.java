package com.example.demospringbootss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Penerima;
public interface PenerimaRepository extends JpaRepository<Penerima, Long> {}