package fr.pizzeria.ihm;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.CONSOLE;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu{
	public ListerPizzasOptionMenu(Scanner in, IPizzaDao dao) {
		super(in, dao);
		this.libelle = "1. Lister les pizzas";
		this.libelleOption = "Liste des pizzas";
	}
	
	public boolean execute() throws PizzaException {
		super.execute();
		
		List<Pizza> pizzas = dao.findAllPizzas();
		for(Pizza piz : pizzas) {
			CONSOLE.info(piz.code + " -> " + piz.nom + " (" + piz.prix + " €)");
		}
		return true;
	}

}
