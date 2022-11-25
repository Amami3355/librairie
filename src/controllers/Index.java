package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.FournisseurDAO;
import dao.LivreDAO;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			var fournisseurs = FournisseurDAO.getAllFournisseurs();
			var allLivres = LivreDAO.getAllLivres();
			var auteurs = LivreDAO.getAuteurs();
			var editeurs = LivreDAO.getEditeurs();
			request.setAttribute("fournisseurs", fournisseurs);
			request.setAttribute("allLivres", allLivres);
			request.setAttribute("auteurs", auteurs);
			request.setAttribute("editeurs", editeurs);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
