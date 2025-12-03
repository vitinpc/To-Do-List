package br.com.api.to_do_list.services;

import java.util.List;

import br.com.api.to_do_list.dto.TaskRequest;
import br.com.api.to_do_list.dto.TaskResponse;
import br.com.api.to_do_list.enums.Priority;
import br.com.api.to_do_list.enums.Status;

public interface TaskService {

    TaskResponse createTask(TaskRequest taskRequest);

    List<TaskResponse> findAll();

    TaskResponse findById(Long id);

    TaskResponse updateTask(Long id, TaskRequest taskRequest);

    TaskResponse updateStatus(Long id, Status status);

    TaskResponse updatePriority(Long id, Priority priority);

    void deleteTask(Long id);
}
