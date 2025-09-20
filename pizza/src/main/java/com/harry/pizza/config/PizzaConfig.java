package com.harry.pizza.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaConfig {
    private String sauce;
    private String topping;
    private String crust;
}
