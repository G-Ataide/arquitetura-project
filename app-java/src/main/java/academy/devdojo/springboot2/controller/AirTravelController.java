package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.AirTravel;
import academy.devdojo.springboot2.service.AirTravelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("airtravel")
@Log4j2
@RequiredArgsConstructor
public class AirTravelController {

    @Autowired
    private final AirTravelService airTravelService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AirTravel>> listAll() {
        List<AirTravel> airTravels = airTravelService.listAllNonPageable();

        if (airTravels.size()>0){
            return ResponseEntity.ok(airTravels);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/orig/{origId}")
    public ResponseEntity<List<AirTravel>> findById(@PathVariable long origId) {

        List<AirTravel> airTravels = airTravelService.findByOrigId(origId);

        if (airTravels.size()>0){
            return ResponseEntity.ok(airTravels);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/date/{date}")
    public ResponseEntity<List<AirTravel>> findByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {

        List<AirTravel> airTravels = airTravelService.findByDate(date);

        if (airTravels.size()>0){
            return ResponseEntity.ok(airTravels);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping(path = "/amount-passenger/{amountPassenger}")
    public ResponseEntity<List<AirTravel>> findByTop10Price(@PathVariable Integer amountPassenger) {

        List<AirTravel> airTravels  = airTravelService.findByTop10PriceAndAmountPassenger(amountPassenger);

        if (airTravels.size()>0){
            return ResponseEntity.ok(airTravels);
        }
        return ResponseEntity.notFound().build();

    }

}
