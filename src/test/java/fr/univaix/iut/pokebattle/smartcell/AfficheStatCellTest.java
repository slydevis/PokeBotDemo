package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AfficheStatCellTest {

	private AfficheStatCell cell = new AfficheStatCell();

	@Test
	public void askBadStatTest() {
		assertEquals("@nedseb stat?", cell.ask(new Tweet("nedseb", "#stat #partage ?")));
	}

	@Test
	public void askStatTest() {
		assertEquals("@nedseb #attack=0",
				cell.ask(new Tweet("nedseb", "#stat #attack ?")));
	}

	@Test
	public void notAskStatTest() {
		assertEquals(null,
				cell.ask(new Tweet("nedseb", "attack")));
	}
}
