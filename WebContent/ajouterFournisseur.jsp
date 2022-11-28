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

	<form method='post' action='ajouterFournisseur' style="max-width: 40%; margin: auto;">
	
		<div class="mb-3">
			<label for="isbn" class="form-label">Code Fournisseur</label>
			<input type="number" name="code_fournisseur" class="form-control" id="fode_fournisseur">
		</div>
		<div class="mb-3">
			<label for="titre" class="form-label">Raison sociale</label> 
			<input type="text" name="raison_sociale" class="form-control" id="raison_sociale">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Rue</label> 
			<input type="text" class="form-control" id="rue_fournisseur" name="rue_fournisseur">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Code postal</label> 
			<input type="number" class="form-control" id="code_postal" name="code_postal">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Localité</label> 
			<input type="text" class="form-control" id="localite" name="localite">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Pays</label> 
			<input type="text" class="form-control" id="pays" name="pays">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Téléphone</label> 
			<input type="number" class="form-control" id="tel_fournisseur" name="tel_fournisseur">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">URL</label> 
			<input type="text" class="form-control" id="url_fournisseur" name="url_fournisseur">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Email</label> 
			<input type="email" class="form-control" id="email_fournisseur" name="email_fournisseur">
		</div>
		<div class="mb-3">
			<label class="form-label" for="theme">Fax</label> 
			<input type="number" class="form-control" id="fax_fournisseur" name="fax_fournisseur">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

	<%@ include file="footer.jsp"%>
	<%@ include file="bootstrapJS.jsp"%>
	<script type="text/javascript" src="scripts/script.js"></script>
</body>
</html>