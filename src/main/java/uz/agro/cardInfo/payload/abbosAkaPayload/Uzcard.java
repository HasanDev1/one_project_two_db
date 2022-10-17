package uz.agro.cardInfo.payload.abbosAkaPayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Uzcard {
    private String cardAccountUzCard;
    private String cardNumberUzCard;
    private String expiry;

}
