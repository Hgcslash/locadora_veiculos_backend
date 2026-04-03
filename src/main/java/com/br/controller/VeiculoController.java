package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Veiculo;
import com.br.repository.VeiculoRepository;

//Controller responsável por disponibilizar os serviços da entidade Veiculo.
@RestController

//Define o caminho base da URL.
@RequestMapping("/cveiculo")

// Permite acesso de qualquer origem (Insomnia, front-end, etc)
@CrossOrigin(origins="*")
public class VeiculoController {

    //Injeta automaticamente o Repository
    @Autowired
    private VeiculoRepository vrep;

    //LISTAR - retorna todos os veiculos
    @GetMapping
    public List<Veiculo> listar(){
        return this.vrep.findAll();
    }

    //CONSULTAR - retorna um veiculo pelo ID
    @GetMapping("/{id}")
    public Veiculo consultar(@PathVariable Long id) {
        return this.vrep.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));
    }

    //INSERIR - cadastra um novo veiculo
    @PostMapping
    public Veiculo inserir(@RequestBody Veiculo veiculo) {
        return this.vrep.save(veiculo);
    }

    //ALTERAR - atualiza um veiculo existente
    @PutMapping("/{id}")
    public Veiculo alterar(@PathVariable Long id, @RequestBody Veiculo veiculo) {

        Veiculo existente = this.vrep.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        //Atualiza os dados
        existente.setModelo(veiculo.getModelo());
        existente.setPlaca(veiculo.getPlaca());
        existente.setAnoFabricacao(veiculo.getAnoFabricacao());
        existente.setDisponivel(veiculo.isDisponivel());
        existente.setDataCadastro(veiculo.getDataCadastro());

        return this.vrep.save(existente);
    }

    //EXCLUIR - remove um veiculo pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        Veiculo existente = this.vrep.findById(id)
                .orElseThrow(() -> new RuntimeException("Veiculo não encontrado"));

        this.vrep.delete(existente);
    }
}