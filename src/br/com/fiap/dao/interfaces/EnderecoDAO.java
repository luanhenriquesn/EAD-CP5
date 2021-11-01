package br.com.fiap.dao.interfaces;

import java.util.List;

import br.com.fiap.beans.Endereco;

/**
 * Esta interface e utilizada para impor metodos a todas as classes que manipulam Endereco no banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public interface EnderecoDAO {
	
	void cadastrar(Endereco endereco);
	
	void editar(Endereco endereco);
	
	List<Endereco> listar();
	
	void excluir(int codigoEndereco);
	
	Endereco buscar(int codigoEndereco);
}
