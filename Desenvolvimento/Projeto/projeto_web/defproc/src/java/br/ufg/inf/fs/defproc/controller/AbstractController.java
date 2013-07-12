package br.ufg.inf.fs.defproc.controller;

import br.ufg.inf.fs.defproc.domain.Atividade;
import br.ufg.inf.fs.defproc.domain.FerramentasDaAtividade;


/**
 * Classe abstrata que define o controlador de atividades no modelo MVC
 * Controller é o componente intermediário entre a apresentação (View) e os componentes de negócio (Serviços + DAO + Model).
 * 
 * @author Jonathan Silva Pereira
 * 
 * 11/07/2013
 */

public abstract class AbstractController {
    
   private Atividade atividade;

    public AbstractController(Atividade atividade) {
        this.atividade = atividade;
    }
    
    public void setName(String name) {
        this.atividade.setNome(name);
    }
    
    public void setDescricao(String descricao) {
        this.atividade.setDescricao(descricao);
    }
    
    public void addFerramenta(FerramentasDaAtividade ferramenta) {
        //this.atividade.listaFerramentas.add(ferramenta);
    }
    
    public void setCriterioEntrada() {
        
    }
    
    public void setCriterioSaida() {
        
    }
    
    public Atividade getAtividade() {
        return atividade;
    }
    
    
    
    
    
}
