package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.PizzaException;

public abstract class OptionMenu{
	Scanner in;
	PizzaDaoImpl dao;
	String libelle;
	String libelleOption;
	static String facultatif = ", ou entree pour passer";
	
	public OptionMenu(Scanner in, PizzaDaoImpl dao){
		this.in = in;
		this.dao = dao;
	}


	public String getLibelle() {
		return this.libelle;
	}
	
	public boolean execute() throws PizzaException {
		System.out.println(this.libelleOption);
		return true;
	}
	
	
	/**
	 * @param in
	 * @param obligatoire
	 * @return
	 */
	public static String saisirCode(Scanner in, boolean obligatoire) {
		String addMess = "";
		if(!obligatoire) {
			addMess += OptionMenu.facultatif;
		}
		System.out.println("Veuillez saisir le code" + addMess);
		return in.nextLine();
	}
	/**
	 * @param in
	 * @param obligatoire
	 * @return
	 */
	public static String saisirNom(Scanner in, boolean obligatoire) {
		String addMess = "";
		if(!obligatoire) {
			addMess += OptionMenu.facultatif;
		}
		System.out.println("Veuillez saisir le nom (sans espace)" + addMess);
		return in.nextLine();
	}
	/**
	 * @param in
	 * @param obligatoire
	 * @return
	 */
	public static double saisirPrix(Scanner in, boolean obligatoire) {
		String addMess = "";
		if(!obligatoire) {
			addMess += OptionMenu.facultatif;
		}
		System.out.println("Veuillez saisir le prix" + addMess);
		try{
			double prix = in.nextDouble();//probleme on reste coincé ici si on tape entrée directement
			in.nextLine();
			return prix;
		}
		catch(InputMismatchException e) {
			System.out.println("veuillez saisir un prix avec uniquement des chiffres et un \".\" au maximum");
		}
		return 0;
	}

}
