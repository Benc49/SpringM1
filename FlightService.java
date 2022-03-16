package com.example.demo.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class FlightService {

    private final FlightRepository flightRepository;


    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlight() {
        return flightRepository.findAll();
    }


    public void addNewFlight(Flight flight) {
        Optional<Flight> flightOptional = flightRepository.findFlightByDestination(flight.getDestination());
        if (flightOptional.isPresent()) {
            throw new IllegalStateException("location taken");
        }
        flightRepository.save(flight);


    }

    public void deleteFlight(Long flightId) {
        boolean exists = flightRepository.existsById(flightId);
        if (!exists) {
            throw new IllegalStateException("Flight with the id " + flightId + " does not exist");
        }

        flightRepository.deleteById(flightId);
    }

    @Transactional
    public void updateFlight(Long flightId, String pname, String destination) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new IllegalStateException(
                "Flight with id " + flightId + " does not exist."
        ));
        if(pname != null
                && pname.length() > 0
                && !Objects.equals(flight.getPname(), pname)){
            flight.setPname(pname);
        }
        if(destination != null
                && destination.length() > 0
                && !Objects.equals(flight.getDestination(), destination)){
            flight.setDestination(destination);
        }
    }

}


