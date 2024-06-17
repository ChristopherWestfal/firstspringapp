package org.example.firstspringapp.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdService {
    public String randomId(){
        return UUID.randomUUID().toString();
    }
}
