package by.bsuir.lukashevich.shopdemoREST.repositary;

import by.bsuir.lukashevich.shopdemoREST.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepositary extends JpaRepository<Price, Long> {
}
