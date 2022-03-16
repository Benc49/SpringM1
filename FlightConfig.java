package com.example.demo.flight;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

    @Configuration
    public class FlightConfig {

        @Bean
        CommandLineRunner commandLineRunner(FlightRepository repository){
            return args -> {
                Flight Ben = new Flight(

                        "Ben",
                        "Belize",
                        LocalDate.of(2000, Month.JANUARY, 5)


                );
                Flight James = new Flight(
                        "James",
                        "Germany",
                        LocalDate.of(2004, Month.JANUARY, 5)

                );
                repository.saveAll(
                        List.of(Ben, James)
                );

            };
        }
    }


