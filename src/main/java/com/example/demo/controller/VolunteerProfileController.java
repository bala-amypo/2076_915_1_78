package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerProfile register(@RequestBody VolunteerProfile profile) {
        return service.createVolunteer(profile);
    }

    @PatchMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestBody AvailabilityUpdateRequest req) {

        VolunteerProfile p = service.getVolunteerById(id);
        p.setAvailabilityStatus(req.getAvailabilityStatus());
        return service.createVolunteer(p);
    }
}
