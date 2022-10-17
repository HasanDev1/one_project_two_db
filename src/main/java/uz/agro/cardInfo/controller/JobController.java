package uz.agro.cardInfo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.agro.cardInfo.entity.Ui02025;
import uz.agro.cardInfo.service.JobService;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PutMapping("/job/get")
    public HashSet<Ui02025> getAllNullCardnums(){
        return jobService.allNullCards();
    }
}
