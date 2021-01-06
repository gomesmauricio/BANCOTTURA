package VIEW;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConnexao {

	public static void main(String[] args) {
		
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BANCOTTURA", "root");
			System.out.println("Conexão: " + conexao.toString());
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}

}
