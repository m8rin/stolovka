package rinat.isangulov.stolovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rinat.isangulov.stolovka.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findDishByCode(String code);

    Dish findDishById(Long id);
}
