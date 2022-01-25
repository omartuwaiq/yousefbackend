package com.example.FoodDelivery.model.services;

import com.example.FoodDelivery.model.entities.Menu;
import com.example.FoodDelivery.model.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServise {
    private MenuRepository menuRepository;
    @Autowired
    public void MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }
    public List<Menu>getMenu(){
        return menuRepository.findAll();
    }
    public Optional<Menu> getMenu(Integer menu_id){
        return menuRepository.findById( menu_id);

    }
    public  void addNewMenu(Menu menu ){
        menuRepository.save(menu);
    }
    public void deleteMenu( Integer menu_id){
        menuRepository.deleteById(menu_id);
    }
}
