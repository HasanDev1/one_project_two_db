package uz.agro.cardInfo.payload.abbosAkaPayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HumoCard {
    private String cardAccountHumo;
    private String cardNumberHumo;
    private String expiry;
}
