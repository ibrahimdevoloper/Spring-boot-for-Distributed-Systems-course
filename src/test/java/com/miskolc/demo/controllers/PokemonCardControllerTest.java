package com.miskolc.demo.controllers;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.miskolc.demo.models.PokemonCard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
This will start our Spring Boot application and make it available
for our test to perform requests to it.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PokemonCardControllerTest {
    //Spring to inject a test helper
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void getSinglePokemon() {
        ResponseEntity<String> response = restTemplate.getForEntity("/cards/1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        assertThat(id).isNotNull();
        assertThat(id).isEqualTo(1);
    }

    @Test
    void getAllPokemons() {
        ResponseEntity<String> response = restTemplate.getForEntity("/cards", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void addPokemon() {
        ResponseEntity<String> response = restTemplate.postForEntity("/cards", new PokemonCard("Rattata", 1, "Normal"), String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void editPokemon() {
       //TODO: Implement this test for the editPokemon method
    }

    @Test
    void deletePokemon() {
        //TODO: Implement this test for the deleteById method
    }
}
