package com.example.controller;

import com.example.repository.CoffeeRepository;
import com.example.entity.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeController(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping("/{id}")
    Coffee ById(@PathVariable long id) throws Exception {
        return coffeeRepository.findById(id).orElseThrow(
                ()-> new Exception("There was an error getting the Coffee from the Database.")
        );
    }

    @GetMapping("/all")
    public List<Coffee> findAllCoffee(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/active")
    public List<Coffee> findAllActive(){  return coffeeRepository.findByActive(1L);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCoffee(@PathVariable long id){
        coffeeRepository.deleteById(id);
    }


}
