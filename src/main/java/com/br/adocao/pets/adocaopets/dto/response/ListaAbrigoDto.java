package com.br.adocao.pets.adocaopets.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaAbrigoDto {
    private String nome;
    private String telefone;
    private String email;
}
