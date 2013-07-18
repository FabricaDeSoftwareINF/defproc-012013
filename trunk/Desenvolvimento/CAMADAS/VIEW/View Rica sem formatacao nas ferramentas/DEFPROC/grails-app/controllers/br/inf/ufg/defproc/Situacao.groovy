package br.inf.ufg.defproc

/**
 * Created with IntelliJ IDEA.
 * User: hirako
 * Date: 15/07/13
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */
public enum Situacao {
    ABERTA("Aberta"),
    EM_ANDAMENTO("Em Andamento"),
    AGUARDANDO_APROVACAO("Aguardando Aprovação"),
    CONCLUIDA("Concluída")

    private final String valor

    public Situacao(String valor){
        this.valor = valor
    }

}