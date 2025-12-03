package com.example.demospringbootss.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Ekspedisi;

public interface EkspedisiRepository extends JpaRepository<Ekspedisi, Long> {
    
    List<Ekspedisi> findByPaketId(Long id);
    
}