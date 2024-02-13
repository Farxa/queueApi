package com.example.queueApi.service;

import com.example.queueApi.model.Queue;
import java.util.List;

public interface QueueService {
    Queue createOrUpdateQueue(Queue queue);
    List<Queue> getAllQueues();
    Queue getQueueById(Long id);
    void deleteQueue(Long id);
}
