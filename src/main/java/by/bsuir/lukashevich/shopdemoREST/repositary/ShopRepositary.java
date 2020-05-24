package by.bsuir.lukashevich.shopdemoREST.repositary;

import by.bsuir.lukashevich.shopdemoREST.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepositary extends JpaRepository<Shop, Long> {
}
