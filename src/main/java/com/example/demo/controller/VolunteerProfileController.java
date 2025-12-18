package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {



    @Autowired 
    VolunteerProfileService vps;
    @PostMapping("/create")
    public VolunteerProfile create(@RequestBody VolunteerProfile profile){

        return vps.createVolunteer(profile);

    }
    @GetMapping("/get/{id}")

    public Optional<VolunteerProfile> getbyid(@PathVariable Long id){

        return vps.getVolunteerById(id);

    }
     @GetMapping("/getall")
    public List<VolunteerProfile> getall(){

        return vps.getAllVolunteers();

    }
    @GetMapping("/fv")
    public VolunteerProfile findvolunteer(@RequestParam String Volid){

        return vps.findByVolunteerId(Volid);

    }
    @PutMapping("/update/{id}")
    public VolunteerProfile update(@PathVariable Long id,@RequestBody String availabilityStatus){


        return vps.updateAvailability(id,availabilityStatus);

    }
    

}
