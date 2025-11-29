package br.com.api.to_do_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.to_do_list.model.TaskEntity;

public interface TodoRepository extends JpaRepository<TaskEntity, Long> {
}
