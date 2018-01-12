package fr.pizzeria.dao;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.CONSOLE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;
public class PizzaDaoImpl implements IPizzaDao{

	//initialisation des pizzas
	List<Pizza> pizzas = new ArrayList<Pizza>();
	
	public PizzaDaoImpl() {
		
		this.pizzas.add( new Pizza("PEP", "Pépéroni", 12.50 ));
		this.pizzas.add( new Pizza("MAR", "Margherita", 14.00 ));
		this.pizzas.add( new Pizza("REIN", "La Reine", 11.50 ));
		this.pizzas.add( new Pizza("FRO", "LA 4 froamges", 12.00 ));
		this.pizzas.add( new Pizza("CAN", "La cannibale", 12.50 ));
		this.pizzas.add( new Pizza("SAV", "La savoyarde", 13.00 ));
		this.pizzas.add( new Pizza("ORI", "L'orientale", 13.50 ));
		this.pizzas.add( new Pizza("IND", "L'indienne", 14.00 ));
	}

	@Override
	public List<Pizza> findAllPizzas() {		
		return this.pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws PizzaException{
		this.pizzas.add(pizza);
	}

	@Override
	public void updatePizza(String codePizza, String newCode, String newNom, double newPrix) throws PizzaException {
		int i = this.pizzaCodeId(codePizza);
		
		if (newCode.length() == 3) { 
			this.pizzas.get(i).code = newCode; 
		}
		else if (newCode.length() != 0){
			throw new PizzaException("Le code doit être de 3 charactères");
		}
		if (newNom.length() != 0){
			this.pizzas.get(i).nom = newNom;
		}
		if(newPrix != 0){
			this.pizzas.get(i).prix = newPrix;
		}
	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		int i = this.pizzaCodeId(codePizza);
	
		this.pizzas.remove(i);
	}

	@Override
	public void Init() {
		this.pizzas.clear();
		
		this.pizzas.add( new Pizza("PEP", "Pépéroni", 12.50 ));
		this.pizzas.add( new Pizza("MAR", "Margherita", 14.00 ));
		this.pizzas.add( new Pizza("REIN", "La Reine", 11.50 ));
		this.pizzas.add( new Pizza("FRO", "LA 4 froamges", 12.00 ));
		this.pizzas.add( new Pizza("CAN", "La cannibale", 12.50 ));
		this.pizzas.add( new Pizza("SAV", "La savoyarde", 13.00 ));
		this.pizzas.add( new Pizza("ORI", "L'orientale", 13.50 ));
		this.pizzas.add( new Pizza("IND", "L'indienne", 14.00 ));
	}

	@Override
	public void Close() {
		
	}
}
