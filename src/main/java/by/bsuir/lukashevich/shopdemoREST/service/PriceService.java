package by.bsuir.lukashevich.shopdemoREST.service;

import by.bsuir.lukashevich.shopdemoREST.model.Price;
import by.bsuir.lukashevich.shopdemoREST.repositary.PriceRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final PriceRepositary priceRepositary;

    @Autowired
    public PriceService(PriceRepositary priceRepositary) {
        this.priceRepositary = priceRepositary;
    }

    public Price findById(Long id) {
        return priceRepositary.getOne(id);
    }

    public List<Price> findAll() {
        return priceRepositary.findAll();
    }

    public Price savePrice(Price price) {
        return priceRepositary.save(price);
    }

    public void deleteById(Long id) {
        priceRepositary.deleteById(id);
    }
}
