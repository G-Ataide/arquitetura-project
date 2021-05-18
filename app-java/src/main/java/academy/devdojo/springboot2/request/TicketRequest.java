package academy.devdojo.springboot2.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private String token;
    private String seat;
    private Long airtravelId;
    private String passengerName;
    private String passengerDocument;
}
