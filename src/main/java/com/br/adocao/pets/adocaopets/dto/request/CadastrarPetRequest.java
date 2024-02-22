package com.br.adocao.pets.adocaopets.dto.request;

public record CadastrarPetRequest(String especie,
                                  String raca,
                                  String nome,
                                  String personalidade,
                                  int idade,
                                  Float peso) {
}
