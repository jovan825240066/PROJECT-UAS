package com.example.demospringbootss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Motor;

public interface MotorRepository extends JpaRepository<Motor, Long> {
}