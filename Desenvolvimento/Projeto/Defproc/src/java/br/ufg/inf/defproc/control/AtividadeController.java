package br.ufg.inf.defproc.control;

import br.ufg.inf.defproc.model.Atividade;

/**
 *
 * @author Jonathan
 */
public class AtividadeController {
    
    private Atividade atividade;
    
    public AtividadeController() {
        atividade = new Atividade();        
    }
    
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    public Atividade getAtividade() {
        return atividade;
    }
    
    
    
}
