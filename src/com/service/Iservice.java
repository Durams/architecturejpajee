package com.service;

import java.util.List;

import com.metier.Adresse;
import com.metier.Connexion;
import com.metier.Personne;

public interface Iservice {
 
	public int ajouterPersonne (Personne p);
	
	public Personne getPersonne(int idPersonne);// récupérer une personne à partir de son id
	
	public Personne affichagePersonne(int idPersonne);
	
	public int supprimerPersonne(Personne p);
	
	public int modifierPersonne (Personne p);
	
	public List<Personne> findAllPersonnes();
	
	public List<Personne> rechercheParMC (String mc);
	
public int ajouterAdresse (Adresse a);
	
	public Adresse getAdresse(int idAdresse);// récupérer une adresse à partir de son id
	
	public Adresse affichageAdresse(int idAdresse);
	
	public int supprimerAdresse(Adresse a);
	
	public int modifierAdresse(Adresse a);

	public List<Adresse> findAllAdresses();
	
	public List<Adresse> rechercheParMCA (String mca);
	
public int ajouterConnexion (Connexion c);
	
	public Connexion getConnexion(int idConnexion);// récupérer une personne à partir de son id
	
	public Connexion affichageConnexion(int idConnexion);
	
	public int supprimerConnexion(Connexion c);
	
	public int modifierConnexion(Connexion c);

	public List<Connexion> findAllConnexions();
	
	public List<Connexion> rechercheParMCC (String mcc);
	
	public List<Personne> findAllPersonnesConnexion();
	
	public List<Personne> findAllPersonnesAdresse();
	
	
}
