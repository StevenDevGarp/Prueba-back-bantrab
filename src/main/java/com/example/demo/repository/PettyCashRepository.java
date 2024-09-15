package com.example.demo.repository;

import com.example.demo.entity.PettyCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PettyCashRepository extends JpaRepository<PettyCash, Integer> {
}
