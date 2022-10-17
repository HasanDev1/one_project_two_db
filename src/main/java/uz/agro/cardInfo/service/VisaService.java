package uz.agro.cardInfo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.agro.cardInfo.entity.CardTemp;
import uz.agro.cardInfo.payload.visa.NewVisaResponse;
import uz.agro.cardInfo.repository.CardRepository;
import uz.agro.cardInfo.repository.CardTempRepository;
import uz.agro.cardInfo.repository.visa.IzdCardsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VisaService {

    private final IzdCardsRepository izdCardsRepository;
    private final CardTempRepository cardTempRepository;

    public ResponseEntity<?> getNewVisaCards(){
        List<NewVisaResponse> responseList = izdCardsRepository.getAllNewVisaCards();
        log.info("tekshirish natejasida kelib chiqqan visa kartalar soni: {}", responseList.size());
        log.info("yangi qo`shilishi mumkin bo`lgan visa kartalar: {}", responseList);
        List<CardTemp> cardTempList = new ArrayList<>();

        for (int i = 0; i < responseList.size(); i++) {
            if (!cardTempRepository.existsByAccountFromIzdCards(responseList.get(i).getMfo(), responseList.get(i).getTranz_acct())){
                CardTemp cardTemp = new CardTemp();
                cardTemp.setBranch(responseList.get(i).getMfo());
                cardTemp.setAccount(responseList.get(i).getTranz_acct());
                cardTemp.setCardnum(responseList.get(i).getCard());
                cardTempList.add(cardTemp);
                cardTemp = null;
            }
        }
        log.info("yangi qo`shilgan kartalar soni: {}",+cardTempList.size());
        log.info("\n");
        cardTempRepository.saveAll(cardTempList);
        return ResponseEntity.ok(cardTempList);
    }

}
