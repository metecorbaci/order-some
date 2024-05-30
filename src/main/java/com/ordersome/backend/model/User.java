package com.ordersome.backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="`user`")
@Table(
        uniqueConstraints=
        @UniqueConstraint(name ="ui_email" ,columnNames={"email"})
)
public class User {
    static public String TABLE = "user";
    static public String ORDERS = "orders";
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String last_name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {
        super();
    }
    public User(String email,String first_name,String last_name,String password){
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
