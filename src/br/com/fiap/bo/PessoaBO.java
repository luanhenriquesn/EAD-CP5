package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.beans.Pessoa;
import br.com.fiap.dao.DAOFactory;
import br.com.fiap.dao.interfaces.PessoaDAO;

/**
 * Esta classe e utilizada para validar as pessoas antes de envia-las ao banco
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class PessoaBO {
	
	private PessoaDAO pessoaDAO = null;
	
	public PessoaBO() {
		pessoaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getPessoaDAO();
	}

	/**
	 * Metodo para validar uma pessoa
	 * @param pessoa Pessoa a ser validada
	 * @throws Exception
	 */
	public void validarPessoa(Pessoa pessoa) throws Exception{
		if (pessoa.getNome() == null || pessoa.getNome().trim().length() < 3 || pessoa.getNome().trim().length() > 50) {
			throw new Exception("O nome da pessoa deve ter entre 3 e 50 caracteres.");
		}
		
		if (pessoa.getAnoNascimento() == null || pessoa.getAnoNascimento() < 0 || pessoa.getAnoNascimento() > 9999 ) {
			throw new Exception("O ano de nascimento da pessoa deve ser positivo, e possuir no maximo 4 digitos.");
		}
		
		if (pessoa.getSexo() == null || (pessoa.getSexo() != 'M' && pessoa.getSexo() != 'F')) {
			throw new Exception("O sexo informado deve ser 'M' (Masculino) ou 'F'(Feminino).");
		}
		
		if (pessoa.getCorOlho() == null || pessoa.getCorOlho().trim().length() < 3 || pessoa.getCorOlho().trim().length() > 20) {
			throw new Exception("A cor do olho deve ter entre 3 e 20 caracteres.");
		}
		
		if (pessoa.getCorPele() == null || pessoa.getCorPele().trim().length() < 3 || pessoa.getCorPele().trim().length() > 20) {
			throw new Exception("A cor da pele deve ter entre 3 e 20 caracteres.");
		}
		
		if (pessoa.getCorCabelo() == null || pessoa.getCorCabelo().trim().length() < 3 || pessoa.getCorCabelo().trim().length() > 20) {
			throw new Exception("A cor do cabelo deve ter entre 3 e 20 caracteres.");
		}
		
	}
	
	/**
	 * Metodo para validar uma pessoa antes de cadastra-la no banco
	 * @param pessoa Pessoa a ser validada
	 * @throws Exception
	 */
	public void cadastrar(Pessoa pessoa) throws Exception {
		validarPessoa(pessoa);
		pessoaDAO.cadastrar(pessoa);
	}
	
	/**
	 * Metodo para validar uma pessoa antes de edita-la no banco
	 * @param pessoa Pessoa a ser validada
	 * @throws Exception
	 */
	public void editar(Pessoa pessoa) throws Exception {
		validarPessoa(pessoa);
		if (pessoa.getCodigo() <= 0 || pessoa.getCodigo() > 999) {
			throw new Exception("Informe um codigo de pessoa valido.");
		}
		pessoaDAO.editar(pessoa);
	}
	
	/**
	 * Metodo para retornar pessoas cadastradas no banco
	 * @return Uma lista com as pessoas cadastradas no banco
	 */
	public List<Pessoa> listar() {
		return pessoaDAO.listar();
	}
	
	/**
	 * Metodo para validar o codigo de uma pessoa antes de exclui-la do banco
	 * @param codigoPessoa Codigo da pessoa a ser excluida
	 * @throws Exception
	 */
	public void excluir(int codigoPessoa) throws Exception {
		if (codigoPessoa <= 0 || codigoPessoa > 999) {
			throw new Exception("Informe um codigo de pessoa valido.");
		}
		pessoaDAO.excluir(codigoPessoa);
	}
	
	/**
	 * Metodo para validar o codigo de uma pessoa antes de busca-la no banco
	 * @param codigoPessoa Codigo a ser validado
	 * @return Pessoa buscada no banco
	 * @throws Exception
	 */
	public Pessoa buscar(int codigoPessoa) throws Exception {
		if (codigoPessoa <= 0 || codigoPessoa > 999) {
			throw new Exception("Informe um codigo de pessoa valido.");
		}
		return pessoaDAO.buscar(codigoPessoa);
	}
}
