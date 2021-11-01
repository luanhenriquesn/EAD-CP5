package br.com.fiap.dao;

import br.com.fiap.dao.impl.oracle.OracleCachorroDAO;
import br.com.fiap.dao.impl.oracle.OracleCarroDAO;
import br.com.fiap.dao.impl.oracle.OracleEnderecoDAO;
import br.com.fiap.dao.impl.oracle.OraclePessoaDAO;
import br.com.fiap.dao.interfaces.CachorroDAO;
import br.com.fiap.dao.interfaces.CarroDAO;
import br.com.fiap.dao.interfaces.EnderecoDAO;
import br.com.fiap.dao.interfaces.PessoaDAO;

/**
 * Esta classe e utilizada para retornar as classes DAO do banco Oracle
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class OracleDAOFactory extends DAOFactory{
	
	/**
	 * Metodo para retornar a classe que manipula Pessoas no banco Oracle
	 * @return PessoaDAO do banco Oracle
	 */
	@Override
	public PessoaDAO getPessoaDAO() {
		return new OraclePessoaDAO();
	}
	
	/**
	 * Metodo para retornar a classe que manipula Cachorros no banco Oracle
	 * @return CachorroDAO do banco Oracle
	 */
	@Override
	public CachorroDAO getCachorroDAO() {
		return new OracleCachorroDAO();
	}
	
	/**
	 * Metodo para retornar a classe que manipula Enderecos no banco Oracle
	 * @return EnderecoDAO do banco Oracle
	 */
	@Override
	public EnderecoDAO getEnderecoDAO() {
		return new OracleEnderecoDAO();
	}
	
	/**
	 * Metodo para retornar a classe que manipula Carros no banco Oracle
	 * @return CarroDAO do banco Oracle
	 */
	@Override
	public CarroDAO getCarroDAO() {
		return new OracleCarroDAO();
	}


}
