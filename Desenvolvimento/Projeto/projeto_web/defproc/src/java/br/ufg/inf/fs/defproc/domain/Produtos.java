package br.ufg.inf.fs.defproc.domain;

import lombok.Data;

/**
 * Classe que representa a entidade Produtos.
 * @author Natan Pimenta
 */
@Data
public class Produtos {

	private long id;
	private Atividade atividade;
	private String nome;
	private String descricao;
	private String produto;
	private String status;
	
}
