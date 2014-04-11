package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AskStatAttackCellTest {

	private AskStatAttackCell cell = new AskStatAttackCell();

	@Test
	public void statNomTest() throws TwitterException {
		assertEquals("@huyvin24 #plaquage #NOM= plaquage", cell.ask(new Tweet(
				"huyvin24", "@Ronflex #statAttack #NOM #plaquage ?")));
	}

	@Test
	public void statNiveauTest() throws TwitterException {
		assertEquals("@huyvin24 #plaquage #NIVEAU= N.35", cell.ask(new Tweet(
				"huyvin24", "@Ronflex #statAttack #NIVEAU #plaquage ?")));
	}

	@Test
	public void statPuissanceTest() throws TwitterException {
		assertEquals("@huyvin24 #plaquage #PUISSANCE= 85", cell.ask(new Tweet(
				"huyvin24", "@Ronflex #statAttack #PUISSANCE #plaquage ?")));
	}

	@Test
	public void statPPTest() throws TwitterException {
		assertEquals("@huyvin24 #plaquage #PRECISION= 100", cell.ask(new Tweet(
				"huyvin24", "@Ronflex #statAttack #PRECISION #plaquage ?")));
	}

	@Test
	public void statAttackTest() throws TwitterException {
		assertEquals("@huyvin24 #plaquage #PP= 15", cell.ask(new Tweet(
				"huyvin24", "@Ronflex #statAttack #PP #plaquage ?")));
	}

	@Test
	public void badAttackTest() throws TwitterException {
		assertEquals("@huyvin24 Attack unknown", cell.ask(new Tweet(
				"huyvin24", "@Ronflex #statAttack #PRECISION #nounours ?")));
	}

	@Test
	public void badStatAttackTest() throws TwitterException {
		assertEquals("@huyvin24 Stat unknown", cell.ask(new Tweet(
				"huyvin24", "@Ronflex #statAttack #nounours #plaquage ?")));
	}
}
