package fr.pizzeria.model;

/**
 * @author ETY1
 *
 */
public class Pizza {
	public static int nextId = 0;
	public int id ;
	public String code;
	public String nom;
	public double prix;

	/** Constructeur: l'id est généré avec un compteur
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix) {
		this.id = nextId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;

	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	
}
