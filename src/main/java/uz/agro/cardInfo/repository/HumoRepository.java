package uz.agro.cardInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.agro.cardInfo.entity.Humo_cards;
import uz.agro.cardInfo.payload.abbosAkaPayload.HumoCard;
import uz.agro.cardInfo.payload.HumoCardInfo;

import java.util.List;

public interface HumoRepository extends JpaRepository<Humo_cards, String> {

//    @Query("select new uz.agro.cardInfo.payload.HumoCardInfo(s.branch, s.client_b, s.expiry1) from Humo_cards s where s.real_card = ?1")
//    HumoCardInfo getCardMfoAndUnical(String cardNumber);

    @Query ("select new uz.agro.cardInfo.payload.HumoCardInfo(h.branch, h.client_b, h.expiry1, b.tranz_acct) from Bf_empc_accounts b inner join Humo_cards h on b.account_no = h.account_no where h.real_card = ?1 ")
    List<HumoCardInfo> getHumoCardAndTranzAcct(String cardNumber);

    @Query("select new uz.agro.cardInfo.payload.abbosAkaPayload.HumoCard( a.tranz_acct, c.real_card, to_char(c.expiry1, 'yyyy-mm-dd')) from Humo_cards c, Bf_empc_accounts a, Client_p p where p.pinfl = ?1 and p.branch = ?2 and p.id = c.client_b and p.branch = c.branch and c.account_no = a.account_no and  substring(c.real_card, 1, 8) in ('98600301', '98600303', '98600308', '98600309', '40734200')")
    List<HumoCard>getHumoCardsByPinflAndBranch(String pinfl, String branch);

}
