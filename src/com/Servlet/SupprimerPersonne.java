package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Iservice;
import com.service.ServiceImpl;

/**
 * Servlet implementation class SupprimerPersonne
 */
@WebServlet("/SupprimerPersonne")
public class SupprimerPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private Iservice service = new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		service.supprimerPersonne(service.getPersonne(id));// modifier pour avoir l'id 
		
		
		//3 - préparation à l'envoi        
				request.setAttribute("personnes", service.findAllPersonnes());                
				request.setAttribute("adresses", service.findAllAdresses());
				//4- appel de la jsp        
				request.getRequestDispatcher("personnes.jsp")        
				.forward(request, response);
				}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
