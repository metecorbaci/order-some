package com.ordersome.backend.model;
import jakarta.persistence.*;

import java.util.List;

@Entity(name="food")
@Table(
        uniqueConstraints=
        @UniqueConstraint(name ="ui_name" ,columnNames={"name"})
)
public class Food {
    static public String TABLE = "food";

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @OneToMany(mappedBy = "food")
    private List<Order> orders;

    public Food() {
        super();
    }

    public Food(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
