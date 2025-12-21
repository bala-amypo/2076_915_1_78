package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluationRecord evaluate(@RequestBody EvaluationRequest req) {
        AssignmentEvaluationRecord e = new AssignmentEvaluationRecord();
        e.setAssignmentId(req.getAssignmentId());
        e.setRating(req.getRating());
        e.setFeedback(req.getComments());
        return service.evaluateAssignment(e);
    }
}
