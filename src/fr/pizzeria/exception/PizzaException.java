package fr.pizzeria.exception;

public class PizzaException extends Exception{

	public PizzaException(String mess) {
		System.out.println("PizzaException " + mess);
	}

}
