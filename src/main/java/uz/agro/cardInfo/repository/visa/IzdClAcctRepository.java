package uz.agro.cardInfo.repository.visa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.agro.cardInfo.entity.visa.IzdCards;
import uz.agro.cardInfo.entity.visa.IzdClAcct;

@Repository
public interface IzdClAcctRepository extends JpaRepository<IzdClAcct, String> {
}
