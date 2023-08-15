package com.example.demo.ambula.service;

import com.example.demo.ambula.entity.UserLocation;
import com.example.demo.ambula.repository.UserLocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserLocationService {

    @Autowired
    private UserLocationRepository repository;


    public List<UserLocation> getNearestUsers(int n) {
        List<UserLocation> users = repository.findNearestUsers();
        if (users.size() > n) {
            users = users.subList(0, n);
        }
        
        log.info("Fetched nearest {} users", n);
        return users;
    }
}
