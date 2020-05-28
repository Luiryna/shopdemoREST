package by.bsuir.lukashevich.shopdemoREST.service;

import by.bsuir.lukashevich.shopdemoREST.model.Stock;
import by.bsuir.lukashevich.shopdemoREST.repositary.StockRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    private final StockRepositary stockRepositary;

    @Autowired
    public StockService(StockRepositary stockRepositary) {
        this.stockRepositary = stockRepositary;
    }

    public Stock findById(Long id) {
        return stockRepositary.getOne(id);
    }

    public List<Stock> findAll() {
        return stockRepositary.findAll();
    }

    public Stock saveShop(Stock stock) {
        return stockRepositary.save(stock);
    }

    public void deleteById(Long id) {
        stockRepositary.deleteById(id);
    }
}
