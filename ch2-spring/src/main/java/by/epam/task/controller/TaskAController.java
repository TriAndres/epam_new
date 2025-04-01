package by.epam.task.controller;

import by.epam.task.service.TaskAService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/a")
@RequiredArgsConstructor
public class TaskAController {
    private final TaskAService taskA1Service;

    @GetMapping("/task1")
    public String task1() {
        return taskA1Service.taskA1();
    }
}