package com.miskolc.demo.repositories;

import com.miskolc.demo.models.PokemonCard;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
public interface PokemonCardRepository extends ElasticsearchRepository<PokemonCard, Integer> {
}
