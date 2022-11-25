<%@page import="business.Livre"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="head.jsp"%>
</head>
<body>
	<%@ include file="auteursModal.jsp" %>
	<%@ include file="editeursModal.jsp" %>
	<%@ include file="header.jsp"%>
	<%
	ArrayList<Livre> livres = (ArrayList<Livre>) request.getAttribute("livres");
	%>


	<table class="table">
		<thead>
			<tr>
				<th scope="col">isbn</th>
				<th scope="col">Titre</th>
				<th scope="col">Nombre Pages</th>
				<th scope="col">Format</th>
				<th scope="col">Auteur</th>
				<th scope="col">Editeur</th>
				<th scope="col">Année d'édition</th>
				<th scope="col">Prix</th>
				<th scope="col">Langue</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Livre livre : livres) {
			%>
			<tr>
				<td><%=livre.getIsbn()%></td>
				<td><%=livre.getTitre()%></td>
				<td><%=livre.getNbrPages()%></td>
				<td><%=livre.getFormat()%></td>
				<td><%=livre.getNomAuteur() + " " + livre.getPrenomAuteur()%></td>
				<td><%=livre.getEditeur()%></td>
				<td><%=livre.getAnneeEdition()%></td>
				<td><%=livre.getPrixVente()%></td>
				<td><%=livre.getLangue()%></td>
			</tr>
			<%
			};
			%>
		</tbody>
	</table>
	<%@ include file="footer.jsp"%>
	<%@ include file="bootstrapJS.jsp"%>
	
	<script src="scripts/script.js"></script>
</body>
</html>