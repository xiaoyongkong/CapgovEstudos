package br.com.capgov.roupas.Dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import br.com.capgov.roupas.factory.*;
import br.com.capgov.roupas.bean.*;

public class ConsultaRoupasDAO {
	
	private String query;
	private java.io.PrintWriter out;
	ConexaoBanco con = new ConexaoBanco();
	
	public int ConsultaRoupa() throws SQLException, Exception {
		
		query = "SELECT * FROM roupas";
		
		
		return HTMLConsulta(con.select(query));
	
	}
	
	public ResultSet InsereRoupa() throws SQLException, Exception{
		
		br.com.capgov.roupas.bean.RoupasBean roupasBean = new br.com.capgov.roupas.bean.RoupasBean();
		br.com.capgov.roupas.factory.ConexaoBanco conexao = new br.com.capgov.roupas.factory.ConexaoBanco();
		
		query = "INSERT INTO roupas(nome, descricao, tamanho, quantidade, valor) VALUES (" + roupasBean.getNome() + ","
				+ roupasBean.getDescricao() + "," + roupasBean.getTamanho() + "," + roupasBean.getQuantidade() + "," + roupasBean.getValor() + ")";
				
		return conexao.insert(query);
	}
	
	
	
	private int HTMLConsulta(java.sql.ResultSet rs)
		    throws Exception {
		 int rowCount = 0;
		 
		 out.println("<P ALIGN='center'><TABLE BORDER=1>");
		 ResultSetMetaData rsmd = rs.getMetaData();
		 int columnCount = rsmd.getColumnCount();
		 // table header
		 out.println("<TR>");
		 for (int i = 0; i < columnCount; i++) {
		   out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
		   }
		 System.out.println("</TR>");
		 // the data
		 while (rs.next()) {
		  rowCount++;
		  out.println("<TR>");
		  for (int i = 0; i < columnCount; i++) {
		    out.println("<TD>" + rs.getString(i + 1) + "</TD>");
		    }
		  out.println("</TR>");
		  }
		 out.println("</TABLE></P>");
		 return rowCount;
		}
}
