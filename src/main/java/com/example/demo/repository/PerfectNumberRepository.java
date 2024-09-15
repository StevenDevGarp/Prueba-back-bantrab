package com.example.demo.repository;

import com.example.demo.entity.PerfectNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfectNumberRepository extends JpaRepository<PerfectNumbers, Integer> {
}
