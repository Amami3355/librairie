package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.LivreDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Livre", loadOnStartup = 1)
public class Livre extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Livre() {

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			LivreDAO.init(this.getServletContext());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			var livres = LivreDAO.getAllLivres();
			var auteurs = LivreDAO.getAuteurs();
			var editeurs = LivreDAO.getEditeurs();
			
			request.setAttribute("livres", livres);
			request.setAttribute("auteurs", auteurs);
			request.setAttribute("editeurs", editeurs);
			request.getRequestDispatcher("/livres.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String auteur = request.getParameter("auteur");
		String editeur = request.getParameter("editeur");
		System.out.println(auteur);
		System.out.println(editeur);
		try {
			var auteurs = LivreDAO.getAuteurs();
			var editeurs = LivreDAO.getEditeurs();

			if (auteur == null && editeur == null) {
//				System.out.println("kkkk");
				try {
					var livres = LivreDAO.getAllLivres();
					request.setAttribute("livres", livres);
					request.setAttribute("auteurs", auteurs);
					request.setAttribute("editeurs", editeurs);
					request.getRequestDispatcher("/livres.jsp").forward(request, response);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (auteur != null && editeur == null) {
				try {
					var livres = LivreDAO.getLivresParAuteur(auteur);
					request.setAttribute("livres", livres);
					request.setAttribute("auteurs", auteurs);
					request.setAttribute("editeurs", editeurs);
					request.getRequestDispatcher("/livres.jsp").forward(request, response);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (auteur == null && editeur != null) {
				try {
					var livres = LivreDAO.getLivresParEditeur(editeur);
					request.setAttribute("livres", livres);
					request.setAttribute("auteurs", auteurs);
					request.setAttribute("editeurs", editeurs);
					request.getRequestDispatcher("/livres.jsp").forward(request, response);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {

		}
	}

}
