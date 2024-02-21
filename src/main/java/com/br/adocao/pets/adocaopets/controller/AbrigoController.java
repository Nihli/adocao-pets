package com.br.adocao.pets.adocaopets.controller;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarAbrigoRequest;
import com.br.adocao.pets.adocaopets.exception.CustomValidationException;
import com.br.adocao.pets.adocaopets.service.AbrigoService;
import jakarta.validation.Valid;
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
        try{
            return ResponseEntity.ok(abrigoService.ListaAbrigo());

        } catch (CustomValidationException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> CadastrarAbrigo(@RequestBody @Valid CadastrarAbrigoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(abrigoService.cadastraAbrigo(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarAbrigo(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(abrigoService.buscaAbrigo(id));

        } catch (CustomValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> RemoverAbrigo(@PathVariable Long id) {
        try {
            abrigoService.removerAbrigo(id);

            return ResponseEntity.ok("Recurso removido");

        } catch (CustomValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
