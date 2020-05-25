package by.bsuir.lukashevich.shopdemoREST.rest;

import by.bsuir.lukashevich.shopdemoREST.model.Shop;
import by.bsuir.lukashevich.shopdemoREST.service.ShopService;
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
@RequestMapping("/api/shop/")
public class ShopRESTController {

    private ShopService shopService;

    @Autowired
    public ShopRESTController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop) {
        HttpHeaders headers = new HttpHeaders();

        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.shopService.saveShop(shop);
        return new ResponseEntity<>(shop, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Shop> updateShop(@RequestBody Shop shop, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.shopService.saveShop(shop);

        return new ResponseEntity<>(shop, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Shop> deleteShop(@PathVariable("id") Long id) {
        Shop shop = this.shopService.findById(id);

        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.shopService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Shop>> getAllShop() {
        List<Shop> shops = this.shopService.findAll();

        if (shops.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(shops, HttpStatus.OK);
    }
}
