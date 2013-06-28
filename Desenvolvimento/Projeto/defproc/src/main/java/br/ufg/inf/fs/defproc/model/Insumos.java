package br.ufg.inf.fs.defproc.model;

import lombok.Data;

/**
 * Classe que representa a entidade Produtos.
 * @author Natan Pimenta
 */
@Data
public class Insumos {

	private long id;
	private Atividade atividade;
	private String nome;
	private String descricao;
	private String insumo;
	
}
