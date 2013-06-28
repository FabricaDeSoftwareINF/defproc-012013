package br.ufg.inf.fs.defproc.model;

import lombok.Data;

/**
 * Classe que representa a entidade ProcessoDoUsuario.
 * @author Natan Pimenta
 */
@Data
public class ProcessoDoUsuario {

	private Processo processo;
	private int nivelPermissao;
}
