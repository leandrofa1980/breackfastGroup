package br.com.leandrofa1980.breackfast.dto;

import java.io.Serializable;

import br.com.leandrofa1980.breackfast.entities.Participante;

public class ParticipanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	private String opcao;
	
	public ParticipanteDTO() {
		
	}

	public ParticipanteDTO(Long id, String nome, String cpf, String opcao) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.opcao = opcao;
	}
	
	public ParticipanteDTO(Participante entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cpf = entity.getCpf();
		this.opcao = entity.getOpcao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}
}
