package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {
   
    public  VolunteerProfileRepository vpr;
    public VolunteerProfileServiceImpl(VolunteerProfileRepository vpr){
        this.vpr=vpr;
    }
    @Override
    public VolunteerProfile createVolunteer(VolunteerProfile profile){

        return vpr.save(profile);

    }
    @Override
    public Optional<VolunteerProfile> getVolunteerById(Long id){

        return vpr.findById(id);

    }
    @Override
    public List<VolunteerProfile> getAllVolunteers(){

        return (vpr.findAll());

    }
    @Override
    public VolunteerProfile findByVolunteerId(String VolunteerId){

        return vpr.findByVolunteerId(VolunteerId);
      

       
    }
    @Override
    public VolunteerProfile updateAvailability(Long id,String availabilityStatus){
        VolunteerProfile vp=vpr.getReferenceById(id);
       vp.setAvailabilityStatus(availabilityStatus);
       return vpr.save(vp);

       
        


    }


    
}
