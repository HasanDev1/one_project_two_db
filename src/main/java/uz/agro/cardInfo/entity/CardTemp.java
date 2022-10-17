package uz.agro.cardInfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "card_temp")
public class CardTemp {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 16)
    private String cardnum;


    @Column(length = 5)
    private String branch;


    @Column(length = 20)
    private String account;
}
