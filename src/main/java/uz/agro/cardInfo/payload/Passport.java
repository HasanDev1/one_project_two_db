package uz.agro.cardInfo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Passport {
    private LocalDate BIRTHDAY;
    private String NAME;
    private String POST_ADDRESS;
    private String BIRTH_PLACE;
    private String PASSPORT_TYPE;
    private String PASSPORT_SERIAL;
    private String PASSPORT_NUMBER;
    private String PASSPORT_PLACE_REGISTRATION;
    private LocalDate PASSPORT_DATE_REGISTRATION;
    private LocalDate PASSPORT_DATE_EXPIRATION;
}
