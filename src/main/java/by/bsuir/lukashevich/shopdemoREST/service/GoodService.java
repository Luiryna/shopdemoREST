package by.bsuir.lukashevich.shopdemoREST.service;

import by.bsuir.lukashevich.shopdemoREST.model.Good;
import by.bsuir.lukashevich.shopdemoREST.repositary.GoodRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {
    private final GoodRepositary goodRepositary;

    @Autowired
    public GoodService(GoodRepositary goodRepositary) {
        this.goodRepositary = goodRepositary;
    }

    public Good findById(Long id) {
        return goodRepositary.getOne(id);
    }

    public List<Good> findAll() {
        return goodRepositary.findAll();
    }

    public Good saveGood(Good good) {
        return goodRepositary.save(good);
    }

    public void deleteById(Long id) {
        goodRepositary.deleteById(id);
    }
}
