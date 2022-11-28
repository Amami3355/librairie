package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import business.Livre;
import dao.LivreDAO;

@WebServlet(urlPatterns = "/editerLivre")
public class EditerLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("editerLivre.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("kkk");
		if ((request.getParameter("isbn_to_edit") == "") && (request.getParameter("isbn") == null)) {
			System.out.println("kkk");
			doGet(request, response);
			
		} else if (request.getParameter("isbn") == null) {
			System.out.println("kkk");
			try {
				int isbn = Integer.parseInt(request.getParameter("isbn_to_edit"));
				Livre livreToEdit = LivreDAO.getLivreParISBN(isbn);
				request.setAttribute("livreToEdit", livreToEdit);
				request.getRequestDispatcher("editerLivre.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			
		} else {
			System.out.println("kkk");
			try {
				int isbn = Integer.parseInt(request.getParameter("isbn"));
				var editParams = request.getParameterMap();
				LivreDAO.editLivre(isbn, editParams);
				Livre livreToEdit = LivreDAO.getLivreParISBN(isbn);
				request.setAttribute("livreToEdit", livreToEdit);
				request.getRequestDispatcher("editerLivre.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
