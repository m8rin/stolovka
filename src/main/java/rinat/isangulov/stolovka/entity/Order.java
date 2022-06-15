package rinat.isangulov.stolovka.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private float cost;
    private boolean active;
    private String status;
    private String date;

   /* @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "order_status", joinColumns = @JoinColumn(name = "order_id"))
    @Enumerated(EnumType.STRING)
    private Set<Status> statuses;*/

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_dishes",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "dishId")
    )
    private List<Dish> order_dishes = new ArrayList<>();

    public Order(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Dish> getOrder_dishes() {
        return order_dishes;
    }

    public void setOrder_dishes(List<Dish> order_dishes) {
        this.order_dishes = order_dishes;
    }

    public void addDish(Dish dish) {
        this.order_dishes.add(dish);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
