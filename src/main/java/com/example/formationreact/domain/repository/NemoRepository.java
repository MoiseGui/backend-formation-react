package com.example.formationreact.domain.repository;

import com.example.formationreact.domain.model.Nemo;
import com.example.formationreact.domain.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NemoRepository extends JpaRepository<Nemo, Long> {
    List<Nemo> findByStatus(Status status);
    List<Nemo> findAllByOrderByIdDesc();
}

