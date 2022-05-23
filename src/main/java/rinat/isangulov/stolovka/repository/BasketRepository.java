package rinat.isangulov.stolovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rinat.isangulov.stolovka.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket findBasketById(Long id);
}
