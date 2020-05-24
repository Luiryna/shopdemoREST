package by.bsuir.lukashevich.shopdemoREST.rest;

import by.bsuir.lukashevich.shopdemoREST.model.Good;
import by.bsuir.lukashevich.shopdemoREST.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/good/")
public class GoodRESTController {

    private GoodService goodService;

    @Autowired
    public GoodRESTController(GoodService goodService){
        this.goodService = goodService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Good> saveGood(@RequestBody Good good) {
        HttpHeaders headers = new HttpHeaders();

        if (good == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.goodService.saveGood(good);
        return new ResponseEntity<>(good, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Good> updateGood(@RequestBody Good good, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (good == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.goodService.saveGood(good);

        return new ResponseEntity<>(good, headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Good> deleteGood(@PathVariable("id") Long id) {
        Good good = this.goodService.findById(id);

        if (good == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.goodService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Good>> getAllGood() {
        List<Good> goods = this.goodService.findAll();

        if (goods.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(goods, HttpStatus.OK);
    }
}
