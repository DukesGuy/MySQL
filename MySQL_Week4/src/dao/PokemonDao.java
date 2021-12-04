package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Pokemon;

public class PokemonDao {
	
	private Connection connection;
	private final String GET_ALL_POKEMON_QUERY = "SELECT * FROM pokemon";
	private final String GET_A_POKEMON_QUERY = "SELECT * FROM pokemon WHERE id = ?";
	private final String CREATE_NEW_POKEMON_QUERY = "INSERT INTO pokemon(name,level,type,gender) VALUES(?,?,?,?)";
	private final String DELETE_POKEMON_BY_ID_QUERY = "DELETE FROM pokemon WHERE id = ?";
	private final String UPDATE_POKEMON_BY_ID_QUERY = "UPDATE pokemon SET name = ?, level = ?, type = ?, gender = ? WHERE id = ?";
	
	public PokemonDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Pokemon> getAllPokemon() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_ALL_POKEMON_QUERY).executeQuery();
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		
		while (rs.next()) {
			pokemon.add(populatePokemon(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
		}
		
		return pokemon;
	}
	
	public Pokemon getPokemonById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_A_POKEMON_QUERY);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePokemon(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
	}
	
	public void createNewPokemon(String pokemonName, int pokemonLevel, String pokemonType, String pokemonGender) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_POKEMON_QUERY);
		ps.setString(1, pokemonName);
		ps.setInt(2, pokemonLevel);
		ps.setString(3, pokemonType);
		ps.setString(4, pokemonGender);
		ps.executeUpdate();
	}
	
	public void updatePokemonById(int pokemonId, String pokemonName, int pokemonLevel, String pokemonType, String pokemonGender) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_POKEMON_BY_ID_QUERY);
		ps.setString(1, pokemonName);
		ps.setInt(2, pokemonLevel);
		ps.setString(3, pokemonType);
		ps.setString(4, pokemonGender);
		ps.setInt(5, pokemonId);
		ps.executeUpdate();
	}
	
	
	public void deletePokemonById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_POKEMON_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	private Pokemon populatePokemon(int id, String name, int level, String type, String gender) {
		return new Pokemon(id, name, level, type, gender);
	}
	
	

}
