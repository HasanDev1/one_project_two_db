package uz.agro.cardInfo.repository.visa;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.agro.cardInfo.entity.CardTemp;
import uz.agro.cardInfo.entity.visa.IzdCards;
import uz.agro.cardInfo.payload.visa.NewVisaResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public interface IzdCardsRepository extends JpaRepository<IzdCards, String> {

    @Query("select new uz.agro.cardInfo.payload.visa.NewVisaResponse(br.MFO, acci.TRANZ_ACCT, cr.CARD, cr.STATUS1) from IzdClients cl inner join IzdAgreement agr on cl.client = agr.CLIENT and cl.bank_c = agr.BANK_C inner join IzdCards cr on agr.AGRE_NOM = cr.AGREEMENT_KEY and agr.BANK_C = cr.BANK_C inner join IzdClAcct cla on cr.CL_ACCT_KEY = cla.TAB_KEY and cr.BANK_C = cla.bank_c inner join IzdClAcct acc on cla.ACCOUNT_NO = acc.ACCOUNT_NO and cla.bank_c = acc.bank_c inner join IzdBranches br on cla.bank_c = br.BANK_C and cla.B_BR_ID = br.B_BR_ID inner join IzdAccInfo acci on acc.ACCOUNT_NO = acci.ACCOUNT_NO and acc.bank_c = acci.BANK_C and acci.TRANZ_ACCT is not null and cr.STATUS1 = '0' and cr.CTIME>TO_CHAR(sysdate-5) AND cr.CTIME<=TO_CHAR(sysdate)")
    List<NewVisaResponse> getAllNewVisaCards();

}
