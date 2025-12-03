package com.example.demospringbootss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Kurir;
public interface KurirRepository extends JpaRepository<Kurir, Long> {}