package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.DAOFactory;
import br.com.fiap.dao.interfaces.EnderecoDAO;

/**
 * Esta classe e utilizada para validar os enderecos antes de envia-los ao banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class EnderecoBO {
	
	private EnderecoDAO enderecoDAO = null;
	
	public EnderecoBO() {
		enderecoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getEnderecoDAO();
	}

	/**
	 * Metodo para validar um endereco
	 * @param endereco Endereco a ser validado
	 * @throws Exception
	 */
	public void validarEndereco(Endereco endereco) throws Exception{
		if (endereco.getSiglaEstado() == null || endereco.getSiglaEstado().trim().length() != 2) {
			throw new Exception("A sigla do Estado deve ter 2 caracteres.");
		}
		
		if (endereco.getNomeCidade() == null || endereco.getNomeCidade().trim().length() < 3 || endereco.getNomeCidade().trim().length() > 30) {
			throw new Exception("O nome da cidade deve ter entre 3 e 30 caracteres.");
		}
		
		if (endereco.getNomeBairro() == null || endereco.getNomeBairro().trim().length() < 3 || endereco.getNomeBairro().trim().length() > 30) {
			throw new Exception("O nome do bairro deve ter entre 3 e 30 caracteres.");
		}
		
		if (endereco.getLogradouro() == null || endereco.getLogradouro().trim().length() < 6 || endereco.getLogradouro().trim().length() > 40) {
			throw new Exception("O logradouro deve ter entre 6 e 40 caracteres.");
		}
		
		if (endereco.getNumeroResidencia() == null || endereco.getNumeroResidencia() < 0 || endereco.getNumeroResidencia() > 99999) {
			throw new Exception("O numero de residencia deve ser positivo, e possuir no maximo 5 digitos.");
		}
	}
	
	/**
	 * Metodo para validar um endereco antes de cadastra-lo no banco
	 * @param endereco Endereco a ser validado
	 * @throws Exception
	 */
	public void cadastrar(Endereco endereco) throws Exception {
		validarEndereco(endereco);
		enderecoDAO.cadastrar(endereco);
	}
	
	/**
	 * Metodo para validar um endereco antes de edita-lo no banco
	 * @param endereco Endereco a ser validado
	 * @throws Exception
	 */
	public void editar(Endereco endereco) throws Exception {
		validarEndereco(endereco);
		if (endereco.getCodigo() <= 0 || endereco.getCodigo() > 999) {
			throw new Exception("Informe um codigo de endereco valido.");
		}
		enderecoDAO.editar(endereco);
	}
	
	/**
	 * Metodo para retornar enderecos cadastrados no banco
	 * @return Uma lista com os enderecos cadastrados no banco
	 */
	public List<Endereco> listar() {
		return enderecoDAO.listar();
	}
	
	/**
	 * Metodo para validar o codigo de um endereco antes de exclui-lo do banco
	 * @param codigoEndereco Codigo do endereco a ser excluido
	 * @throws Exception
	 */
	public void excluir(int codigoEndereco) throws Exception {
		if (codigoEndereco <= 0 || codigoEndereco > 999) {
			throw new Exception("Informe um codigo de endereco valido.");
		}
		enderecoDAO.excluir(codigoEndereco);
	}
	
	/**
	 * Metodo para validar o codigo de um endereco antes de busca-lo no banco
	 * @param codigoEndereco Codigo a ser validado
	 * @return Endereco buscado no banco
	 * @throws Exception
	 */
	public Endereco buscar(int codigoEndereco) throws Exception {
		if (codigoEndereco <= 0 || codigoEndereco > 999) {
			throw new Exception("Informe um codigo de endereco valido.");
		}
		return enderecoDAO.buscar(codigoEndereco);
	}
}
