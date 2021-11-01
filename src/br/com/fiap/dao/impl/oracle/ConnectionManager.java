package br.com.fiap.dao.impl.oracle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Gerenciador de conexao com o banco de dados Oracle.
 * Esta classe e utilizada nas classes DAO para o Oracle.
 */
public class ConnectionManager {
    
	private static ConnectionManager instance;
    
        
    private ConnectionManager() throws ClassNotFoundException {
        
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }
    
    
    /**
     * Pega a instancia desta classe.
     * @return A instancia.
     * @throws SQLException
     */
    public static ConnectionManager getInstance() throws SQLException{
        try{
        	if (instance == null) {
                instance = new ConnectionManager();
            }
        } 
        catch(ClassNotFoundException e){
            
            throw new SQLException("O Driver JDBC nao foi encontrado!");
        }
        
        return instance;
    }
    
    
    /**
     * Abre uma conexao com o banco de dados.
     * @return Um objeto que representa a conexao com o banco de dados.
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
                
        String usuario = "adm-sqldb@servidor-sqldb-rm85181";
        String senha = "@Fiap2021";	
        String jdbcUrl = "jdbc:sqlserver://servidor-sqldb-rm85181.database.windows.net:1433;database=sqldb-cp6";
        try{
            return DriverManager.getConnection(jdbcUrl, usuario, senha);
            
        }
        catch (SQLException e) {
            
            e.printStackTrace();
            throw new SQLException("Erro ao abrir a conexao com banco de dados: " + e.getMessage());
        }
        
    }
}