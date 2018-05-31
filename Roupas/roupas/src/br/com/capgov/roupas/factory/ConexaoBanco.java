package br.com.capgov.roupas.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class ConexaoBanco {

    private ResultSet rs = null;
    private int res;
	
	public Connection createConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/fes";
		String user = "root";
		String password = "";
		
		Connection conexao = DriverManager.getConnection(url, user, password);
				
		return conexao;
		
	}
	
	public ResultSet select(String sql) throws SQLException {
        
		ConexaoBanco con = new ConexaoBanco();
		Statement stmt = con.createConnection().createStatement();
		rs = stmt.executeQuery(sql);
        return rs;
    }
}