package com.miskolc.demo.repositories;

import com.miskolc.demo.models.PokemonCard;
import org.springframework.data.repository.CrudRepository;

public interface PokemonCardRepository extends CrudRepository<PokemonCard, Long> {
}
