package br.com.fiap.dao.impl.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Endereco;
import br.com.fiap.beans.Pessoa;
import br.com.fiap.dao.interfaces.PessoaDAO;

/**
 * Esta classe e utilizada para manipular as pessoas no banco Oracle.
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class OraclePessoaDAO implements PessoaDAO {
	
	/**
	 * Metodo para cadastrar uma Pessoa no banco de dados
	 * @param pessoa O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void cadastrar(Pessoa pessoa) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO T_BTTF_PESSOA (CD_PESSOA, CD_ENDERECO, NM_PESSOA, NR_ANO_NASCIMENTO, DS_SEXO, DS_COR_PELE, DS_COR_CABELO, DS_COR_OLHO) "
					+ "VALUES (SQ_PESSOA.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pessoa.getEndereco().getCodigo());
			stmt.setString(2, pessoa.getNome());
			stmt.setInt(3, pessoa.getAnoNascimento());
			stmt.setString(4, pessoa.getSexo().toString());
			stmt.setString(5, pessoa.getCorPele());
			stmt.setString(6, pessoa.getCorCabelo());
			stmt.setString(7, pessoa.getCorOlho());
			
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir a pessoa no banco: " + e.getMessage());

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("Nao foi possivel efetuar o rollback: " + e.getMessage());
			}
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
	}

	/**
	 * Metodo para editar uma Pessoa no banco de dados
	 * @param pessoa O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void editar(Pessoa pessoa) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE T_BTTF_PESSOA SET CD_ENDERECO = ?, NM_PESSOA = ? , NR_ANO_NASCIMENTO = ?, DS_SEXO = ?, DS_COR_PELE = ?,"
					+ " DS_COR_CABELO = ?, DS_COR_OLHO = ? WHERE CD_PESSOA = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, pessoa.getEndereco().getCodigo());
			stmt.setString(2, pessoa.getNome());
			stmt.setInt(3, pessoa.getAnoNascimento());
			stmt.setString(4, pessoa.getSexo().toString());
			stmt.setString(5, pessoa.getCorPele());
			stmt.setString(6, pessoa.getCorCabelo());
			stmt.setString(7, pessoa.getCorOlho());
			stmt.setInt(8, pessoa.getCodigo());
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel editar a pessoa no banco: " + e.getMessage());

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("Nao foi possivel efetuar o rollback: " + e.getMessage());
			}
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
	}

	/**
	 * Metodo para buscar todas as Pessoas no banco
	 * @return Uma lista de Pessoas cadastradas no banco
	 */
	@Override
	public List<Pessoa> listar() {
		Connection conn = null;
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT CD_PESSOA, CD_ENDERECO, NM_PESSOA, NR_ANO_NASCIMENTO, DS_SEXO, DS_COR_PELE, DS_COR_CABELO, DS_COR_OLHO FROM T_BTTF_PESSOA";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setCodigo(rs.getInt("CD_PESSOA"));
				Endereco endereco = new Endereco();
				endereco.setCodigo(rs.getInt("CD_ENDERECO"));
				pessoa.setEndereco(endereco);
				pessoa.setNome(rs.getString("NM_PESSOA"));
				pessoa.setAnoNascimento(rs.getInt("NR_ANO_NASCIMENTO"));
				pessoa.setSexo(rs.getString("DS_SEXO").charAt(0));
				pessoa.setCorPele(rs.getString("DS_COR_PELE"));
				pessoa.setCorCabelo(rs.getString("DS_COR_CABELO"));
				pessoa.setCorOlho(rs.getString("DS_COR_OLHO"));
				
				pessoas.add(pessoa);
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel listar as pessoas do banco: " + e.getMessage());
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
		return pessoas;
	}

	/**
	 * Metodo para excluir uma Pessoa no banco de dados pelo seu codigo
	 * @param codigoPessoa O codigo da Pessoa que deve ser excluida do Banco
	 */
	@Override
	public void excluir(int codigoPessoa) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM T_BTTF_PESSOA WHERE CD_PESSOA = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codigoPessoa);
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel excluir a pessoa do banco: " + e.getMessage());

			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.err.println("Nao foi possivel efetuar o rollback: " + e.getMessage());
			}
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
	}

	/**
	 * Metodo para buscar uma Pessoa pelo codigo no banco de dados
	 * @param codigoPessoa O codigo da Pessoa a ser buscada no banco
	 * @return A Pessoa buscada
	 */
	@Override
	public Pessoa buscar(int codigoPessoa) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT CD_ENDERECO, NM_PESSOA, NR_ANO_NASCIMENTO, DS_SEXO, DS_COR_PELE, DS_COR_CABELO, DS_COR_OLHO FROM T_BTTF_PESSOA WHERE CD_PESSOA = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigoPessoa);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Pessoa pessoa = new Pessoa();
				
				pessoa.setCodigo(codigoPessoa);
				Endereco endereco = new Endereco();
				endereco.setCodigo(rs.getInt("CD_ENDERECO"));
				pessoa.setEndereco(endereco);
				pessoa.setNome(rs.getString("NM_PESSOA"));
				pessoa.setAnoNascimento(rs.getInt("NR_ANO_NASCIMENTO"));
				pessoa.setSexo(rs.getString("DS_SEXO").charAt(0));
				pessoa.setCorPele(rs.getString("DS_COR_PELE"));
				pessoa.setCorCabelo(rs.getString("DS_COR_CABELO"));
				pessoa.setCorOlho(rs.getString("DS_COR_OLHO"));
	
				return pessoa;
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel buscar a pessoa no banco: " + e.getMessage());
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
		return null;
	}

}
