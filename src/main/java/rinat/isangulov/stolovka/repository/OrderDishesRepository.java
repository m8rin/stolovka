package rinat.isangulov.stolovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rinat.isangulov.stolovka.entity.OrderDishes;

import java.util.ArrayList;
import java.util.List;

public interface OrderDishesRepository extends JpaRepository<OrderDishes, Long> {

    OrderDishes findOrderDishesById(Long id);

    List<OrderDishes> findAllByOrderId(Long orderId);
}
