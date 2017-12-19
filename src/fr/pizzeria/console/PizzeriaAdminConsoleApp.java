package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	//initialisation des pizzas
	public static Pizza[] tableauPizza = new Pizza[100];
	
	/**
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
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
			String choix = "";
			while(!exit) {
				System.out.println("***** Pizzeria Administration *****");
				System.out.println("1. Lister les pizzas");
				System.out.println("2. Ajouter une nouvelle pizza");
				System.out.println("3. Mettre à jour une pizza");
				System.out.println("4. Supprimer une pizza");
				System.out.println("99. Sortir");
	
				String menu = in.nextLine();
				switch(menu) {
				case "1":
					affichePizzas();
					break;
				case "2":
					System.out.println("Ajout d'une nouvelle pizza");
					tableauPizza[Pizza.nextId] = new Pizza(saisirCode(in), saisirNom(in), saisirPrix(in));
					
					break;
				case "3":
					System.out.println("Mise à jour d'une pizza");
					affichePizzas();
					System.out.println("Veuillez choisir la pizza à modifier");
					System.out.println("99 pour abandonner");
					
					choix = in.nextLine();
					if(choix.equals("99")) {
						break;
					}
					
					int i = pizzaCodeId(choix);
					
					tableauPizza[i].code = saisirCode(in);
					tableauPizza[i].nom = saisirNom(in);
					tableauPizza[i].prix = saisirPrix(in);

					break;
				case "4":
					System.out.println("Suppression d'une pizza");
					affichePizzas();
					System.out.println("Veuillez choisir la pizza à supprimer");
					System.out.println("99 pour abandonner");
					
					choix = in.nextLine();
					if(choix.equals("99")) {
						break;
					}
					
					int j = pizzaCodeId(choix);
					
					tableauPizza[j] = null;
					break;
				case "99":
					System.out.println("Au revoir :(");
					exit = true;
					break;
				}
			}
		}
	}
	
	public static void affichePizzas() {
		System.out.println("Liste des pizzas");
		for(int i = 0; i < Pizza.nextId; i++) {
			if(tableauPizza[i] != null ) {
				System.out.println(tableauPizza[i].code + " -> " + tableauPizza[i].nom + " (" + tableauPizza[i].prix + " €)");
			}
		}
	}
	
	/**
	 * @param choix Code d'une pizza
	 * @return Index de la pizza dans le tableau
	 */
	public static int pizzaCodeId(String choix) {
		int i = 0;
		do {
			System.out.println(i);
			
			while(tableauPizza[i] == null) {//on évite les élément inexistants/supprimés
				i++;
			}
			if(choix.equals(tableauPizza[i].code)) {//on trouve l'élément, on stop la boucle
				break;
			}
			else {
				i++;
			}
		}while(i < Pizza.nextId);//on arette si on ne trouve rien
		return i;
	}
	
	public static String saisirCode(Scanner in) {
		System.out.println("Veuillez saisir le code");
		return in.nextLine();
	}
	public static String saisirNom(Scanner in) {
		System.out.println("Veuillez saisir le nom (sans espace)");
		return in.nextLine();
	}
	public static double saisirPrix(Scanner in) {
		System.out.println("Veuillez saisir le prix");
		return in.nextDouble();
	}
}
