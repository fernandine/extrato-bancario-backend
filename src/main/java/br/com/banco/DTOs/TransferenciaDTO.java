package br.com.banco.DTOs;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.banco.entity.Transferencia;
import lombok.NonNull;


public class TransferenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant data_transferencia;
	@NonNull
	private Integer valor;
	@NonNull
	private String tipo;
	@NonNull
	private String nome_operador_transacao;
	@NonNull
	private double conta;
	
	public TransferenciaDTO() {
	}
	
	public TransferenciaDTO(Transferencia x) {
		id = x.getId();
		data_transferencia = x.getData_transferencia();
		valor = x.getValor();
		tipo = x.getTipo();
		nome_operador_transacao = x.getNome_operador_transacao();
	}

	

	public TransferenciaDTO(Long id, Instant data_transferencia, @NonNull Integer valor, @NonNull String tipo,
			@NonNull String nome_operador_transacao, @NonNull double conta) {
		super();
		this.id = id;
		this.data_transferencia = data_transferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nome_operador_transacao = nome_operador_transacao;
		this.conta = conta;
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

	public double getConta() {
		return conta;
	}

	public void setConta(double conta) {
		this.conta = conta;
	}

}

	