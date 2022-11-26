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

	<form method='post' action='ajouterLivre' style="max-width: 40%; margin: auto;">
	
		<div class="mb-3">
			<label for="isbn" class="form-label">ISBN</label>
			<input type="number" name="isbn" class="form-control" id="isbn">
		</div>
		<div class="mb-3">
			<label for="titre" class="form-label">Titre</label> 
			<input type="text" name="titre" class="form-control" id="titre">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Thème</label> 
			<input type="text" class="form-control" id="theme" name="theme">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Format</label> 
			<input type="text" class="form-control" id="format" name="format">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Nom de l'auteur</label> 
			<input type="text" class="form-control" id="nom_auteur" name="nom_auteur">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Prenom de l'auteur</label> 
			<input type="text" class="form-control" id="prenom_auteur" name="prenom_auteur">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Editeur</label> 
			<input type="text" class="form-control" id="editeur" name="editeur">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Année d'édition</label> 
			<input type="text" class="form-control" id="annee_edition" name="annee_edition">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Nombre de pages</label> 
			<input type="text" class="form-control" id="nb_pages" name="nb_pages">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Prix Vente</label> 
			<input type="text" class="form-control" id="prix_vente" name="prix_vente">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Langue</label> 
			<input type="text" class="form-control" id="langue" name="langue">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<%@ include file="footer.jsp"%>
	<%@ include file="bootstrapJS.jsp"%>
	<script type="text/javascript" src="scripts/script.js"></script>
</body>
</html>