package br.com.api.to_do_list.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.to_do_list.dto.TaskRequest;
import br.com.api.to_do_list.dto.TaskResponse;
import br.com.api.to_do_list.enums.Priority;
import br.com.api.to_do_list.enums.Status;
import br.com.api.to_do_list.model.TaskEntity;
import br.com.api.to_do_list.repository.TaskRepository;
import br.com.api.to_do_list.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public TaskResponse createTask(TaskRequest request) {

        TaskEntity entity = new TaskEntity();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setPriority(request.getPriority());
        entity.setStatus(Status.PENDING);
        entity.setCreatedAt(LocalDateTime.now());

        TaskEntity savedEntity = repository.save(entity);

        TaskResponse response = new TaskResponse();
        response.setId(savedEntity.getId());
        response.setTitle(savedEntity.getTitle());
        response.setDescription(savedEntity.getDescription());
        response.setPriority(savedEntity.getPriority());
        response.setStatus(savedEntity.getStatus());
        response.setCreatedAt(savedEntity.getCreatedAt());

        return response;
    }

    @Override
    public List<TaskResponse> findAll() {
        
        List<TaskEntity> entities = repository.findAll();

        List<TaskResponse> responses = entities.stream().map(entity -> {
            TaskResponse response = new TaskResponse();
            response.setId(entity.getId());
            response.setTitle(entity.getTitle());
            response.setDescription(entity.getDescription());
            response.setPriority(entity.getPriority());
            response.setStatus(entity.getStatus());
            response.setCreatedAt(entity.getCreatedAt());
            return response;
        }).toList();

        return responses;
    }

    @Override
    public TaskResponse findById(Long id) {
        
        TaskEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        TaskResponse response = new TaskResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setPriority(entity.getPriority());
        response.setStatus(entity.getStatus());
        response.setCreatedAt(entity.getCreatedAt());

        return response;
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest taskRequest) {
        
        TaskEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        entity.setTitle(taskRequest.getTitle());
        entity.setDescription(taskRequest.getDescription());
        entity.setPriority(taskRequest.getPriority());
        TaskEntity updatedEntity = repository.save(entity);

        TaskResponse response = new TaskResponse();
        response.setId(updatedEntity.getId());
        response.setTitle(updatedEntity.getTitle());
        response.setDescription(updatedEntity.getDescription());
        response.setPriority(updatedEntity.getPriority());
        response.setStatus(updatedEntity.getStatus());
        response.setCreatedAt(updatedEntity.getCreatedAt());

        return response;
    }

    @Override
    public TaskResponse updateStatus(Long id, Status status) {
        
        TaskEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        entity.setStatus(status);
        TaskEntity updatedEntity = repository.save(entity);

        TaskResponse response = new TaskResponse();
        response.setId(updatedEntity.getId());
        response.setTitle(updatedEntity.getTitle());
        response.setDescription(updatedEntity.getDescription());
        response.setPriority(updatedEntity.getPriority());
        response.setStatus(updatedEntity.getStatus());
        response.setCreatedAt(updatedEntity.getCreatedAt());

        return response;
    }

    @Override
    public TaskResponse updatePriority(Long id, Priority priority) {

        TaskEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        entity.setPriority(priority);
        TaskEntity updatedEntity = repository.save(entity);

        TaskResponse response = new TaskResponse();
        response.setId(updatedEntity.getId());
        response.setTitle(updatedEntity.getTitle());
        response.setDescription(updatedEntity.getDescription());
        response.setPriority(updatedEntity.getPriority());
        response.setStatus(updatedEntity.getStatus());
        response.setCreatedAt(updatedEntity.getCreatedAt());

        return response;
    }

    @Override
    public void deleteTask(Long id) {

        TaskEntity entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        repository.delete(entity);
    }



}
