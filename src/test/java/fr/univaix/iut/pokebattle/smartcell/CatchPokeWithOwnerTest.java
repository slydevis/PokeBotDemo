package fr.univaix.iut.pokebattle.smartcell;

/* Linda */

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class CatchPokeWithOwnerTest {

    CatchPokeWithOwner cell = new CatchPokeWithOwner();
    @Test
    public void test() {
        Pokemon pokemon = new Pokemon("Ronflex", "Linda");
        cell.setPokemon(pokemon);
        assertEquals("@huyvin My owner is @Linda.", cell.ask(new Tweet("huyvin", "Owner ?")));

    }

}