package com.example.queueApi.service;

import com.example.queueApi.model.Queue;
import com.example.queueApi.repository.QueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    private QueueRepository queueRepository;

    @Override
    public Queue saveQueue(Queue queue) {
        return queueRepository.save(queue);
    }

    @Override
    public List<Queue> getAllQueues() {
        return queueRepository.findAll();
    }

    @Override
    public Queue getQueueById(Long id) {
        return queueRepository.findById(id).orElseThrow(() -> new RuntimeException("Queue not found"));
    }

    @Override
    public Queue updateQueue(Long id, Queue queue) {
        Queue existingQueue = getQueueById(id);
        // Update properties
        existingQueue.setName(queue.getName());
        existingQueue.setOwner(queue.getOwner());
        // Add logic to handle songs and guests if applicable
        return queueRepository.save(existingQueue);
    }

    @Override
    public void deleteQueue(Long id) {
        queueRepository.deleteById(id);
    }
}
