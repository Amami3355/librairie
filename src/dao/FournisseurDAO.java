package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Fournisseur;

public class FournisseurDAO extends ContextDAO  {
	
	public static List<Fournisseur> getAllFournisseurs() throws SQLException{
		List<Fournisseur> fournisseurs = new ArrayList<>();
		String query = "select * from fournisseur";
		try(Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);  
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query)
				){
			
			while (result.next()) {
				var fournisseur = new Fournisseur();
				fournisseur.setCodeFournisseur(result.getInt("code_fournisseur"));
				fournisseur.setRaisonSociale(result.getString("raison_social"));
				fournisseur.setRue(result.getString("rue_fournisseur"));
				fournisseur.setCodePostal(result.getString("code_postal"));
				fournisseur.setLocalite(result.getString("localite"));
				fournisseur.setPays(result.getString("pays"));
				fournisseur.setTel(result.getString("tel_fournisseur"));
				fournisseur.setUrl(result.getString("url_fournisseur"));
				fournisseur.setEmail(result.getString("email_fournisseur"));
				fournisseur.setFax(result.getString("fax_fournisseur"));
				fournisseurs.add(fournisseur);
			}
			
		}
		
		
		return fournisseurs;
	}
	
}
