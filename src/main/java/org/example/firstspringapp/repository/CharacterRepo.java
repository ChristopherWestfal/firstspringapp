package org.example.firstspringapp.repository;

import org.example.firstspringapp.model.AsterixCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepo extends MongoRepository<AsterixCharacter, String> {
    List<AsterixCharacter> findAllByName(String name);
    List<AsterixCharacter> findAllByAge(int age);
    List<AsterixCharacter> findAllByProfession(String profession);
}
