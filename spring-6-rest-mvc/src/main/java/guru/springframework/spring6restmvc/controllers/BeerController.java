package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.models.Beer;
import guru.springframework.spring6restmvc.services.BeerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    @Autowired
    private final BeerService beerService;

    @PatchMapping("/{beerId}")
    public ResponseEntity updateBeerPatch(@PathVariable UUID beerId, @RequestBody Beer beer) {
        log.debug("updateBeer:: Update Beer API hit");

        beerService.updateBeerPatch(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeer(@PathVariable UUID beerId) {
        log.debug("deleteBeer:: Delete Beer API hit");

        beerService.deleteBeer(beerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody Beer beer) {
        log.debug("updateBeer:: Update Beer API hit");

        beerService.updateBeer(beerId, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity createBeer(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> retrieveBeers() {
        return beerService.getBeers();
    }

    @RequestMapping(value = "{beerId}", method = RequestMethod.GET)
    public Beer retrieveBeer(@PathVariable UUID beerId) {
        log.debug("Get beer by id - in controller");
        return beerService.getBeerById(beerId);
    }
}
