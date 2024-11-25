package org.jfcmc.spring.srau.chap03.controller;

import java.util.ArrayList;
import java.util.List;

import org.jfcmc.spring.srau.chap03.domain.Coffee;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                               new Coffee("Café Pergamino"),
                               new Coffee("El laboratorio del Café"),
                               new Coffee("Café Rocket"),
                               new Coffee("Yuyi Café")));
    }

    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);

        return coffee;
    }

    @PutMapping("/coffees/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }

        return (coffeeIndex == -1 ? postCoffee(coffee) : coffee);
    }

    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }
}
