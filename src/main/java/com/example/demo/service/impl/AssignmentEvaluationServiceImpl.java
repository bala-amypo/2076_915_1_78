package com.example.demo.service.impl;
import org.springframework.
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;

import java.util.List;
@Service
public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evalRepo;
    private final TaskAssignmentRecordRepository assignmentRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository evalRepo,
            TaskAssignmentRecordRepository assignmentRepo) {

        this.evalRepo = evalRepo;
        this.assignmentRepo = assignmentRepo;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {

        TaskAssignmentRecord assignment =
                assignmentRepo.findById(evaluation.getAssignmentId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Assignment not found"));

        if (!"COMPLETED".equals(assignment.getStatus())) {
            throw new BadRequestException("Assignment not COMPLETED");
        }

        return evalRepo.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long assignmentId) {
        return evalRepo.findByAssignmentId(assignmentId);
    }
}
