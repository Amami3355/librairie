<%@page import="dao.FournisseurDAO"%>
<%@page import="business.Fournisseur"%>
<%@page import="dao.LivreDAO"%>
<%@page import="business.Livre"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<% List<Livre> livres = LivreDAO.getAllLivres(); 
	List<Fournisseur> fournisseurs = FournisseurDAO.getAllFournisseurs();
	%>

	<form method='post' action='ajouterCommande' style="max-width: 40%; margin: auto;">
	
		<div class="mb-3">
			<label for="livre" class="form-label">ISBN</label>
			<select class="form-select" name="livre">
				<option selected value="">Choisir auteur</option>
						<%
						for (Livre livre : livres) {
						%>
						<option value='<%=livre.getIsbn()%>'><%=livre.getTitre()%></option>
						<%
						}
						%>
			</select>
		</div>
		<div class="mb-3">
			<label for="fournisseur" class="form-label">Fournisseur</label> 
			<select class="form-select" name="fournisseur">
				<option selected value="">Choisir auteur</option>
						<%
						for (Fournisseur fournisseur : fournisseurs) {
						%>
						<option value='<%=fournisseur.getCodeFournisseur()%>'><%=fournisseur.getRaisonSociale()%></option>
						<%
						}
						%>
			</select>
		</div>
		<div class="mb-3">
			<label class="form-label" for="date_achat">Date achat</label> 
			<input type="date" class="form-control" id="date_achat" name="date_achat">
		</div>
		<div class="mb-3">
			<label class="form-label" for="prix_achat">Prix achat</label> 
			<input type="text" class="form-control" id="prix_achat" name="prix_achat">
		</div>
		<div class="mb-3">
			<label class="form-label" for="nb_exemplaires">Nombre d'exemplaires</label> 
			<input type="number" class="form-control" id="nb_exemplaires" name="nb_exemplaires">
		</div>

		<button type="submit" class="btn btn-primary">Ajouter</button>
	</form>

	<%@ include file="footer.jsp"%>
	<%@ include file="bootstrapJS.jsp"%>
	<script type="text/javascript" src="scripts/script.js"></script>
</body>
</html>