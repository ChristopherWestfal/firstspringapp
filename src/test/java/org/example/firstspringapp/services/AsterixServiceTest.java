package org.example.firstspringapp.services;

import org.example.firstspringapp.model.AsterixCharacter;
import org.example.firstspringapp.model.AsterixCharacterWithoutID;
import org.example.firstspringapp.repository.CharacterRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AsterixServiceTest {

    private  CharacterRepo mockRepo;
    private  IdService mockIdService;

    private List<AsterixCharacter> asterixCharacterList;

    @BeforeEach
    void setUp(){
        asterixCharacterList = List.of(
                new AsterixCharacter("1", "Asterix", 35, "Krieger"),
                new AsterixCharacter("2", "Obelix", 35, "Lieferant"),
                new AsterixCharacter("3", "Miraculix", 60, "Druide"),
                new AsterixCharacter("4", "Majestix", 60, "Häuptling"),
                new AsterixCharacter("5", "Troubadix", 25, "Barden"),
                new AsterixCharacter("6", "Gutemine", 35, "Häuptlingsfrau"),
                new AsterixCharacter("7", "Idefix", 5, "Hund"),
                new AsterixCharacter("8", "Geriatrix", 70, "Rentner"),
                new AsterixCharacter("9", "Automatix", 35, "Schmied"),
                new AsterixCharacter("10", "Grockelix", 35, "Fischer")
        );

        mockRepo = mock(CharacterRepo.class);
        mockIdService = mock(IdService.class);
    }



    @Test
    void getAllCharacters_shouldReturnAListOfAllCharacters_whenCalled() {
        //GIVEN
        AsterixService asterixService = new AsterixService(mockRepo, mockIdService);
        List<AsterixCharacter> expected = asterixCharacterList;

        when(mockRepo.findAll()).thenReturn(expected);
        //WHEN
        List<AsterixCharacter> actual = asterixService.getAllCharacters();
        //THEN
        assertEquals(expected, actual);
        verify(mockRepo).findAll();

    }

    @Test
    void updateCharacter_shouldUpdateAsterixCharacter_whenCalledWithIdAndCharacterWithoutId() {
        //Given
        AsterixService asterixService = new AsterixService(mockRepo, mockIdService);
        String id = "1";
        AsterixCharacterWithoutID asterixCharacterWithoutID = new AsterixCharacterWithoutID("Hans", 20, "Held");
        AsterixCharacter asterixCharacter = new AsterixCharacter(id, "Asterix", 35, "Krieger");
        AsterixCharacter expected = new AsterixCharacter("1","Hans", 20, "Held");
        when(mockRepo.existsById(id)).thenReturn(true);
        when(mockRepo.findById(id)).thenReturn(Optional.of(asterixCharacter));
        //When
        asterixService.updateCharacter(id, asterixCharacterWithoutID);
        //Then
        verify(mockRepo).existsById(id);
        verify(mockRepo).findById(id);
        verify(mockRepo).save(expected);
    }

    @Test
    void deleteCharacter() {
        //Given

        //When

        //Then
    }

    @Test
    void getCharacterById () {
        //Given
        AsterixService asterixService = new AsterixService(mockRepo, mockIdService);
        String id = "1";

        //When

        //Then
    }
}