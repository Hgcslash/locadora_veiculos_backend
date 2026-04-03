package com.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.model.Locacao;
import com.br.repository.LocacaoRepository;

//Controller responsável por disponibilizar os serviços da entidade Locacao.
@RestController

//Define o caminho base da URL.
@RequestMapping("/clocacao")

// Permite acesso de qualquer origem (Insomnia, front-end, etc)
@CrossOrigin(origins="*")
public class LocacaoController {

    //Injeta automaticamente o Repository
    @Autowired
    private LocacaoRepository lrep;

    //LISTAR - retorna todas as locacoes
    @GetMapping
    public List<Locacao> listar(){
        return this.lrep.findAll();
    }

    //CONSULTAR - retorna uma locacao pelo ID
    @GetMapping("/{id}")
    public Locacao consultar(@PathVariable Long id) {
        return this.lrep.findById(id)
                .orElseThrow(() -> new RuntimeException("Locacao não encontrada"));
    }

    //INSERIR - cadastra uma nova locacao
    @PostMapping
    public Locacao inserir(@RequestBody Locacao locacao) {
        return this.lrep.save(locacao);
    }

    //ALTERAR - atualiza uma locacao existente
    @PutMapping("/{id}")
    public Locacao alterar(@PathVariable Long id, @RequestBody Locacao locacao) {

        Locacao existente = this.lrep.findById(id)
                .orElseThrow(() -> new RuntimeException("Locacao não encontrada"));

        //Atualiza os dados
        existente.setDataInicio(locacao.getDataInicio());
        existente.setQuantidadeDias(locacao.getQuantidadeDias());
        existente.setValorTotal(locacao.getValorTotal());
        existente.setFinalizada(locacao.isFinalizada());

        return this.lrep.save(existente);
    }

    //EXCLUIR - remove uma locacao pelo ID
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {

        Locacao existente = this.lrep.findById(id)
                .orElseThrow(() -> new RuntimeException("Locacao não encontrada"));

        this.lrep.delete(existente);
    }
}