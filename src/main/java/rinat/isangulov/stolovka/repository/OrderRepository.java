package rinat.isangulov.stolovka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rinat.isangulov.stolovka.entity.Order;
import rinat.isangulov.stolovka.entity.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByCode(String code);

    Order findOrderByUserId(Long id);

    List<Order> findAllByUser(User user);

    List<Order> findAllByUserAndStatusNotContaining(User user, String status);

    List<Order> findAllByStatusNotContaining(String status);

    Order findOrderById(Long id);
}
