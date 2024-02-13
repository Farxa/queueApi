package com.example.queueApi.controller;

import com.example.queueApi.model.Queue;
import com.example.queueApi.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/queues")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @PostMapping
    public Queue createQueue(@RequestBody Queue queue) {
        return queueService.createOrUpdateQueue(queue);
    }

    @GetMapping
    public List<Queue> getAllQueues() {
        return queueService.getAllQueues();
    }

    @GetMapping("/{id}")
    public Queue getQueueById(@PathVariable Long id) {
        return queueService.getQueueById(id);
    }

    @PutMapping("/{id}")
    public Queue updateQueue(@PathVariable Long id, @RequestBody Queue queue) {
        return queueService.createOrUpdateQueue(queue); // Assume this method handles updates as well
    }

    @DeleteMapping("/{id}")
    public void deleteQueue(@PathVariable Long id) {
        queueService.deleteQueue(id);
    }
}
