package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu{
	
	public AjouterPizzaOptionMenu(Scanner in, PizzaDaoImpl dao) {
		super(in, dao);
		this.libelle = "2. Ajouter une nouvelle pizza";
		this.libelleOption = "Ajout d'une nouvelle pizza";
	}
	
	public boolean execute() throws PizzaException{
		super.execute();
		Pizza pizza = new Pizza(super.saisirCode(this.in, true), super.saisirNom(this.in, true), super.saisirPrix(this.in, true));
		
		this.dao.saveNewPizza(pizza);
		return true;
	}

}
