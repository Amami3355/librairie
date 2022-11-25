<%@page import="business.Livre"%>
<%@page import="dao.LivreDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
ArrayList<Livre> allLivres = (ArrayList<Livre>) request.getAttribute("allLivres");
%>

<div class="modal" tabindex="-1" id="livreModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">

			<div class="modal-header">
				<h5 class="modal-title">Choisissez un livre</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<form method='post' action='commandes'>
				<div class="modal-body">
					<select class="form-select" name="isbn" aria-label="Default select example">
						<option selected value="">Choisir livre</option>
						<%
						for (Livre livre : allLivres) {
						%>
						<option value='<%=livre.getIsbn()%>'><%=livre.getTitre()%></option>
						<%
						}
						%>
					</select>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="submit" data-bs-dismiss="modal" class="btn btn-primary" >OK</button>
				</div>
			</form>
		</div>
	</div>
</div>