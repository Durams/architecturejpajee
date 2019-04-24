package com.dao;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.metier.Adresse;
import com.metier.Connexion;
import com.metier.Personne;

public class DaoImpl implements Idao {
	//Déclaration:
	// entity manager factory = crée la connexion
	// entity manager fait les requetes
	//unite de persistence
	EntityManagerFactory emf;
	//porteur de requete
	EntityManager em;
	
	@Override
	public int ajouterPersonne(Personne p) {//méthode
		
		//ouverture de l'unité de persistence
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		//je débute la transaction:
		
		try {
			//1 Débuter la transaction : ouvrir la voie de connexion
			tx.begin();
			//2 Effectuer la requete : mettre les opérations qui doivent se passer, 
			//enchainement d'opération choix puis paiement. Ici ajouter une personne
			//souvt erreur dans requete
			em.persist(p);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		
		return p.getId();
	}

	@Override
	public Personne getPersonne(int idPersonne) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Personne p = new Personne();
		try {
			p = em.getReference(Personne.class, idPersonne);// on fait un cast
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public int supprimerPersonne(Personne p) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//1 Débuter la transaction : ouvrir la voie de connexion
			tx.begin();
			//2 Effectuer la requete : mettre les opérations qui doivent se passer, 
			//enchainement d'opération choix puis paiement. 
			//souvt erreur dans requete
			em.remove(p);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		return p.getId();
	}

	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//1 Débuter la transaction : ouvrir la voie de connexion
			tx.begin();
			//2 Effectuer la requete : mettre les opérations qui doivent se passer, 
			//enchainement d'opération choix puis paiement. 
			//souvt erreur dans requete
			em.merge(p);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		return p.getId();
	}

	@Override
	public Personne affichagePersonne(int idPersonne) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Personne p = new Personne();
		try {
			p = em.find(Personne.class, idPersonne);// on fait un cast
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Personne> findAllPersonnes() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Personne> l =new ArrayList<Personne>();
		
		try {
			q = em.createQuery("SELECT p FROM Personne p");// q = resultset
			l =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;// méthode qui renvoie une liste de personne
		// transforme le resultat en tableau de personne, plus besoin de boucle pour remplir la liste
	}

	@Override
	public List<Personne> rechercheParMC(String mc) {// Méthode de recherche 
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Personne> l =new ArrayList<Personne>();
		
		try {
			q = em.createQuery("SELECT p FROM Personne p where nom like : lenom");// lenom = ?
			q.setParameter("lenom", mc+ "%");// %toto% inclusif mais pour toto%, dois commencer par toto 
			l =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;// méthode qui renvoie une liste de personne
		
	}

	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1 Débuter la transaction : 
			tx.begin();
			//2 Effectuer la requete : 
			em.persist(a);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		
		return a.getIdAdresse();
	}


	@Override
	public Adresse getAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Adresse a = new Adresse();
		try {
			a = em.getReference(Adresse.class, idAdresse);// on fait un cast
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Adresse affichageAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Adresse a = new Adresse();
		try {
			a = em.find(Adresse.class, idAdresse);// on fait un cast
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//1 Débuter la transaction : ouvrir la voie de connexion
			tx.begin();
			//2 Effectuer la requete : mettre les opérations qui doivent se passer, 
			//enchainement d'opération choix puis paiement. 
			//souvt erreur dans requete
			em.remove(a);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		return a.getIdAdresse();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//1 Débuter la transaction : ouvrir la voie de connexion
			tx.begin();
			//2 Effectuer la requete : mettre les opérations qui doivent se passer, 
			//enchainement d'opération choix puis paiement. 
			//souvt erreur dans requete
			em.merge(a);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		return a.getIdAdresse();
	}

	@Override
	public List<Adresse> findAllAdresses() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Adresse> l =new ArrayList<Adresse>();
		
		try {
			q = em.createQuery("SELECT a FROM Adresse a");// q = resultset
			l =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;// méthode qui renvoie une liste de personne
		// transforme le resultat en tableau de personne, plus besoin de boucle pour remplir la liste
	}

	@Override
	public List<Adresse> rechercheParMCA(String mca) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Adresse> z =new ArrayList<Adresse>();
		
		try {
			q = em.createQuery("SELECT a FROM Adresse a where numRue like : lenom");// lenom = ?
			q.setParameter("lenom", mca+ "%");// %toto% inclusif mais pour toto%, dois commencer par toto 
			z =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return z;// méthode qui renvoie une liste de personne
	}

	@Override
	public int ajouterConnexion(Connexion c) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			//1 Débuter la transaction : 
			tx.begin();
			//2 Effectuer la requete : 
			em.persist(c);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		
		return c.getIdConnexion();
	}

	@Override
	public Connexion getConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Connexion c = new Connexion();
		try {
			c = em.getReference(Connexion.class, idConnexion);// on fait un cast
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Connexion affichageConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Connexion c = new Connexion();
		try {
			c = em.find(Connexion.class, idConnexion);// on fait un cast
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//1 Débuter la transaction : ouvrir la voie de connexion
			tx.begin();
			//2 Effectuer la requete : mettre les opérations qui doivent se passer, 
			//enchainement d'opération choix puis paiement. 
			//souvt erreur dans requete
			em.remove(c);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		return c.getIdConnexion();
	}

	@Override
	public int modifierConnexion(Connexion c) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			//1 Débuter la transaction : ouvrir la voie de connexion
			tx.begin();
			//2 Effectuer la requete : mettre les opérations qui doivent se passer, 
			//enchainement d'opération choix puis paiement. 
			//souvt erreur dans requete
			em.merge(c);
			//3 Valider la transaction, ajout en bdd, je ferme la voie de connexion
			tx.commit(); 
			//4 Fermer l'unité de persistence
			em.close();
			emf.close(); 
		} catch (Exception e) {
			// annule la transaction, ce qui s'est fait avant
			tx.rollback();
		}
		return c.getIdConnexion();
	}

