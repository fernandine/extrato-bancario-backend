package br.com.banco.DTOs;

import java.io.Serializable;

import br.com.banco.entity.Conta;


public class ContaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome_responsavel;
	
	public ContaDTO() {
	}
	
	public ContaDTO(Conta entity) {
		id = entity.getId();
		nome_responsavel = entity.getNome_responsavel();
	}


	public ContaDTO(Long id,  String nome_responsavel) {
		super();
		this.id = id;
		this.nome_responsavel = nome_responsavel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

}