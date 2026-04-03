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

//Nome da tabela @Table, nesse caso veiculo
@Table(name="veiculo")
public class Veiculo {

	//Chave Primária que será gerada automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    //Define o nome da coluna para "modelo"
    @Column(name="modelo")
    private String modelo;

    //Define o nome da coluna para "placa"
    @Column(name="placa")
    private String placa;

    //Define o nome da coluna para "ano_fabricacao"
    @Column(name="ano_fabricacao")
    private int anoFabricacao;

    //Define o nome da coluna para "disponivel"
    @Column(name="disponivel")
    private boolean disponivel;

    //Define o nome da coluna para "data_cadastro"
    @Column(name="data_cadastro")
    private Date dataCadastro;

    //Construtor padrão
    public Veiculo() {
        super();
    }

    //Construtor completo
    public Veiculo(Long codigo, String modelo, String placa, int anoFabricacao, boolean disponivel, Date dataCadastro) {
        super();
        this.codigo = codigo;
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
    }

    //GETTERS E SETTERS

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}