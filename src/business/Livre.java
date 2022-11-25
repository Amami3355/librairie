package business;

import java.sql.Date;

public class Livre {
	private long isbn;
	private String titre;
	private String theme;
	private int nbrPages;
	private String format;
	private String nomAuteur;
	private String prenomAuteur;
	private String editeur;
	private long anneeEdition;
	private double prixVente;
	private String langue;
	
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getNbrPages() {
		return nbrPages;
	}
	public void setNbrPages(int nbrPages) {
		this.nbrPages = nbrPages;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getNomAuteur() {
		return nomAuteur;
	}
	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}
	public String getPrenomAuteur() {
		return prenomAuteur;
	}
	public void setPrenomAuteur(String prenomAuteur) {
		this.prenomAuteur = prenomAuteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public long getAnneeEdition() {
		return anneeEdition;
	}
	public void setAnneeEdition(long anneeEdition) {
		this.anneeEdition = anneeEdition;
	}
	public double getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	
	
}
