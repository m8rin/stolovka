package rinat.isangulov.stolovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rinat.isangulov.stolovka.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByCode(String code);
}