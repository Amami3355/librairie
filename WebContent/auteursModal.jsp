<%@page import="dao.LivreDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ArrayList<String> auteurs = (ArrayList<String>) request.getAttribute("auteurs");
%>



<div class="modal" tabindex="-1" id="auteursModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Choisissez un auteur</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form method='post' action='livres'>
				<div class="modal-body">

					<select class="form-select" name="auteur"
						aria-label="Default select example">
						<option selected value="">Choisir auteur</option>
						<%
						for (String auteur : auteurs) {
						%>
						<option value='<%=auteur%>'><%=auteur%></option>
						<%
						}
						%>
					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button data-bs-dismiss="modal" type="submit" class="btn btn-primary" id="validateAuteur">
					OK
					</button>
				</div>
			</form>
		</div>
	</div>
</div>
