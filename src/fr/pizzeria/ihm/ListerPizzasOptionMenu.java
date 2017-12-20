package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public class ListerPizzasOptionMenu extends OptionMenu{
	public ListerPizzasOptionMenu(Scanner in, PizzaDaoImpl dao) {
		super(in, dao);
		this.libelle = "1. Lister les pizzas";
		this.libelleOption = "Liste des pizzas";
	}
	
	public boolean execute() {
		super.execute();
		this.dao.findAllPizzas();
		return true;
	}

}
