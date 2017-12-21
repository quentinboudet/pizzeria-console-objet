package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.PizzaException;

public class ListerPizzasOptionMenu extends OptionMenu{
	public ListerPizzasOptionMenu(Scanner in, PizzaDaoImpl dao) {
		super(in, dao);
		this.libelle = "1. Lister les pizzas";
		this.libelleOption = "Liste des pizzas";
	}
	
	public boolean execute() throws PizzaException {
		super.execute();
		this.dao.findAllPizzas();
		return true;
	}

}
