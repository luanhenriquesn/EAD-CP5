package br.com.fiap.dao.impl.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Carro;
import br.com.fiap.beans.Pessoa;
import br.com.fiap.dao.interfaces.CarroDAO;

/**
 * Esta classe e utilizada para manipular os carros no banco Oracle.
 * @author Luan Henrique S. Neves
 * @since 17/11/2020
 */
public class OracleCarroDAO implements CarroDAO {
	
	/**
	 * Metodo para cadastrar um carro no banco de dados
	 * @param carro O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void cadastrar(Carro carro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO T_BTTF_CARRO (CD_CARRO, CD_PESSOA, NM_FABRICANTE, NM_MODELO, NR_ANO_FABRICACAO, DS_COR) "
					+ "VALUES (SQ_CARRO.NEXTVAL, ?, ?, ?, ?, ?)";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, carro.getDono().getCodigo());
			stmt.setString(2, carro.getNomeFabricante());
			stmt.setString(3, carro.getNomeModelo());
			stmt.setInt(4, carro.getAnoFabricacao());
			stmt.setString(5, carro.getCor());
			
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir o carro no banco: " + e.getMessage());

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
	 * Metodo para editar um Carro no banco de dados
	 * @param carro O objeto que sera utilizado para passar as informacoes para o banco
	 */
	@Override
	public void editar(Carro carro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "UPDATE T_BTTF_CARRO SET CD_PESSOA = ?, NM_FABRICANTE = ? , NM_MODELO = ?, NR_ANO_FABRICACAO = ?, DS_COR = ? WHERE CD_CARRO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, carro.getDono().getCodigo());
			stmt.setString(2, carro.getNomeFabricante());
			stmt.setString(3, carro.getNomeModelo());
			stmt.setInt(4, carro.getAnoFabricacao());
			stmt.setString(5, carro.getCor());
			stmt.setInt(6, carro.getCodigo());
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel editar o carro no banco: " + e.getMessage());

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
	 * Metodo para buscar todos os Carros no banco
	 * @return Uma lista de Carros cadastrados no banco
	 */
	@Override
	public List<Carro> listar() {
		Connection conn = null;
		List<Carro> carros = new ArrayList<Carro>();
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT CD_CARRO, CD_PESSOA, NM_FABRICANTE, NM_MODELO, NR_ANO_FABRICACAO, DS_COR FROM T_BTTF_CARRO";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Carro carro = new Carro();
				
				carro.setCodigo(rs.getInt("CD_CARRO"));
				Pessoa pessoa = new Pessoa();
				pessoa.setCodigo(rs.getInt("CD_PESSOA"));
				carro.setDono(pessoa);
				carro.setNomeFabricante(rs.getString("NM_FABRICANTE"));
				carro.setNomeModelo(rs.getString("NM_MODELO"));
				carro.setAnoFabricacao(rs.getInt("NR_ANO_FABRICACAO"));
				carro.setCor(rs.getString("DS_COR"));
				
				carros.add(carro);
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel listar os carros do banco: " + e.getMessage());
			
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.err.println("Nao foi possivel fechar a conexao: " + e.getMessage());
				}
			}
		}
		return carros;
	}

	/**
	 * Metodo para excluir um Carro no banco de dados pelo seu codigo
	 * @param codigoCarro O codigo do Carro que deve ser excluido do Banco
	 */
	@Override
	public void excluir(int codigoCarro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			String sql = "DELETE FROM T_BTTF_CARRO WHERE CD_CARRO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, codigoCarro);
			
			stmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel excluir o carro do banco: " + e.getMessage());

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
	 * Metodo para buscar um Carro pelo codigo no banco de dados
	 * @param codigoCarro O codigo do Carro a ser buscado no banco
	 * @return O Carro buscado
	 */
	@Override
	public Carro buscar(int codigoCarro) {
		Connection conn = null;
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			String sql = "SELECT CD_PESSOA, NM_FABRICANTE, NM_MODELO, NR_ANO_FABRICACAO, DS_COR FROM T_BTTF_CARRO WHERE CD_CARRO = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, codigoCarro);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				Carro carro = new Carro();
				
				carro.setCodigo(codigoCarro);
				Pessoa pessoa = new Pessoa();
				pessoa.setCodigo(rs.getInt("CD_PESSOA"));
				carro.setDono(pessoa);
				carro.setNomeFabricante(rs.getString("NM_FABRICANTE"));
				carro.setNomeModelo(rs.getString("NM_MODELO"));
				carro.setAnoFabricacao(rs.getInt("NR_ANO_FABRICACAO"));
				carro.setCor(rs.getString("DS_COR"));
	
				return carro;
			}
			
		} catch (Exception e) {
			System.err.println("Nao foi possivel buscar o carro no banco: " + e.getMessage());
			
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
