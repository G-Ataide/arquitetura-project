package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.AirTravel;
import academy.devdojo.springboot2.domain.Airport;
import academy.devdojo.springboot2.repository.AirTravelRepository;
import academy.devdojo.springboot2.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public Airport findById(Long id) {

        Optional<Airport> airport = airportRepository.findById(id);

        if (airport.isPresent()){
            return airport.get();
        }

        return null;

    }

}
