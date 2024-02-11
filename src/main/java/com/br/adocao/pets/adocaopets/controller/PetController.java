package com.br.adocao.pets.adocaopets.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @GetMapping
    public ResponseEntity<String> test () {
        return ResponseEntity.ok("Hello there!");
    }
}
