package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
@Table
public class VolunteerProfile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)

    private Long volunteerId;
    private String fullname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone; 
    private String availabilityStatus;
    private LocalDateTime createdAt;
    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDateTime.now();
    }

    public VolunteerProfile() {
    }

    public Long getId() {
        return id;
    }
    public Long getVolunteerid() {
        return volunteerId;
    }
    public String getFullname() {
        return fullname;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVolunteerid(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
  
    
}
