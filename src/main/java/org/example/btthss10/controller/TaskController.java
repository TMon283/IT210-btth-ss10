package org.example.btthss10.controller;

import jakarta.validation.Valid;
import org.example.btthss10.dto.TaskItemDto;
import org.example.btthss10.model.Priority;
import org.example.btthss10.model.TaskItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class TaskController {
    List<TaskItem> taskItems = new ArrayList<>(
            Arrays.asList(
                    new TaskItem("1", "Chuẩn bị kiến thức ss11", LocalDate.of(2026, 4, 19), Priority.HIGH),
                    new TaskItem("2", "Chuẩn bị kiến thức ss12", LocalDate.of(2026, 4, 20), Priority.MEDIUM),
                    new TaskItem("3", "Chuẩn bị kiến thức ss13", LocalDate.of(2026, 4, 21), Priority.LOW),
                    new TaskItem("4", "Chuẩn bị kiến thức ss14", LocalDate.of(2026, 4, 22), Priority.HIGH),
                    new TaskItem("5", "Chuẩn bị kiến thức ss15", LocalDate.of(2026, 4, 23), Priority.MEDIUM)
                    )
    );

    @GetMapping("/tasks")
    public String getList(Model model) {
        model.addAttribute("tasks", taskItems);
        return "task-list";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("taskItemDto", new TaskItemDto());
        return "task-form";
    }

    @PostMapping("/handle-submit")
    public String handleSubmit(@Valid @ModelAttribute(name = "personDTO") TaskItemDto taskItemDto,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("taskItemDto", taskItemDto);
            return "task-form";
        }
        TaskItem newTaskItem = new TaskItem(
                taskItemDto.getId(),
                taskItemDto.getTitle(),
                taskItemDto.getDeadline(),
                taskItemDto.getPriority()
        );
        taskItems.add(newTaskItem);
        return "redirect:/";
    }
}
