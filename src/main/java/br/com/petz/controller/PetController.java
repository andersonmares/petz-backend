package br.com.petz.controller;

import br.com.petz.model.Pet;
import br.com.petz.repository.PetRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRespository petRespository;

    @PostMapping
    public ResponseEntity<Pet> salvarPet(@RequestBody @Valid Pet pet) {

        Pet petSave = petRespository.save(pet);

        return ResponseEntity.status(HttpStatus.CREATED).body(petSave);

    }

    @GetMapping
    public ResponseEntity<List<Pet>> consultarPet() {

        List<Pet> pets = petRespository.findAll();

        return pets != null ? ResponseEntity.ok(pets) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Optional<Pet>> consultarPetPorId(@PathVariable("id") Long id) {

        Optional<Pet> pet = petRespository.findById(id);

        return pet != null ? ResponseEntity.ok(pet) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Pet> atualizarPet(@PathVariable("id") Long id, @Valid @RequestBody Pet pet) {

        Pet petAtualizado = petRespository.save(pet);

        return ResponseEntity.status(HttpStatus.CREATED).body(petAtualizado);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPet(@PathVariable("id") Long id){

        petRespository.deleteById(id);
    }

}
