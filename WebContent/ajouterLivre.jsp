
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Map"%>
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
	Map<String, String[]> map = null;
	PrintWriter out2 = response.getWriter();
	if (request.getMethod().toLowerCase() == "post"){
		map = request.getParameterMap();
	}
	%>
	
	<form method='post' action='ajouterLivre' style="max-width: 40%; margin: auto;">
	
		<div class="mb-3">
			<label for="isbn" class="form-label">ISBN</label>
			<input type="number" name="isbn" class="form-control" id="isbn" 
			<% if (request.getMethod().toLowerCase() == "post") out2.write("value = '" + map.get("isbn")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label for="titre_livre" class="form-label">Titre</label> 
			<input type="text" name="titre_livre" class="form-control" id="titre_livre" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("titre_livre")[0] + "'"); %> >
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme_livre">Thème</label> 
			<input type="text" class="form-control" id="theme_livre" name="theme_livre" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("theme_livre")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="format_livre">Format</label> 
			<input type="text" class="form-control" id="format_livre" name="format_livre" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("format_livre")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="nom_auteur">Nom de l'auteur</label> 
			<input type="text" class="form-control" id="nom_auteur" name="nom_auteur" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("nom_auteur")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="prenom_auteur">Prenom de l'auteur</label> 
			<input type="text" class="form-control" id="prenom_auteur" name="prenom_auteur" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("prenom_auteur")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="editeur">Editeur</label> 
			<input type="text" class="form-control" id="editeur" name="editeur" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("editeur")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="annee_edition">Année d'édition</label> 
			<input type="text" class="form-control" id="annee_edition" name="annee_edition" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("annee_edition")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="nbr_pages">Nombre de pages</label> 
			<input type="text" class="form-control" id="nbr_pages" name="nbr_pages" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("nbr_pages")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="prix_vente">Prix Vente</label> 
			<input type="text" class="form-control" id="prix_vente" name="prix_vente" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("prix_vente")[0] + "'"); %>>
		</div>
		<div class="mb-3">
			<label class="form-label" for="langue_livre">Langue</label> 
			<input type="text" class="form-control" id="langue_livre" name="langue_livre" 
			<% if (request.getMethod().toLowerCase() == "post") out2.print("value = '" + map.get("langue_livre")[0] + "'"); %>>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<%@ include file="footer.jsp"%>
	<%@ include file="bootstrapJS.jsp"%>
	<script type="text/javascript" src="scripts/script.js"></script>
</body>
</html>