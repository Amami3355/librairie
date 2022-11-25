package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Fournisseur;

public class FournisseurDAO extends ContextDAO  {
	
	
	/**
	 * 
	 * @return Liste de tous les fournisseurs
	 * @throws SQLException
	 */
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
	
	
	/**
	 * Retourne un fournisseur étant donnée son code_fournisseur
	 * @param code
	 * @return Fournisseur
	 * @throws SQLException
	 */
	public static Fournisseur getFournisseurParCode(int code ) throws SQLException {
		Fournisseur fournisseur = null;
		
		String qeury = "select * from fournisseur where code_fournisseur = ?";
		try(Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(qeury)
				){
			statement.setInt(1, code);
			try(ResultSet result = statement.executeQuery()){
				if (result.next()) {
					fournisseur = new Fournisseur();
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
				}
			}
		}
		
		return fournisseur;
	}
	
}










