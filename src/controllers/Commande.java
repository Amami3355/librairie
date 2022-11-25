package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.CommandeDAO;
import dao.FournisseurDAO;
import dao.LivreDAO;

@WebServlet("/commandes")
public class Commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Commande() {
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
			var fournisseurs = FournisseurDAO.getAllFournisseurs();
			var livres = LivreDAO.getAllLivres();
			request.setAttribute("auteurs", auteurs);
			request.setAttribute("editeurs", editeurs);
			request.setAttribute("fournisseurs", fournisseurs);
			request.setAttribute("allLivres", livres);
			var commandes = CommandeDAO.getAllCommandes();
			request.setAttribute("commandes", commandes);
			request.getRequestDispatcher("commandes.jsp").forward(request, response);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			var auteurs = LivreDAO.getAuteurs();
			var editeurs = LivreDAO.getEditeurs();
			var fournisseurs = FournisseurDAO.getAllFournisseurs();
			var livres = LivreDAO.getAllLivres();
			
			request.setAttribute("auteurs", auteurs);
			request.setAttribute("editeurs", editeurs);
			request.setAttribute("fournisseurs", fournisseurs);
			request.setAttribute("allLivres", livres);
			
			if (request.getParameter("codeFournisseur") != null) {
				int codeFournisseur = Integer.parseInt(request.getParameter("codeFournisseur"));
				var commandes = CommandeDAO.getCommandesParFournisseur(codeFournisseur);
				request.setAttribute("commandes", commandes);
				request.getRequestDispatcher("commandes.jsp").forward(request, response);
			}else if (request.getParameter("isbn") != null) {
				long isbn = Long.parseLong(request.getParameter("isbn"));
				var commandes = CommandeDAO.getCommandesParLivre(isbn);
				request.setAttribute("commandes", commandes);
				request.getRequestDispatcher("commandes.jsp").forward(request, response);
			}else {
				var commandes = CommandeDAO.getAllCommandes();
				request.setAttribute("commandes", commandes);
				request.getRequestDispatcher("commandes.jsp").forward(request, response);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
