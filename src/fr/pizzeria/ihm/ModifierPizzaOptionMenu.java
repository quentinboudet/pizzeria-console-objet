package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;

public class ModifierPizzaOptionMenu extends OptionMenu{
	
	public ModifierPizzaOptionMenu(Scanner in, IPizzaDao dao) {
		super(in, dao);
		this.libelle = "3. Mettre � jour une pizza";
		this.libelleOption = "Mise � jour d'une pizza \n" 
				+ "Veuillez choisir la pizza � modifier (avec le code de 3 lettres)\n"
				+ "99 pour abandonner";
	}

	public boolean execute() throws PizzaException {
		super.execute();
		this.dao.findAllPizzas();
		
		String choix = this.in.nextLine();
		if(!choix.equals("99")) {
			this.dao.updatePizza(choix, saisirCode(this.in, false), saisirNom(this.in, false), saisirPrix(this.in, false));
		}

		return true;
	}
}
