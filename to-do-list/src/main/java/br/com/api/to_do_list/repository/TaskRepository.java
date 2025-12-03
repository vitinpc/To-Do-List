package br.com.api.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.to_do_list.model.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
