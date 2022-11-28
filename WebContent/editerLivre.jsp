<%@page import="java.io.PrintWriter"%>
<%@page import="dao.LivreDAO"%>
<%@page import="java.util.List"%>
<%@page import="business.Livre"%>
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
	<%
	Livre livreToEdit = (Livre) request.getAttribute("livreToEdit");
	PrintWriter out2 = response.getWriter();
	%>
	
	<%
	List<Livre> livres = LivreDAO.getAllLivres();
	%>
	<form method='post' style="max-width: 40%; margin: auto; text-align: center;">

		<select class="form-select" name="isbn_to_edit">
			<option selected value="">Choisir auteur</option>
			<%
			for (Livre livre : livres) {
			%>
			<option <%= ((livreToEdit != null) && (livreToEdit.getIsbn() == livre.getIsbn())) ? "selected" : "" %> value='<%=livre.getIsbn()%>'><%=livre.getTitre()%>
			</option>
			<%
			}
			%>
		</select>
		<br>
		<button type="submit" class="btn btn-primary" style="marign: auto;">Submit</button>
	</form>
	
	<br><br>
	<form method='post' action='editerLivre'
		style="max-width: 40%; margin: auto;">

		<div class="mb-3">
			<label for="isbn" class="form-label">ISBN</label> <input
				type="number" name="isbn" class="form-control" id="isbn"
				value='<%=(livreToEdit != null) ? livreToEdit.getIsbn() : ""%>'>
		</div>
		<div class="mb-3">
			<label for="titre_livre" class="form-label">Titre</label> <input
				type="text" name="titre_livre" class="form-control" id="titre_livre"
				value='<%=(livreToEdit != null) && (livreToEdit.getTitre() != null) ? livreToEdit.getTitre() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme_livre">Thème</label> <input
				type="text" class="form-control" id="theme_livre" name="theme_livre"
				value='<%=(livreToEdit != null) && (livreToEdit.getTheme() != null)? livreToEdit.getTheme() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="format_livre">Format</label> <input
				type="text" class="form-control" id="format_livre"
				name="format_livre"
				value='<%=(livreToEdit != null) && (livreToEdit.getFormat() != null)? livreToEdit.getFormat() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="nom_auteur">Nom de l'auteur</label> <input
				type="text" class="form-control" id="nom_auteur" name="nom_auteur"
				value='<%=(livreToEdit != null) && (livreToEdit.getNomAuteur() != null)? livreToEdit.getNomAuteur() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="prenom_auteur">Prenom de
				l'auteur</label> <input type="text" class="form-control" id="prenom_auteur"
				name="prenom_auteur"
				value='<%=(livreToEdit != null) && (livreToEdit.getPrenomAuteur()!= null) ? livreToEdit.getPrenomAuteur() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="editeur">Editeur</label> <input
				type="text" class="form-control" id="editeur" name="editeur"
				value='<%=(livreToEdit != null) && (livreToEdit.getEditeur() != null) ? livreToEdit.getEditeur() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="annee_edition">Année d'édition</label>
			<input type="text" class="form-control" id="annee_edition"
				name="annee_edition"
				value='<%=(livreToEdit != null) && (livreToEdit.getAnneeEdition() != 0) ? livreToEdit.getAnneeEdition() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="nbr_pages_livre">Nombre de
				pages</label> <input type="text" class="form-control" id="nbr_pages_livre"
				name="nbr_pages_livre"
				value='<%=(livreToEdit != null) && (livreToEdit.getNbrPages() != 0) ? livreToEdit.getNbrPages() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="prix_vente">Prix Vente</label> <input
				type="text" class="form-control" id="prix_vente" name="prix_vente"
				value='<%=(livreToEdit != null) && (livreToEdit.getPrixVente() != 0) ? livreToEdit.getPrixVente() : ""%>'>
		</div>
		<div class="mb-3">
			<label class="form-label" for="langue_livre">Langue</label> <input
				type="text" class="form-control" id="langue_livre"
				name="langue_livre"
				value='<%=(livreToEdit != null) && (livreToEdit.getLangue() != null) ? livreToEdit.getLangue() : ""%>'>
		</div>
		<button type="submit" class="btn btn-primary">Modifier</button>
	</form>

	<%@ include file="footer.jsp"%>
	<%@ include file="bootstrapJS.jsp"%>
	<script type="text/javascript" src="scripts/script.js"></script>
</body>
</html>