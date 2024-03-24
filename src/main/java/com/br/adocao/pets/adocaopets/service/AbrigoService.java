package com.br.adocao.pets.adocaopets.service;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarAbrigoRequest;
import com.br.adocao.pets.adocaopets.dto.response.AbrigoResponse;
import com.br.adocao.pets.adocaopets.exception.ResourceNotFoundException;
import com.br.adocao.pets.adocaopets.model.Abrigo;
import com.br.adocao.pets.adocaopets.repository.AbrigoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AbrigoService {

    private AbrigoRepository repository;

    public List<AbrigoResponse> ListaAbrigo() {
        var abrigos = repository.findAll();

        if (abrigos.isEmpty()) {
            throw new ResourceNotFoundException();
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
                .nome(dto.nome())
                .email(dto.email())
                .telefone(dto.telefone())
                .build();

        abrigo = repository.save(abrigo);

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(abrigo, AbrigoResponse.class);
    }

    public AbrigoResponse buscaAbrigo(Long id) {
        var optAbrigo = buscaAbrigoPorId(id);

        if (optAbrigo.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(optAbrigo.get(), AbrigoResponse.class);
    }

    public void removerAbrigo(Long id) {
        var optAbrigo = buscaAbrigoPorId(id);

        if (optAbrigo.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        repository.delete(optAbrigo.get());
    }

    private Optional<Abrigo> buscaAbrigoPorId(Long id) {
        return repository.findById(id);
    }
}
