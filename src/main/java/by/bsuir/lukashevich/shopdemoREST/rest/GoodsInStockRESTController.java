package by.bsuir.lukashevich.shopdemoREST.rest;


import by.bsuir.lukashevich.shopdemoREST.model.GoodsInStock;
import by.bsuir.lukashevich.shopdemoREST.service.GoodsInStockService;
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
@RequestMapping("/api/goods_in_stock/")
public class GoodsInStockRESTController {

    private GoodsInStockService goodsInStockService;

    @Autowired
    public GoodsInStockRESTController(GoodsInStockService goodsInStockService) {
        this.goodsInStockService = goodsInStockService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GoodsInStock> savePrice(@RequestBody GoodsInStock goodsInStock) {
        HttpHeaders headers = new HttpHeaders();

        if (goodsInStock == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.goodsInStockService.savePrice(goodsInStock);
        return new ResponseEntity<>(goodsInStock, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GoodsInStock> updatePrice(@RequestBody GoodsInStock goodsInStock, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (goodsInStock == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.goodsInStockService.savePrice(goodsInStock);

        return new ResponseEntity<>(goodsInStock, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GoodsInStock> deletePrice(@PathVariable("id") Long id) {
        GoodsInStock goodsInStock = this.goodsInStockService.findById(id);

        if (goodsInStock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.goodsInStockService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<GoodsInStock>> getAllPrice() {
        List<GoodsInStock> prices = this.goodsInStockService.findAll();

        if (prices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(prices, HttpStatus.OK);
    }
}
