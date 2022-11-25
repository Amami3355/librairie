
<%@page import="dao.LivreDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
ArrayList<String> editeurs = (ArrayList<String>) request.getAttribute("editeurs");
%>

<div class="modal" tabindex="-1" id="editeursModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<h5 class="modal-title">Choisissez un auteur</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form method='post'>
				<div class="modal-body">
					<select class="form-select" name="editeur" aria-label="Default select example">
						<option selected value="">Choisir editeur</option>
						<%
						for (String editeur : editeurs) {
						%>
						<option value='<%=editeur%>'><%=editeur%></option>
						<%
						}
						%>
					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="submit" data-bs-dismiss="modal" class="btn btn-primary" id="validateEditeur">OK</button>
				</div>
			</form>
		</div>
	</div>
</div>