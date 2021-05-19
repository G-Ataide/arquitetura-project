package academy.devdojo.springboot2.repository;

import academy.devdojo.springboot2.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findById(Long id);

    @Query(value = "SELECT * "
            +" FROM ticket "
            +" WHERE SEAT = ?1 "
            +" AND AIRTRAVEL_ID = ?2",
            nativeQuery = true)
    Optional<Ticket> findBySeatAndAirtravelId(String seat, Long airTravelId);
}
