package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.models.Beer;
import guru.springframework.spring6restmvc.models.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("11111")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("22222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .name("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("33333")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(76)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> getBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {
        log.debug("Get beer by id - in service. Id: " + id.toString());
        return beerMap.get(id);
    }

    @Override
    public Beer saveBeer(Beer beer) {
        log.debug("saveBeer:: create new beer - in service, beer = [{}]", beer);

        LocalDateTime now = LocalDateTime.now();

        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .createdDate(now)
                .updateDate(now)
                .name(beer.getName())
                .version(beer.getVersion())
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }

    @Override
    public void updateBeer(UUID beerId, Beer beer) {
        log.debug("updateBeer:: update beer - in service, beerId = [{}], beer = [{}]", beerId, beer);

        Beer existingBeer = beerMap.get(beerId);
        existingBeer.setUpdateDate(LocalDateTime.now());
        existingBeer.setName(beer.getName());
        existingBeer.setBeerStyle(beer.getBeerStyle());
        existingBeer.setPrice(beer.getPrice());
        existingBeer.setUpc(beer.getUpc());
        existingBeer.setVersion(beer.getVersion());
        existingBeer.setQuantityOnHand(beer.getQuantityOnHand());

        beerMap.put(existingBeer.getId(), existingBeer);
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("deleteBeer:: delete beer - in service, beerId = [{}]", beerId);

        beerMap.remove(beerId);
    }

    @Override
    public void updateBeerPatch(UUID beerId, Beer beer) {
        Beer existingBeer = beerMap.get(beerId);

        if (StringUtils.hasText(beer.getName())) {
            existingBeer.setName(beer.getName());
        }

        if (Objects.nonNull(beer.getBeerStyle())) {
            existingBeer.setBeerStyle(beer.getBeerStyle());
        }

        if (Objects.nonNull(beer.getPrice())) {
            existingBeer.setPrice(beer.getPrice());
        }

        if (Objects.nonNull(beer.getQuantityOnHand())) {
            existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existingBeer.setUpc(beer.getUpc());
        }

    }
}
