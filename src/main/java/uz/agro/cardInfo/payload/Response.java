package uz.agro.cardInfo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.agro.cardInfo.entity.Account;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private String branch;
    private String unical;
    private String pinfl;

    private String expiration_date;

    private Account account;

    private Passport passport;

//    private HashSet<Account> accountList;

    public Response(String branch, String unical, String pinfl) {
        this.branch = branch;
        this.unical = unical;
        this.pinfl = pinfl;
    }
}
