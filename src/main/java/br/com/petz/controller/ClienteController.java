package br.com.petz.controller;

import br.com.petz.model.Cliente;
import br.com.petz.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody @Valid Cliente cliente){

        Cliente clienteSave = clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSave);
    }

    @GetMapping
    public ResponseEntity <List<Cliente>> consultarClientes() {

        List<Cliente> clientes = clienteRepository.findAll();

        return clientes != null ? ResponseEntity.ok(clientes) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Optional<Cliente>> consultarClientePorId(@PathVariable("id") Long id) {

        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente) {

        Cliente clienteAtualizado = clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteAtualizado);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCliente(@PathVariable("id") Long id){

        clienteRepository.deleteById(id);
    }

}
