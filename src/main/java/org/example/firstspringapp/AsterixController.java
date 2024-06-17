package org.example.firstspringapp;

import lombok.RequiredArgsConstructor;
import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.repository.CharacterRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {
    private final CharacterRepo characterRepo;

    @GetMapping()
    public List<AsterixCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }

    @GetMapping("/name")
    public List<AsterixCharacter> getCharacterlistByName(@RequestParam String name){
        return characterRepo.findAllByName(name);
    }

    @GetMapping("/age")
    public List<AsterixCharacter> getCharacterlistByAge(@RequestParam int age){
        return characterRepo.findAllByAge(age);
    }

    @GetMapping("/profession")
    public List<AsterixCharacter> getCharacterlistByProfession(@RequestParam String profession){
        return characterRepo.findAllByProfession(profession);
    }

    @GetMapping("/averageage")
    public double getAvarageAgeByProfession(@RequestParam String profession){
        double averageAge = 0;
        List<AsterixCharacter> charactersByProfession = characterRepo.findAllByProfession(profession);

        for(AsterixCharacter asterixCharacter : charactersByProfession)
            averageAge+=asterixCharacter.age();

        return averageAge/charactersByProfession.size();
    }

    @PostMapping()
    public void addCharacter(@RequestBody AsterixCharacter character){
        characterRepo.save(character);
    }

    @PutMapping
    public void updateCharacter(@RequestBody AsterixCharacter character){
        if(characterRepo.existsById(character.id()))
            characterRepo.save(character);
    }

    @DeleteMapping
    public void deleteCharacter(@RequestParam String id){
        if(characterRepo.existsById(id))
            characterRepo.delete(characterRepo.findById(id).orElseThrow());
    }
}
