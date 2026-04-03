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

//Nome da tabela @Table, nesse caso locacao
@Table(name="locacao")
public class Locacao {

	//Chave Primária que será gerada automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    //Define o nome da coluna para "data_inicio"
    @Column(name="data_inicio")
    private Date dataInicio;

    //Define o nome da coluna para "quantidade_dias"
    @Column(name="quantidade_dias")
    private int quantidadeDias;

    //Define o nome da coluna para "valor_total"
    @Column(name="valor_total")
    private double valorTotal;

    //Define o nome da coluna para "finalizada"
    @Column(name="finalizada")
    private boolean finalizada;

    //Construtor padrão
    public Locacao() {
        super();
    }

    //Construtor completo
    public Locacao(Long codigo, Date dataInicio, int quantidadeDias, double valorTotal, boolean finalizada) {
        super();
        this.codigo = codigo;
        this.dataInicio = dataInicio;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
        this.finalizada = finalizada;
    }

    //GETTERS E SETTERS

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }
}