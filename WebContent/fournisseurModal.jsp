<%@page import="business.Fournisseur"%>
<%@page import="dao.FournisseurDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
ArrayList<Fournisseur> fournisseurs = (ArrayList<Fournisseur>) request.getAttribute("fournisseurs");
%>

<div class="modal" tabindex="-1" id="fournisseurModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<h5 class="modal-title">Choisissez un fournisseur</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form method='post' action='commandes'>
				<div class="modal-body">
					<select class="form-select" name="codeFournisseur" aria-label="Default select example">
						<option selected value="">Choisir fournisseur</option>
						<%
						for (Fournisseur fournisseur : fournisseurs) {
						%>
						<option value='<%=fournisseur.getCodeFournisseur()%>'><%=fournisseur.getRaisonSociale()%></option>
						<%
						}
						%>
					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="submit" data-bs-dismiss="modal" class="btn btn-primary">OK</button>
				</div>
			</form>
		</div>
	</div>
</div>