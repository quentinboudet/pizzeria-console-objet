package fr.pizzeria.dao;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	void findAllPizzas();
	void saveNewPizza(Pizza pizza) throws PizzaException;
	void updatePizza(String codePizza, String newCode, String newNom, double newPrix) throws PizzaException;
	void deletePizza(String codePizza) throws PizzaException;
	
}
