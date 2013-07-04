package br.ufg.inf.fs.defproc.domain;


import lombok.Data;

/**
 * Classe que representa a entidade Participante.
 * @author Natan Pimenta
 */
@Data
public class Participante {

	private Atividade atividade;
	private UsuarioSistema usuario;
}
