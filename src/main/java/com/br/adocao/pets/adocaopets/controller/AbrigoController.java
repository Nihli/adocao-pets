package com.br.adocao.pets.adocaopets.controller;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarAbrigoRequest;
import com.br.adocao.pets.adocaopets.dto.response.AbrigoResponse;
import com.br.adocao.pets.adocaopets.service.AbrigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    @Autowired
    private AbrigoService abrigoService;

    @GetMapping
    public ResponseEntity<?> ListarAbrigos() {
        var abrigos = abrigoService.ListaAbrigo();

        if (abrigos == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum abrigo cadastrado");
        }

        return ResponseEntity.ok(abrigoService.ListaAbrigo());
    }

    @PostMapping
    public ResponseEntity<?> CadastrarAbrigo(@RequestBody CadastrarAbrigoRequest dto) {
        var abrigoCadastrado = abrigoService.cadastraAbrigo(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(abrigoCadastrado);
    }
}
