package by.bsuir.lukashevich.shopdemoREST.rest;

import by.bsuir.lukashevich.shopdemoREST.model.Price;
import by.bsuir.lukashevich.shopdemoREST.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200" })
@RestController
@RequestMapping("/api/price/")
public class PriceRESTController {

    private PriceService priceService;

    @Autowired
    public PriceRESTController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Price> savePrice(@RequestBody Price price) {
        HttpHeaders headers = new HttpHeaders();

        if (price == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.priceService.savePrice(price);
        return new ResponseEntity<>(price, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Price> updatePrice(@RequestBody Price price, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (price == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.priceService.savePrice(price);

        return new ResponseEntity<>(price, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Price> deletePrice(@PathVariable("id") Long id) {
        Price price = this.priceService.findById(id);

        if (price == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.priceService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Price>> getAllPrice() {
        List<Price> prices = this.priceService.findAll();

        if (prices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
