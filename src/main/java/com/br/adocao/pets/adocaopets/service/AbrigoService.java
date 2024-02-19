package com.br.adocao.pets.adocaopets.service;

import com.br.adocao.pets.adocaopets.dto.response.ListaAbrigoDto;
import com.br.adocao.pets.adocaopets.repository.AbrigoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    public ListaAbrigoDto ListaAbrigo() {
        var abrigos = repository.findAll();

        if (abrigos.isEmpty()) {
            return null;
        }

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(abrigos, ListaAbrigoDto.class);
    }
}
