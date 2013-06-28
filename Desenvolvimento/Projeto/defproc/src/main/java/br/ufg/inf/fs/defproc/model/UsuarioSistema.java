package br.ufg.inf.fs.defproc.model;

import java.util.Set;

import lombok.Data;

/**
 * Classe que representa a entidade UsuarioSistema.
 * @author Natan Pimenta
 */
@Data
public class UsuarioSistema {

	private long id;
	private String email;
	private String senha;
	private Set<ProcessoDoUsuario> processos;
}
