/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.defproc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Felipe''
 */
public class Projeto implements Serializable{

    private int id;
    private String nome, descricao;
    private boolean ativo;
    private List<Usuario> gerentes;
    private List<Usuario> aprovadores;
    private List<Usuario> participantes;
    private List<Usuario> observadores;

    public Projeto() {
        gerentes = new ArrayList<Usuario>();
        aprovadores = new ArrayList<Usuario>();
        participantes = new ArrayList<Usuario>();
        observadores = new ArrayList<Usuario>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Usuario> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Usuario> gerentes) {
        this.gerentes = gerentes;
    }

    public List<Usuario> getAprovadores() {
        return aprovadores;
    }

    public void setAprovadores(List<Usuario> aprovadores) {
        this.aprovadores = aprovadores;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    public List<Usuario> getObservadores() {
        return observadores;
    }

    public void setObservadores(List<Usuario> observadores) {
        this.observadores = observadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }  
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projeto other = (Projeto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
