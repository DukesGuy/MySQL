package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.PokemonDao;
import entity.Pokemon;

public class Menu {
	
	
	private PokemonDao pokemonDao = new PokemonDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display All Pokemon", 
			"Display a Pokemon", 
			"Create a Pokemon", 
			"Update a Pokemon", 
			"Delete a Pokemon");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayAllPokemon();
				} else if (selection.equals("2")) {
					displayAPokemon();
				}else if (selection.equals("3")) {
					createPokemon();
				} else if (selection.equals("4")) {
					updatePokemon();
				} else if (selection.equals("5")) {
					deletePokemon();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			System.out.println("\nPress enter to continue...");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n--------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i+1 + ") " + options.get(i));
		}
	}
	
	private void displayAllPokemon() throws SQLException {
		List<Pokemon> pokemon = pokemonDao.getAllPokemon();
		for (Pokemon each : pokemon) {
			System.out.println(each.getId() + ": " + each.getName() + "\n\tLevel: " + 
					each.getLevel() + "   Type: " + each.getType() + "   Gender: " + each.getGender());
		}
	}
	
	private void displayAPokemon() throws SQLException {
		System.out.print("Enter Pokemon id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Pokemon pokemon = pokemonDao.getPokemonById(id);
		System.out.println(pokemon.getId() + ": " + pokemon.getName() + "\n\tLevel: " + 
		pokemon.getLevel() + "   Type: " + pokemon.getType() + "   Gender: " + pokemon.getGender());
	}
	
	private void createPokemon() throws SQLException {
		System.out.print("Enter new Pokemon's name: ");
		String pokemonName = scanner.nextLine();
		System.out.print("Enter new Pokemon's level: ");
		int pokemonLevel = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter new Pokemon Type: ");
		String pokemonType = scanner.nextLine();
		System.out.print("Enter new Pokemon Gender: ");
		String pokemonGender = scanner.nextLine();
		pokemonDao.createNewPokemon(pokemonName, pokemonLevel, pokemonType, pokemonGender);
	}
	
	private void updatePokemon() throws SQLException {
		System.out.print("Enter Pokemon's id to update: ");
		int pokemonId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter updated Name: ");
		String pokemonName = scanner.nextLine();
		System.out.print("Enter updated Level: ");
		int pokemonLevel = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter updated Type: ");
		String pokemonType = scanner.nextLine();
		System.out.print("Enter updated Gender: ");
		String pokemonGender = scanner.nextLine();
		pokemonDao.updatePokemonById(pokemonId, pokemonName, pokemonLevel, pokemonType, pokemonGender);
	}
	
	private void deletePokemon() throws SQLException {
		System.out.print("Enter Pokemon id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		pokemonDao.deletePokemonById(id);
	}
	

}
