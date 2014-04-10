package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AskStatAttackCellTest {
	
	AskStatAttackCell cell = new AskStatAttackCell();

	@Test
	public void StatAttackTest() throws TwitterException {
		assertEquals("@huyvin24 #repos #PUISSANCE= -", cell.ask(new Tweet("huyvin24", "@Ronflex #statAttack #PUISSANCE #repos ?")));
	}
	
	@Test
	public void BadAttackTest() throws TwitterException {
		assertEquals("@huyvin24 Attack unknown", cell.ask(new Tweet("huyvin24", "@Ronflex #statAttack #PRECISION #nounours ?")));
	}
	
	@Test
	public void BadStatAttackTest() throws TwitterException {
		assertEquals("@huyvin24 Stat unknown", cell.ask(new Tweet("huyvin24", "@Ronflex #statAttack #nounours #plaquage ?")));
	}
}
