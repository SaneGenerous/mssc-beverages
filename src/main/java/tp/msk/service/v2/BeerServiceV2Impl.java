package tp.msk.service.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tp.msk.web.model.BeerDTO;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Ice")
                .beerStyle("Lemonade")
                .build();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Glass")
                .beerStyle("Pommes")
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        //todo - impl beer update
        log.debug("Update....");
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting a beer.....");
    }
}
