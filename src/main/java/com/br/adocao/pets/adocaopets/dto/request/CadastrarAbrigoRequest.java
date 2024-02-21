package com.br.adocao.pets.adocaopets.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CadastrarAbrigoRequest (@NotBlank(message = "Nome do abrigo é obrigatório") String nome,
                                      @NotBlank(message = "Telefone do abrigo é obrigatório") String telefone,
                                      @NotBlank(message = "Email do abrigo é obrigatório") String email) {

}