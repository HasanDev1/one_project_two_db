package uz.agro.cardInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.agro.cardInfo.entity.Ui02025;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface Ui02025Repository extends JpaRepository<Ui02025, String> {
//    List<Ui02025> findAllByCardNumIsNull();

    @Query(nativeQuery = true, value = "select * from ui_02_025 d where d.card_num is null ")
    HashSet<Ui02025>findAllByCardNumIsNull();

    @Modifying
    @Query("update Ui02025 u set u.cardNum = ?1 where u.account = ?2 ")
    void update(String cardNum, String account);


    Ui02025 findByAccount(String account);

}
