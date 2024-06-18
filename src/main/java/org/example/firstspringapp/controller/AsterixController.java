package org.example.firstspringapp.controller;

import lombok.RequiredArgsConstructor;
import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.model.AsterixCharacterWithoutID;
import org.example.firstspringapp.services.AsterixService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asterix/characters")
@RequiredArgsConstructor
public class AsterixController {

    private final AsterixService asterixService;

    @GetMapping()
    public List<AsterixCharacter> getAllCharacters(){
        return asterixService.getAllCharacters();
    }

    @GetMapping("id")
    public AsterixCharacterWithoutID getCharacterById(@RequestParam String id){
        return asterixService.getCharacterById(id);
    }

    @GetMapping("/name")
    public List<AsterixCharacter> getCharacterlistByName(@RequestParam String name){
        return asterixService.getCharacterlistByName(name);
    }

    @GetMapping("/age")
    public List<AsterixCharacter> getCharacterlistByAge(@RequestParam int age){
        return asterixService.getCharacterlistByAge(age);
    }

    @GetMapping("/profession")
    public List<AsterixCharacter> getCharacterlistByProfession(@RequestParam String profession){
        return asterixService.getCharacterlistByProfession(profession);
    }

    @GetMapping("/averageage")
    public double getAvarageAgeByProfession(@RequestParam String profession){
        return asterixService.getAvarageAgeByProfession(profession);
    }

    @PostMapping()
    public void addCharacter(@RequestBody AsterixCharacterWithoutID character){
        asterixService.addCharacter(character);
    }

    @PutMapping
    public void updateCharacter(@RequestParam String id, @RequestBody AsterixCharacterWithoutID character){
        asterixService.updateCharacter(id, character);
    }

    @DeleteMapping
    public void deleteCharacter(@RequestParam String id){
        asterixService.deleteCharacter(id);
    }
}
