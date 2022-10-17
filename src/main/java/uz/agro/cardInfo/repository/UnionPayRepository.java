package uz.agro.cardInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.agro.cardInfo.entity.Card;
import uz.agro.cardInfo.payload.CardInfo;

public interface UnionPayRepository extends JpaRepository<Card, String> {
    @Query (value = "select * from upi.card d where d.card_number = ?1", nativeQuery = true)
    Card getByCardNumber(String cardNumber);
}
