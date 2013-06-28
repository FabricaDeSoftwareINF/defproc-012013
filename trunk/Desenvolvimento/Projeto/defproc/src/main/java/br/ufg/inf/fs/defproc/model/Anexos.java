package br.ufg.inf.fs.defproc.model;

import lombok.Data;

/**
 * Classe que representa a entidade Anexos.
 * @author Natan Pimenta
 */
@Data
public class Anexos {

	private long id;
	private Atividade atividade;
	private String nome;
	private String descricao;
	private String anexo;
	
}
