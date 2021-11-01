package br.com.fiap.dao.impl.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cachorro;
import br.com.fiap.beans.Pessoa;
import br.com.fiap.dao.interfaces.CachorroDAO;

/**
 * Esta classe e utilizada para manipular os cachorros no banco Oracle.
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class OracleCachorroDAO implements CachorroDAO{
	
	/**
	 * Metodo para cadastrar um cachorro no banco de dados
	 * @param cachorro O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void cadastrar(Cachorro cachorro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO T_BTTF_CACHORRO (CD_CACHORRO, CD_PESSOA, NM_CACHORRO, DS_RACA, NR_ANO_NASCIMENTO, DS_SEXO, DS_COR_PELO, DS_COR_OLHO) "
					+ "VALUES (SQ_CACHORRO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cachorro.getDono().getCodigo());
			stmt.setString(2, cachorro.getNome());
			stmt.setString(3, cachorro.getRaca());
			stmt.setInt(4, cachorro.getAnoNascimento());
			stmt.setString(5, cachorro.getSexo().toString());
			stmt.setString(6, cachorro.getCorPelo());
			stmt.setString(7, cachorro.getCorOlho());
			
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir o cachorro no banco: " + e.getMessage());

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
	 * Metodo para editar um Cachorro no banco de dados
	 * @param cachorro O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void editar(Cachorro cachorro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE T_BTTF_CACHORRO SET CD_PESSOA = ? , NM_CACHORRO = ?, DS_RACA = ?, NR_ANO_NASCIMENTO = ?,"
					+ " DS_SEXO = ?, DS_COR_PELO = ?, DS_COR_OLHO = ? WHERE CD_CACHORRO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, cachorro.getDono().getCodigo());
			stmt.setString(2, cachorro.getNome());
			stmt.setString(3, cachorro.getRaca());
			stmt.setInt(4, cachorro.getAnoNascimento());
			stmt.setString(5, cachorro.getSexo().toString());
			stmt.setString(6, cachorro.getCorPelo());
			stmt.setString(7, cachorro.getCorOlho());
			stmt.setInt(8, cachorro.getCodigo());
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel editar o cachorro no banco: " + e.getMessage());

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
	 * Metodo para buscar todos os Cachorros no banco
	 * @return Uma lista de Cachorros cadastrados no banco
	 */
	@Override
	public List<Cachorro> listar() {
		Connection conn = null;
		List<Cachorro> cachorros = new ArrayList<Cachorro>();
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT CD_CACHORRO, CD_PESSOA, NM_CACHORRO, DS_RACA, NR_ANO_NASCIMENTO, DS_SEXO, DS_COR_PELO, DS_COR_OLHO FROM T_BTTF_CACHORRO";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Cachorro cachorro = new Cachorro();
				
				cachorro.setCodigo(rs.getInt("CD_CACHORRO"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCodigo(rs.getInt("CD_PESSOA"));
				cachorro.setDono(pessoa);
				cachorro.setNome(rs.getString("NM_CACHORRO"));
				cachorro.setRaca(rs.getString("DS_RACA"));
				cachorro.setAnoNascimento(rs.getInt("NR_ANO_NASCIMENTO"));
				cachorro.setSexo(rs.getString("DS_SEXO").charAt(0));
				cachorro.setCorPelo(rs.getString("DS_COR_PELO"));
				cachorro.setCorOlho(rs.getString("DS_COR_OLHO"));
				
				cachorros.add(cachorro);
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel listar os cachorros do banco: " + e.getMessage());
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
		return cachorros;
	}

	/**
	 * Metodo para excluir um Cachorro no banco de dados pelo seu codigo
	 * @param codigoCachorro O codigo do Cachorro que deve ser excluido do Banco
	 */
	@Override
	public void excluir(int codigoCachorro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM T_BTTF_CACHORRO WHERE CD_CACHORRO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codigoCachorro);
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel excluir o cachorro do banco: " + e.getMessage());

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
	 * Metodo para buscar um Cachorro pelo codigo no banco de dados
	 * @param codigoCachorro O codigo do Cachorro a ser buscado no banco
	 * @return O Cachorro buscado
	 */
	@Override
	public Cachorro buscar(int codigoCachorro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT CD_PESSOA, NM_CACHORRO, DS_RACA, NR_ANO_NASCIMENTO, DS_SEXO, DS_COR_PELO, DS_COR_OLHO FROM T_BTTF_CACHORRO WHERE CD_CACHORRO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigoCachorro);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Cachorro cachorro = new Cachorro();
				
				cachorro.setCodigo(codigoCachorro);
				Pessoa pessoa = new Pessoa();
				pessoa.setCodigo(rs.getInt("CD_PESSOA"));
				cachorro.setDono(pessoa);
				cachorro.setNome(rs.getString("NM_CACHORRO"));
				cachorro.setRaca(rs.getString("DS_RACA"));
				cachorro.setAnoNascimento(rs.getInt("NR_ANO_NASCIMENTO"));
				cachorro.setSexo(rs.getString("DS_SEXO").charAt(0));
				cachorro.setCorPelo(rs.getString("DS_COR_PELO"));
				cachorro.setCorOlho(rs.getString("DS_COR_OLHO"));
	
				return cachorro;
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel buscar o cachorro no banco: " + e.getMessage());
			
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