	@Override
	public List<Connexion> findAllConnexions() {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Connexion> l =new ArrayList<Connexion>();
		
		try {
			q = em.createQuery("SELECT c FROM Connexion c");// q = resultset
			l =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;// méthode qui renvoie une liste de personne
		// transforme le resultat en tableau de personne, plus besoin de boucle pour remplir la liste
	}

	@Override
	public List<Connexion> rechercheParMCC(String mcc) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Connexion> l =new ArrayList<Connexion>();
		
		try {
			q = em.createQuery("SELECT c FROM Connexion c where login like : lelogin");// lenom = ?
			q.setParameter("lelogin", mcc+ "%");// %toto% inclusif mais pour toto%, dois commencer par toto 
			l =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;// méthode qui renvoie une liste de personne
	}

	@Override
	public List<Personne> findAllPersonnesConnexion() {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Personne> l =new ArrayList<Personne>();
		
		try {
			q = em.createQuery("SELECT p FROM Personne p join p.connexion");// q = resultset
			l =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;// méthode qui renvoie une liste de personne
		// transforme le resultat en tableau de personne, plus besoin de boucle pour remplir la liste
	}

	@Override
	public List<Personne> findAllPersonnesAdresse() {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");//intro qui permet d'ouvrir et de fermer la connexion
		em = emf.createEntityManager();
		Query q = null; // query = requete , rajouter import query.persistence
		List<Personne> l =new ArrayList<Personne>();
		
		try {
			q = em.createQuery("SELECT p FROM Personne p full join fetch p.adresse");// q = resultset
			l =q.getResultList();
			em.close();
			emf.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return l;// méthode qui renvoie une liste de personne
		// transforme le resultat en tableau de personne, plus besoin de boucle pour remplir la liste;
	}
	}


