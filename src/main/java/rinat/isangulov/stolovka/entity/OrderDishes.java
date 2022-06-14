package rinat.isangulov.stolovka.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_dishes")
public class OrderDishes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int count;
    private String cost;
    private boolean active;
    private Long dishId;
    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dish_id) {
        this.dishId = dish_id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long order_id) {
        this.orderId = order_id;
    }
}
