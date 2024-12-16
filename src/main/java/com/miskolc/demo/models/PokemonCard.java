package com.miskolc.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Data
@Entity
@Table(name = "PokemonCard")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonCard {
//    static private int mainId=0;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int price;
    private String type;

}
