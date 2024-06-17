package org.example.firstspringapp.util;

import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.model.AsterixCharacterWithoutID;
import org.example.firstspringapp.services.IdService;

public class ChangeModels {

    private static final IdService idService = new IdService();

    public static AsterixCharacter changeToCharacterWithId(AsterixCharacterWithoutID character) {
        AsterixCharacter temp = new AsterixCharacter(idService.randomId(), character.name(), character.age(), character.profession());
        return temp;
    }
}
