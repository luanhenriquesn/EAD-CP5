package br.com.fiap.dao;

import br.com.fiap.dao.interfaces.CachorroDAO;
import br.com.fiap.dao.interfaces.CarroDAO;
import br.com.fiap.dao.interfaces.EnderecoDAO;
import br.com.fiap.dao.interfaces.PessoaDAO;

/**
 * Esta classe e utilizada para manipular os DAOFactorys dos bancos
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public abstract class DAOFactory {
	public static final int ORACLE = 1;
	
	
	private static DAOFactory oracleDAOFactory = null;
	
	/**
	 * Metodo para retornar o DAOFactory do banco desejado
	 * @param banco Numero do banco desejado
	 * @return DAOFactory do banco, ou null
	 */
	public static DAOFactory getDAOFactory(int banco) {
		switch (banco) {
		case ORACLE:
			if (oracleDAOFactory == null) {
				oracleDAOFactory = new OracleDAOFactory();
			}
			return oracleDAOFactory;
			
		default:
			return null;
		}
	}
	
	
	public abstract PessoaDAO getPessoaDAO();
	public abstract CachorroDAO getCachorroDAO();
	public abstract EnderecoDAO getEnderecoDAO(); 
	public abstract CarroDAO getCarroDAO();
}
