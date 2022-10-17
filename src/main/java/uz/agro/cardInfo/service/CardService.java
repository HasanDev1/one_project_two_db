package uz.agro.cardInfo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.agro.cardInfo.entity.Account;
import uz.agro.cardInfo.entity.Card;
import uz.agro.cardInfo.entity.Client_p;
import uz.agro.cardInfo.repository.CardRepository;
import uz.agro.cardInfo.payload.abbosAkaPayload.CardInfo;
import uz.agro.cardInfo.payload.abbosAkaPayload.HumoCard;
import uz.agro.cardInfo.payload.abbosAkaPayload.Uzcard;
import uz.agro.cardInfo.payload.HumoCardInfo;
import uz.agro.cardInfo.payload.Passport;
import uz.agro.cardInfo.payload.Response;
import uz.agro.cardInfo.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {

    @Autowired
    private final CardRepository cardRepository;
    private final HumoRepository humoRepository;
    private final UnionPayRepository unionPayRepository;
    private final ClientPRepository clientPRepository;
    private final AccountRepository accountRepository;

    public ResponseEntity<?> getPinflByCardNumber(String cardNumber) {
        if (cardNumber.startsWith("8600")) {


            Card card = cardRepository.findByCard_number(cardNumber);

            log.info("uzkard karta: -{}", card);

            if (card != null) {
                Passport passport = new Passport();
                Account account = accountRepository.findByID(card.getDef_pos_account().substring(5,25));
                Client_p client_p = clientPRepository.findByBranchAndId(card.getBranch(), card.getDef_pos_account().substring(14, 22));

                if (client_p==null){
                    log.info("karta yuridek shaxsga tegishli ");
                    Response response = new Response();
                    response.setBranch(card.getBranch());
                    response.setUnical(card.getDef_pos_account().substring(14,22));
                    response.setExpiration_date(card.getExpiration_date());
                    response.setPinfl("bu plastik karta yuridek shaxsga tegishli. ");
                    response.setAccount(account);
                    log.info("Uzkard info: -{}", response);
                    return ResponseEntity.ok(response);
                }

                Response response = new Response();
                response.setBranch(card.getBranch());
                response.setUnical(card.getDef_pos_account().substring(14, 22));
                response.setExpiration_date(card.getExpiration_date());
                response.setPinfl(client_p.getPinfl());
                response.setAccount(account);

                passport.setNAME(client_p.getName());
                passport.setBIRTHDAY(client_p.getBirthday());
                passport.setPASSPORT_SERIAL(client_p.getPassport_serial());
                passport.setPASSPORT_NUMBER(client_p.getPassport_number());
                passport.setPASSPORT_TYPE(client_p.getPassport_type());
                passport.setPASSPORT_DATE_REGISTRATION(client_p.getPassport_date_registration());
                passport.setPASSPORT_DATE_EXPIRATION(client_p.getPassport_date_expiration());
                passport.setPASSPORT_PLACE_REGISTRATION(client_p.getPassport_place_registration());
                passport.setPOST_ADDRESS(client_p.getPost_address());
                passport.setBIRTH_PLACE(client_p.getBirth_place());

                response.setPassport(passport);
                log.info("Uzkard info: -{}", response);
                return ResponseEntity.ok(response);

            } else {
                return new ResponseEntity<>("bunday karta topilmadi, iltimos tekshirib qaytadan urinib ko`ring", HttpStatus.BAD_REQUEST);

            }
        } else if (cardNumber.startsWith("9860") || cardNumber.startsWith("4073")) {

            List<HumoCardInfo> humoCardInfo = humoRepository.getHumoCardAndTranzAcct(cardNumber);

            if (humoCardInfo != null) {
                System.out.println("humo card: "+humoCardInfo);
                Passport passport = new Passport();
                System.out.println("tranz_acct: "+ humoCardInfo.get(0).getTranz_acct());
                Account account = accountRepository.findByID(humoCardInfo.get(0).getTranz_acct());
                Client_p client_p = clientPRepository.findByBranchAndId(humoCardInfo.get(0).getBranch(), humoCardInfo.get(0).getUnical());

                if(client_p == null){
                    log.info("karta yuridek shaxsga tegishli ");
                    Response response = new Response();
                    response.setBranch(humoCardInfo.get(0).getBranch());
                    response.setUnical(humoCardInfo.get(0).getUnical());
                    response.setExpiration_date(humoCardInfo.get(0).getExpiration_date().toString());
                    response.setPinfl("bu plastik karta yuridek shaxsga tegishli. ");
                    response.setAccount(account);
                    log.info("humoCard info: -{}", response);
                    return ResponseEntity.ok(response);
                }

                Response response = new Response();
                response.setBranch(humoCardInfo.get(0).getBranch());
                response.setUnical(humoCardInfo.get(0).getUnical());
                response.setExpiration_date(humoCardInfo.get(0).getExpiration_date().toString());
                response.setPinfl(client_p.getPinfl());
                response.setAccount(account);

                passport.setNAME(client_p.getName());
                passport.setBIRTHDAY(client_p.getBirthday());
                passport.setPASSPORT_SERIAL(client_p.getPassport_serial());
                passport.setPASSPORT_NUMBER(client_p.getPassport_number());
                passport.setPASSPORT_TYPE(client_p.getPassport_type());
                passport.setPASSPORT_DATE_REGISTRATION(client_p.getPassport_date_registration());

                passport.setPASSPORT_DATE_EXPIRATION(client_p.getPassport_date_expiration());
                passport.setPASSPORT_PLACE_REGISTRATION(client_p.getPassport_place_registration());
                passport.setPOST_ADDRESS(client_p.getPost_address());
                passport.setBIRTH_PLACE(client_p.getBirth_place());

                response.setPassport(passport);
                log.info("humo card info: -{}", response);
                return ResponseEntity.ok(response);

            } else {
                return new ResponseEntity<>("bunday karta topilmadi, iltimos tekshirib qaytadan urinib ko`ring", HttpStatus.BAD_REQUEST);
            }
        } else if (cardNumber.startsWith("6262") || cardNumber.startsWith("5440")) {

            Card unionCard = unionPayRepository.getByCardNumber(cardNumber);
            System.out.println(unionCard);
            log.info("Union karta : {}", unionCard);
            if (unionCard != null) {
                Passport passport = new Passport();
                Account account = accountRepository.findByID(unionCard.getDef_pos_account().substring(5,25));
                Client_p client_p = clientPRepository.findByBranchAndId(unionCard.getBranch(), unionCard.getDef_pos_account().substring(14, 22));

                if (client_p == null){
                    log.info("karta yuridek shaxsga tegishli ");
                    Response response = new Response();
                    response.setBranch(unionCard.getBranch());
                    response.setUnical(unionCard.getDef_pos_account().substring(14,22));
                    response.setExpiration_date(unionCard.getExpiration_date());
                    response.setPinfl("bu plastik karta yuridek shaxsga tegishli. ");
                    response.setAccount(account);
                    log.info("unionCard info: -{}", response);
                    return ResponseEntity.ok(response);
                }

                Response response = new Response();
                response.setBranch(unionCard.getBranch());
                response.setUnical(unionCard.getDef_pos_account().substring(14, 22));
                response.setExpiration_date(unionCard.getExpiration_date());
                response.setPinfl(client_p.getPinfl());
                response.setAccount(account);

                passport.setNAME(client_p.getName());
                passport.setBIRTHDAY(client_p.getBirthday());
                passport.setPASSPORT_SERIAL(client_p.getPassport_serial());
                passport.setPASSPORT_NUMBER(client_p.getPassport_number());
                passport.setPASSPORT_TYPE(client_p.getPassport_type());
                passport.setPASSPORT_DATE_REGISTRATION(client_p.getPassport_date_registration());
                passport.setPASSPORT_DATE_EXPIRATION(client_p.getPassport_date_expiration());
                passport.setPASSPORT_PLACE_REGISTRATION(client_p.getPassport_place_registration());
                passport.setPOST_ADDRESS(client_p.getPost_address());
                passport.setBIRTH_PLACE(client_p.getBirth_place());

                response.setPassport(passport);
                log.info("unionCard info: -{}", response);
                return ResponseEntity.ok(response);

            } else {
                return new ResponseEntity<>("bunday karta topilmadi, iltimos tekshirib qaytadan urinib ko`ring", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Bunday turdagi karta dasturga kiritilmagan", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getCardsByPinfAndBranch(String pinfl, String branch){
        List<Uzcard> uzcardList = cardRepository.findAllUzcardByPinflAndBranch(pinfl,branch);
        List<Card> cardList = cardRepository.findAllUnionUzcardByPinflAndBranch(pinfl, branch);
        List<Uzcard>  uzcards = new ArrayList<>();
        cardList.forEach(card -> {
            Uzcard uzcard = new Uzcard();
            uzcard.setCardAccountUzCard(card.getDef_pos_account().substring(5));
            uzcard.setCardNumberUzCard(card.getCard_number());
            uzcard.setExpiry(card.getExpiration_date());
            uzcards.add(uzcard);
        });
        uzcardList.addAll(uzcards);

        List<HumoCard>humoCardsNew = new ArrayList<>();
        List<Uzcard>uzcardListNew = new ArrayList<>();


        List<HumoCard> humoCardList = humoRepository.getHumoCardsByPinflAndBranch(pinfl, branch);
        humoCardList.forEach(humoCard -> {
            HumoCard card = new HumoCard();
            card.setCardAccountHumo(humoCard.getCardAccountHumo());
            card.setCardNumberHumo(humoCard.getCardNumberHumo().replaceAll(humoCard.getCardNumberHumo().substring(8,12), "****"));
            card.setExpiry(humoCard.getExpiry());
            humoCardsNew.add(card);
        });

        uzcardList.forEach(uzcard -> {
            Uzcard card = new Uzcard();
            card.setCardAccountUzCard(uzcard.getCardAccountUzCard());
            card.setCardNumberUzCard(uzcard.getCardNumberUzCard().replaceAll(uzcard.getCardNumberUzCard().substring(8,12), "****"));
            card.setExpiry(uzcard.getExpiry());
            uzcardListNew.add(card);
        });


        CardInfo cardInfo = new CardInfo();
        cardInfo.setFio(clientPRepository.getNameByPinflAndBranch(pinfl, branch));
        cardInfo.setPinfl(pinfl);
        cardInfo.setHumoCards(humoCardsNew);
        cardInfo.setUzCards(uzcardListNew);
        return ResponseEntity.ok(cardInfo);
    }
}
