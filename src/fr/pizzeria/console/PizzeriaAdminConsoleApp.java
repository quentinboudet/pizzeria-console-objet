package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	
	/**
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		//initialisation des pizzas
		Pizza[] tableauPizza = new Pizza[100];
		tableauPizza[0] = new Pizza("PEP", "Pépéroni", 12.50 );
		tableauPizza[1] = new Pizza("MAR", "Margherita", 14.00 );
		tableauPizza[2] = new Pizza("REIN", "La Reine", 11.50 );
		tableauPizza[3] = new Pizza("FRO", "LA 4 froamges", 12.00 );
		tableauPizza[4] = new Pizza("CAN", "La cannibale", 12.50 );
		tableauPizza[5] = new Pizza("SAV", "La savoyarde", 13.00 );
		tableauPizza[6] = new Pizza("ORI", "L'orientale", 13.50 );
		tableauPizza[7] = new Pizza("IND", "L'indienne", 14.00 );
		
		
		
		try(Scanner in = new Scanner(System.in)){
			boolean exit = false;
			while(!exit) {
				System.out.println("***** Pizzeria Administration *****");
				System.out.println("1. Lister les pizzas");
				System.out.println("2. Ajouter une nouvelle pizza");
				System.out.println("3. Mettre à jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
	
				switch(in.nextLine()) {
				case "1":
					System.out.println("Liste des pizzas");
					int i = 0;
					while(tableauPizza[i] != null ) {
						System.out.println(tableauPizza[i].code + " -> " + tableauPizza[i].nom + " (" + tableauPizza[i].prix + " €)");
						
						i++;
					}
					break;
				case "2":
					System.out.println("Ajout d'une nouvelle pizza");
					break;
				case "3":
					System.out.println("Mise à jour d'une pizza");
					break;
				case "4":
					System.out.println("Suppression d'une pizza");
					break;
				case "99":
					System.out.println("Au revoir :(");
					exit = true;
					break;
				}
			}
		}
	}
}
