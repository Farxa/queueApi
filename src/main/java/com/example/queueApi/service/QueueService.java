package com.example.queueApi.service;

import com.example.queueApi.model.Queue;
import java.util.List;

public interface QueueService {
    Queue saveQueue(Queue queue);
    List<Queue> getAllQueues();
    Queue getQueueById(Long id);
    Queue updateQueue(Long id, Queue queue);
    void deleteQueue(Long id);
}
