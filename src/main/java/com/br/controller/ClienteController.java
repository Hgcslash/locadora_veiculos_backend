package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Cliente;
import com.br.repository.ClienteRepository;

//Controller responsável por disponibilizar os serviços da entidade Cliente.
@RestController

//Define o caminho base da URL.
@RequestMapping("/ccliente")

// Permite acesso de qualquer origem (Insomnia, front-end, etc)
@CrossOrigin(origins="*")
public class ClienteController {

    //Injeta automaticamente o Repository
    @Autowired
    private ClienteRepository crep;

    //LISTAR - retorna todos os clientes
    @GetMapping
    public List<Cliente> listar(){
        return this.crep.findAll();
    }

    //CONSULTAR - retorna um cliente pelo ID
    @GetMapping("/{id}")
    public Cliente consultar(@PathVariable Long id) {
        return this.crep.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    //INSERIR - cadastra um novo cliente
    @PostMapping
    public Cliente inserir(@RequestBody Cliente cliente) {
        return this.crep.save(cliente);
    }

    //ALTERAR - atualiza um cliente existente
    @PutMapping("/{id}")
    public Cliente alterar(@PathVariable Long id, @RequestBody Cliente cliente) {

        Cliente existente = this.crep.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        //Atualiza os dados
        existente.setNome(cliente.getNome());
        existente.setCpf(cliente.getCpf());
        existente.setIdade(cliente.getIdade());
        existente.setRegular(cliente.isRegular());
        existente.setDataCadastro(cliente.getDataCadastro());

        return this.crep.save(existente);
    }

    //EXCLUIR - remove um cliente pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        Cliente existente = this.crep.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        this.crep.delete(existente);
    }
}