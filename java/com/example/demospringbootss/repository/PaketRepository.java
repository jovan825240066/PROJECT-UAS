package com.example.demospringbootss.repository;

import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Paket;

public interface PaketRepository extends JpaRepository<Paket, Long> {

    List<Paket> findByGudangId(Long id);

    Paket findByNomorResi(String nomorResi);
    
}