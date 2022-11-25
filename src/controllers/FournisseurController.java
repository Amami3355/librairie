package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import business.Fournisseur;
import dao.FournisseurDAO;
import dao.LivreDAO;

@WebServlet(urlPatterns = "/fournisseurs")
public class FournisseurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FournisseurController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			var auteurs = LivreDAO.getAuteurs();
			var editeurs = LivreDAO.getEditeurs();
			var allLivres = LivreDAO.getAllLivres();
			request.setAttribute("auteurs", auteurs);
			request.setAttribute("editeurs", editeurs);
			request.setAttribute("allLivres", allLivres);
			
			
			List<Fournisseur> fournisseurs = FournisseurDAO.getAllFournisseurs();
			request.setAttribute("fournisseurs", fournisseurs);
			request.getRequestDispatcher("fournisseurs.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
