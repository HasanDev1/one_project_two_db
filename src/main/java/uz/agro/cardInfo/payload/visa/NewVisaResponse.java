package uz.agro.cardInfo.payload.visa;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewVisaResponse {

    private String mfo;
    private String tranz_acct;
    private String card;
    private String status;
}
