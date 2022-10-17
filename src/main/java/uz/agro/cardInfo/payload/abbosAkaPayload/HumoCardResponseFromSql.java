package uz.agro.cardInfo.payload.abbosAkaPayload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HumoCardResponseFromSql {
    private String realCard;
    private String tranzAcct;
    private String expiry;
}
