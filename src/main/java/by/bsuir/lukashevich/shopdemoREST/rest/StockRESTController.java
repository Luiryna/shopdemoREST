package by.bsuir.lukashevich.shopdemoREST.rest;

import by.bsuir.lukashevich.shopdemoREST.model.Stock;
import by.bsuir.lukashevich.shopdemoREST.service.StockService;
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
@RequestMapping("/api/stock/")
public class StockRESTController {

    private StockService stockService;

    @Autowired
    public StockRESTController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Stock> saveShop(@RequestBody Stock stock) {
        HttpHeaders headers = new HttpHeaders();

        if (stock == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.stockService.saveShop(stock);
        return new ResponseEntity<>(stock, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Stock> updateShop(@RequestBody Stock stock, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (stock == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.stockService.saveShop(stock);

        return new ResponseEntity<>(stock, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Stock> deleteShop(@PathVariable("id") Long id) {
        Stock stock = this.stockService.findById(id);

        if (stock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.stockService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Stock>> getAllShop() {
        List<Stock> stocks = this.stockService.findAll();

        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}
