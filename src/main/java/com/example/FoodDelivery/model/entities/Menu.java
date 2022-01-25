package com.example.FoodDelivery.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int menu_id;
    private  String name;
    private String size;
    private String picture;
    //call user table
//@ManyToOne
//@JoinColumn(name = "restaurants", referencedColumnName = "RestaurantsId")
//private Restaurants restaurants;
    @ManyToMany(mappedBy = "menu")
    @JsonIgnore
    private List<Restaurants>restaurants = new ArrayList<>();
//call orders table
@ManyToOne
@JoinColumn(name ="orders",referencedColumnName = "ORDER_id")
private Orders orders;

    public Menu(int menu_id, String name, String size, String picture , Orders orders) {
        this.menu_id = menu_id;
        this.name = name;
        this.size = size;
        this.picture = picture;
        this.orders = orders;
    }

    public Menu() {
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
