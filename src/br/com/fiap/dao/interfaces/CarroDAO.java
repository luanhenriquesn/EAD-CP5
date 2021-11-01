package br.com.fiap.dao.interfaces;

import java.util.List;

import br.com.fiap.beans.Carro;

/**
 * Esta interface e utilizada para impor metodos a todas as classes que manipulam Carro no banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public interface CarroDAO {
	
	void cadastrar(Carro carro);
	
	void editar(Carro carro);
	
	List<Carro> listar();
	
	void excluir(int codigoCarro);
	
	Carro buscar(int codigoCarro);
}
