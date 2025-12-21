package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRecordService taskService;
    private final TaskAssignmentService assignmentService;

    public TaskController(TaskRecordService taskService,
                          TaskAssignmentService assignmentService) {
        this.taskService = taskService;
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return taskService.createTask(task);
    }

    @PostMapping("/{taskId}/assign")
    public TaskAssignmentRecord assign(@PathVariable Long taskId) {
        return assignmentService.assignTask(taskId);
    }
}
