package com.example.FoodDelivery.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ORDER_id;
     private String type;
     private String time;
     private  String location;
//menu
    //call user table
    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName="id")
    private User user;
    //call driver table
    @ManyToOne
    @JoinColumn(name ="driver",referencedColumnName = "drive_id")
    private Driver driver;
    //call menu table
    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<Menu>itms =new ArrayList<>();


    public Orders(int ORDER_id, String type, String time, String location, User user) {
        this.ORDER_id = ORDER_id;
        this.type = type;
        this.time = time;
        this.location = location;
        this.user = user;
    }

    public Orders() {
    }


    public int getORDER_id() {
        return ORDER_id;
    }

    public void setORDER_id(int ORDER_id) {
        this.ORDER_id = ORDER_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
