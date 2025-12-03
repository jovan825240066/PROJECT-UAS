package com.example.demospringbootss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Tracking;
import java.util.Optional;

public interface TrackingRepository extends JpaRepository<Tracking, Long> {
    Optional<Tracking> findByNomorResi(String nomorResi);
    boolean existsByNomorResi(String nomorResi);
}