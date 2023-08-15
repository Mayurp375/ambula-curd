package com.example.demo.ambula.controller;

import com.example.demo.ambula.entity.UserLocation;
import com.example.demo.ambula.repository.UserLocationRepository;
import com.example.demo.ambula.service.UserLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
@Slf4j
public class UserLocationController {

    @Autowired
    private UserLocationRepository repository;

    @Autowired
    private UserLocationService service;

    //http://localhost:8080/data/create_data


    @PostMapping("/create_data")
    public ResponseEntity<String> createData(@RequestBody UserLocation userLocation) {
        log.info("inside create method " + userLocation);

        log.info("Creating data for user: {}", userLocation.getName());
        repository.save(userLocation);
        return ResponseEntity.ok("Data created successfully.");
    }

    //http://localhost:8080/data/update_data/1

    @PatchMapping("/update_data/{id}")
    public ResponseEntity<String> updateData(@PathVariable Long id, @RequestBody UserLocation newUserLocation) {
        UserLocation userLocation = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        log.info("inside create method " + userLocation);

        log.info("Creating data for user: {}", userLocation.getName() + " : " + id);
        repository.save(userLocation);
        return ResponseEntity.ok("Data updated successfully.");
    }

    //http://localhost:8080/data/get_users/1

    @GetMapping("/get_users/{n}")
    public ResponseEntity<List<UserLocation>> getNearestUsers(@PathVariable int n) {

        log.getName();
        log.warn("not able to search");
        return ResponseEntity.ok(service.getNearestUsers(n));
    }
}
