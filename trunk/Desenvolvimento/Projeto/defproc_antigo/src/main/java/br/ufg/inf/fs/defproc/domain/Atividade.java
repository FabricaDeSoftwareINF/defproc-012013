package br.ufg.inf.fs.defproc.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Classe que representa a entidade Atividade.
 * @author Natan Pimenta
 *
 */
@Data
public class Atividade {

	private long id;
	private String nome;
	private String descricao;
	private Date criterioEntrada;
	private Date criterioSaida;
	private Date dataEntrega;
	private int status;
	private Processo processoRelacionado;
	private List<FerramentasDaAtividade> listaFerramentas;
	
}
