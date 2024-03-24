package com.br.adocao.pets.adocaopets.controller;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarPetRequest;
import com.br.adocao.pets.adocaopets.dto.response.PetResponse;
import com.br.adocao.pets.adocaopets.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @PostMapping
    public ResponseEntity<PetResponse> cadastraPet (@RequestBody CadastrarPetRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(petService.cadastraPet(dto));
    }
}
