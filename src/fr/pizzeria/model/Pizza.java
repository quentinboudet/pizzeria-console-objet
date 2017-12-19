package fr.pizzeria.model;

/**
 * @author ETY1
 *
 */
public class Pizza {
	public static int lastId = 0;
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
		this.id = lastId++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;

	}
	public static void main(String[] args) {

	}

}
