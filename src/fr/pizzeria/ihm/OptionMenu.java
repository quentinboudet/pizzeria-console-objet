package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;

public abstract class OptionMenu{
	Scanner in;
	PizzaDaoImpl dao;
	String libelle;
	String libelleOption;
	
	public OptionMenu(Scanner in, PizzaDaoImpl dao){
		this.in = in;
		this.dao = dao;
	}


	public String getLibelle() {
		return this.libelle;
	}
	
	public boolean execute() {
		System.out.println(this.libelleOption);
		return true;
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
