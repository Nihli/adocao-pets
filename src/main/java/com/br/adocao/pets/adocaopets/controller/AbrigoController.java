package com.br.adocao.pets.adocaopets.controller;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarAbrigoRequest;
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
        var abrigos = abrigoService.ListaAbrigo();

        if (abrigos == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum abrigo cadastrado");
        }

        return ResponseEntity.ok(abrigoService.ListaAbrigo());
    }

    @PostMapping
    public ResponseEntity<?> CadastrarAbrigo(@RequestBody @Valid CadastrarAbrigoRequest dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(abrigoService.cadastraAbrigo(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> BuscarAbrigo(@PathVariable Long id) {
        var abrigo = abrigoService.buscaAbrigo(id);

        if (abrigo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Abrigo não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(abrigo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> RemoverAbrigo(@PathVariable Long id) {
        if (!abrigoService.removerAbrigo(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Abrigo não encontrado");
        }

        return ResponseEntity.ok("Recurso removido");
    }
}
