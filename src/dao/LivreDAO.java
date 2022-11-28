package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import business.Livre;

public class LivreDAO extends ContextDAO {

	/**
	 * 
	 * @return la liste de tous les livres disponibles
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
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

	/**
	 * 
	 * @param auteur
	 * @return La liste de tous les livres d'un certain auteur donné en paramètre
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Livre> getLivresParAuteur(String auteur) throws SQLException, ClassNotFoundException {
		if (auteur == "") {
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

	/**
	 * 
	 * @param editeur
	 * @return La liste de tous les livre d'un certain éditeur donné en paramètre
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<Livre> getLivresParEditeur(String editeur) throws SQLException, ClassNotFoundException {

		if (editeur == "") {
			return getAllLivres();
		}

		ArrayList<Livre> livres = new ArrayList<>();

		String query = "select distinct * from livre where editeur = ?";
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, editeur);

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

	/**
	 * 
	 * @return La liste de tous les auteurs
	 * @throws SQLException
	 */
	public static ArrayList<String> getAuteurs() throws SQLException {
		ArrayList<String> auteurs = new ArrayList<>();

		String query = "select distinct concat(nom_auteur, ' ', prenom_auteur) as auteur from livre";

		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query)) {
			while (result.next()) {
				auteurs.add(result.getString("auteur"));
			}
		}

		return auteurs;
	}

	/**
	 * 
	 * @return La liste de tous les éditeurs
	 * @throws SQLException
	 */
	public static ArrayList<String> getEditeurs() throws SQLException {
		ArrayList<String> editeurs = new ArrayList<>();

		String query = "select distinct editeur from livre";

		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query)) {
			while (result.next()) {
				editeurs.add(result.getString("editeur"));
			}
		}

		return editeurs;
	}

	/**
	 * 
	 * @param isbn
	 * @return Le livre dont le isbn est donné en paramètre s'il existe sion null
	 * @throws SQLException
	 */
	public static Livre getLivreParISBN(long isbn) throws SQLException {
		Livre livre = null;
		String query = "select * from livre where isbn = ?";
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setLong(1, isbn);
			try (ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					livre = new Livre();
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
				}

			}
		}

		return livre;
	}

	public static void AddLivre(Map<String, String[]> livreToAdd) throws SQLException {

		String query = "insert into livre (isbn, titre_livre, theme_livre, nbr_pages_livre, format_livre, nom_auteur, prenom_auteur, editeur, "
				+ "annee_edition, prix_vente, langue_livre) values " + "(?,?,?,?,?,?,?,?,?,?,?)";
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, Integer.parseInt(livreToAdd.get("isbn")[0]));
			statement.setString(2, livreToAdd.get("titre_livre")[0]);
			statement.setString(3, livreToAdd.get("theme_livre")[0]);
			statement.setInt(4, Integer.parseInt(livreToAdd.get("nbr_pages")[0]));
			statement.setString(5, livreToAdd.get("format_livre")[0]);
			statement.setString(6, livreToAdd.get("nom_auteur")[0]);
			statement.setString(7, livreToAdd.get("prenom_auteur")[0]);
			statement.setString(8, livreToAdd.get("editeur")[0]);
			statement.setInt(9, Integer.parseInt(livreToAdd.get("annee_edition")[0]));
			statement.setDouble(10, Integer.parseInt(livreToAdd.get("prix_vente")[0]));
			statement.setString(11, livreToAdd.get("langue_livre")[0]);

			statement.execute();
		}

	}

public static void editLivre(int isbn, Map<String, String[]> livreToEdit) throws Exception{
		
		String query = "update livre set titre_livre = ?, theme_livre = ?, nbr_pages_livre = ?, format_livre = ?, nom_auteur = ?, " + 
		"prenom_auteur = ?, editeur = ?, annee_edition = ?, prix_vente = ?, langue_livre = ?" + 
				"where isbn = ?";
		
		try( Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword); 
				PreparedStatement statement = connection.prepareStatement(query)
				){
			
			statement.setString(1, livreToEdit.get("titre_livre")[0]);
			statement.setString(2, livreToEdit.get("theme_livre")[0]);
			
			statement.setInt(3, Integer.parseInt(livreToEdit.get("nbr_pages_livre")[0]));
			System.out.println("hello");
			statement.setString(4, livreToEdit.get("format_livre")[0]);
			statement.setString(5, livreToEdit.get("nom_auteur")[0]);
			statement.setString(6, livreToEdit.get("prenom_auteur")[0]);
			
			statement.setString(7, livreToEdit.get("editeur")[0]);
			statement.setInt(8, Integer.parseInt(livreToEdit.get("annee_edition")[0]));
			statement.setDouble(9, Double.parseDouble(livreToEdit.get("prix_vente")[0]));
			statement.setString(10, livreToEdit.get("langue_livre")[0]);
			statement.setInt(11, isbn);
			
			statement.execute();
		}
		
	}

}
