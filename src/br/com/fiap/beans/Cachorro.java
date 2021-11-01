package br.com.fiap.beans;

import java.io.Serializable;

/**
 * Esta classe e utilizada para representar um Cachorro
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
@SuppressWarnings("serial")
public class Cachorro extends Personagem implements Serializable{
	private Pessoa dono;
	private String raca;
	private String corPelo;
	
	
	public Cachorro() {
		super();
	}

	public Cachorro(String nome, Integer anoNascimento, Character sexo, String corOlho, 
			Pessoa dono, String raca, String corPelo) {
		super(nome, anoNascimento, sexo, corOlho);
		this.dono = dono;
		this.raca = raca;
		this.corPelo = corPelo;
	}

	public Cachorro(Integer codigo, String nome, Integer anoNascimento, Character sexo, String corOlho, 
			Pessoa dono, String raca, String corPelo) {
		super(codigo, nome, anoNascimento, sexo, corOlho);
		this.dono = dono;
		this.raca = raca;
		this.corPelo = corPelo;
	}


	public Pessoa getDono() {
		return dono;
	}
	
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCorPelo() {
		return corPelo;
	}

	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}
	
}
