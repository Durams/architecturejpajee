package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Personne;
import com.service.Iservice;
import com.service.ServiceImpl;

/**
 * Servlet implementation class ModifierPersonne
 */
@WebServlet("/ModifierPersonne")
public class ModifierPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub, on utilise la méthode gest qui retourne toutes les valeurs de l'ID
		
		Personne p = service.affichagePersonne(Integer.parseInt(request.getParameter("id")));
		// tout en une ligne, creation variable pers, je cree le paramètre et definition de la variable 
		request.setAttribute("id", p.getId());
		request.setAttribute("lastname", p.getNom());
		request.setAttribute("firstname", p.getPrenom());
		request.setAttribute("age", p.getAge());
		
	
		
		//3 - préparation à l'envoi        
		request.setAttribute("personnes", service.findAllPersonnes());                
		request.setAttribute("adresses", service.findAllAdresses());
		//4- Appel de la JSP
		request.getRequestDispatcher("personnes.jsp").forward(request, response);  // set c'est mettre dans la case      
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
