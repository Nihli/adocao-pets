package com.br.adocao.pets.adocaopets.service;

import com.br.adocao.pets.adocaopets.dto.request.CadastrarPetRequest;
import com.br.adocao.pets.adocaopets.model.Pet;
import com.br.adocao.pets.adocaopets.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @InjectMocks
    private PetService petService;

    @Mock
    private PetRepository petRepository;

    @Captor
    private ArgumentCaptor<Pet> petCaptor;

    @Test
    void deveCadastrarNovoPet () {
        //ARRANGE
        CadastrarPetRequest dto = new CadastrarPetRequest("Cachorro", "Yorkshire terrier", "Scooby", "Quieto e teimoso", 16, 5.6f);
        Pet pet = new Pet(null, "Cachorro", "Yorkshire terrier", "Scooby", "Quieto e teimoso", 16, 5.6f);

        //ACT
        given(petRepository.save(pet)).willReturn(pet);

        petService.cadastraPet(dto);

        //ASSERT
        then(petRepository).should().save(petCaptor.capture());
        Pet petCadastrado = petCaptor.getValue();

        Assertions.assertEquals(pet.getEspecie(), petCadastrado.getEspecie());
        Assertions.assertEquals(pet.getRaca(), petCadastrado.getRaca());
        Assertions.assertEquals(pet.getNome(), petCadastrado.getNome());
        Assertions.assertEquals(pet.getPersonalidade(), petCadastrado.getPersonalidade());
        Assertions.assertEquals(pet.getIdade(), petCadastrado.getIdade());
        Assertions.assertEquals(pet.getPeso(), petCadastrado.getPeso());
    }
}
