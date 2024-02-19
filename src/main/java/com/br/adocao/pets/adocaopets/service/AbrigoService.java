package com.br.adocao.pets.adocaopets.service;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarAbrigoRequest;
import com.br.adocao.pets.adocaopets.dto.response.AbrigoResponse;
import com.br.adocao.pets.adocaopets.model.Abrigo;
import com.br.adocao.pets.adocaopets.repository.AbrigoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    public List<AbrigoResponse> ListaAbrigo() {
        var abrigos = repository.findAll();

        if (abrigos.isEmpty()) {
            return null;
        }

        List<AbrigoResponse> response = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        abrigos.forEach(abrigo -> {
            response.add(modelMapper.map(abrigo, AbrigoResponse.class));
        });

        return response;
    }

    public AbrigoResponse cadastraAbrigo(CadastrarAbrigoRequest dto) {
        var abrigo = Abrigo.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .build();

        abrigo = repository.save(abrigo);

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(abrigo, AbrigoResponse.class);
    }
}
