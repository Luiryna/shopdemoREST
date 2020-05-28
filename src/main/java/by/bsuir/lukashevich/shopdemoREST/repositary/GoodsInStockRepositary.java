package by.bsuir.lukashevich.shopdemoREST.repositary;

import by.bsuir.lukashevich.shopdemoREST.model.GoodsInStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsInStockRepositary extends JpaRepository<GoodsInStock, Long> {
}
