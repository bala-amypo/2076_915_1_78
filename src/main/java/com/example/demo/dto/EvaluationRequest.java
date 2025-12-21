package com.example.demo.dto;

public class EvaluationRequest {
    private Long assignmentId;
    private Integer rating;
    private String comments;

    public Long getAssignmentId() { return assignmentId; }
    public Integer getRating() { return rating; }
    public String getComments() { return comments; }
}
