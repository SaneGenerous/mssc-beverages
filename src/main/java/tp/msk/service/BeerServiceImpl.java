package tp.msk.service;

import org.springframework.stereotype.Service;
import tp.msk.web.model.BeerDTO;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Ice")
                .beerStyle("Lemonade")
                .build();
    }
}
