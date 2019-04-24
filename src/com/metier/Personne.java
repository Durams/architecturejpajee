package com.metier;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
// 1er méthode
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERS")
@DiscriminatorValue("PERS")

//2nd méthode
//@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)

//3eme methode
//@Inheritance(strategy = InheritanceType.JOINED)

public class Personne {
	@Id
	//a enlever ligne du dessous pour 2nd methode heritage, remettre pour 3eme methode
	@GeneratedValue(strategy=GenerationType.IDENTITY)//équivalent serial
	private int id;
	private String nom;
	private String prenom;
	private int age;
	
	@ManyToOne//(cascade = {CascadeType.PERSIST}) //entre personne et adresse //A enlever pour incrémenter personne a une adresse
	private Adresse adresse;
	
	@ManyToMany(mappedBy="personnes")//fetch = FetchType.LAZY ou EAGER
	private List<Club> clubs = new ArrayList<Club>();
	
	@OneToOne(cascade = {CascadeType.PERSIST})// lorque je charge les personnes, je charge les info de telechargement EAGER
	private Connexion connexion;
	
	
	public List<Club> getClubs() {
		return clubs;
	}
	public void setClubs(List<Club> clubs) {
		this.clubs = clubs;
	}
	public Connexion getConnexion() {
		return connexion;
	}
	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + 
				adresse+ "]";
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	
}
