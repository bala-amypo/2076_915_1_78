package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.VolunteerProfile;

public interface VolunteerProfileService {

    public VolunteerProfile createVolunteer(VolunteerProfile profile);
    public Optional<VolunteerProfile> getVolunteerById(Long id);
    public List<VolunteerProfile> getAllVolunteers();
    public VolunteerProfile findByVolunteerId(String VolunteerId);
    public VolunteerProfile updateAvailability(Long id,String availabilityStatus);


}
