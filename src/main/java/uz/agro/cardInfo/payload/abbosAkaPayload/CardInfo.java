package uz.agro.cardInfo.payload.abbosAkaPayload;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
//@Data
@Getter
@Setter
public class CardInfo {
//    @JsonProperty("FIO")
    private String fio;
//    @JsonProperty("PINFL")
    private String pinfl;

//    @JsonProperty("Uzcard")
    private List<Uzcard> uzCards;

//    @JsonProperty("Humo")
    private List<HumoCard> humoCards;


}
