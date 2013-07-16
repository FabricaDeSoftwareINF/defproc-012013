/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Jonathan
 */
public class Atividade {
    private long id;
    private String nome, descricao;
    private Date criterioEntrada;
    private Date criterioSaida;
    private Date dataEntrega;
    private int status;

    //private Processo processoRelacionado;
    //private List<FerramentasDaAtividade> listaFerramentas;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriterioEntrada() {
        return criterioEntrada;
    }

    public void setCriterioEntrada(Date criterioEntrada) {
        this.criterioEntrada = criterioEntrada;
    }

    public Date getCriterioSaida() {
        return criterioSaida;
    }

    public void setCriterioSaida(Date criterioSaida) {
        this.criterioSaida = criterioSaida;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
    
}
