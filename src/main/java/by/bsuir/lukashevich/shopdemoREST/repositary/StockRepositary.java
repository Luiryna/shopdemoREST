package by.bsuir.lukashevich.shopdemoREST.repositary;

import by.bsuir.lukashevich.shopdemoREST.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepositary extends JpaRepository<Stock, Long> {
}
