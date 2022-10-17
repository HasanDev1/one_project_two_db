package uz.agro.cardInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.agro.cardInfo.entity.Client_p;
import uz.agro.cardInfo.payload.Response;

public interface ClientPRepository extends JpaRepository<Client_p, String> {

    @Query("select new uz.agro.cardInfo.payload.Response(d.branch, d.id, d.pinfl) from Client_p d where d.branch = ?2 and d.id = ?1")
    Response getPinflByUnicalAndBranch(String id, String branch);
    Client_p findByBranchAndId(String branch, String unical);

    @Query("select c.name from Client_p c where c.pinfl = ?1 and c.branch = ?2")
    String getNameByPinflAndBranch(String pinfl, String branch);

}
