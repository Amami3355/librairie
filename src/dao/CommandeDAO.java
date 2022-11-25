package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import business.Commande;

public class CommandeDAO extends ContextDAO {

	/**
	 * retoune toutes les commandes
	 * 
	 * @return une liste de commandes
	 * @throws SQLException
	 */
	public static List<Commande> getAllCommandes() throws SQLException {
		List<Commande> commandes = new ArrayList<>();
		String query = "select * from commande";
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query)) {
			while (result.next()) {
				Commande commande = new Commande();
				commande.setId(result.getInt("id_commande"));
				commande.setLivre(LivreDAO.getLivreParISBN(result.getLong("isbn")));
				commande.setFournisseur(FournisseurDAO.getFournisseurParCode(result.getInt("code_fournisseur")));
				commande.setDateAchat(result.getDate("date_achat"));
				commande.setPrixAchat(result.getDouble("prix_achat"));
				commande.setNbrExemplaires(result.getInt("nb_exemplaires"));
				commandes.add(commande);
			}
		}

		return commandes;
	}

	public static List<Commande> getCommandesParFournisseur(int codeFournisseur) throws SQLException {
		List<Commande> commandes = new ArrayList<>();

		String query = "select * from commande where code_fournisseur = ?";
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(query))
		{
			statement.setInt(1, codeFournisseur);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					Commande commande = new Commande();
					commande.setId(result.getInt("id_commande"));
					commande.setLivre(LivreDAO.getLivreParISBN(result.getLong("isbn")));
					commande.setFournisseur(FournisseurDAO.getFournisseurParCode(result.getInt("code_fournisseur")));
					commande.setDateAchat(result.getDate("date_achat"));
					commande.setPrixAchat(result.getDouble("prix_achat"));
					commande.setNbrExemplaires(result.getInt("nb_exemplaires"));
					commandes.add(commande);
				}
			}

		}

		return commandes;
	}
	
	public static List<Commande> getCommandesParLivre(long isbn) throws SQLException {
		List<Commande> commandes = new ArrayList<>();

		String query = "select * from commande where isbn = ?";
		try (Connection connection = DriverManager.getConnection(dbUrl, dbLogin, dbPassword);
				PreparedStatement statement = connection.prepareStatement(query))
		{
			statement.setLong(1, isbn);
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					Commande commande = new Commande();
					commande.setId(result.getInt("id_commande"));
					commande.setLivre(LivreDAO.getLivreParISBN(result.getLong("isbn")));
					commande.setFournisseur(FournisseurDAO.getFournisseurParCode(result.getInt("code_fournisseur")));
					commande.setDateAchat(result.getDate("date_achat"));
					commande.setPrixAchat(result.getDouble("prix_achat"));
					commande.setNbrExemplaires(result.getInt("nb_exemplaires"));
					commandes.add(commande);
				}
			}

		}

		return commandes;
	}
}
