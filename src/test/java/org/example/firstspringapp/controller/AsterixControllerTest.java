package org.example.firstspringapp.controller;

import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.repository.CharacterRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AsterixControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CharacterRepo characterRepo;

    @BeforeEach
    void setUp(){
        AsterixCharacter asterixCharacter = new AsterixCharacter("1", "Hans", 20, "Magier");
        AsterixCharacter asterixCharacter2 = new AsterixCharacter("2", "Peter", 35, "Krieger");
        AsterixCharacter asterixCharacter3 = new AsterixCharacter("3", "Jürgen", 20, "Hausmeister");
        AsterixCharacter asterixCharacter4 = new AsterixCharacter("4", "Peter", 66, "Magier");
        characterRepo.save(asterixCharacter);
        characterRepo.save(asterixCharacter2);
        characterRepo.save(asterixCharacter3);
        characterRepo.save(asterixCharacter4);
    }

    @Test
    void getAllCharacters_shouldReturnListWith1Object_whenObjectWasSavedInRepository() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                         [
                          {
                            "id": "1",
                            "name": "Hans",
                            "age": 20,
                            "profession": "Magier"
                          },
          {
                            "id": "2",
                            "name": "Peter",
                            "age": 35,
                            "profession": "Krieger"
                          },
                         {
                            "id": "3",
                            "name": "Jügen",
                            "age": 20,
                            "profession": "Hausmeister"
                          },
                          {
                            "id": "4",
                            "name": "Peter",
                            "age": 66,
                            "profession": "Magier"
                          }
                          ]                         
                """));
    }

    @Test
    void getCharacterById_shouldReturnCharacterWithId_whenCalledWithId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters/id").param("id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Hans"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$.profession").value("Magier"));
    }

    @Test
    void getCharacterlistByName_shouldReturnCharacterlistWithNamePeter_whenCalledWithNamePeter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters/name").param("name", "Peter"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                         [
                          {
                            "id": "2",
                            "name": "Peter",
                            "age": 35,
                            "profession": "Krieger"
                          },
                          {
                            "id": "4",
                            "name": "Peter",
                            "age": 66,
                            "profession": "Magier"
                          }
                          ]                         
                """));
    }

    @Test
    void getCharacterlistByAge_shouldReturnCharacterlistWithAge20_whenCalledWithAge20() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters/age").param("age", String.valueOf(20)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                         [
                          {
                            "id": "1",
                            "name": "Hans",
                            "age": 20,
                            "profession": "Magier"
                          },
                          {
                            "id": "3",
                            "name": "Jürgen",
                            "age": 20,
                            "profession": "Hausmeister"
                          }
                          ]                         
                """));
    }

    @Test
    void getCharacterlistByProfession_shouldReturnCharacterlistWithProfessionMagier_whenCalledWithProfessionMagier() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters/profession").param("profession", "Magier"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                         [
                          {
                            "id": "1",
                            "name": "Hans",
                            "age": 20,
                            "profession": "Magier"
                          },
                          {
                            "id": "4",
                            "name": "Peter",
                            "age": 66,
                            "profession": "Magier"
                          }
                         ]
    """));
    }

    @Test
    void getAvarageAgeByProfession() {
    }

    @Test
    void addCharacter() {
    }

    @Test
    void updateCharacter() {
    }

    @Test
    void deleteCharacter() {
    }
}