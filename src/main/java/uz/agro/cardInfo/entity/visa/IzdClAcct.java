package uz.agro.cardInfo.entity.visa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "izd_cl_acct")
public class IzdClAcct {

    @Id
    private String TRANZ_ACCT;

    private Integer TAB_KEY;

    private Integer MAIN_ROW;
    private String ACC_PRTY;
    private String client;
    private String CARD_ACCT;
    private Long ACCOUNT_NO;
    private Long BACCOUNT_NO;
    private String ccy;
    private String C_ACCNT_TYPE;
    private String bank_c;
    private String usrid;
    private LocalDate ctime;
    private String groupc;
    private Integer B_BR_ID;
    private Integer parent_account_no;
    private String parent_tranz_acct;
    private String parent_bank_c;
    private String parent_groupc;
    private String cardnum;
    private String card_seq;
    private String iban;
    private Integer office_id;

}
