package br.com.api.to_do_list.dto;

import java.time.LocalDateTime;

import br.com.api.to_do_list.enums.Priority;
import br.com.api.to_do_list.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse {

    private Long id;

    private String title;

    private String description;

    private Priority priority;

    private Status status;
    
    private LocalDateTime createdAt;
}
