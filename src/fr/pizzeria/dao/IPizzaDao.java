package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	/**
	 * @param choix : Code d'une pizza
	 * @return : Index de la pizza dans le tableau
	 * @throws PizzaException 
	 */
	public default int pizzaCodeId(String choix) throws PizzaException {
		boolean pizzaTrouve = false;
		int i = 0;
		List<Pizza> pizzas = findAllPizzas();
		for (Pizza piz : pizzas) {
			if(choix.equals(piz.code)) {//on trouve l'élément, on stop la boucle
				pizzaTrouve = true;
				i = piz.hashCode();
			}
		}
		
		if(!pizzaTrouve) {
			throw new PizzaException("Aucune pizza ne correspond à ce code");
		}
		return i;
	}
	
	List<Pizza> findAllPizzas();
	void saveNewPizza(Pizza pizza) throws PizzaException;
	void updatePizza(String codePizza, String newCode, String newNom, double newPrix) throws PizzaException;
	void deletePizza(String codePizza) throws PizzaException;
	void Init();
	void Close();
	
}
