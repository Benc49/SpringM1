package com.example.demo.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flight")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlight(){
        return flightService.getFlight();

    }


    @PostMapping
    public void registerNewFlight(@RequestBody Flight flight){
        flightService.addNewFlight(flight);

    }
    @DeleteMapping(path = "{Id}")
    public void deleteFlight(@PathVariable("Id") Long Id){
        flightService.deleteFlight(Id);

    }
    @PutMapping(path = "{Id}")
    public void updateFlight(
            @PathVariable("Id") Long Id,
            @RequestParam(required = false) String pname,
            @RequestParam(required = false) String destination
    ){
        flightService.updateFlight(Id, pname, destination);
    }
}

