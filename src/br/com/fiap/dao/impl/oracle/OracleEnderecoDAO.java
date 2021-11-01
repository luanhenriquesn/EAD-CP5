package br.com.fiap.dao.impl.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Endereco;
import br.com.fiap.dao.interfaces.EnderecoDAO;

/**
 * Esta classe e utilizada para manipular os enderecos no banco Oracle.
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class OracleEnderecoDAO implements EnderecoDAO {
	
	/**
	 * Metodo para cadastrar um endereco no banco de dados
	 * @param endereco O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void cadastrar(Endereco endereco) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO T_BTTF_ENDERECO (CD_ENDERECO, SG_ESTADO, NM_CIDADE, NM_BAIRRO, DS_LOGRADOURO, NR_RESIDENCIA) "
					+ "VALUES (SQ_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, endereco.getSiglaEstado());
			stmt.setString(2, endereco.getNomeCidade());
			stmt.setString(3, endereco.getNomeBairro());
			stmt.setString(4, endereco.getLogradouro());
			stmt.setInt(5, endereco.getNumeroResidencia());
			
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir o endereco no banco: " + e.getMessage());

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
	 * Metodo para editar um Endereco no banco de dados
	 * @param endereco O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void editar(Endereco endereco) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
					
			String sql = "UPDATE T_BTTF_ENDERECO SET SG_ESTADO = ?, NM_CIDADE = ? , NM_BAIRRO = ?, DS_LOGRADOURO = ?, NR_RESIDENCIA = ? WHERE CD_ENDERECO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, endereco.getSiglaEstado());
			stmt.setString(2, endereco.getNomeCidade());
			stmt.setString(3, endereco.getNomeBairro());
			stmt.setString(4, endereco.getLogradouro());
			stmt.setInt(5, endereco.getNumeroResidencia());
			stmt.setInt(6, endereco.getCodigo());
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel editar o endereco no banco: " + e.getMessage());

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
	 * Metodo para buscar todos os Enderecos no banco
	 * @return Uma lista de Enderecos cadastrados no banco
	 */
	@Override
	public List<Endereco> listar() {
		Connection conn = null;
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT CD_ENDERECO, SG_ESTADO, NM_CIDADE, NM_BAIRRO, DS_LOGRADOURO, NR_RESIDENCIA FROM T_BTTF_ENDERECO";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Endereco endereco = new Endereco();
				
				endereco.setCodigo(rs.getInt("CD_ENDERECO"));
				endereco.setSiglaEstado(rs.getString("SG_ESTADO"));
				endereco.setNomeCidade(rs.getString("NM_CIDADE"));
				endereco.setNomeBairro(rs.getString("NM_BAIRRO"));
				endereco.setLogradouro(rs.getString("DS_LOGRADOURO"));
				endereco.setNumeroResidencia(rs.getInt("NR_RESIDENCIA"));
				
				enderecos.add(endereco);
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel listar os enderecos do banco: " + e.getMessage());
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
		return enderecos;
	}

	/**
	 * Metodo para excluir um Endereco no banco de dados pelo seu codigo
	 * @param codigoEndereco O codigo do Endereco que deve ser excluido do Banco
	 */
	@Override
	public void excluir(int codigoEndereco) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM T_BTTF_ENDERECO WHERE CD_ENDERECO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codigoEndereco);
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel excluir o endereco do banco: " + e.getMessage());

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
	 * Metodo para buscar um Endereco pelo codigo no banco de dados
	 * @param codigoEndereco O codigo do Endereco a ser buscado no banco
	 * @return O Endereco buscado
	 */
	@Override
	public Endereco buscar(int codigoEndereco) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT SG_ESTADO, NM_CIDADE, NM_BAIRRO, DS_LOGRADOURO, NR_RESIDENCIA FROM T_BTTF_ENDERECO WHERE CD_ENDERECO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigoEndereco);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Endereco endereco = new Endereco();
				
				endereco.setCodigo(codigoEndereco);
				endereco.setSiglaEstado(rs.getString("SG_ESTADO"));
				endereco.setNomeCidade(rs.getString("NM_CIDADE"));
				endereco.setNomeBairro(rs.getString("NM_BAIRRO"));
				endereco.setLogradouro(rs.getString("DS_LOGRADOURO"));
				endereco.setNumeroResidencia(rs.getInt("NR_RESIDENCIA"));
	
				return endereco;
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel buscar o endereco no banco: " + e.getMessage());
			
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
