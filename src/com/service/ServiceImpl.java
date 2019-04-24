package com.service;

import java.util.List;

import com.dao.DaoImpl;
import com.dao.Idao;
import com.metier.Adresse;
import com.metier.Connexion;
import com.metier.Personne;

public class ServiceImpl implements Iservice {

	private Idao dao = new DaoImpl();
	@Override
	
	public int ajouterPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.ajouterPersonne(p);
	}
	@Override
	public Personne getPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return dao.getPersonne(idPersonne);
	}
	@Override
	public int supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.supprimerPersonne(p);
	}
	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.modifierPersonne(p);
	}
	@Override
	public Personne affichagePersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return dao.affichagePersonne( idPersonne);
	}
	@Override
	public List<Personne> findAllPersonnes() {
		// TODO Auto-generated method stub
		return dao.findAllPersonnes();
	}
	@Override
	public List<Personne> rechercheParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercheParMC(mc);
	}
	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.ajouterAdresse(a);
	}
	@Override
	public Adresse getAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		return dao.getAdresse(idAdresse);
	}
	@Override
	public Adresse affichageAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		return dao.affichageAdresse(idAdresse);
	}
	@Override
	public int supprimerAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.supprimerAdresse(a);
	}
	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.modifierAdresse(a);
	}
	@Override
	public List<Adresse> findAllAdresses() {
		// TODO Auto-generated method stub
		return dao.findAllAdresses();
	}
	@Override
	public List<Adresse> rechercheParMCA(String mca) {
		// TODO Auto-generated method stub
		return dao.rechercheParMCA(mca);
	}
	@Override
	public int ajouterConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.ajouterConnexion(c);
	}
	@Override
	public Connexion getConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		return dao.getConnexion(idConnexion);
	}
	@Override
	public Connexion affichageConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		return dao.affichageConnexion(idConnexion);
	}
	@Override
	public int supprimerConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.supprimerConnexion(c);
	}
	@Override
	public int modifierConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.modifierConnexion(c);
	}
	@Override
	public List<Connexion> findAllConnexions() {
		// TODO Auto-generated method stub
		return dao.findAllConnexions();
	}
	@Override
	public List<Connexion> rechercheParMCC(String mcc) {
		// TODO Auto-generated method stub
		return dao.rechercheParMCC(mcc);
	}
	@Override
	public List<Personne> findAllPersonnesConnexion() {
		// TODO Auto-generated method stub
		return dao.findAllPersonnesConnexion();
	}
	@Override
	public List<Personne> findAllPersonnesAdresse() {
		// TODO Auto-generated method stub
		return dao.findAllPersonnesAdresse();
	}

}
