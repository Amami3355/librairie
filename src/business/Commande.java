package business;

import java.sql.Date;

public class Commande {
	private int id;
	private Livre livre;
	private Fournisseur fournisseur;
	private Date dateAchat;
	private double prixAchat;
	private int nbrExemplaires;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Date getDateAchat() {
		return dateAchat;
	}
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}
	public int getNbrExemplaires() {
		return nbrExemplaires;
	}
	public void setNbrExemplaires(int nbrExemplaires) {
		this.nbrExemplaires = nbrExemplaires;
	}
	
	
	
	
}
