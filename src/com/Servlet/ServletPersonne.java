package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Connexion;
import com.metier.Personne;
import com.service.Iservice;
import com.service.ServiceImpl;
/**
 * Servlet implementation class ServletPersonne
 */
@WebServlet("/ServletPersonne")
public class ServletPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();

    /**
     * Default constructor. 
     */
    public ServletPersonne() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//1- récupération des données      
		// rajout des paramètres adresses pour la liste déroulante
				String nom;        
				String prenom;        
				int age;   
				int id;
				int idAdresse;
				String login;
				String mdp;
				
				if(request.getParameter("lastname")!=null) {            
					   
					age = Integer.parseInt(request.getParameter("age"));            
					nom = request.getParameter("lastname");            
					prenom = request.getParameter("firstname");  
					idAdresse=Integer.parseInt(request.getParameter("idAdresse"));
					login = request.getParameter("login");//parceque les login et mdp n'existe pas donc pas de idConnexion
					mdp = request.getParameter("password");
					
					//2- envoyer à la couche service        
					Personne p = new Personne();        
					p.setAge(age);        
					p.setNom(nom);        
					p.setPrenom(prenom); 
					
					Connexion c = new Connexion();
					c.setLogin(login);
					c.setMdp(mdp);
					p.setConnexion(c);
					
					if (idAdresse!=0) {
					p.setAdresse(service.getAdresse(idAdresse));
					}
					
					// rajouter un if pour pouvoir mettre une personne sans adresse
					
					
					if(request.getParameter("ajouter")!=null) {
					service.ajouterPersonne(p);               
				}
					if(request.getParameter("modifier")!=null) {
						id = Integer.parseInt(request.getParameter("id"));
						p.setId(id);
						//p.setAdresse(service.getAdresse(idAdresse));
						service.modifierPersonne(p);
					
					
				}
			}
				
				//3 - préparation à l'envoi        
				request.setAttribute("personnes", service.findAllPersonnes());   
				request.setAttribute("adresses", service.findAllAdresses());
				
				
				//4- appel de la jsp        
				request.getRequestDispatcher("personnes.jsp").forward(request, response);

			}
				
				

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
