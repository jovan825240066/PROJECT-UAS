package com.example.demospringbootss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Gudang;

public interface GudangRepository extends JpaRepository<Gudang, Long> {
}