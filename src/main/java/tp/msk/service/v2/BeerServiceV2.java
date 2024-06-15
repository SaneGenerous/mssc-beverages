package tp.msk.service.v2;

import tp.msk.web.model.BeerDTO;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDTO getBeerById(UUID beerId);
    BeerDTO saveNewBeer(BeerDTO beerDTO);
    void updateBeer(UUID beerId, BeerDTO beerDTO);
    void deleteBeerById(UUID beerId);
}
