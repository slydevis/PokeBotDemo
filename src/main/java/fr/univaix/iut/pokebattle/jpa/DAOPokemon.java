package fr.univaix.iut.pokebattle.jpa;

import java.util.List;

import fr.univaix.iut.pokebattle.jpa.Pokemon.Type;

public interface DAOPokemon extends DAO<Pokemon, String> {
	List<Pokemon> findByType(Type type);

}