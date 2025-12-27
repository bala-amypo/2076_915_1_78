package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer-skills")
public class VolunteerSkillController {

    private final VolunteerSkillService volunteerSkillService;

    public VolunteerSkillController(VolunteerSkillService volunteerSkillService) {
        this.volunteerSkillService = volunteerSkillService;
    }

    /**
     * Add or update a volunteer skill
     */
    @PostMapping
    public ResponseEntity<VolunteerSkillRecord> addOrUpdateSkill(
            @Valid @RequestBody VolunteerSkillRecord skill) {

        VolunteerSkillRecord saved =
                volunteerSkillService.addOrUpdateSkill(skill);

        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    /**
     * Get all skills for a volunteer
     */
    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<VolunteerSkillRecord>> getSkillsByVolunteer(
            @PathVariable Long volunteerId) {

        List<VolunteerSkillRecord> skills =
                volunteerSkillService.getSkillsByVolunteer(volunteerId);

        return ResponseEntity.ok(skills);
    }
}
