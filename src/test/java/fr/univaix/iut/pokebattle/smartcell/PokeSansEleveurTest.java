package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by h1103428 on 17/03/14.
 */
public class PokeSansEleveurTest {


    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testPokeEleveur() {
        assertEquals("@huyvin24 @huyvin24 is my owner ", cell.ask(new Tweet("huyvin24", "Owner?")));
    }

    @org.junit.Test
    public void testPokeSansEleveur() {
        assertEquals("@huyvin24 No owner ", cell.ask(new Tweet("huyvin24", "Owner?")));
    }

    @Test
    public void testSalut() {
        assertEquals("@nedseb Pika pika", cell.ask(new Tweet("nedseb", "Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals("@nedseb Pika pika", cell.ask(new Tweet("nedseb", "au revoir")));
    }

}
