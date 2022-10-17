package uz.agro.cardInfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.agro.cardInfo.payload.CardRequest;
import uz.agro.cardInfo.service.CardService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CardController {

    private final CardService cardService;

    @PostMapping("/getCardInfo")
    public ResponseEntity<?>getCardInfoByCardNumber(@RequestBody CardRequest cardRequest){
        return cardService.getPinflByCardNumber(cardRequest.getCardNumber());
    }

    @GetMapping("/getCardInfo/{cardNumber}")
    public ResponseEntity<?>getCardInfoByCardNumberWithParam(@PathVariable String cardNumber){
        return cardService.getPinflByCardNumber(cardNumber);
    }

    @GetMapping("/get-all-cards")
    public ResponseEntity<?> getAllCardsByPinfAndBranch(@RequestParam(name = "pinfl") String pinfl, @RequestParam(name = "branch") String branch){
        return ResponseEntity.ok(cardService.getCardsByPinfAndBranch(pinfl, branch).getBody());
    }
}
