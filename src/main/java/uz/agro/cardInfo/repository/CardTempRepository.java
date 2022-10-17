package uz.agro.cardInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.agro.cardInfo.entity.CardTemp;

import java.util.List;

@Repository
public interface CardTempRepository extends JpaRepository<CardTemp, String> {

    List<CardTemp> findAllByAccount(String account);

    @Query("select case when count(c) > 0 then true else false end from CardTemp c where c.branch = ?1 and c.account = ?2")
    boolean existsByAccountFromIzdCards(String branch, String account);
}
