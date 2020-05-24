package by.bsuir.lukashevich.shopdemoREST.service;

import by.bsuir.lukashevich.shopdemoREST.model.Shop;
import by.bsuir.lukashevich.shopdemoREST.repositary.ShopRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepositary shopRepositary;

    @Autowired
    public ShopService(ShopRepositary shopRepositary) {
        this.shopRepositary = shopRepositary;
    }

    public Shop findById(Long id) {
        return shopRepositary.getOne(id);
    }

    public List<Shop> findAll() {
        return shopRepositary.findAll();
    }

    public Shop saveShop(Shop shop) {
        return shopRepositary.save(shop);
    }

    public void deleteById(Long id) {
        shopRepositary.deleteById(id);
    }
}
