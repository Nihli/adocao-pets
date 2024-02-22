package com.br.adocao.pets.adocaopets.service;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarPetRequest;
import com.br.adocao.pets.adocaopets.dto.response.PetResponse;
import com.br.adocao.pets.adocaopets.model.Pet;
import com.br.adocao.pets.adocaopets.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetResponse cadastraPet(CadastrarPetRequest dto){
        var pet = Pet.builder()
                .especie(dto.especie())
                .raca(dto.raca())
                .nome(dto.nome())
                .personalidade(dto.personalidade())
                .idade(dto.idade())
                .peso(dto.peso())
                .build();

        pet = petRepository.save(pet);

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pet, PetResponse.class);
    }
}
