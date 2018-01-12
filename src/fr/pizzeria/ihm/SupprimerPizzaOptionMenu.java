package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	public SupprimerPizzaOptionMenu(Scanner in, IPizzaDao dao) {
		super(in, dao);
		this.libelle = "4. Supprimer une pizza";
		this.libelleOption = "Suppression d'une pizza \n"
				+ "Veuillez choisir la pizza à supprimer (code à 3 lettres)`\n"
				+ "99 pour abandonner";
	}

	public boolean execute() throws PizzaException {
		super.execute();
		this.dao.findAllPizzas();
		
		String choix = this.in.nextLine();
		if(!choix.equals("99")) {
			this.dao.deletePizza(choix);
		}
		return true;
	}

}
