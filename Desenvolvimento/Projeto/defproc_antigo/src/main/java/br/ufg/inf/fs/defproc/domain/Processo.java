package br.ufg.inf.fs.defproc.domain;

import java.util.Set;

import lombok.Data;

/**
 * Classe que representa a entidade Processo.
 * @author Natan Pimenta
 */
@Data
public class Processo {

	private long id;
	private String nome;
	private String descricao;
	private Set<UsuarioSistema> usuarios;
}
