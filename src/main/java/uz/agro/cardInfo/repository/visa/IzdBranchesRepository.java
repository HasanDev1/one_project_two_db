package uz.agro.cardInfo.repository.visa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.agro.cardInfo.entity.visa.IzdBranches;

@Repository
public interface IzdBranchesRepository extends JpaRepository<IzdBranches, String> {
}
