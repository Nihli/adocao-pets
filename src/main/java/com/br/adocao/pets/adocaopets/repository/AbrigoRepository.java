package com.br.adocao.pets.adocaopets.repository;

import com.br.adocao.pets.adocaopets.model.Abrigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
}
