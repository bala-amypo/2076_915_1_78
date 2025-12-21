package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> byTask(@PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> byVolunteer(@PathVariable Long volunteerId) {
        return service.getAssignmentsByVolunteer(volunteerId);
    }
}
