package com.br.adocao.pets.adocaopets.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetResponse {
    private Long id;
    private String especie;
    private String raca;
    private String nome;
    private String personalidade;
    private int idade;
    private Float peso;
}
