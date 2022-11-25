const validateAuteur = document.querySelector("#validateAuteur");
const validateEditeur = document.querySelector("#validateEditeur");


validateAuteur.addEventListener('click', redirectToLivreParAuteur);
validateEditeur.addEventListener('click', redirectToLivreParEditeur);

function redirectToLivreParAuteur() {
	const auteurSelect = document.querySelector("#auteurSelect");
	window.Location.href = "/Livre?auteur=" + auteurSelect.value;
}

function redirectToLivreParEditeur() {
	const editeurSelect = document.querySelector("#editeurSelect");
	window.Location.href = "/Livre?auteur=" + editeurSelect.value;
}