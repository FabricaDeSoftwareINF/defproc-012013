package br.ufg.inf.fs.defproc.domain;


import lombok.Data;

/**
 * Classe que representa a entidade AtividadeSecundaria.
 * @author Natan Pimenta
 *
 */
@Data
public class AtividadeSecundaria {

	private Atividade atividade;
	private int atividadeSecundaria;
	private String descricao;
	private String tipoAtividade;

}
