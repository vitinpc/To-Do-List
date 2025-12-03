package br.com.api.to_do_list.dto;

import jakarta.annotation.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    @NonNull
    private String title;

    private String description;

    private Priority priority;
}
