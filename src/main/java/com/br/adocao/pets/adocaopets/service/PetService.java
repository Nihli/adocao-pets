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
        var pet = new Pet(
                null,
                dto.especie(),
                dto.raca(),
                dto.nome(),
                dto.personalidade(),
                dto.idade(),
                dto.peso()
        );

        pet = petRepository.save(pet);

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(pet, PetResponse.class);
    }
}
