package org.example.btthss10.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.btthss10.model.Priority;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskItemDto {
    private String id;
    @NotBlank(message = "Title không được để trống")
    @Min(value = 5, message = "Title không được ngắn hơn 5 kí tự")
    private String title;
    @Future(message = "Ngày nhập vào phải lớn hơn ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    @NotNull
    private Priority priority;

    public TaskItemDto() {
    }

    public TaskItemDto(String id, String title, LocalDate deadline, Priority priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
