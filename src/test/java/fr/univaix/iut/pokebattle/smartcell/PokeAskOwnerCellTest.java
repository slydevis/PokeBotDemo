package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokeAskOwnerCellTest {

    PokeAskOwnerCell cell = new PokeAskOwnerCell();
	@Test
	public void testEleveur() {
		Pokemon pokemon = new Pokemon("Ronflex", "Linda");	
		cell.setPokemon(pokemon);
		assertEquals("@huyvin My owner is @Linda.", cell.ask(new Tweet("huyvin", "Owner?")));
		
	}

    @Test
    public void testSansEleveur() {
        Pokemon pokemon = new Pokemon("Ronflex");
        cell.setPokemon(pokemon);
        assertEquals("@huyvin No owner", cell.ask(new Tweet("huyvin", "Owner?")));
    }

}
