package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<Beer> getBeers();

    Beer getBeerById(UUID id);

    Beer saveBeer(Beer beer);

    void updateBeer(UUID beerId, Beer beer);

    void deleteBeer(UUID beerId);

    void updateBeerPatch(UUID beerId, Beer beer);
}
