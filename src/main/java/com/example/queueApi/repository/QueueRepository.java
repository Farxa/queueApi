package com.example.queueApi.repository;


import com.example.queueApi.model.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueRepository extends JpaRepository<Queue, Long> {
}

