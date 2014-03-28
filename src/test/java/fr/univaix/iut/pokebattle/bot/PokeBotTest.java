package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using smartcell properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() {
        assertEquals("Fleeex...zZz", pokeBot.ask(new Tweet("Salut")));
        assertEquals("Fleeex...zZz", pokeBot.ask(new Tweet("This is not a question.")));
        assertEquals("@nedseb RON-FLEEEX", pokeBot.ask(new Tweet("nedseb", "Salut")));
        assertEquals("@nedseb RON-FLEEEX", pokeBot.ask(new Tweet("nedseb", "This is not a question.")));

    }
    
    
    public void testOwner() {
    	
    }
    
    
    @Test
    public void testBadAtk() {
    	assertEquals("@nedseb RON-FLEEEX", pokeBot.ask(new Tweet("nedseb", "attack")));
    }
    
    @Test
    public void testAtk() {
    	assertEquals("@bulbizarre #attack #plaquage! /cc @nedseb", pokeBot.ask(new Tweet
    			("nedseb", "#attack #plaquage @bulbizarre")));
    }
    
}
