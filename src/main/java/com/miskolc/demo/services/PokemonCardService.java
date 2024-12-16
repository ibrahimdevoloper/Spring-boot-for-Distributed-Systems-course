package com.miskolc.demo.services;

import com.miskolc.demo.models.PokemonCard;
import com.miskolc.demo.repositories.PokemonCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonCardService {

    @Autowired
    private PokemonCardRepository pokemonCardRepository;

    //add a new pokemon card
    public void addPokemonCard(PokemonCard pokemonCard){
        pokemonCardRepository.save(pokemonCard);
    }

    //get all pokemon cards
    public List<PokemonCard> getAllPokemonCards(){
        List<PokemonCard> pokemonCards = new ArrayList<>();
        pokemonCardRepository.findAll().forEach(pokemonCards::add);
        return pokemonCards;
    }

    //get a pokemon card by id
    public PokemonCard getPokemonCard(long id){
        return pokemonCardRepository.findById(id).orElse(null);
    }

    //update a pokemon card
    public void updatePokemonCard(PokemonCard pokemonCard){
        pokemonCardRepository.save(pokemonCard);
    }

    //delete a pokemon card
    public void deletePokemonCard(long id){
        pokemonCardRepository.deleteById(id);
    }

}
