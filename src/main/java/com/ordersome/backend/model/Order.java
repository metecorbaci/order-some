package com.ordersome.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity(name="`order`")
@Table(
        uniqueConstraints=
        @UniqueConstraint(name ="ui_user_id_food_id" ,columnNames={"user_id","food_id"})
)
public class Order {
    public static String TABLE_NAME = "`order`";

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id" , referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_o_user_id"))
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="food_id" , referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_o_food_id"))
    private Food food;
    @CreationTimestamp()
    private Date created_at;

    public Order() {
        super();
    }
    public Order(User user, Food food) {
        this.user = user;
        this.food = food;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
