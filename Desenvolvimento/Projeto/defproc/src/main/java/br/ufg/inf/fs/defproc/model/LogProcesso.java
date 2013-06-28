package br.ufg.inf.fs.defproc.model;

import java.util.Date;

import lombok.Data;

/**
 * Classe que representa a entidade LogProcesso.
 * @author Natan Pimenta
 */
@Data
public class LogProcesso {

	private Processo processoRelacionado;
	private Date data;
	private String log;
}
