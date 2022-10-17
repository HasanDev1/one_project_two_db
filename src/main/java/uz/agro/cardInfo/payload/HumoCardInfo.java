package uz.agro.cardInfo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HumoCardInfo {

    private String branch;
    private String unical;
    private LocalDate expiration_date;
    private String tranz_acct;
}
