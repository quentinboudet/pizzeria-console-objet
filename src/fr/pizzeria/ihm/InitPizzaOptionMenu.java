package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class InitPizzaOptionMenu extends OptionMenu {

	public InitPizzaOptionMenu(Scanner in, IPizzaDao dao) {
		super(in, dao);
		this.libelle = "5. Réinitialiser la liste de pizza";
		this.libelleOption = "";
	}

	public boolean execute() throws PizzaException {
		super.execute();

		this.dao.Init();
		return true;
	}

}
