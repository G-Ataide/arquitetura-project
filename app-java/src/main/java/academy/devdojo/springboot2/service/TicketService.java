package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.AirTravel;
import academy.devdojo.springboot2.domain.Airport;
import academy.devdojo.springboot2.domain.Ticket;
import academy.devdojo.springboot2.repository.AirportRepository;
import academy.devdojo.springboot2.repository.TicketRepository;
import academy.devdojo.springboot2.request.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    private final AirTravelService airTravelService;

    private final UserService userService;

    public String create(TicketRequest ticketRequest) {

        if (userService.validSession(ticketRequest.getToken()).equals("invalid token")){
            return "Invalid Token";
        }

        Optional<Ticket> ticketBySeatAndAirtravelId = ticketRepository.findBySeatAndAirtravelId(ticketRequest.getSeat(), ticketRequest.getAirtravelId());

        if(ticketBySeatAndAirtravelId.isPresent()){
            return "Seat is occupied";
        }

        Optional<AirTravel> airTravel = airTravelService.findById(ticketRequest.getAirtravelId());

        if(!airTravel.isPresent()){
            return "Airtravel not found";
        }

        if(airTravel.get().getAmountSeat() == 0){
            return "Airtravel is fully";
        }

        String locator = CriptoService.encrypt(
                airTravel.get().getAirportOrig().getCode()
                        .concat(airTravel.get().getAirportOrig().getCode()),
                20);
        airTravel.get().getAirportOrig().getCode();
        airTravel.get().getAirportDest().getCode();

        locator =  airTravel.get().getAirportOrig().getCode()
                .concat("-")
                .concat(airTravel.get().getAirportDest().getCode())
                .concat("-")
                .concat(locator);

        airTravel.get().setAmountSeat(airTravel.get().getAmountSeat()-1);

        Ticket ticket = Ticket.builder()
                .airTravel(airTravel.get())
                .locator(locator)
                .seat(ticketRequest.getSeat())
                .passengerName(ticketRequest.getPassengerName())
                .passengerDocument(ticketRequest.getPassengerDocument())
                .price(airTravel.get().getPrice())
                .build();

        ticketRepository.save(ticket);

        airTravelService.save(airTravel.get());

        return ticket.getLocator();
    }
}
