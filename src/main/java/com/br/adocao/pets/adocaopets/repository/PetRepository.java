package com.br.adocao.pets.adocaopets.repository;

import com.br.adocao.pets.adocaopets.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}
