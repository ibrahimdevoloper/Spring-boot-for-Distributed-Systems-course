package com.miskolc.demo.models;

import lombok.Data;

@Data
public class PokemonCard {
    private String name;
    private int price;
    private String type;

    public PokemonCard(String name, int price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
