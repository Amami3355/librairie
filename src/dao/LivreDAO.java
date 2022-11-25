package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import business.Livre;

public class LivreDAO extends ContextDAO {

	public static ArrayList<Livre> getAllLivres() throws SQLException, ClassNotFoundException {

		ArrayList<Livre> livres = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
			String query = "select * from livre";
			try (Statement statement = connection.createStatement()) {
				try (ResultSet result = statement.executeQuery(query)) {
					while (result.next()) {
						Livre livre = new Livre();
						livre.setIsbn(result.getLong("isbn"));
						livre.setTitre(result.getString("titre_livre"));
						livre.setTheme(result.getString("theme_livre"));
						livre.setNbrPages(result.getInt("nbr_pages_livre"));
						livre.setFormat(result.getString("format_livre"));
						livre.setNomAuteur(result.getString("nom_auteur"));
						livre.setPrenomAuteur(result.getString("prenom_auteur"));
						livre.setEditeur(result.getString("editeur"));
						livre.setAnneeEdition(result.getLong("annee_edition"));
						livre.setPrixVente(result.getDouble("prix_vente"));
						livre.setLangue(result.getString("langue_livre"));

						livres.add(livre);
					}

				}

			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return livres;
	}

	public static ArrayList<Livre> getLivresParAuteur(String auteur) throws SQLException, ClassNotFoundException {
		if (auteur =="") {
			return getAllLivres();
		}
		String[] auteurArray = auteur.split(" ");
		ArrayList<Livre> livres = new ArrayList<>();
		String query = "select * from livre where nom_auteur = ? and prenom_auteur = ?";
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, auteurArray[0]);
			statement.setString(2, auteurArray[1]);

			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					Livre livre = new Livre();
					livre.setIsbn(result.getLong("isbn"));
					livre.setTitre(result.getString("titre_livre"));
					livre.setTheme(result.getString("theme_livre"));
					livre.setNbrPages(result.getInt("nbr_pages_livre"));
					livre.setFormat(result.getString("format_livre"));
					livre.setNomAuteur(result.getString("nom_auteur"));
					livre.setPrenomAuteur(result.getString("prenom_auteur"));
					livre.setEditeur(result.getString("editeur"));
					livre.setAnneeEdition(result.getLong("annee_edition"));
					livre.setPrixVente(result.getDouble("prix_vente"));
					livre.setLangue(result.getString("langue_livre"));

					livres.add(livre);
				}
			}

		}
		return livres;
	}

	public static ArrayList<Livre> getLivresParEditeur(String editeur) throws SQLException, ClassNotFoundException{
		
		if (editeur == "") {
			return getAllLivres();
		}
		
		ArrayList<Livre> livres = new ArrayList<>();
		
		String query = "select distinct * from livre where editeur = ?";
		try(Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(query)){
			
			statement.setString(1, editeur);
			
			try(ResultSet result = statement.executeQuery()){
				while (result.next()) {
					Livre livre = new Livre();
					livre.setIsbn(result.getLong("isbn"));
					livre.setTitre(result.getString("titre_livre"));
					livre.setTheme(result.getString("theme_livre"));
					livre.setNbrPages(result.getInt("nbr_pages_livre"));
					livre.setFormat(result.getString("format_livre"));
					livre.setNomAuteur(result.getString("nom_auteur"));
					livre.setPrenomAuteur(result.getString("prenom_auteur"));
					livre.setEditeur(result.getString("editeur"));
					livre.setAnneeEdition(result.getLong("annee_edition"));
					livre.setPrixVente(result.getDouble("prix_vente"));
					livre.setLangue(result.getString("langue_livre"));

					livres.add(livre);
				}
			}
			
		}
		return livres;
	}
	

	public static ArrayList<String> getAuteurs() throws SQLException{
		System.out.println("kkkk");
		ArrayList<String> auteurs = new ArrayList<>();
		
		String query = "select distinct concat(nom_auteur, ' ', prenom_auteur) as auteur from livre";
		
		try(Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query)
				){
			while (result.next()) {
				auteurs.add(result.getString("auteur"));
			}
		}
		
		return auteurs;
	}
	
	public static ArrayList<String> getEditeurs() throws SQLException{
		ArrayList<String> editeurs = new ArrayList<>();
		
		String query = "select distinct editeur from livre";
		
		try(Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query)
				){
			while (result.next()) {
				editeurs.add(result.getString("editeur"));
			}
		}
		
		return editeurs;
	}

}
