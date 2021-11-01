package br.com.fiap.beans;

import java.io.Serializable;

/**
 * Esta classe e utilizada para representar um Carro
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
@SuppressWarnings("serial")
public class Carro implements Serializable{
	private Integer codigo;
	private Pessoa dono;
	private String nomeFabricante;
	private String nomeModelo;
	private Integer anoFabricacao;
	private String cor;
	
	
	public Carro() {
		super();
	}

	public Carro(Pessoa dono, String nomeFabricante, String nomeModelo, Integer anoFabricacao, String cor) {
		super();
		this.dono = dono;
		this.nomeFabricante = nomeFabricante;
		this.nomeModelo = nomeModelo;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
	}

	public Carro(Integer codigo, Pessoa dono, String nomeFabricante, String nomeModelo, Integer anoFabricacao,
			String cor) {
		super();
		this.codigo = codigo;
		this.dono = dono;
		this.nomeFabricante = nomeFabricante;
		this.nomeModelo = nomeModelo;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
	}

	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Pessoa getDono() {
		return dono;
	}
	
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	
	public String getNomeFabricante() {
		return nomeFabricante;
	}
	
	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}
	
	public String getNomeModelo() {
		return nomeModelo;
	}
	
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
