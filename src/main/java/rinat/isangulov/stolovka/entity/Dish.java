package rinat.isangulov.stolovka.entity;

import javax.persistence.*;
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
    private String img;
    private String imgURL;
    private int count;

    @ManyToMany(mappedBy = "order_dishes")
    private List<Order> orders;

    public Dish() {
    }

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    @Override
    public String toString() {
        return code + "\t " + name + "\t " + price;
    }

}
