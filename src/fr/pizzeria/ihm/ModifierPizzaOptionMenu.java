package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.PizzaException;

public class ModifierPizzaOptionMenu extends OptionMenu{
	
	public ModifierPizzaOptionMenu(Scanner in, PizzaDaoImpl dao) {
		super(in, dao);
		this.libelle = "3. Mettre à jour une pizza";
		this.libelleOption = "Mise à jour d'une pizza";
	}

	public boolean execute() throws PizzaException {
		super.execute();
		this.dao.findAllPizzas();
		System.out.println("Veuillez choisir la pizza à modifier");
		System.out.println("99 pour abandonner");
		
		String choix = this.in.nextLine();
		if(!choix.equals("99")) {
			this.dao.updatePizza(choix, saisirCode(this.in, false), saisirNom(this.in, false), saisirPrix(this.in, false));
		}

		return true;
	}
}
