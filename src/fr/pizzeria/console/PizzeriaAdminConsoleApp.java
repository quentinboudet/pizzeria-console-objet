package fr.pizzeria.console;

import java.util.InputMismatchException;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoJdbc;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.InitPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {


	public static final Logger CONSOLE  = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	
	/**
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		
		try(Scanner in = new Scanner(System.in)){
			
			IPizzaDao dao = new PizzaDaoJdbc();
			
			OptionMenu[] option = new OptionMenu[5];
			option[0] = new ListerPizzasOptionMenu(in, dao);
			option[1] = new AjouterPizzaOptionMenu(in, dao);
			option[2] = new ModifierPizzaOptionMenu(in, dao);
			option[3] = new SupprimerPizzaOptionMenu(in, dao);
			option[4] = new InitPizzaOptionMenu(in, dao);
			
			boolean exit = false;
			while(!exit) {
				
				System.out.println("***** Pizzeria Administration *****");
				for(int i = 0; i < option.length; i++) {
					System.out.println(option[i].getLibelle());
				}
				System.out.println("99. Sortir");

				try {
					int menu = in.nextInt();
					in.nextLine();
					if(menu == 99) {
						System.out.println("Au revoir :(");
						exit = true;
						break;
					}
					else {
						option[menu - 1].execute();
					}
				}
				catch(PizzaException e) {
					System.out.println(e.getMessage());
				}
				catch(NumberFormatException e) {
					System.out.println("Vous devez utiliser un nombre avec \".\" pour délimiter la saisie");
				}
				catch(ArrayIndexOutOfBoundsException  | InputMismatchException e) {
					System.out.println("Cette option n'existe pas");
					if(e.getClass().getName() == "java.util.InputMismatchException"){
						in.nextLine();
					}
				}
			}
			dao.Close();
		}
	}
}
