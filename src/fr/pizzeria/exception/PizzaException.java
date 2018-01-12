package fr.pizzeria.exception;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.CONSOLE;
public class PizzaException extends Exception{

	public PizzaException(String mess) {
		CONSOLE.info("PizzaException " + mess);
	}

}
