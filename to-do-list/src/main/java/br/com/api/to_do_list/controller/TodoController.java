package br.com.api.to_do_list.controller;

import java.util.List;

import br.com.api.to_do_list.services.TaskService;
import br.com.api.to_do_list.dto.TaskRequest;
import br.com.api.to_do_list.dto.TaskResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/tasks")
public class TodoController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest request) {
        TaskResponse response = service.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(Long id) {
        TaskResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> responses = service.findAll();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(Long id, @RequestBody TaskRequest request) {
        TaskResponse response = service.updateTask(id, request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponse> updateTaskStatus(Long id, String status) {
        TaskResponse response = service.updateStatus(id, null);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/priority")
    public ResponseEntity<TaskResponse> updateTaskPriority(Long id, String priority) {
        TaskResponse response = service.updatePriority(id, null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
