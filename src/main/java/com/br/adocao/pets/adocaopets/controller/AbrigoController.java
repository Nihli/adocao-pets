package com.br.adocao.pets.adocaopets.controller;

import com.br.adocao.pets.adocaopets.dto.response.ListaAbrigoDto;
import com.br.adocao.pets.adocaopets.service.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    public ResponseEntity<ListaAbrigoDto> ListarAbrigos() {
        return ResponseEntity.ok(abrigoService.ListaAbrigo());
    }
}
