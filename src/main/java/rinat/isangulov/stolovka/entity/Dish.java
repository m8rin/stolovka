package rinat.isangulov.stolovka.entity;

import javax.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String price;
    private String category;
    private int count;

    public Dish() {
    }

    public Dish(String code, String name, String price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Dish(String code, String name, String price, String category) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return code + "\t " + name + "\t " + price;
    }

}
