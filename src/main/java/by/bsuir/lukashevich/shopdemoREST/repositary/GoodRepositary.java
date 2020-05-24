package by.bsuir.lukashevich.shopdemoREST.repositary;

import by.bsuir.lukashevich.shopdemoREST.model.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepositary extends JpaRepository<Good, Long> {
}
