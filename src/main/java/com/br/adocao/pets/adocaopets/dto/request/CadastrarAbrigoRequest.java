package com.br.adocao.pets.adocaopets.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarAbrigoRequest {
    private String nome;
    private String telefone;
    private String email;
}
