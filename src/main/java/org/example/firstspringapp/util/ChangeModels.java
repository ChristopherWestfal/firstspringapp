package org.example.firstspringapp.util;

import lombok.RequiredArgsConstructor;
import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.model.AsterixCharacterWithoutID;
import org.example.firstspringapp.services.IdService;

public class ChangeModels {

    private static final IdService idService = new IdService();

    public static AsterixCharacter changeToID(AsterixCharacterWithoutID character) {
        AsterixCharacter temp = new AsterixCharacter(idService.randomId(), character.name(), character.age(), character.profession());
        return temp;

    }

    public  static AsterixCharacter changeWithoutGeneratedId(String id, AsterixCharacterWithoutID characterWithoutID){
        AsterixCharacter temp = new AsterixCharacter(id, characterWithoutID.name(), characterWithoutID.age(), characterWithoutID.profession());
        return temp;
    }
}
