package uz.agro.cardInfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(length = 5)
    private String branch;

    @Column(length = 64)
    private String company_name;
    @Column(length = 24)
    private String card_number;
    @Column(length = 1)
    private Integer is_primary;

    @Column(length = 2)
    private String card_type;
    @Column(length = 32)
    private String def_atm_account;
    @Column(length = 32)
    private String def_pos_account;
    @Column(length = 26)
    private String embossed_ch_name;
    @Column(length = 4)
    private String expiration_date;
    @Column(length = 8)
    private String card_status;
    @Column(length = 6)
    private String contract_id;

    private LocalDate date_open;

    private LocalDate date_close;
    @Column(length = 8)
    private String hot_card_status;

}
