package br.com.fiap.dao.interfaces;

import java.util.List;

import br.com.fiap.beans.Cachorro;

/**
 * Esta interface e utilizada para impor metodos a todas as classes que manipulam Cachorro no banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public interface CachorroDAO {
	
	void cadastrar(Cachorro cachorro);
	
	void editar(Cachorro cachorro);
	
	List<Cachorro> listar();
	
	void excluir(int codigoCachorro);
	
	Cachorro buscar(int codigoCachorro);
}
