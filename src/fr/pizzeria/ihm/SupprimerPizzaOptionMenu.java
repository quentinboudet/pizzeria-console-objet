package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	public SupprimerPizzaOptionMenu(Scanner in, PizzaDaoImpl dao) {
		super(in, dao);
		this.libelle = "4. Supprimer une pizza";
		this.libelleOption = "Suppression d'une pizza";
	}

	public boolean execute() {
		super.execute();
		this.dao.findAllPizzas();
		System.out.println("Veuillez choisir la pizza à supprimer");
		System.out.println("99 pour abandonner");
		
		String choix = in.nextLine();
		if(!choix.equals("99")) {
			this.dao.deletePizza(choix);
		}
		return true;
	}

}
