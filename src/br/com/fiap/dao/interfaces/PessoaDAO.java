package br.com.fiap.dao.interfaces;

import java.util.List;

import br.com.fiap.beans.Pessoa;

/**
 * Esta interface e utilizada para impor metodos a todas as classes que manipulam Pessoa no banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public interface PessoaDAO {
	
	void cadastrar(Pessoa pessoa);
	
	void editar(Pessoa pessoa);
	
	List<Pessoa> listar();
	
	void excluir(int codigoPessoa);
	
	Pessoa buscar(int codigoPessoa);
}
