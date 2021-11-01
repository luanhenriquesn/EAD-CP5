package br.com.fiap.beans;

import java.io.Serializable;

/**
 * Esta classe e utilizada para representar um Endereco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
@SuppressWarnings("serial")
public class Endereco implements Serializable{
	private Integer codigo;
	private String siglaEstado;
	private String nomeCidade;
	private String nomeBairro;
	private String logradouro;
	private Integer numeroResidencia;
	
	
	public Endereco() {
		super();
	}

	public Endereco(String siglaEstado, String nomeCidade, String nomeBairro, String logradouro,
			Integer numeroResidencia) {
		super();
		this.siglaEstado = siglaEstado;
		this.nomeCidade = nomeCidade;
		this.nomeBairro = nomeBairro;
		this.logradouro = logradouro;
		this.numeroResidencia = numeroResidencia;
	}

	public Endereco(Integer codigo, String siglaEstado, String nomeCidade, String nomeBairro, String logradouro,
			Integer numeroResidencia) {
		super();
		this.codigo = codigo;
		this.siglaEstado = siglaEstado;
		this.nomeCidade = nomeCidade;
		this.nomeBairro = nomeBairro;
		this.logradouro = logradouro;
		this.numeroResidencia = numeroResidencia;
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getSiglaEstado() {
		return siglaEstado;
	}
	
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	
	public String getNomeCidade() {
		return nomeCidade;
	}
	
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
	public String getNomeBairro() {
		return nomeBairro;
	}
	
	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public Integer getNumeroResidencia() {
		return numeroResidencia;
	}
	
	public void setNumeroResidencia(Integer numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}
	
}
