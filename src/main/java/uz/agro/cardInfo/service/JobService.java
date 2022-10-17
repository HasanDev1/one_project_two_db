package uz.agro.cardInfo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.agro.cardInfo.entity.Ui02025;
import uz.agro.cardInfo.repository.CardTempRepository;
import uz.agro.cardInfo.repository.Ui02025Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class JobService {
    private final CardTempRepository cardTempRepository;
    private final Ui02025Repository ui02025Repository;

    private final EntityManager entityManager;
    public HashSet<Ui02025> allNullCards() {
        HashSet<Ui02025> list = ui02025Repository.findAllByCardNumIsNull();
        HashSet<Ui02025> ui02025List = new HashSet<>();
        List<String> accounts = new ArrayList<>();
        List<String> cardNumers = new ArrayList<>();

        AtomicInteger i = new AtomicInteger();
        ui02025Repository.findAllByCardNumIsNull().forEach(ui02025 -> {

            System.out.println("Dastlabki holat: " + ui02025.getCardNum()+ "\taccount: "+ui02025.getAccount());
            ui02025Repository.update(cardTempRepository.findAllByAccount(ui02025.getAccount()).get(0).getCardnum(), ui02025.getAccount());
//            System.out.println("yangilangan holati: " + ui02025.getCardNum());
            System.out.println();
            ui02025List.add(ui02025);
//            ui02025Repository.save(ui02025);
        });
        System.out.println("size: "+list.size());
        return ui02025List;
    }



}
