package packeageConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDatabase {
	// Variada criada usando o termo FINAL significa que ela nunca terá seu valor
	// alterado
	private final static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final static String URL = "jdbc:sqlserver://localhost:62410;encrypt=false;databaseName=BluePen;";
	private final static String User = "sa";
	private final static String password = "Senailab05";

	public static Connection getConnection() {
		try {
			Class.forName(Driver);
			System.out.println("Conexão Estabelecida!");
			return DriverManager.getConnection(URL, User, password);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro de Conexão!", e);
		}

	}

	public static void closeConnection(Connection con) {

		try { //Tentativa de fechar o banco no Try
			if (con != null) {
				con.close();
				System.out.println("Conexão Fechada!");
			}
		} catch (SQLException e) { //Caso o comando acima não funcione o catch ativa com uma mensagem de erro vinda de dentro do banco 
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);
		
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void closeConnection(Connection conexao, PreparedStatement stmt, ResultSet rs ) {
		closeConnection(conexao,stmt);
		
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}






