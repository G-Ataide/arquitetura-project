package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.AirTravel;
import academy.devdojo.springboot2.repository.AirTravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirTravelService {

    private final AirTravelRepository airTravelRepository;

    public Optional<AirTravel> findById(Long id) {
        return airTravelRepository.findById(id);
    }

    public List<AirTravel> listAllNonPageable() {
        return airTravelRepository.findAll();
    }

    public List<AirTravel> findByOrigId(Long origId) {
        return airTravelRepository.findAllByAirportOrigId(origId);
    }

    public List<AirTravel> findByDate(LocalDate date) {
        return airTravelRepository.findByDate(date);
    }

    public List<AirTravel> findByTop10PriceAndAmountPassenger(Integer amountPassenger){
        return airTravelRepository.findByTop10PriceAndAmountPassenger(amountPassenger);
    }

    @Transactional
    public AirTravel save(AirTravel airTravel) {
        return airTravelRepository.save(airTravel);
    }

}
