package com.example.demo.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository
        extends JpaRepository<Flight, Long> {

    //    @Query("SELECT s FROM s WHERE s.email=?1")
    Optional<Flight> findFlightByDestination(String destination);
}
