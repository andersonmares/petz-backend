package br.com.petz.repository;

import br.com.petz.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRespository extends JpaRepository<Pet, Long> {
}
