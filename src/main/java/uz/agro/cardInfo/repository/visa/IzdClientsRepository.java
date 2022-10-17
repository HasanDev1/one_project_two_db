package uz.agro.cardInfo.repository.visa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.agro.cardInfo.entity.visa.IzdClients;

@Repository
public interface IzdClientsRepository extends JpaRepository<IzdClients, String> {
}
