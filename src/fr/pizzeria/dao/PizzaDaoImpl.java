package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao{

	//initialisation des pizzas
	Pizza[] pizzas = new Pizza[100];
	
	public PizzaDaoImpl() {
		
		this.pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50 );
		this.pizzas[1] = new Pizza("MAR", "Margherita", 14.00 );
		this.pizzas[2] = new Pizza("REIN", "La Reine", 11.50 );
		this.pizzas[3] = new Pizza("FRO", "LA 4 froamges", 12.00 );
		this.pizzas[4] = new Pizza("CAN", "La cannibale", 12.50 );
		this.pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00 );
		this.pizzas[6] = new Pizza("ORI", "L'orientale", 13.50 );
		this.pizzas[7] = new Pizza("IND", "L'indienne", 14.00 );
	}
	
	/**
	 * @param choix : Code d'une pizza
	 * @return : Index de la pizza dans le tableau
	 */
	public int pizzaCodeId(String choix) {
		int i = 0;
		do {
			System.out.println(i);
			
			while(this.pizzas[i] == null) {//on évite les élément inexistants/supprimés
				i++;
			}
			if(choix.equals(this.pizzas[i].code)) {//on trouve l'élément, on stop la boucle
				break;
			}
			else {
				i++;
			}
		}while(i < Pizza.nextId);//on arette si on ne trouve rien
		return i;
	}

	@Override
	public void findAllPizzas() {
		for(int i = 0; i < Pizza.nextId; i++) {
			if(this.pizzas[i] != null ) {
				System.out.println(this.pizzas[i].code + " -> " + this.pizzas[i].nom + " (" + this.pizzas[i].prix + " €)");
			}
		}
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		this.pizzas[pizza.id] = pizza;
	}

	@Override
	public void updatePizza(String codePizza, String newCode, String newNom, double newPrix) {
		int i = this.pizzaCodeId(codePizza);
		
		this.pizzas[i].code = newCode;
		this.pizzas[i].nom = newNom;
		this.pizzas[i].prix = newPrix;
	}

	@Override
	public void deletePizza(String codePizza) {
		int i = this.pizzaCodeId(codePizza);
	
		this.pizzas[i] = null;
	}
}
