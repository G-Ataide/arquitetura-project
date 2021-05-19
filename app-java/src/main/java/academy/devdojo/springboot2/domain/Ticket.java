package academy.devdojo.springboot2.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ticket {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "airtravel_id", nullable = false)
    private AirTravel airTravel;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "locator")
    private String locator;

    @Column(name = "passenger_name")
    private String passengerName;

    @Column(name = "passenger_document")
    private String passengerDocument;

    @Column(name = "seat")
    private String seat;
}
