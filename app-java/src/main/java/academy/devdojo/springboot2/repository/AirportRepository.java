package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Optional<Airport> findById(Long id);

}
