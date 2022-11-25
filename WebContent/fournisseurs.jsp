<%@page import="business.Fournisseur"%>
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
	<%
	List<Fournisseur> fournisseurs = (List<Fournisseur>) request.getAttribute("fournisseurs");
	%>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Code</th>
				<th scope="col">Raison Sociale</th>
				<th scope="col">Rue</th>
				<th scope="col">Code Postal</th>
				<th scope="col">Localité</th>
				<th scope="col">Pays</th>
				<th scope="col">URL</th>
				<th scope="col">Téléphone</th>
				<th scope="col">Mail</th>
				<th scope="col">Fax</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Fournisseur fournisseur : fournisseurs) {
			%>
			<tr>
				<td><%=fournisseur.getCodeFournisseur()%></td>
				<td><%=fournisseur.getRaisonSociale()%></td>
				<td><%=fournisseur.getRue()%></td>
				<td><%=fournisseur.getCodePostal()%></td>
				<td><%=fournisseur.getLocalite()%></td>
				<td><%=fournisseur.getPays()%></td>
				<td><%=fournisseur.getUrl()%></td>
				<td><%=fournisseur.getTel()%></td>
				<td><%=fournisseur.getEmail()%></td>
				<td><%=fournisseur.getFax()%></td>
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