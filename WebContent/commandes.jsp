<%@page import="business.Commande"%>
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
	<%@ include file="auteursModal.jsp"%>
	<%@ include file="editeursModal.jsp"%>
	<%@ include file="fournisseurModal.jsp"%>
	<%@ include file="livreModal.jsp"%>
	<%@ include file="header.jsp"%>
	<%
	List<Commande> commandes = (List<Commande>) request.getAttribute("commandes");
	%>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Livre</th>
				<th scope="col">Fournisseur</th>
				<th scope="col">Date Achat</th>
				<th scope="col">Prix Achat</th>
				<th scope="col">Nombre d'exemplaires</th>

			</tr>
		</thead>
		<tbody>
			<%
			for (Commande commande : commandes) {
			%>
			<tr>
				<td><%=commande.getLivre().getTitre()%></td>
				<td><%=commande.getFournisseur().getRaisonSociale()%></td>
				<td><%=commande.getDateAchat().toString()%></td>
				<td><%=commande.getPrixAchat()%></td>
				<td><%=commande.getNbrExemplaires()%></td>
			</tr>
			<%
			}
			;
			%>
		</tbody>
	</table>
	<%@ include file="footer.jsp"%>
	<%@ include file="bootstrapJS.jsp"%>

</body>
</html>