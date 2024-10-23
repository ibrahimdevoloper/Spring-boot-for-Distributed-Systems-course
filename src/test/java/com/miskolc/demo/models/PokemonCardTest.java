package com.miskolc.demo.models;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
/*
The @JsonTest annotation marks the CashCardJsonTest as a test class
which uses the Jackson framework (which is included as part of Spring).
 */
@JsonTest
public class PokemonCardTest {
    /*
    @Autowired is an annotation that directs Spring
    to create an object of the requested type.
     */
    @Autowired
    private JacksonTester<PokemonCard> json;
    @Test
    void cashCardSerializationTest() throws IOException {
        PokemonCard pokemonCard = new PokemonCard(1,"Kyurem", 123,"Holo");
        assertThat(json.write(pokemonCard)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(pokemonCard)).hasJsonPathNumberValue("@.price");
        assertThat(json.write(pokemonCard)).extractingJsonPathNumberValue("@.price")
                .isEqualTo(123);
        assertThat(json.write(pokemonCard)).hasJsonPathStringValue("@.name");
        assertThat(json.write(pokemonCard)).extractingJsonPathStringValue("@.name")
                .isEqualTo("Kyurem");
        assertThat(json.write(pokemonCard)).hasJsonPathStringValue("@.type");
        assertThat(json.write(pokemonCard)).extractingJsonPathStringValue("@.type")
                .isEqualTo("Holo");
    }

    @Test
    void myFirstTest() {
        assertThat(42).isEqualTo(42);
    }
}
