package uz.agro.cardInfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bf_empc_accounts {
    @Id

    private String client;
    private String branch;
    private String account_no;
    private String card_acct;
    private String tranz_acct;
    private String ab_expirty;
    private String created_date;
}
