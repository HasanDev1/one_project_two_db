package uz.agro.cardInfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agro.cardInfo.service.VisaService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VisaController {

    private final VisaService visaService;

    @Scheduled(cron = "0 0 7 * * *")  // har kuni soat 7 da amal bajaradi
    @GetMapping("/visa/new/get")
    public ResponseEntity<?> getAllNewVisaCards(){
        return visaService.getNewVisaCards();
    }

//    @GetMapping("/schedule")
//    @Scheduled(cron = "*/60 * * * * *")  /// har 10 secunda amal bajaradi
//    public void checkSchedule(){
//        System.out.println(System.currentTimeMillis());
//    }

}
