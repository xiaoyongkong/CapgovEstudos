package br.com.capgov.roupas.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.capgov.roupas.domain.Roupa;

import java.sql.Connection;

public class ConexaoBanco {

    private ResultSet rs = null;
    private int res;
	
	public Connection createConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/capgov";
		String user = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexao = DriverManager.getConnection(url, user, password);
				
		return conexao;
		
	}
	
	public ArrayList<Roupa> select(String sql) throws SQLException {
        
		Statement stmt = createConnection().prepareStatement(sql);
		rs = stmt.executeQuery(sql);
		
		ArrayList<Roupa> lista = new ArrayList<Roupa>();
		
		while(rs.next()){
			Roupa roupa = new Roupa();
			roupa.setNome(rs.getString("nome"));
			roupa.setDescricao((rs.getString("descricao")));
			roupa.setTamanho(rs.getString("tamanho"));
			roupa.setQuantidade(rs.getInt("quantidade"));
			roupa.setValor(rs.getFloat("valor"));
			
			lista.add(roupa);			
			
		}
        return lista;
    }
	
	public ResultSet insert(String sql) throws SQLException {
        
		Statement stmt = createConnection().createStatement();
		res = stmt.executeUpdate(sql);
		System.out.println("Inseriu");
        return rs;
    }
}