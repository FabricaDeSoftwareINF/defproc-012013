package br.ufg.inf.fs.defproc.domain;

import lombok.Data;

/**
 * Classe que representa a entidade CadastroFerramentas.
 * @author Natan Pimenta
 *
 */
@Data
public class CadastroFerramentas {

	private long id;
	private String nome;
	private String descricao;
	private String tipo;
	
}
