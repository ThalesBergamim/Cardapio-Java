package com.example.cardapio.controller;


import com.example.cardapio.Food.Food;
import com.example.cardapio.Food.FoodReponseDTO;
import com.example.cardapio.Food.FoodRepository;
import com.example.cardapio.Food.FoodRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodReponseDTO> getAll(){
        List<FoodReponseDTO> foodList = repository.findAll().stream().map(FoodReponseDTO::new).toList();
        return foodList;
    }
}
