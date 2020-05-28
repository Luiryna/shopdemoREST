package by.bsuir.lukashevich.shopdemoREST.service;

import by.bsuir.lukashevich.shopdemoREST.model.GoodsInStock;
import by.bsuir.lukashevich.shopdemoREST.repositary.GoodsInStockRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInStockService {
    private final GoodsInStockRepositary goodsInStockRepositary;

    @Autowired
    public GoodsInStockService(GoodsInStockRepositary goodsInStockRepositary) {
        this.goodsInStockRepositary = goodsInStockRepositary;
    }

    public GoodsInStock findById(Long id) {
        return goodsInStockRepositary.getOne(id);
    }

    public List<GoodsInStock> findAll() {
        return goodsInStockRepositary.findAll();
    }

    public GoodsInStock savePrice(GoodsInStock goodsInStock) {
        return goodsInStockRepositary.save(goodsInStock);
    }

    public void deleteById(Long id) {
        goodsInStockRepositary.deleteById(id);
    }
}
