package com.example.FoodDelivery.controller;

import com.example.FoodDelivery.model.entities.Menu;
import com.example.FoodDelivery.model.services.MenuServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "https://yousefstation.herokuapp.com")
@RestController
@RequestMapping(path = "api/menu")
public class MenuController {
    private MenuServise menuServise;
    @Autowired
    public MenuController(MenuServise menuServise){
        this.menuServise =menuServise;
    }
    @GetMapping
    public List<Menu> getMenu(){
        return menuServise.getMenu();
    }
    @GetMapping(path = "{Menu_id}")
    public Optional<Menu>getMenu(@PathVariable(name ="menu_id")Integer menu_id){
      return menuServise.getMenu(menu_id);
    }
    @PostMapping("add")
    public void registerNewMenu(@RequestBody Menu menu){
        menuServise.addNewMenu(menu);
    }
    ////
    @DeleteMapping(path = "delete/{Menu_id}")
    public void deleteMENU(@PathVariable("Menu_id")Integer menu_id){
        menuServise.deleteMenu(menu_id);
    }
}
