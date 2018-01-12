package fr.pizzeria.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements IPizzaDao {

	Connection myBdd;
	
	public PizzaDaoJdbc() {
		try {
			Properties props = new Properties();
			props.load(new FileInputStream("ressources/jdbc.properties"));

			Class.forName(props.getProperty("jdbc.driver"));
			
			this.myBdd = (Connection) DriverManager.getConnection(
				props.getProperty("jdbc.url"),
				props.getProperty("jdbc.username"), 
				props.getProperty("jdbc.password")
			);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> listPizzas = new ArrayList<Pizza>();
		
		try {
			Statement statement = (Statement) this.myBdd.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT * FROM pizzas");
			
			//On met toutes les pizzas dans listPizzas
			while(resultats.next()) {
				String code = resultats.getString("code");
				String nom = resultats.getString("nom");
				double prix = resultats.getDouble("prix");
				
				listPizzas.add(new Pizza(code, nom, prix));
			}
			
			resultats.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listPizzas;
	}

	/**
	 * @param pizza
	 * @throws PizzaException
	 */
	@Override
	public void saveNewPizza(Pizza pizza) throws PizzaException {
//		if(this.pizzaCodeId(pizza.code) < 0) {
//			throw new PizzaException("Une pizza existe déjà avec ce code");
//		}

		try {
			Statement statement = (Statement) this.myBdd.createStatement();
			
			int createPizzas = statement.executeUpdate(""
					+ "INSERT INTO pizzas "
					+ "VALUE('" + pizza.code + "', '" + pizza.nom + "', '" + pizza.prix + "')"
			);
			System.out.println(createPizzas + " pizza ajouté");
		
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param codePizza
	 * @param newCode
	 * @param newNom
	 * @param newPrix
	 * @throws PizzaException
	 */
	@Override
	public void updatePizza(String codePizza, String newCode, String newNom, double newPrix) throws PizzaException {

		try {
			Statement statement = (Statement) this.myBdd.createStatement();
			ResultSet resultats = statement.executeQuery("SELECT * FROM pizzas WHERE code = '"+ codePizza + "'");
			resultats.next();
			
			System.out.println(resultats.getString("code"));
			System.out.println(resultats.getString("nom"));
			System.out.println(resultats.getDouble("prix"));

			Pizza piz = new Pizza(resultats.getString("code"), resultats.getString("nom"), resultats.getDouble("prix"));

			if (newCode.length() == 3) {
				piz.code = newCode;
			} else if (newCode.length() != 0) {
				throw new PizzaException("Le code doit être de 3 charactères");
			}
			if (newNom.length() != 0) {
				piz.nom = newNom;
			}
			if (newPrix != 0) {
				piz.prix = newPrix;
			}
			
			PreparedStatement updatePizzaSt = this.myBdd.prepareStatement(
					"UPDATE pizzas "
					+ "SET code = ?, nom = ?, prix = ? "
					+ "WHERE code = ?"
			);
			updatePizzaSt.setString(1, piz.code);
			updatePizzaSt.setString(2, piz.nom);
			updatePizzaSt.setDouble(3, piz.prix);
			updatePizzaSt.setString(4, codePizza);
			updatePizzaSt.executeUpdate();
			
			System.out.println(updatePizzaSt + " pizza modifié");
			
			
			resultats.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param codePizza
	 * @throws PizzaException
	 */
	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		try {
			Statement statement = (Statement) this.myBdd.createStatement();
			
			
			int updatePizzas = statement.executeUpdate(""
					+ "DELETE FROM pizzas "
					+ "WHERE code = '" + codePizza + "'"
			);
			System.out.println(updatePizzas + " pizza supprimé");
			
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void Init() {
		PizzaDaoImpl daoImpl = new PizzaDaoImpl();
		List<Pizza> pizzasBd = daoImpl.findAllPizzas();

		try {
			Statement statement = (Statement) this.myBdd.createStatement();

			int deletePizzas = statement.executeUpdate("DELETE FROM pizzas");
			System.out.println(deletePizzas + " pizzas supprimées");


			PreparedStatement createPizzas = this.myBdd.prepareStatement("INSERT INTO pizzas VALUE(?, ?, ?)");
			for (Pizza piz : pizzasBd) {
				createPizzas.setString(1, piz.getCode());
				createPizzas.setString(2, piz.getNom());
				createPizzas.setDouble(3, piz.getPrix());
				createPizzas.executeUpdate();
				System.out.println(createPizzas + " pizza ajouté");
			}
			
			
			statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Close() {
		try {
			myBdd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
