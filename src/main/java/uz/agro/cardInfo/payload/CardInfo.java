package uz.agro.cardInfo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardInfo {
    private String branch;
    private String defPosAccount;
    private String expiration_date;
}
