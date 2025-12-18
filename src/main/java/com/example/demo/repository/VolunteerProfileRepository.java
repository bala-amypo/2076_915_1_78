package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VolunteerProfile;

@Repository
public interface VolunteerProfileRepository extends JpaRepository<VolunteerProfile,Long>{

    public VolunteerProfile findByVolunteerId(String VolunteerId);
    

    
} 