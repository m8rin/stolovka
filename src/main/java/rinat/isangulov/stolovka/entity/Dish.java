package rinat.isangulov.stolovka.entity;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private float price;
    private String category;
    //private int countInOrder;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "dishesOrderList")
    private Collection<Order> dishes;

    public Dish() {}

    public Dish(String code, String name, float price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Dish(String code, String name, float price, String category) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
/*
    public int getCountInOrder() {
        return countInOrder;
    }

    public void setCountInOrder(int countInOrder) {
        this.countInOrder = countInOrder;
    }*/

    @Override
    public String toString() {
        return code + "\t " + name + "\t " + price;
    }

}