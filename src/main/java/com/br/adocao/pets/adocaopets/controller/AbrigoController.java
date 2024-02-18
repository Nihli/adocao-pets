package com.br.adocao.pets.adocaopets.controller;

import com.br.adocao.pets.adocaopets.dto.response.ListaAbrigoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    @GetMapping
    public ResponseEntity<ListaAbrigoDto> ListarAbrigos() {
        return ResponseEntity.ok(null);
    }
}
