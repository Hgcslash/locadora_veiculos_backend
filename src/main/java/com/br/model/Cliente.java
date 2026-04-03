package com.br.model;

//Importa o tipo Date para trabalhar com datas
import java.sql.Date;

//Importações do JPA ("API")
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Entidade @Entity que será transformada em tabela
@Entity

//Nome da tabela @Table, nesse caso cliente
@Table(name="cliente")
public class Cliente {

	//Chave Primária que será gerada automaticamente pelo banco de dados, numeração única e sequencial
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    //Define o nome da coluna para "nome" e armazena o nome do cliente
    @Column(name="nome")
    private String nome;

    //Define o nome da coluna para "cpf" e armazena o cpf do cliente
    @Column(name="cpf")
    private String cpf;

    //Define o nome da coluna para "idade" e armazena a idade do cliente
    @Column(name="idade")
    private int idade;

    //Define o nome da coluna para "regular" e armazena se o cliente está ativo
    @Column(name="regular")
    private boolean regular;

    //Define o nome da coluna para "data_cadastro" e armazena a data que o cliente foi cadastrado no sistema
    @Column(name="data_cadastro")
    private Date dataCadastro;

    //Construtor padrão - Obrigatório para o JPA funcionar corretamente
    public Cliente() {
        super();
    }

    //Construtor completo - Com todos os atributos, facilita na criação de objetos completos
    public Cliente(Long codigo, String nome, String cpf, int idade, boolean regular, Date dataCadastro) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.regular = regular;
        this.dataCadastro = dataCadastro;
    }

    //GETTERS E SETTERS

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isRegular() {
        return regular;
    }

    public void setRegular(boolean regular) {
        this.regular = regular;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}