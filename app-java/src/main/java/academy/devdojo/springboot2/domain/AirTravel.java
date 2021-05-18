package academy.devdojo.springboot2.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode
public class AirTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aiport_orig_id", nullable = false)
    private Airport airportOrig;

    @ManyToOne
    @JoinColumn(name = "airport_dest_id", nullable = false)
    private Airport airportDest;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "ts_departure")
    private LocalDateTime tsDeparture;

    @Column(name = "ts_arrival")
    private LocalDateTime tsArrival;

    @Column(name = "amount_seat")
    private Long amountSeat;




}
