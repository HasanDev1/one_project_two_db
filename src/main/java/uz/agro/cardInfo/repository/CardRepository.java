package uz.agro.cardInfo.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import uz.agro.cardInfo.entity.Card;
import uz.agro.cardInfo.payload.abbosAkaPayload.Uzcard;
import uz.agro.cardInfo.payload.CardInfo;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Component
public interface CardRepository extends JpaRepository<Card, String> {
    @Query("select new uz.agro.cardInfo.payload.CardInfo(c.branch, c.def_pos_account, c.expiration_date) from Card c where c.card_number = ?1")
    CardInfo getCardMfoAndUnical(String cardNumber);

    @Query("select c from Card c where c.card_number = ?1")
    Card findByCard_number(String cardNumber);

    @Query("select new uz.agro.cardInfo.payload.abbosAkaPayload.Uzcard(substring(c.def_atm_account, 6), c.card_number, c.expiration_date ) from Card c, Client_p p where p.pinfl = ?1 and p.branch = ?2 and c.branch = p.branch and substring(c.def_atm_account, 15, 8) = p.id and add_months(to_date(c.date_open), 60) > to_date(to_char(sysdate, 'dd.mm.yyyy'), 'dd.mm.yyyy') and substring(c.card_number, 1, 8) not in('86000432', '86000410', '86000411')")
    List<Uzcard> findAllUzcardByPinflAndBranch(String pinf, String branch);

    @Query(nativeQuery = true, value = "select * from upi.card c, client_p p where p.pinfl = ?1 and p.branch = ?2 and c.branch = p.branch and substr(c.def_atm_account, 15, 8) = p.id and add_months(to_date(c.date_open), 60 ) > to_date(to_char(sysdate, 'dd.mm.yyyy'), 'dd.mm.yyyy') and  substr (card_number, 1, 8) in ('62625700')")
    List<Card> findAllUnionUzcardByPinflAndBranch(String pinf, String branch);

//    @Query( nativeQuery = true, value = "select substr(c.def_atm_account, 6) account, c.card_number, c.expiration_date from card c, client_p p where p.pinfl = ?1 and p.branch = ?2 and c.branch = p.branch and substr(c.def_atm_account, 15, 8) = p.id and add_months(to_date(c.date_open), 60 ) > to_date(to_char(sysdate, 'dd.mm.yyyy'), 'dd.mm.yyyy') and substr (c.card_number, 1, 8) not in ('86000432', '86000410', '86000411') union all select substr(c.def_atm_account, 6) account, c.card_number, c.expiration_date from upi.card c, client_p p where p.pinfl = ?1 and p.branch = ?2 and c.branch = p.branch and substr(c.def_atm_account, 15, 8) = p.id and add_months(to_date(c.date_open), 60 ) > to_date(to_char(sysdate, 'dd.mm.yyyy'), 'dd.mm.yyyy') and  substr (card_number, 1, 8) in ('62625700')")
//    List<Uzcard> findAllUzcardByPinflAndBranch(String pinf, String branch);

}
