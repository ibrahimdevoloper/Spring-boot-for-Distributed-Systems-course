package com.miskolc.demo.controller;

import com.miskolc.demo.models.PokemonCard;
import com.miskolc.demo.services.PokemonCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/cards")
public class PokemonCardController {
    //    List<PokemonCard> cards;
    @Autowired
    PokemonCardService pokemonCardService;

    public PokemonCardController() {
//        cards = new LinkedList<>();
//        cards.add(new PokemonCard("Kyurem",100,"Holo"));
//        cards.add(new PokemonCard("Charmender",10,"Normal"));
//        cards.add(new PokemonCard("Pickachu",50,"Ghost"));
    }

    @GetMapping("/{id}")
    private ResponseEntity<PokemonCard> findById(@PathVariable int id) {
//        PokemonCard card = null;
//        for(int j=0; j<cards.size();j++){
//            PokemonCard temp = cards.get(j);
//            if (temp.getId() == id) {
//                card =temp;
//                break;
//            }
//        }
        PokemonCard card = pokemonCardService.getPokemonCard(id);
        if (card == null)
            return (ResponseEntity<PokemonCard>) notFound();
        return ResponseEntity.ok(card);
    }

    @GetMapping(path = "")
    private ResponseEntity<List<PokemonCard>> findAll() {
        List<PokemonCard> cards = pokemonCardService.getAllPokemonCards();
        if (cards.size() < 1)
            return (ResponseEntity<List<PokemonCard>>) notFound();
        return ResponseEntity.ok(cards);
    }

    @PostMapping(path = "")
    private ResponseEntity<PokemonCard> addPokemon(@RequestBody PokemonCard card) {
        System.out.println("add Pokemon");
        pokemonCardService.addPokemonCard(card);
        return ResponseEntity.ok(card);
    }

    @PutMapping(path = "")
    private ResponseEntity<PokemonCard> editPokemon(@RequestBody PokemonCard card) {
        pokemonCardService.updatePokemonCard(card);
        return ResponseEntity.ok(card);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteById(@PathVariable int id) {
//        PokemonCard card = null;
//        for (int j = 0; j < cards.size(); j++) {
//            PokemonCard temp = cards.get(j);
//            if (temp.getId() == id) {
//                cards.remove(j);
//                break;
//            }
//        }
        pokemonCardService.deletePokemonCard(id);
        return ResponseEntity.ok("{\"message\":\"Deleted\"}");
    }
}
