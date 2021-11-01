package br.com.fiap.beans;

import java.io.Serializable;

/**
 * Esta classe e utilizada para representar uma Pessoa
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
@SuppressWarnings("serial")
public class Pessoa extends Personagem implements Serializable{
	private Endereco endereco;
	private String corPele;
	private String corCabelo;
	
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome, Integer anoNascimento, Character sexo, String corOlho, 
			Endereco endereco, String corPele, String corCabelo) {
		super(nome, anoNascimento, sexo, corOlho);
		this.endereco = endereco;
		this.corPele = corPele;
		this.corCabelo = corCabelo;
	}
	
	public Pessoa(Integer codigo, String nome, Integer anoNascimento, Character sexo, String corOlho, 
			Endereco endereco, String corPele, String corCabelo) {
		super(codigo, nome, anoNascimento, sexo, corOlho);
		this.endereco = endereco;
		this.corPele = corPele;
		this.corCabelo = corCabelo;
	}

	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCorPele() {
		return corPele;
	}

	public void setCorPele(String corPele) {
		this.corPele = corPele;
	}

	public String getCorCabelo() {
		return corCabelo;
	}

	public void setCorCabelo(String corCabelo) {
		this.corCabelo = corCabelo;
	}
	
	
}
