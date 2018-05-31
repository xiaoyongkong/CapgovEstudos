package br.com.capgov.roupas.Dao;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import br.com.capgov.roupas.factory.*;


public class ConsultaRoupasDAO {
	
	private String query;
	private java.io.PrintWriter out;
	
	public int ConsultaRoupa() throws SQLException, Exception {
		
		query = "SELECT * FROM roupas";
		
		ConexaoBanco con = new ConexaoBanco();
		
		return HTMLConsulta(con.select(query));
	
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
