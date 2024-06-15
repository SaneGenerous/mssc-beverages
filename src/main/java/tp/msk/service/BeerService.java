package tp.msk.service;

import org.springframework.stereotype.Service;
import tp.msk.web.model.BeerDTO;

import java.util.UUID;


public interface BeerService {
    BeerDTO getBeerById(UUID beerId);
    BeerDTO saveNewBeer(BeerDTO beerDTO);
    void updateBeer(UUID beerId, BeerDTO beerDTO);
    void deleteBeerById(UUID beerId);
}
