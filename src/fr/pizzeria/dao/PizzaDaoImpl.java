package fr.pizzeria.dao;

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
	
	/**
	 * @param choix : Code d'une pizza
	 * @return : Index de la pizza dans le tableau
	 * @throws PizzaException 
	 */
	public int pizzaCodeId(String choix) throws PizzaException {
		boolean trouvePizza = false;
		int i = 0;
		do {
			
			while(this.pizzas.get(i) == null) {//on évite les élément inexistants/supprimés (périmé)
				i++;
			}
			if(choix.equals(this.pizzas.get(i).code)) {//on trouve l'élément, on stop la boucle
				trouvePizza = true;
				break;
			}
			i++;
		}while(i < this.pizzas.size());//on arette si on ne trouve rien
		
		if(!trouvePizza) {
			throw new PizzaException("Aucune pizza ne correspond à ce code");
		}
		return i;
	}

	@Override
	public void findAllPizzas() {
		for(int i = 0; i < this.pizzas.size(); i++) {
			if(this.pizzas.get(i) != null ) {
				System.out.println(this.pizzas.get(i).code + " -> " + this.pizzas.get(i).nom + " (" + this.pizzas.get(i).prix + " €)");
			}
		}
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
}
