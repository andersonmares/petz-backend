package br.com.petz.controller;

import br.com.petz.model.Endereco;
import br.com.petz.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping(value = "enderecos/{cep}")
    public Endereco consultarEnderecoPorCep(@PathVariable String cep) {
        return enderecoRepository.buscarPorCep(cep);
    }

}
