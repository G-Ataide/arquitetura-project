package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.AirTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AirTravelRepository extends JpaRepository<AirTravel, Long> {

    Optional<AirTravel> findById(Long id);

    List<AirTravel> findAllByAirportOrigId(Long origId);

    @Query(value = "SELECT * "
                    +" FROM air_travel "
                    +" WHERE CAST(?1 AS DATE) BETWEEN CAST(TS_ARRIVAL AS DATE) AND CAST(TS_DEPARTURE AS DATE)",
            nativeQuery = true)
    List<AirTravel> findByDate(LocalDate date);

    @Query(value = "SELECT * "
            +" FROM air_travel "
            +" WHERE AMOUNT_SEAT >= ?1"
            +" ORDER BY PRICE",
            nativeQuery = true)
    List<AirTravel> findByTop10PriceAndAmountPassenger(Integer amountPassenger);


}

