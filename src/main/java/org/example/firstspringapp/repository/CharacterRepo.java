package org.example.firstspringapp.repository;

import org.example.firstspringapp.model.AsterixCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepo extends MongoRepository<AsterixCharacter, String> {
    List<AsterixCharacter> findAllByName(String name);
    List<AsterixCharacter> findAllByAge(int age);
    List<AsterixCharacter> findAllByProfession(String profession);
}
