package com.miskolc.demo.models;

import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
public class PokemonCard {
//    static private int mainId=1;
    private int id;
    private String name;
    private int price;
    private String type;
//    public PokemonCard(String name, int price, String type) {
//        mainId++;
//        this.id=mainId;
//        this.name = name;
//        this.price = price;
//        this.type = type;
//    }

    public PokemonCard(int id,String name, int price, String type) {
        this.id=id;
        this.name = name;
        this.price = price;
        this.type = type;
    }
}
