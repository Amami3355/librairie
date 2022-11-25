<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header
	class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
	<a href="/"
		class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
		<svg class="bi me-2" width="40" height="32">
			<use xlink:href="#bootstrap" /></svg> <span class="fs-4">Simple
			header</span>
	</a>

	<ul class="nav nav-pills">
		<li class="nav-item"><a href="Index" class="nav-link active"
			aria-current="page">Home</a></li>
		
		<li class="nav-item"><div class="dropdown">
				<a class="nav-link dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">Livres</a>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="livres">Tous les livres</a></li>
					<li><a class="dropdown-item" href="livres" data-bs-toggle="modal" data-bs-target="#auteursModal">Livre par Auteur</a></li>
					<li><a class="dropdown-item" href="livres" data-bs-toggle="modal" data-bs-target="#editeursModal">Livre par Editeur</a></li>
				</ul>
			</div></li>
		<li class="nav-item"><div class="dropdown">
				<a class="nav-link dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">Fournisseurs</a>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="fournisseurs">Tous les fournisseurs</a></li>
				</ul>
			</div></li>
		<li class="nav-item"><div class="dropdown">
				<a class="nav-link dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">Commandes</a>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
				<li><a class="dropdown-item" href="commandes">Touts les commandes</a></li>
					<li><a class="dropdown-item" href="commandes" data-bs-toggle="modal" data-bs-target="#fournisseurModal">Commande par fournisseur</a></li>
					<li><a class="dropdown-item" href="commandes" data-bs-toggle="modal" data-bs-target="#livreModal">Commande par livre</a></li>
				</ul>
			</div></li>
		<li class="nav-item"><div class="dropdown">
				<a class="nav-link dropdown-toggle" type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false">Admin Login</a>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					<li><a class="dropdown-item" href="#">Action</a></li>
					<li><a class="dropdown-item" href="#">Another action</a></li>
					<li><a class="dropdown-item" href="#">Something else here</a></li>
				</ul>
			</div></li>
	</ul>
</header>

<!-- 
<div class="collapse navbar-collapse justify-content-md-center"
	id="navbarsExample08">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link active"
			aria-current="page" href="#">Centered nav only</a></li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		<li class="nav-item"><a class="nav-link disabled" href="#"
			tabindex="-1" aria-disabled="true">Disabled</a></li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="dropdown08" data-bs-toggle="dropdown"
			aria-expanded="false">Dropdown</a>
			<ul class="dropdown-menu" aria-labelledby="dropdown08">
				<li><a class="dropdown-item" href="#">Action</a></li>
				<li><a class="dropdown-item" href="#">Another action</a></li>
				<li><a class="dropdown-item" href="#">Something else here</a></li>
			</ul></li>
	</ul>
</div> -->