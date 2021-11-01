package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Carro;
import br.com.fiap.dao.DAOFactory;
import br.com.fiap.dao.interfaces.CarroDAO;

/**
 * Esta classe e utilizada para validar os carros antes de envia-los ao banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class CarroBO {
	
	private CarroDAO carroDAO = null;
	
	public CarroBO() {
		carroDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getCarroDAO();
	}

	/**
	 * Metodo para validar um carro
	 * @param carro Carro a ser validado
	 * @throws Exception
	 */
	public void validarCarro(Carro carro) throws Exception{
		if (carro.getNomeFabricante() == null || carro.getNomeFabricante().trim().length() < 3 || carro.getNomeFabricante().trim().length() > 30) {
			throw new Exception("O nome do fabricante do carro deve ter entre 3 e 30 caracteres.");
		}
		
		if (carro.getNomeModelo() == null || carro.getNomeModelo().trim().length() < 3 || carro.getNomeModelo().trim().length() > 30) {
			throw new Exception("O nome do modelo do carro deve ter entre 3 e 30 caracteres.");
		}
		
		if (carro.getAnoFabricacao() == null || carro.getAnoFabricacao() < 0 || carro.getAnoFabricacao() > 9999) {
			throw new Exception("O ano de fabricacao do carro deve ser positivo, e possuir no maximo 4 digitos");
		}
		
		if (carro.getCor() == null || carro.getCor().trim().length() < 3 || carro.getCor().trim().length() > 20) {
			throw new Exception("A cor do carro deve ter entre 3 e 20 caracteres.");
		}
	}
	
	/**
	 * Metodo para validar um carro antes de cadastra-lo no banco
	 * @param carro Carro a ser validado
	 * @throws Exception
	 */
	public void cadastrar(Carro carro) throws Exception {
		validarCarro(carro);
		carroDAO.cadastrar(carro);
	}
	
	/**
	 * Metodo para validar um carro antes de edita-lo no banco
	 * @param carro Carro a ser validado
	 * @throws Exception
	 */
	public void editar(Carro carro) throws Exception {
		validarCarro(carro);
		if (carro.getCodigo() <= 0 || carro.getCodigo() > 999) {
			throw new Exception("Informe um codigo de carro valido.");
		}
		carroDAO.editar(carro);
	}
	
	/**
	 * Metodo para retornar carros cadastrados no banco
	 * @return Uma lista com os carros cadastrados no banco
	 */
	public List<Carro> listar() {
		return carroDAO.listar();
	}
	
	/**
	 * Metodo para validar o codigo de um carro antes de exclui-lo do banco
	 * @param codigoCarro Codigo do carro a ser excluido
	 * @throws Exception
	 */
	public void excluir(int codigoCarro) throws Exception {
		if (codigoCarro <= 0 || codigoCarro > 999) {
			throw new Exception("Informe um codigo de carro valido.");
		}
		carroDAO.excluir(codigoCarro);
	}
	
	/**
	 * Metodo para validar o codigo de um carro antes de busca-lo no banco
	 * @param codigoCarro Codigo a ser validado
	 * @return Carro buscado no banco
	 * @throws Exception
	 */
	public Carro buscar(int codigoCarro) throws Exception {
		if (codigoCarro <= 0 || codigoCarro > 999) {
			throw new Exception("Informe um codigo de carro valido.");
		}
		return carroDAO.buscar(codigoCarro);
	}
}

