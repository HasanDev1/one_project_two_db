package uz.agro.cardInfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Humo_cards {
    @Id
    private String client;
    private String client_b;
    private String branch;
    private String card;
    private String status1;
    private String status2;
    private LocalDate expiry1;
    private LocalDate expirity2;
    private String renew;
    private LocalDate renew_date;
    private String card_name;
    private String mc_name;
    private String m_name;
    private String stop_couse;
    private String renewed_card;
    private Integer design_id;
    private String instant;
    private String real_card;
    private String card_acct;
    private String tranz_acct;
    private String account_no;
    private LocalDate update_status;

}
