package br.com.fiap.beans;

import java.io.Serializable;

/**
 * Esta classe e utilizada para representar um Personagem
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
@SuppressWarnings("serial")
public abstract class Personagem implements Serializable{
	private Integer codigo;
	private String nome;
	private Integer anoNascimento;
	private Character sexo;
	private String corOlho;
	
	
	public Personagem() {
		super();
	}

	public Personagem(String nome, Integer anoNascimento, Character sexo, String corOlho) {
		super();
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.sexo = sexo;
		this.corOlho = corOlho;
	}

	public Personagem(Integer codigo, String nome, Integer anoNascimento, Character sexo, String corOlho) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.sexo = sexo;
		this.corOlho = corOlho;
	}

	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(Integer anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public String getCorOlho() {
		return corOlho;
	}

	public void setCorOlho(String corOlho) {
		this.corOlho = corOlho;
	}
	
	
}
