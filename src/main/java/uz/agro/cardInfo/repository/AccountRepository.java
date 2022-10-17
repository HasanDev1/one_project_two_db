package uz.agro.cardInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.agro.cardInfo.entity.Account;
import uz.agro.cardInfo.entity.Card;
import uz.agro.cardInfo.payload.CardInfo;

import java.util.HashSet;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

//    HashSet<Account> findByBRANCHAndCLIENT(String branch, String unical);

//    @Query("select new uz.agro.cardInfo.payload.CardInfo(c.branch, c.def_pos_account, c.expiration_date) from Card c where c.card_number = ?1")
//    CardInfo getCardMfoAndUnical(String cardNumber);
    Account findByID(String id);


}
