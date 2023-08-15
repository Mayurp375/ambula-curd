package com.example.demo.ambula.repository;

import com.example.demo.ambula.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {

    @Query("SELECT u FROM UserLocation u ORDER BY SQRT(u.latitude * u.latitude + u.longitude * u.longitude) ASC")
    List<UserLocation> findNearestUsers();
}
