package com.example.demospringbootss.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demospringbootss.entity.Orang;
public interface OrangRepository extends JpaRepository<Orang, Long> {}