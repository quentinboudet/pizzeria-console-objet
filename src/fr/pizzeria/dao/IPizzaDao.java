package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	void findAllPizzas();
	void saveNewPizza(Pizza pizza);
	void updatePizza(String codePizza, String newCode, String newNom, double newPrix);
	void deletePizza(String codePizza);
	
}
