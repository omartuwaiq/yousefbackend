package com.example.FoodDelivery.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RestaurantsId;
    private String name;
    private String image;
//@OneToMany(mappedBy = "restaurants")
//@JsonIgnore
//private List<Menu>items = new ArrayList<>();
@ManyToMany
@JoinTable(name="restaurants_manu",
          joinColumns=@JoinColumn(name ="RestaurantsId"),
          inverseJoinColumns=@JoinColumn(name="menu_id"))
private List<Menu>menu;

    public Restaurants(int restaurantsId, String name, String image, List<Menu> menu) {
        RestaurantsId = restaurantsId;
        this.name = name;
        this.image = image;
        this.menu = menu;
    }

    public Restaurants() {


    }




    public int getRestaurantsId() {
        return RestaurantsId;
    }

    public void setRestaurantsId(int restaurantsId) {
        RestaurantsId = restaurantsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
