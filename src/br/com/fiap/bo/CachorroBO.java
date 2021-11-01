package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Cachorro;
import br.com.fiap.dao.DAOFactory;
import br.com.fiap.dao.interfaces.CachorroDAO;

/**
 * Esta classe e utilizada para validar os cachorros antes de envia-los ao banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class CachorroBO {
	
	private CachorroDAO cachorroDAO = null;
	
	public CachorroBO() {
		cachorroDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getCachorroDAO();
	}

	/**
	 * Metodo para validar um cachorro
	 * @param cachorro Cachorro a ser validado
	 * @throws Exception
	 */
	public void validarCachorro(Cachorro cachorro) throws Exception{
		if (cachorro.getNome() == null || cachorro.getNome().trim().length() < 3 || cachorro.getNome().trim().length() > 30) {
			throw new Exception("O nome do cachorro deve ter entre 3 e 30 caracteres.");
		}
		
		if (cachorro.getAnoNascimento() == null || cachorro.getAnoNascimento() < 0 || cachorro.getAnoNascimento() > 9999 ) {
			throw new Exception("O ano de nascimento do cachorro deve ser positivo, e possuir no maximo 4 digitos.");
		}
		
		if (cachorro.getSexo() == null || (cachorro.getSexo() != 'M' && cachorro.getSexo() != 'F')) {
			throw new Exception("O sexo informado deve ser 'M' (Masculino) ou 'F'(Feminino).");
		}
		
		if (cachorro.getCorOlho() == null || cachorro.getCorOlho().trim().length() < 3 || cachorro.getCorOlho().trim().length() > 20) {
			throw new Exception("A cor do olho deve ter entre 3 e 20 caracteres.");
		}
		
		if (cachorro.getRaca() == null || cachorro.getRaca().trim().length() < 3 || cachorro.getRaca().trim().length() > 30) {
			throw new Exception("O nome da raca do cachorro deve ter entre 3 e 30 caracteres.");
		}
		
		if (cachorro.getCorPelo() == null || cachorro.getCorPelo().trim().length() < 3 || cachorro.getCorPelo().trim().length() > 20) {
			throw new Exception("A cor do pelo deve ter entre 3 e 20 caracteres.");
		}
	}
	
	/**
	 * Metodo para validar um cachorro antes de cadastra-lo no banco
	 * @param cachorro Cachorro a ser validado
	 * @throws Exception
	 */
	public void cadastrar(Cachorro cachorro) throws Exception {
		validarCachorro(cachorro);
		cachorroDAO.cadastrar(cachorro);
	}
	
	/**
	 * Metodo para validar um cachorro antes de edita-lo no banco
	 * @param cachorro Cachorro a ser validado
	 * @throws Exception
	 */
	public void editar(Cachorro cachorro) throws Exception {
		validarCachorro(cachorro);
		if (cachorro.getCodigo() <= 0 || cachorro.getCodigo() > 999) {
			throw new Exception("Informe um codigo de cachorro valido.");
		}
		cachorroDAO.editar(cachorro);
	}
	
	/**
	 * Metodo para retornar cachorros cadastrados no banco
	 * @return Uma lista com os cachorros cadastrados no banco
	 */
	public List<Cachorro> listar() {
		return cachorroDAO.listar();
	}
	
	/**
	 * Metodo para validar o codigo de um cachorro antes de exclui-lo do banco
	 * @param codigoCachorro Codigo do cachorro a ser excluido
	 * @throws Exception
	 */
	public void excluir(int codigoCachorro) throws Exception {
		if (codigoCachorro <= 0 || codigoCachorro > 999) {
			throw new Exception("Informe um codigo de cachorro valido.");
		}
		cachorroDAO.excluir(codigoCachorro);
	}
	
	/**
	 * Metodo para validar o codigo de um cachorro antes de busca-lo no banco
	 * @param codigoCachorro Codigo a ser validado
	 * @return Cachorro buscado no banco
	 * @throws Exception
	 */
	public Cachorro buscar(int codigoCachorro) throws Exception {
		if (codigoCachorro <= 0 || codigoCachorro > 999) {
			throw new Exception("Informe um codigo de cachorro valido.");
		}
		return cachorroDAO.buscar(codigoCachorro);
	}
}
