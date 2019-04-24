/*package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Personne;
import com.service.Iservice;
import com.service.ServiceImpl;
*/

/**
 * Servlet implementation class Chargement
 */
/*
@WebServlet("/ChargementTableau")
public class ChargementTableau extends HttpServlet {
	
	private Iservice service = new ServiceImpl();
	
	private static final long serialVersionUID = 1L;
   */    
    /**
     * @see HttpServlet#HttpServlet()
     */
/*
    public ChargementTableau() {
        super();
        // TODO Auto-generated constructor stub
    }
*/
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Personne> pers = service.findAll();// envoie de pers de la base de donnée vers jsp
		request.setAttribute("personnes", pers);
		request.getRequestDispatcher("personne.jsp").forward(request,  response);// pas possible de faire deux dispatcher 
	}
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
*/