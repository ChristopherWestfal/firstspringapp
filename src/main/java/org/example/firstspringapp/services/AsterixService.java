package org.example.firstspringapp.services;

import lombok.RequiredArgsConstructor;
import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.model.AsterixCharacterWithoutID;
import org.example.firstspringapp.repository.CharacterRepo;
import org.example.firstspringapp.util.ChangeModels;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AsterixService {
    private final CharacterRepo characterRepo;
    private final IdService idService;

    public List<AsterixCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }

    public List<AsterixCharacter> getCharacterlistByName(String name){
        return characterRepo.findAllByName(name);
    }

    public List<AsterixCharacter> getCharacterlistByAge(int age){
        return characterRepo.findAllByAge(age);
    }

    public List<AsterixCharacter> getCharacterlistByProfession(String profession){
        return characterRepo.findAllByProfession(profession);
    }

    public double getAvarageAgeByProfession(String profession){
        double averageAge = 0;
        List<AsterixCharacter> charactersByProfession = characterRepo.findAllByProfession(profession);

        for(AsterixCharacter asterixCharacter : charactersByProfession)
            averageAge+=asterixCharacter.age();

        return averageAge/charactersByProfession.size();
    }

    public void addCharacter(AsterixCharacterWithoutID character){
        AsterixCharacter asterixCharacter = ChangeModels.changeToCharacterWithId(character);
        characterRepo.save(asterixCharacter);
    }

    public void updateCharacter(String id, AsterixCharacterWithoutID character){
        if(characterRepo.existsById(id)) {
            AsterixCharacter asterixCharacter = characterRepo.findById(id).orElseThrow().withName(character.name()).withAge(character.age()).withProfession(character.profession());
            characterRepo.save(asterixCharacter);
        }
    }

    public void deleteCharacter(String id){
        if(characterRepo.existsById(id))
            characterRepo.delete(characterRepo.findById(id).orElseThrow());
    }

    public AsterixCharacterWithoutID getCharacterById(String id) {
        AsterixCharacter temp = characterRepo.findById(id).orElseThrow();
        return ChangeModels.changeToCharacterWithoutId(temp);
    }
}
