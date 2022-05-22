package br.com.banco.DTOs;

import java.io.Serializable;
import java.time.Instant;

import br.com.banco.entity.Transferencia;

public class TransferenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long id;
	private Instant data_transferencia;
	private Integer valor;
	private String tipo;
	private String nome_operador_transacao;
	private double conta_id;

	public TransferenciaDTO() {
	}

	public TransferenciaDTO(Transferencia x) {
		id = x.getId();
		data_transferencia = x.getData_transferencia();
		valor = x.getValor();
		tipo = x.getTipo();
		nome_operador_transacao = x.getNome_operador_transacao();
	}

	public TransferenciaDTO(Long id, Instant data_transferencia, Integer valor, String tipo,
			String nome_operador_transacao, double conta_id) {
		super();
		this.id = id;
		this.data_transferencia = data_transferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nome_operador_transacao = nome_operador_transacao;
		this.conta_id = conta_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(Instant data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}

	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}

	public double getConta_id() {
		return conta_id;
	}

	public void setConta_id(double conta_id) {
		this.conta_id = conta_id;
	}

	

}
