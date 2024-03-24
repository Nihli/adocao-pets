package com.br.adocao.pets.adocaopets.controller;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarAbrigoRequest;
import com.br.adocao.pets.adocaopets.dto.response.AbrigoResponse;
import com.br.adocao.pets.adocaopets.exception.ResourceNotFoundException;
import com.br.adocao.pets.adocaopets.service.AbrigoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/abrigo")
public class AbrigoController {

    private AbrigoService abrigoService;

    @GetMapping
    public ResponseEntity<List<AbrigoResponse>> ListarAbrigos() {
        return ResponseEntity.ok(abrigoService.ListaAbrigo());
    }

    @PostMapping
    public ResponseEntity<?> CadastrarAbrigo(@RequestBody @Valid CadastrarAbrigoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(abrigoService.cadastraAbrigo(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbrigoResponse> BuscarAbrigo(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(abrigoService.buscaAbrigo(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> RemoverAbrigo(@PathVariable Long id) {
        abrigoService.removerAbrigo(id);

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<String> captureException() {
        return ResponseEntity.notFound().build();
    }
}
