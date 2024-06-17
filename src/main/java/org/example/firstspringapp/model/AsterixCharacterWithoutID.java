package org.example.firstspringapp.model;

import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Document("AsterixCharacters")
public record AsterixCharacterWithoutID(
        String name,
        int age,
        String profession) {
}
