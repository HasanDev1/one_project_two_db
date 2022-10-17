package uz.agro.cardInfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ui_02_025")
@Entity
public class Ui02025 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 5)
    private String codeBank;

    private String ui_id;

    @Column(length = 5)
    private String baseObu;

    @Column(length = 20)
    private String account;

    @Column(length = 3)
    private String code_str;

    @Column(length = 2)
    private String vidUsl;

    @Column(length = 1)
    private String kodPay;

    @Column(length = 20)
    private String summa;

    @Column(length = 4)
    private String kodMcc;

    @Column(length = 8)
    private String clientCode;

    private String cardNum;

    private String codeTerm;

    private String nameOrgTerm;

    private LocalDate dateTransac;

    private Integer idUi;

    private LocalDate data;

    private String send;

    private String version;

    private String count_r;
}
