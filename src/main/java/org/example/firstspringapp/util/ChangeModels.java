package org.example.firstspringapp.util;

import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.model.AsterixCharacterWithoutID;
import org.example.firstspringapp.services.IdService;

import java.util.Optional;

public class ChangeModels {

    private static final IdService idService = new IdService();

    public static AsterixCharacter changeToCharacterWithId(AsterixCharacterWithoutID character) {
        return new AsterixCharacter(idService.randomId(), character.name(), character.age(), character.profession());
    }

    public static AsterixCharacterWithoutID changeToCharacterWithoutId(AsterixCharacter character) {
        return new AsterixCharacterWithoutID( character.name(), character.age(), character.profession());
    }
}
