package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.DAO.ConnectDB;

public class ParolaDAO {
	
	public ParolaDAO() {
		
	}
	 public boolean anagrammaPresente(String nome) {

		 
		 boolean presente=false; 
		try {
			String sql= "SELECT nome FROM parola WHERE nome = ? ";
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, nome);
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					presente=true;
				}
				conn.close();
				return presente;
				
		 }
		 catch(SQLException e) {
			 throw new RuntimeException("Errore Db");
		 }
		 
		  
		 
	 }

}
